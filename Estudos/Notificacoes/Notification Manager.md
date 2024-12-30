> 🤔 #duvida Precisamos criar um service que irá pegar os textos da notificação e usar a LLM?

A [[NotificationManager.java]] está em:`frameworks/base/core/java/android/app/NotificationManager.java 

E sua AIDL: [[INotificationManager.aidl]] `frameworks/base/core/java/android/app/INotificationManager.aidl`

Esta classe possui uma [[Notification Policy]].
Classe para notificar o usuário sobre eventos que acontecem. É assim que você informa ao usuário que algo aconteceu em segundo plano. A notificação pode ter diferentes formas:

* Um ícone persistente na barra de status
* Ligar ou disparar Leds no device
* Alertar o usuário através de sons ou vibrações

Cada um dos métodos de notificação leva um id e uma tag opcional, a qual pode ser nula. Esses parâmetros forma o par (tag, id) ou (null, id). Esse par identifica a notificação do app para o sistema, então este par deve ser único dentro do app. Se você chamar um dos métodos notify com um par (tag, id) que está atualmente ativo e um novo conjunto de parâmetros de notificação, ela será atualizada.

#### Constantes

Nesta classe as constantes desempenham papel de: gerenciar o comportamento das notificações, implementar diferentes níveis de prioridade, controlar a visibilidade, categorizar as notificações, monitorar mudanças no sistema de notificações. [Aqui](https://developer.android.com/reference/android/app/NotificationManager#constants_1) é possível vê-las


> 🤔 #duvida Quais dessas constantes serão de fato úteis? E como usá-las?


Uma versao de teste - Um app que usa o MediaPIpe... E 