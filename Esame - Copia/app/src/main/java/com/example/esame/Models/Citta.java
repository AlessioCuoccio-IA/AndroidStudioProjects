package com.example.esame.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Citta implements Parcelable {
    private String nome;
    private String provincia;

    public Citta(String nome, String provincia) {
        this.nome = nome;
        this.provincia = provincia;
    }

    protected Citta(Parcel in) {
        nome = in.readString();
        provincia = in.readString();
    }

    public static final Creator<Citta> CREATOR = new Creator<Citta>() {
        @Override
        public Citta createFromParcel(Parcel in) {
            return new Citta(in);
        }

        @Override
        public Citta[] newArray(int size) {
            return new Citta[size];
        }
    };

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return "Citta{" +
                "nome='" + nome + '\'' +
                ", provincia='" + provincia + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(provincia);
    }
}
