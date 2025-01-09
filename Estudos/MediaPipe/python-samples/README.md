# MediaPipe - Python usage examples

Follow steps describes in sections below to install and execute the scripts.

## Environment Setup

To be able to run Python scripts, follow steps bellow.

### Python Setup

After clone this repository, follow steps bellow:

1. Install python in version `3.10` or `3.11` em :  [pyhton.org](https://www.python.org/downloads/)

2. Create and activate a `virtualenv`:

```bash
$ python -m venv venv_mediapipe_ 
$ .\venv_mediapipe_\Scripts\activate
```

3. Install remain python dependecies:
```bash
$ pip install -r requirements.txt
```

### C++ Dependencies (for Windows):

1. Download and install the latest [Visual C++ Redistributable](https://learn.microsoft.com/en-us/cpp/windows/latest-supported-vc-redist?view=msvc-170) from the official Microsoft website:

2. Download Visual C++ Redistributable Packages
- Install both the x64 and x86 versions, as MediaPipe may depend on either or both.


## Run Code

1. Download [Bert model](https://storage.googleapis.com/mediapipe-models/text_embedder/bert_embedder/float32/1/bert_embedder.tflite)

2. Execute mediapipe script:

```
cd python-samples
python embedding_text.py
```