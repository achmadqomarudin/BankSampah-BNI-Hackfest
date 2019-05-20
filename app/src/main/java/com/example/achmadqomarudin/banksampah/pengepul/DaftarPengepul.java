package com.example.achmadqomarudin.banksampah.pengepul;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.example.achmadqomarudin.banksampah.R;

/**
 * A login screen that offers login via email/password.
 */
public class DaftarPengepul extends AppCompatActivity {

    public EditText mNamaLengkap, mEmail, mPassword, mAlamatLengkap, mNoTelpon, mNoKtp;
    public Button mBtnPendaftaranPengepul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengepul_daftar);

        /**Daftar Isi Form Pengepul*/
        /*mNamaLengkap = (EditText) findViewById(R.id.id_nama_lengkap_pengepul);
        mEmail = (EditText) findViewById(R.id.id_email_pengepul);
        mPassword = (EditText) findViewById(R.id.id_password_pengepul);
        mAlamatLengkap = (EditText) findViewById(R.id.id_alamat_lengkap_pengepul);
        mNoTelpon = (EditText) findViewById(R.id.id_no_telpon_pengepul);
        mNoKtp = (EditText) findViewById(R.id.id_no_ktp_pengepul);

        *//**Button Email*//*
        mBtnPendaftaranPengepul = (Button) findViewById(R.id.btn_daftar_pengepul);
        mBtnPendaftaranPengepul.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {

                final String NamaLengkap = mNamaLengkap.getText().toString();
                final String Email = mEmail.getText().toString();
                final String Password = mPassword.getText().toString();
                final String AlamatLengkap = mAlamatLengkap.getText().toString();
                final String NoTelpon = mNoTelpon.getText().toString();
                final String NoKtp = mNoKtp.getText().toString();

                if (NamaLengkap.isEmpty() || Email.isEmpty() || Password.isEmpty() || AlamatLengkap.isEmpty() || NoTelpon.isEmpty() || NoKtp.isEmpty()) {

                    mNamaLengkap.setError("Nama Lengkap tidak boleh kosong!");
                    mEmail.setError("Email tidak boleh kosong!");
                    mPassword.setError("Password tidak boleh kosong");
                    mAlamatLengkap.setError("Alamat Lengkap tidak boleh kosong!");
                    mNoTelpon.setError("No. Telpon tidak boleh kosong!");
                    mNoKtp.setError("No. KTP tidak boleh kosong!");

                } else {

                    Intent i_btn_daftar_pengepul = new Intent(DaftarPengepul.this, DashboardPengepul.class);
                    startActivity(i_btn_daftar_pengepul);
                }
            }
        });*/
    }
}

