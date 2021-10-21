package com.example.esame.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Account  implements Parcelable {
    private String email;
    private String password;
    private Persona persona;

    public Account(String email, String password, Persona persona) {
        this.email = email;
        this.password = password;
        this.persona = persona;
    }

    protected Account(Parcel in) {
        email = in.readString();
        password = in.readString();
        persona = in.readParcelable(Persona.class.getClassLoader());
    }

    public static final Creator<Account> CREATOR = new Creator<Account>() {
        @Override
        public Account createFromParcel(Parcel in) {
            return new Account(in);
        }

        @Override
        public Account[] newArray(int size) {
            return new Account[size];
        }
    };

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + email + '\'' +
                ", password='" + password + '\'' +
                ", persona=" + persona +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(email);
        dest.writeString(password);
        dest.writeParcelable(persona, flags);
    }
}
