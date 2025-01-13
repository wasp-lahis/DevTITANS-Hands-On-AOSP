# Investigação - SystemUi 

Dado o desafio do Hands-On que é modificar a exibição das notificações, com o uso do media-pipe para tornar os textos diferentes, precisamos descobrir o funcionamento da SystemUi quando este evento ocorre para podermos operar e modificar o AOSP. Este processo de investigação será relatado e provado com os experimentos que realizaremos ao longo da trajetória


## RoadMap 🛣️

Trata-se do nosso processo de descoberta dos fatores influenciam na exibição das notificações pela SystemUi, desde a estaca zero até o momento Eureka, que será quando descobrirmos de fato como alterar a exibição para satisfazer aos requisitos mínimos do Hands-On Final.

### 0.Estaca Zero 😵

Neste primeiro momento, estamos buscando ampliar a compreensão do problema, e para tanto investigamos primariamente os arquivos da pasta ``` frameworks/base/core/java/android/app/Notification``` , afim de compreender os processos internos do aosp para o gerenciamento das notificações. Além disso também necessitávamos de entendimento para criar um mecanismo de gerar notificações, o que será muito útil posteriormente para os experimentos. Os estudos acerca os arquivos de Notification estão mais detalhados <to-do>(mudar os arquivos de notification pra uma página). 

### 1.Primeiro experimento ⚛️

#### 1.1.Objetivos

O objetivo deste primeiro teste são:

* Averiguar quais são os métodos acionados pela SystemUi quando uma notificação é disparada
* Filtrar quais arquivos serão importantes
* Manusear as notificações

#### 1.2.Processo

<img src="https://github.com/wasp-lahis/DevTITANS-Hands-On-AOSP/blob/study/mediapipe-python/Estudos/Notificacoes/imgs/PrimExpProcess.png" >

#### 1.3.Tutorial

#### 1.4.Resultados

### Eureka - Descobrimos 🎆
