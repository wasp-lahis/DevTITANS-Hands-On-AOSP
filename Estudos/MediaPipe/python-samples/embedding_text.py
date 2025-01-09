#!/usr/bin/env python3
# coding: utf-8

r"""
This script perform a similiraty inference between text phrases using Bert Model and MediaPipe module.

Usage:
    $ python .\embedding_text.py
"""

import mediapipe as mp
from mediapipe.tasks import python
from mediapipe.tasks.python import text


# Create your base options with the model that was downloaded earlier
base_options = python.BaseOptions(model_asset_path='bert_embedder.tflite')

# Set your values for using normalization and quantization
l2_normalize = True 
quantize = False 

# Create the final set of options for the Embedder
options = text.TextEmbedderOptions(
    base_options=base_options, l2_normalize=l2_normalize, quantize=quantize)

with text.TextEmbedder.create_from_options(options) as embedder:
  # Retrieve the first and second sets of text that will be compared
  first_text = "I'm feeling so good" 
  second_text = "I'm okay I guess"
  #third_text = "Your number account is 897"
  third_text = "I'm a bad persons, bad bad bad!"
   

  print("\n[INFO] Input Text phrases:")
  print(f"\tfirst_text: {first_text}")
  print(f"\tsecond_text: {second_text}")
  print(f"\tthird_text: {third_text}")

  # Convert both sets of text to embeddings
  print("\n[INFO] Embedder Model: bert_embedder.tflite")
  first_embedding_result = embedder.embed(first_text)
  second_embedding_result = embedder.embed(second_text)
  third_embedding_result = embedder.embed(third_text)

  # Calculate and print similarity
  similarity_12 = text.TextEmbedder.cosine_similarity(
      first_embedding_result.embeddings[0],
      second_embedding_result.embeddings[0])
  
  similarity_23 = text.TextEmbedder.cosine_similarity(
      second_embedding_result.embeddings[0],
      third_embedding_result.embeddings[0])
  
  similarity_13 = text.TextEmbedder.cosine_similarity(
      first_embedding_result.embeddings[0],
      third_embedding_result.embeddings[0])
  
  print("\n[INFO] Output:")
  print("\tCousine Similarity bt phrases 1-2:", similarity_12)
  print("\tCousine Similarity bt phrases 2-3:", similarity_23)
  print("\tCousine Similarity bt phrases 1-3:", similarity_13)