# Investigação - SystemUi 

Dado o desafio do Hands-On que é modificar a exibição das notificações, com o uso do media-pipe para tornar os textos diferentes, precisamos descobrir o funcionamento da SystemUi quando este evento ocorre para podermos operar e modificar o AOSP. Este processo de investigação será relatado e provado com os experimentos que realizaremos ao longo da trajetória


## RoadMap 🛣️

Trata-se do nosso processo de descoberta dos fatores influenciam na exibição das notificações pela SystemUi, desde a estaca zero até o momento Eureka, que será quando descobrirmos de fato como alterar a exibição para satisfazer aos requisitos mínimos do Hands-On Final.

### 0.Estaca Zero 😵

Neste primeiro momento, estamos buscando ampliar a compreensão do problema, e para tanto investigamos primariamente os arquivos da pasta ``` frameworks/base/core/java/android/app/Notification``` , afim de compreender os processos internos do aosp para o gerenciamento das notificações. Além disso também necessitávamos de entendimento para criar um mecanismo de gerar notificações, o que será muito útil posteriormente para os experimentos. Os estudos acerca os arquivos de Notification estão mais detalhados  `<TO DO>`(mudar os arquivos de notification pra uma página). 

### 1. Experimento: Analisando LogCat ⚛️

#### 1.1.Objetivos

O objetivo deste primeiro teste são:

* Averiguar quais são os métodos acionados pela SystemUi quando uma notificação é disparada
* Filtrar quais arquivos serão importantes
* Manusear as notificações

#### 1.2.Processo

<img src="https://github.com/wasp-lahis/DevTITANS-Hands-On-AOSP/blob/study/systemui/Estudos/Notificacoes/imgs/PrimExpProcess.png" >

#### 1.3.Tutorial

##### 1.3.1. NotificationListener 

Neste tutorial, iremos modificar o arquivo Notification Listener, presente na pasta ```frameworks/base/packages/SystemUi/src/com/android/systemui/statusbar```, o intuito principal deste primeiro teste é perceber como manipular o texto da notificação quando a notificação é "postada", e o método responsável por isso (onNotificationPosted) está presente nesta classe. Neste exemplo eu só quis verificar se era possível pegar o texto da notificação, e então adicionei um Log.d no método citado.

Primeiro: Modifique o método onNotificationPosted, adicionando o seguinte bloco de código:

```
Log.d("Testando - DevTitans", "=== NOTIFICATION POSTED ===");
if(sbn!= null){
  Log.d("NotifContent", "Title: " + sbn.getNotification().extras.getString(Notification.EXTRA_TITLE));
  Log.d("NotifContent", "Text: " + sbn.getNotification().extras.getString(Notification.EXTRA_TEXT));
  Log.d("NotifContent", "Package: " + sbn.getPackageName());
}
```
Segundo: Builde seu AOSP

Terceiro: Ligue o emulador e ative o logcat.


#### 1.4.Resultados

Após obtermos a saída do log, podemos verificar que é possível obter o texto da notificação

```
01-10 14:44:27.924   712   712 D NotifContent: Title: Titulo
01-10 14:44:27.924   712   712 D NotifContent: Text: Notificacao tops
01-10 14:44:27.924   712   712 D NotifContent: Package: br.edu.ufam.testenotification
01-10 14:44:27.927   433  1762 D NuPlayerDriver: NuPlayerDriver(0xeafc0dd0) created, clientPid(712)
```

#### 1.5. Conclusão

Após um diálogo com o [Mateus Preste](https://github.com/mateusPreste), foi-nos explicado que a este experimento teve mais utilidade para uma percepção geral da lógica de chamada da notificação, portanto ele nos sugeriu usar a ferramenta AutomatorViewerUi, para rastrear os componentes de View e desse modo conseguir ver onde estavam os conteúdos exibidos pela SystemUI na notificação... Após isso mudamos nossa estratégia e seguimos a sugestão. 

 `<TO DO>` Explicar que a classe NotificationListener...


### 2. Experimento: Analisando AutomatorViewerUi⚛️

```💡 O AutomatorViewerUi é uma ferramenta do Android que permite visualizar a hierarquia de elementos da interface do usuário (UI) em aplicativos Android```

#### 2.1 Objetivos

Os objetivos deste segundo experimento são:

* Inspecionar os componentes visuais da notificação
* Analisar qual o package que o componente visual de notificação está
* Modificar o conteúdo de uma notificação via SystemUi

#### 2.2. Processo

#### 2.3. Tutorial

##### 2.3.1 Configurando a ferramenta

Com o emulador acionado, navegue até a pasta ```Android/Sdk/tools/bin```, depois disso digite o comando ./uiautomatorviewer, e será inicializado o programa.

##### 2.3.2 Verificando a hierarquia

Após isso, abra a aba de notificações no emulador, e na ferramenta de automatorviewer aperte no segundo botão superior esquerdo, depois disso será fornecido um print da tela e é possível rastrear os componentes visuais da tela

##### 2.3.4 Análise das classes 

O processo de investigação foi desempenhado seguindo as sugestões do monitor, o qual nos direcionou a procurar por classes que fossem responsáveis por exibir o conteúdo do componente visual da notificação. Após verificar que a notificação exibida pela systemUi pertencia à classe ```com.android.systemui:id/expandableNotificationRow``` como é comprovado na figura abaixo, após isso foi necessário analisar o código e verificar em que momento o conteúdo da notificação era exibido e que arquivo era responsável por isso.

``` 💡 A classe ExpandableNotificationRow.java está no seguinte path com.android.systemui:id/expandableNotificationRow```

<img src ="https://github.com/wasp-lahis/DevTITANS-Hands-On-AOSP/blob/study/systemui/Estudos/Notificacoes/imgs/Captura%20de%20tela%20de%202025-01-14%2014-11-14.png" >

Depois de analisar o código, chegamos ao teste incial que era modificar o título da mensagem.

##### 2.3.5 Modificando o título da Notificação - SOU UM IMPOSTOR DEVTITANS ! 🕶️ 

``` 📍 Modificação feita em ExpandableNotificationRow.java```

Ao analisar o código podemos verificar que há um método chamado ``ìnitialize()`` o qual é o entry point em que a notificação é inicializada e que por padrão instancia a entry, a qual possui os dados principais da notificação, então abaixo da instancia do entry eu criei um novo título, desssa forma:

```
  public void initialize(...){
    mEntry = entry; //Já é instanciado por padrão
    mEntry.getSbn().getNotification().extras.putString(Notification.EXTRA_TITLE, "Sou um Impostor DevTITANS");
    //resto do código abaixo
  }
```
* getSbn() : Pega o StatusBarNotification
* getNotification()
* extras : Acessa o Bundle de extras da notificação

O resultado desta modificação pode ser verificado nos resultados.

#### 2.4 Resultados

##### 2.4.1 Título da notificação modificado

<img src="https://github.com/wasp-lahis/DevTITANS-Hands-On-AOSP/blob/study/systemui/Estudos/Notificacoes/imgs/SouUmImpostorDevTITANS.png">




##### 2.4.1 






### Eureka - Descobrimos 🎆
