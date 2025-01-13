import os
from huggingface_hub import hf_hub_download
from mediapipe.tasks.python.genai import converter


def gemma_download(token):
  REPO_ID = "google/gemma-2b-it"
  FILENAMES = ["tokenizer.json", "tokenizer_config.json", "model-00001-of-00002.safetensors", "model-00002-of-00002.safetensors"]
  os.environ['HF_TOKEN'] = token
  with out:
    for filename in FILENAMES:
      hf_hub_download(repo_id=REPO_ID, filename=filename, local_dir="./gemma-2b-it")

gemma_download("")