package com.example.usuario.broadcastreceiver;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.telephony.TelephonyManager;

public class CallBroadcast extends BroadcastReceiver {
    public static final int CALL_NOTIFICATION = 1;
    private static final String TAG = "CallBroadcast";

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        //1.- Recoger los datos del intent
        if (bundle != null) {
            String state = bundle.getString(TelephonyManager.EXTRA_STATE);

            //1.1.- Según el estado de la llamada
            if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {

                //1.2.- Recoger número de teléfono
                String number = bundle.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);

                //2.- A quién le pasamos la información
                Intent newIntent = new Intent(context, CallInformationActivity.class);
                newIntent.putExtra("number", number);
                newIntent.putExtra("idNotification", CALL_NOTIFICATION);
                PendingIntent pendingIntent = PendingIntent.getActivity(context,
                        CALL_NOTIFICATION, newIntent, 0);

                //3.- Crear la notificación
                NotificationCompat.Builder builder =
                        new NotificationCompat.Builder(context, "Notification");
                //Personalizamos (obligatorios los dos iconos, small y large
                builder.setContentTitle("CallBroadcast")
                        .setContentText("Contenido")
                        .setSmallIcon(android.R.drawable.sym_call_incoming)
                        .setLargeIcon(BitmapFactory.decodeResource(
                                context.getResources(), android.R.drawable.sym_call_incoming))
                        .setAutoCancel(true)
                        .setContentIntent(pendingIntent);   // <---- Aquí se le pasa la activity

                //4.- Lanzar la notificación
                NotificationManager notificationManager =
                        (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(CALL_NOTIFICATION, builder.build());
            }
        }
    }

}
