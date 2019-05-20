package com.example.achmadqomarudin.banksampah.penjual;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.example.achmadqomarudin.banksampah.R;

public class DaftarPenjual extends AppCompatActivity {

    public EditText mNamaLengkap, mEmail, mPassword, mAlamatLengkap, mNoTelpon, mNoKtp;
    public Button mBtnDaftarPenjual;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penjual_daftar);

        /**Daftar Isi Form Penjual*/
        /*mNamaLengkap = (EditText) findViewById(R.id.id_nama_lengkap_penjual);
        mEmail = (EditText) findViewById(R.id.id_email_penjual);
        mPassword = (EditText) findViewById(R.id.id_password_penjual);
        mAlamatLengkap = (EditText) findViewById(R.id.id_alamat_lengkap_penjual);
        mNoTelpon = (EditText) findViewById(R.id.id_no_telpon_penjual);
        mNoKtp = (EditText) findViewById(R.id.id_no_ktp_penjual);*/

        /**Button Email*/
       /* mBtnDaftarPenjual = (Button) findViewById(R.id.btn_daftar_penjual);
        mBtnDaftarPenjual.setOnClickListener(new OnClickListener() {

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

                Intent i_btn_daftar_penjual = new Intent(DaftarPenjual.this, DashboardPenjual.class);
                startActivity(i_btn_daftar_penjual);
            }
            }
        });*/
    }
}

