# Investigação - SystemUi 

Dado o desafio do Hands-On que é modificar a exibição das notificações, com o uso do media-pipe para tornar os textos diferentes, precisamos descobrir o funcionamento da SystemUi quando este evento ocorre para podermos operar e modificar o AOSP. Este processo de investigação será relatado e provado com os experimentos que realizaremos ao longo da trajetória


## RoadMap 🛣️

Trata-se do nosso processo de descoberta dos fatores influenciam na exibição das notificações pela SystemUi, desde a estaca zero até o momento Eureka, que será quando descobrirmos de fato como alterar a exibição para satisfazer aos requisitos mínimos do Hands-On Final.

### 0.Estaca Zero 😵

Neste primeiro momento, estamos buscando ampliar a compreensão do problema, e para tanto investigamos primariamente os arquivos da pasta ``` frameworks/base/core/java/android/app/Notification``` , afim de compreender os processos internos do aosp para o gerenciamento das notificações. Além disso também necessitávamos de entendimento para criar um mecanismo de gerar notificações, o que será muito útil posteriormente para os experimentos. Os estudos acerca os arquivos de Notification estão mais detalhados <to-do>(mudar os arquivos de notification pra uma página). 

### 1. Experimento: Analisando LogCat⚛️

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

##### 1.4.1NotificationListener

Após obtermos a saída do log, podemos verificar que é possível obter o texto da notificação

```
01-10 14:44:27.924   712   712 D NotifContent: Title: Titulo
01-10 14:44:27.924   712   712 D NotifContent: Text: Notificacao tops
01-10 14:44:27.924   712   712 D NotifContent: Package: br.edu.ufam.testenotification
01-10 14:44:27.927   433  1762 D NuPlayerDriver: NuPlayerDriver(0xeafc0dd0) created, clientPid(712)
```

### Eureka - Descobrimos 🎆
