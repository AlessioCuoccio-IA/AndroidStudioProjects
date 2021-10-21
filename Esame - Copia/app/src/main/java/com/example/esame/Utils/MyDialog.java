package com.example.esame.Utils;

import android.content.Context;

import androidx.appcompat.app.AlertDialog;

public abstract class MyDialog {

    public static void makeDialog(Context context, String title, String message) {
        AlertDialog.Builder builder=new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(true);
        builder.show();
    }
}
