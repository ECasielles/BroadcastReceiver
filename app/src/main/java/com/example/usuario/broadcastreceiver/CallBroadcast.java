package com.example.usuario.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by usuario on 9/02/18.
 */

public class CallBroadcast extends BroadcastReceiver {
    private static final String TAG = "CallBroadcast";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "Se ha recogido el Intent");
    }
}
