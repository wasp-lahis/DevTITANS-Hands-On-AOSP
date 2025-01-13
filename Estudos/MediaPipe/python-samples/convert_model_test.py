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

token_secret = ""

def gemma_download(token):
    REPO_ID = "google/gemma-2b-it"
    FILENAMES = ["tokenizer.json", "tokenizer_config.json", "model-00001-of-00002.safetensors", "model-00002-of-00002.safetensors"]
    os.environ['HF_TOKEN'] = token

    for filename in FILENAMES:
        hf_hub_download(repo_id=REPO_ID, filename=filename, local_dir="./gemma-2b-it")


if __name__ == '__main__':

    # Uncomment to donwload. Remember to use your hugging face token access with gema auth ok
    # gemma_download(token_secret)