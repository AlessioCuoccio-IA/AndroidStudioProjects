package com.example.esame.Utils;

import android.widget.EditText;
import android.widget.RadioButton;

public abstract class Check {

    public static boolean checkField(EditText text){
        if(text.length() == 0) {
            text.setError("Campo obbligatorio");
            return false;
        } return true;
    }
}
