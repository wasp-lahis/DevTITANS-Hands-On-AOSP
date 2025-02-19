# MediaPipe - Python usage examples

Follow steps describes in sections below to install and execute the scripts.

## Environment Setup - Linux

To be able to run Python scripts on **Linux**, follow steps bellow.

### Python Setup

After clone this repository, follow steps bellow:

1. First, install python in version `3.10`:  [pyhton.org](https://www.python.org/downloads/)

2. Install `pip` and `virtualenv`:
```bash
sudo apt-get install python3-pip -y
pip3 install virtualenv 
```

2. Create and activate virtualenv (`venv_mediapipe`):

```bash
python3 -m virtualenv venv_mediapipe
source venv_mediapipe/bin/activate
```

3. Install remain python dependecies:
```bash
pip install -r requirements.txt
```


## Run Codes

1. Download [Bert model](https://storage.googleapis.com/mediapipe-models/text_embedder/bert_embedder/float32/1/bert_embedder.tflite) (for script `embedding_text.py`)

2. Execute mediapipe scripts:

- To run mediapipe "Hello World"/! example, type:

    ```bash
    cd python-samples
    python embedding_text.py
    ```

- To run **Model converter script** example type:
    ```bash
    cd python-samples
    python convert_model_test.py
    ```