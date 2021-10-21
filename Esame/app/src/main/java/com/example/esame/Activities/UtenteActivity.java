package com.example.esame.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.esame.Models.Account;
import com.example.esame.R;

public class UtenteActivity extends AppCompatActivity {
    private Account account;
    private TextView nome;
    private TextView cognome;
    private TextView eta;
    private TextView sesso;
    private TextView email;
    private TextView password;
    private TextView telefono;
    private TextView citta;
    private TextView provincia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utente);
        Intent intent = getIntent();
        account = intent.getParcelableExtra("Dati");

        nome = findViewById(R.id.nome);
        cognome = findViewById(R.id.cognome);
        eta = findViewById(R.id.eta);
        sesso = findViewById(R.id.sesso);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        telefono = findViewById(R.id.telefono);
        citta = findViewById(R.id.nomeCitta);
        provincia = findViewById(R.id.provincia);

        nome.setText(account.getPersona().getNome());
        cognome.setText(account.getPersona().getCognome());
        eta.setText(String.valueOf(account.getPersona().getEta()));
        sesso.setText(account.getPersona().getSesso());
        email.setText(account.getEmail());
        password.setText(account.getPassword());
        telefono.setText(account.getPersona().getTelefono());
        citta.setText(account.getPersona().getCitta().getNome());
        provincia.setText(account.getPersona().getCitta().getProvincia());
    }
}