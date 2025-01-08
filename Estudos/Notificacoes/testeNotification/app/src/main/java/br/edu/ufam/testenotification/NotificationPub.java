package br.edu.ufam.testenotification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;

public class NotificationPub extends BroadcastReceiver {
    private static final String CHANNEL_ID = "br.edu.ufam.testenotification";
    public static String ID = "notification-id";
    public static String NOTIFICATION = "notification";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("debug","Trying rcv notif");
        NotificationManager nfm = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (nfm != null) {
            // Create channel if running on Android O or higher
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel channel = new NotificationChannel(
                        CHANNEL_ID,
                        "testeNotification",
                        NotificationManager.IMPORTANCE_DEFAULT
                );
                nfm.createNotificationChannel(channel);
                Log.i("debug","criando canal de notif");
            }

            Log.i("debug","notificando...");

            // Build notification using the SAME channel ID
            NotificationCompat.Builder builder = new NotificationCompat.Builder(
                    context, CHANNEL_ID  // Use the same CHANNEL_ID here
            );

            builder.setSmallIcon(R.drawable.baseline_info_24)
                    .setContentTitle("Titulo")
                    .setContentText("Notificacao tops")
                    .setAutoCancel(true)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);

            nfm.notify(1, builder.build());
        }
    }
}