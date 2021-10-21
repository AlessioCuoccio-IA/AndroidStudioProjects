package com.example.esame.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.esame.Models.Account;
import com.example.esame.Models.Citta;
import com.example.esame.Models.Persona;
import com.example.esame.R;
import com.example.esame.Utils.Check;
import com.example.esame.Utils.MyDialog;

import java.util.ArrayList;

public class RegistrationActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY = "com.example.esame.activities.LoginActivity.extra.REPLY";
    private EditText email;
    private EditText password;
    private EditText nome;
    private EditText cognome;
    private EditText eta;
    private RadioButton sesso;
    private EditText citta;
    private EditText provincia;
    private EditText telefono;
    private static final String LOG_TAG = RegistrationActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        nome = findViewById(R.id.nome);
        cognome = findViewById(R.id.cognome);
        eta = findViewById(R.id.eta);
        citta = findViewById(R.id.citta);
        provincia = findViewById(R.id.provincia);
        telefono = findViewById(R.id.telefono);
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {

            case R.id.sessoM:
                if (checked)
                    sesso = findViewById(R.id.sessoM);
                break;

            case R.id.sessoF:
                if (checked)
                    sesso = findViewById(R.id.sessoF);
                break;
        }
    }

    public void register(View view) {
        Citta c;
        Persona persona;
        Account account;

        if (Check.checkField(email)
                && Check.checkField(password)
                && Check.checkField(nome)
                && Check.checkField(cognome)
                && Check.checkField(eta)
                && Check.checkField(telefono)
                && Check.checkField(citta)
                && Check.checkField(provincia)) {

            c = new Citta(citta.getText().toString(),
                    provincia.getText().toString());

            persona = new Persona(nome.getText().toString(),
                    cognome.getText().toString(),
                    Integer.parseInt(eta.getText().toString()),
                    telefono.getText().toString(),
                    sesso.getText().toString(),
                    c);

            account = new Account(email.getText().toString(),
                    password.getText().toString(),
                    persona);

            Intent intent = new Intent();
            intent.putExtra(EXTRA_REPLY, account);
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}