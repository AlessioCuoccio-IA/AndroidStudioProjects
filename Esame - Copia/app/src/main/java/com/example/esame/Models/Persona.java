package com.example.esame.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Persona implements Parcelable {
    private String nome;
    private String cognome;
    private Integer eta;
    private String telefono;
    private String sesso;
    private Citta citta;

    public Persona(String nome, String cognome, Integer eta, String telefono, String sesso, Citta citta) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.telefono = telefono;
        this.sesso = sesso;
        this.citta = citta;
    }

    protected Persona(Parcel in) {
        nome = in.readString();
        cognome = in.readString();
        if (in.readByte() == 0) {
            eta = null;
        } else {
            eta = in.readInt();
        }
        telefono = in.readString();
        sesso = in.readString();
        citta = in.readParcelable(Citta.class.getClassLoader());
    }

    public static final Creator<Persona> CREATOR = new Creator<Persona>() {
        @Override
        public Persona createFromParcel(Parcel in) {
            return new Persona(in);
        }

        @Override
        public Persona[] newArray(int size) {
            return new Persona[size];
        }
    };

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Integer getEta() {
        return eta;
    }

    public void setEta(Integer eta) {
        this.eta = eta;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSesso() {
        return sesso;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    public Citta getCitta() {
        return citta;
    }

    public void setCitta(Citta citta) {
        this.citta = citta;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", eta=" + eta +
                ", telefono='" + telefono + '\'' +
                ", sesso=" + sesso +
                ", citta=" + citta +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(cognome);
        if (eta == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(eta);
        }
        dest.writeString(telefono);
        dest.writeString(sesso);
        dest.writeParcelable(citta, flags);
    }
}
