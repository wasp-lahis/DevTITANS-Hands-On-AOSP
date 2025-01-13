package br.edu.ufam.testenotification;

import static android.app.PendingIntent.FLAG_ONE_SHOT;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.notificacao);

        if(ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.POST_NOTIFICATIONS}, 101);
        }else{
            Log.i("debug", "Permissao garantida já!");
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(view.getContext(),
                        "Criando uma notificacao em 10 segundos..",
                        Toast.LENGTH_SHORT);
                toast.show();
                //faz a notificacao
                agendaNotificacao2(10000);
            }
        });
    }

    private void agendaNotificacao2(int delay){
        Intent intent = new Intent(getApplicationContext(),
                NotificationPub.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

//        apenas para teste
//        nfm.notify(0, builder.build());
        Log.i("debug", "agendando notificacao");
        PendingIntent pendingIntent2 =
                PendingIntent.getBroadcast(getApplicationContext(),
                        0,
                        intent,
                        PendingIntent.FLAG_IMMUTABLE);

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.setAndAllowWhileIdle(
                AlarmManager.RTC_WAKEUP,
                SystemClock.elapsedRealtime() + 1000,
                pendingIntent2
        );
    }


}