package com.example.esame.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.esame.R;

public class ProdottiActivity extends AppCompatActivity {

    public static final String EXTRA_ITEMS = "com.example.esame.activities.ProdottiActivity.extra.ITEMS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prodotti);
    }


    public void selectProduct(View view) {
        Intent intent = new Intent();

        switch (view.getId()){
            case R.id.pane:
                intent.putExtra(EXTRA_ITEMS, "Pane");
                setResult(RESULT_OK, intent);
                finish();
                break;
            case R.id.latte:
                intent.putExtra(EXTRA_ITEMS, "Latte");
                setResult(RESULT_OK, intent);
                finish();
                break;
            case R.id.olio:
                intent.putExtra(EXTRA_ITEMS, "Olio");
                setResult(RESULT_OK, intent);
                finish();
                break;
            case R.id.uova:
                intent.putExtra(EXTRA_ITEMS, "Uova");
                setResult(RESULT_OK, intent);
                finish();
                break;

            case R.id.formaggio:
                intent.putExtra(EXTRA_ITEMS, "Formaggio");
                setResult(RESULT_OK, intent);
                finish();
                break;
            case R.id.riso:
                intent.putExtra(EXTRA_ITEMS, "Riso");
                setResult(RESULT_OK, intent);
                finish();
                break;

            default:
                Toast.makeText(ProdottiActivity.this, "There was an error", Toast.LENGTH_LONG).show();
                break;
        }
    }
}