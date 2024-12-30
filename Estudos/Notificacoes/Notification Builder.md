
Em resumo, isso é uma api pra simplificar a criação de notificações a nível de aplicação. Provê uma forma mais conveniente de definir vários campos da notificação e gerar content views.

Todas aquelas constantes mencionadas no texto sobre o [[Notification]] agora podem ser instanciadas usando métodos públicos, um exemplo disso pode ser visualizado abaixo:

```java
String channelId = "email_notifications";
NotificationChannel channel = new NotificationChannel(
    channelId,                          
    "Email Notifications",              
    NotificationManager.IMPORTANCE_DEFAULT
);

channel.setDescription("Notificações de novos emails");
NotificationManager notificationManager = mContext.getSystemService(NotificationManager.class);
notificationManager.createNotificationChannel(channel);

Notification noti = new Notification.Builder(mContext, channelId)
    .setContentTitle("New mail from " + sender.toString())
    .setContentText(subject)
    .setSmallIcon(R.drawable.new_mail)
    .setLargeIcon(aBitmap)
    .build();

```

`Builder(Context, channelId)`: O channelID serve para especificar de onde a notificação está vindo, e serve basicamente para categorizar, também é possível criar sem o ChannelId... só passando o context.
