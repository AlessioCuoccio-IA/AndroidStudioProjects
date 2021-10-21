package com.example.esame.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.esame.Models.Account;
import com.example.esame.Models.Citta;
import com.example.esame.Models.Persona;
import com.example.esame.R;
import com.example.esame.Utils.Check;
import com.example.esame.Utils.MyDialog;

import java.util.ArrayList;


public class LoginActivity extends AppCompatActivity {
    private static final String LOG_TAG = LoginActivity.class.getSimpleName();
    private EditText email;
    private EditText password;
    public static final int TEXT_REQUEST = 1;
    private static ArrayList<Account> list = new ArrayList<>();

    Citta c = new Citta("Bitonto", "Bari");

    Persona persona = new Persona("Alessio", "Cuoccio", 25, "3662138262", "M", c);

    Account test = new Account("ale@email.com", "123", persona);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        list.add(test);
    }

    public void paginaRegister(View view) {
        Log.d(LOG_TAG, "Register Clicked");
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivityForResult(intent, TEXT_REQUEST);

    }

    public void login(View view) {
        if (Check.checkField(email) && Check.checkField(password)) {

            if (list.isEmpty()) {

                MyDialog.makeDialog(this, "Failed", "Nessun utente registrato");

            } else {

                for (Account account : list) {

                    if (email.getText().toString().equals(account.getEmail()) &&
                            password.getText().toString().equals(account.getPassword())) {

                        Intent intent = new Intent(this, MainActivity.class);
                        intent.putExtra("Account", account);
                        startActivity(intent);

                    } else {

                        MyDialog.makeDialog(this, "Failed", "Dati non corretti");
                    }
                }
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Boolean registered = false;

        if (requestCode == TEXT_REQUEST) {

            if (resultCode == RESULT_OK) {

                Account account = data.getParcelableExtra(RegistrationActivity.EXTRA_REPLY);

                for (Account account1 : list) {

                    if (account.getEmail().equals(account1.getEmail())) {

                        registered = true;
                    }
                }
                if (registered) {

                    MyDialog.makeDialog(this, "Failed", "Utente già registrato");

                } else {

                    list.add(account);
                    MyDialog.makeDialog(this, "Success", "Utente registrato");

                }
            }
        }
    }

}