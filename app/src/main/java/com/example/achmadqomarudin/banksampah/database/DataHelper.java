package com.example.achmadqomarudin.banksampah.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilhamelmujib on 7/29/17.
 */

public class DataHelper extends SQLiteOpenHelper{

    public static final String db = "db_bank_sampah";
    public static final String tb_penjual = "tb_penjual";
    public static final String tb_pengepul = "tb_pengepul";
    public static final String tb_barang = "tb_barang";
    public static final String tb_tembar = "tb_tembar"; //temporary barang
    public static final String tb_nasbar = "tb_nasbar"; //nasbah barang -> 0 = bank nasabah, 1 = luar nasabah
    public static final String tb_nasabah = "tb_nasabah";


    public static final List<String> create = new ArrayList<String>(){{
        add("create table " + tb_penjual +
                " (nama_penjual TEXT, email TEXT PRIMARY KEY,password TEXT,alamat TEXT, telp TEXT, no_ktp TEXT)");
        add("create table " + tb_pengepul +
                " (nama_bank TEXT,nama_pemilik TEXT, email TEXT PRIMARY KEY,password TEXT,alamat TEXT, telp TEXT)");
        add("create table " + tb_barang +
                " (id_barang INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,nama_barang TEXT, jenis TEXT,harga INTEGER)");
        add("create table " + tb_tembar +
                " (id_tembar INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, id_barang INTEGER, qty INTEGER,subtotal INTEGER)");
        add("create table " + tb_nasbar +
                " (id_nasbar INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, email_penjual TEXT ,id_barang INTEGER, qty INTEGER,subtotal INTEGER, status INTEGER)");
        add("create table " + tb_nasabah +
                " (id_nasabah INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, email_penjual TEXT ,email_pengepul TEXT)");

    }};

    public static final List<String> table = new ArrayList<String>(){{
        add(tb_penjual);
        add(tb_pengepul);
        add(tb_barang);
        add(tb_tembar);
        add(tb_nasbar);
        add(tb_nasabah);
    }};

    public DataHelper(Context context) {
        super(context, db, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        for (int i = 0; i < create.size(); i++){
            sqLiteDatabase.execSQL(create.get(i));
        }

        List<String> nama_penjual = new ArrayList<String>(){{
            add("Muhamad Ilham");
            add("Ferdi Haspi N");
            add("Angelena Abbiyah");
            add("John Lenon");
            add("Agnesia");
        }};

        List<String> email = new ArrayList<String>(){{
            add("muhamadilham@gmail.com");
            add("ferdihaspin@gmail.com");
            add("angelenaabbiyah@gmail.com");
            add("johnlenon@gmail.com");
            add("agnesia@gmail.com");
        }};

        List<String> pass = new ArrayList<String>(){{
            add("12345");
            add("12121");
            add("21212");
            add("0");
            add("1");

        }};

        List<String> alamat = new ArrayList<String>(){{
            add("Jl. Nasi Ayam Kremes + Minum");
            add("Jl. Nasi Ayam Bakar + Aqua");
            add("Jl. Nasi Ayam Kremes + Soto + Minum");
            add("Jl. Nasi Ayam Cincang + minum");
            add("Jl. Soto Babat + Fanta");
        }};
        List<String> telp = new ArrayList<String>(){{
            add("09394839489");
            add("09394839489");
            add("09394839489");
            add("09394839489");
            add("09394839489");
        }};
        List<String> ktp = new ArrayList<String>(){{
            add("25000");
            add("26000");
            add("27000");
            add("20000");
            add("25000");
        }};
        try {
            for (int i = 0; i < nama_penjual.size(); i++){
                String sql = "INSERT INTO tb_penjual (nama_penjual, email,password,alamat, telp, no_ktp) VALUES " +
                        "('"+nama_penjual.get(i)+"', " +
                        "'"+email.get(i)+"'," +
                        "'"+pass.get(i)+"'," +
                        "'"+alamat.get(i)+"'," +
                        "'"+telp.get(i)+"'," +
                        "'"+ktp.get(i)+"');";
                sqLiteDatabase.execSQL(sql);
            }

        }catch (SQLException e){
            System.out.print(e.toString());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        for (int j = 0; j < table.size(); j++){
            sqLiteDatabase.execSQL(table.get(j));
        }
    }
}
