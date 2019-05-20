package com.example.achmadqomarudin.banksampah.adapter;

/**
 * Created by ilhamelmujib on 8/17/17.
 */

public class Penjual {
    private String nama, id;
    private Integer icon;

    public Penjual(String nama, String id, Integer icon) {
        this.nama = nama;
        this.id = id;
        this.icon = icon;
    }

    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public Integer getIcon() {
        return icon;
    }
    public void setIcon(Integer icon) {
        this.icon = icon;
    }
}