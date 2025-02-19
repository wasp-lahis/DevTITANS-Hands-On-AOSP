#!/usr/bin/env python3
# coding: utf-8

r"""
This script performs gemma model conversion to Android using MediaPipe lib.

Usage:
    $ python .\convert_model_test.py
"""

import os
from huggingface_hub import hf_hub_download
from mediapipe.tasks.python.genai import converter

token_secret = "<insert_huggingface_token>"

def gemma_download(token):
    REPO_ID = "google/gemma-2b-it"
    FILENAMES = ["tokenizer.json", "tokenizer_config.json", "model-00001-of-00002.safetensors", "model-00002-of-00002.safetensors"]
    os.environ['HF_TOKEN'] = token

    for filename in FILENAMES:
        hf_hub_download(repo_id=REPO_ID, filename=filename, local_dir="./gemma-2b-it")


def gemma_convert_config(backend):
    input_ckpt = './gemma-2b-it/'
    vocab_model_file = './gemma-2b-it/'
    output_dir = './gemma-2b-it-converted/'
    output_tflite_file = f'./gemma-2b-it-converted/gemma_{backend}.tflite'

    # Verificar se os diretórios existem
    if not os.path.exists(input_ckpt):
        raise FileNotFoundError(f"Diretório de checkpoints não encontrado: {input_ckpt}")
    if not os.path.exists(vocab_model_file):
        raise FileNotFoundError(f"Arquivo vocab_model não encontrado: {vocab_model_file}")
    os.makedirs(output_dir, exist_ok=True)
    os.makedirs(os.path.dirname(output_tflite_file), exist_ok=True)

    # Certifique-se de que o backend é válido
    supported_backends = ['tflite', 'onnx', 'tensorflow']
    # if backend not in supported_backends:
    if 'tflite' not in supported_backends:
        raise ValueError(f"Backend {backend} não suportado! Suportados: {supported_backends}")

    # Configurar a conversão
    try:
        result = converter.ConversionConfig(
            input_ckpt=input_ckpt,
            ckpt_format='safetensors',
            model_type='GEMMA_2B',
            backend=backend,
            output_dir=output_dir,
            combine_file_only=False,
            vocab_model_file=vocab_model_file,
            output_tflite_file=output_tflite_file
        )
        return result
    except Exception as e:
        raise RuntimeError(f"Erro na conversão: {str(e)}")


if __name__ == '__main__':

    # Uncomment line below to donwload gemma model. Remember to use your hugging face token access with gemma auth ok
    #gemma_download(token_secret)

    config = gemma_convert_config('gpu')
    converter.convert_checkpoint(config)