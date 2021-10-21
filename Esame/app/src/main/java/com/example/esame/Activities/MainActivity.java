package com.example.esame.Activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.esame.Models.Account;
import com.example.esame.Utils.MyDialog;
import com.example.esame.R;
import com.example.esame.Utils.WordListAdapter;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private static final int TEXT_REQUEST = 1;
    private Button nome_cognome;
    private Account account;
    private final LinkedList<String> mWordList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDialog.makeDialog(this, "Success", "Login Effettuato");

        Intent intent = getIntent();
        account = intent.getParcelableExtra("Account");
        nome_cognome = findViewById(R.id.nome_cognome);
        nome_cognome.setText(account.getPersona().getNome() + " " + account.getPersona().getCognome());

        mRecyclerView = findViewById(R.id.recyclerview);
    }


    public void dettagli(View view) {
        Intent intent = new Intent(MainActivity.this, UtenteActivity.class);
        intent.putExtra("Dati", account);
        startActivity(intent);
    }

    public void aggiungiProdotto(View view) {
        Intent intent = new Intent(MainActivity.this, ProdottiActivity.class);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String word = data.getStringExtra(ProdottiActivity.EXTRA_ITEMS);
                mWordList.add(word);
                mAdapter = new WordListAdapter(this, mWordList);
                mRecyclerView.setAdapter(mAdapter);
                mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            }
        }
    }
}