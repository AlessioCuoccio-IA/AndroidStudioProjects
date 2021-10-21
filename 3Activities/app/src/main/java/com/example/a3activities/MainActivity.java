package com.example.a3activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.example.a3activities.extra.MESSAGE";
    private String articolo = "Il Recovery destina il 40% delle risorse alle Regioni meridionali, ma il criterio non si applica a tutte le voci di spesa. X De Luca: \"Cifra non vera\". Carfagna: \"Verificheremo gli esiti dei bandi\". X Allarme per gli uffici impreparati a gare e appalti";
    private String[] message = articolo.split("X");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onClick(View view) {
        Intent intent = new Intent(this, secondActivity.class);

        switch (view.getId()) {
            case R.id.button_1:
                intent.putExtra(EXTRA_MESSAGE, message[0]);
                break;
            case R.id.button_2:
                intent.putExtra(EXTRA_MESSAGE, message[1]);
                break;
            case R.id.button_3:
                intent.putExtra(EXTRA_MESSAGE, message[2]);
                break;
            default:
                throw new RuntimeException("Unknow button ID");
        }
        startActivity(intent);

    }
}

