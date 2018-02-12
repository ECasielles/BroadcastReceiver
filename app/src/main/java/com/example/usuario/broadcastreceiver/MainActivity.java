package com.example.usuario.broadcastreceiver;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendIntent(View view) {
        Intent intent = new Intent("com.example.usuario.broadcastreceiver.intent");
        Bundle bundle = new Bundle();
        bundle.putString(TelephonyManager.EXTRA_STATE, TelephonyManager.EXTRA_STATE_RINGING);
        bundle.putString(TelephonyManager.EXTRA_INCOMING_NUMBER, "696969696");
        intent.putExtras(bundle);
        sendBroadcast(intent);
    }

}
