package com.example.andriginting.recyclerview;

/**
 * Created by Andri Ginting on 11/8/2017.
 */

public class KontenModel  {
    public String gambar,nama;

    public KontenModel(String gambar, String nama) {
        this.gambar = gambar;
        this.nama = nama;
    }

    public KontenModel() {
    }

    public String  getGambar() {
        return gambar;
    }

    public String getNama() {
        return nama;
    }
}
