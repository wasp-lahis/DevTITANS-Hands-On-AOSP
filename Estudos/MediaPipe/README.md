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


Decidimos iniciar os estudos utilizando Python devido a boa documentação e quantidade de exemplos disponíveis. Uma vez finalizado os testes iniciais com Python, partiremos para estudar e reproduzir exemplos no Android Studio e, por fim, AOSP.

As próximas seções detalham os experimentos realizados.

### 1. Experimento: Rodar script "Hello World" do MediaPipe ⚛️

#### 1.1.Objetivos

Os objetivos destes primeiros experimentos são:

* Estudar sobre o `mediapipe`
* Instalar a lib `mediapipe`
* Registrar eventuais dependências e dificudades de instalação

#### 1.2.Processo

#### 1.3.Experimentos e Resultados

O tutorial está disponível em: 

### 1.4 Descobertas e Dificuldades

- No momento que estamos escrevendo este relato (14/01/2025), não há releases para as versões do `mediapipe` mais recentes do Python (13.01). Logo, tivemos que utilizar versões anteriores como a `3.10` e `3.11`;

- O SO Windows não é uma boa opção para quem quer começar a trabalhar com o `mediapipe` pois além de ser preciso instalar pacotes adicionais e o software Visual Studio, existem alguns scripts que não possuem suporte para esse SO ainda (scripts de conversão de modelo por exemplo).

- O `mediapipe` é utilizado com modelos LLM pricipalmente no processo de conversão de modelos. Teste que será feita no experimento 2.

### 2. Experimento: Conversão de Modelos para Android ⚛️

todo: conversão de modelos p android

### 3. Experimento: Inferência do Modelo no Android Studio ⚛️

todo: conversão de modelos p android