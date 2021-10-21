package com.example.helloconstraint;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int mCount = 0;
    private TextView mShowCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this,
                R.string.toast_message,
                Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view) {
        mCount++;
        findViewById(R.id.button_zero).setBackgroundColor(Color.RED);
        view.setBackgroundColor(Color.GREEN);
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }

    public void makeZero(View view) {
        mCount = 0;
        if (mShowCount != null)
        {
            mShowCount.setText(Integer.toString(mCount));
            view.setBackgroundColor(Color.GRAY);
            findViewById(R.id.button_count).setBackgroundColor(Color.rgb(98,0,238));
        }
    }
}