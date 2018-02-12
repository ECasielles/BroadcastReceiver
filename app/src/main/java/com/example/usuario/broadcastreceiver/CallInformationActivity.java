package com.example.usuario.broadcastreceiver;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class CallInformationActivity extends AppCompatActivity {
    private static final String TAG = "CallInformationActivity";
    TextView txvPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_information);
        txvPhone = findViewById(R.id.txvPhone);
        txvPhone.setText(getIntent().getStringExtra("number"));
    }

}
