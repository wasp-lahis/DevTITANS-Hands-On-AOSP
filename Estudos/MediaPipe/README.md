# Investigação - MediaPipe 

Uma das branches de investigação do *Hands-On Final de AOSP* consiste em descobrir como utilizar a lib `mediapipe`, modelos LLM e o AOSP para gerar texto que resume um conjunto de notificações. A timeline deste processo de estudo e investigação será detalhada nas subseções a seguir. 


## RoadMap 🛣️

Trata-se do nosso processo de descoberta do workflow mínimo necessário para realizar as ações: utilizar o mediapipe, qual modelo empregar na geração de texto (resumo de notificações), como portar este modelo para o Android e, por fim, como portá-lo para o AOSP. Este relato vai desde a estaca zero até o momento Eureka, que será quando descobrirmos todos os passos para satisfazer os requisitos mínimos do *Hands-On Final*.


### 0.Estaca Zero 😵

Separamos materiais para leitura e alguns tutoriais para basear os experimentos e estudos iniciais:

- **MediaPipe - Leituras**

	- [Página Oficial](https://ai.google.dev/edge/mediapipe/solutions/guide?hl=pt-br)
	- [Repositório Oficial no Github](https://github.com/google-ai-edge/mediapipe)


- **Modelos pré-treinados** 

	- [Tucano: Advancing Neural Text Generation for Portuguese](https://nkluge-correa.github.io/Tucano/)

- **Tutoriais - Python**
	- Text Similarity
		- [Guia de incorporação de texto para Python](https://ai.google.dev/edge/mediapipe/solutions/text/text_embedder/python?hl=pt-br)
		- [How to add text similarity to your applications easily using MediaPipe and Python](https://medium.com/google-developer-experts/how-to-add-text-similarity-to-your-applications-easily-using-mediapipe-and-python-6d309edeed21)
		- [BERT |  MediaPipe | Cousine Similarity](https://dev.to/sajjadrahman56/a-beginners-guide-to-text-embedding-using-bert-with-mediapipe-1j1h)

	- Tools
		- [MediaPipe Text Embedder for Web](https://codepen.io/mediapipe-preview/pen/XWBVZmE)


### 1.Experimento: Rodar script "Hello World" do MediaPipe ⚛️

todo: setup mediapipe e script de similaridade

### 2.Experimento: Conversão de Modelos ⚛️

todo: conversão de modelos p android

### 3.Experimento: Inferência do Modelo no Android Studio ⚛️

todo: conversão de modelos p android