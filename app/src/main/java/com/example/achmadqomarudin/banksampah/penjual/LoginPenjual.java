package com.example.achmadqomarudin.banksampah.penjual;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.achmadqomarudin.banksampah.R;

/**
 * A login screen that offers login via email/password.
 */
public class LoginPenjual extends AppCompatActivity {

    private TextView mTvDaftar;
    private Button mBtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penjual_login);

        mTvDaftar = (TextView) findViewById(R.id.tv_daftar_penjual);
        mBtnLogin = (Button) findViewById(R.id.btn_sign_in_penjual);

        mTvDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), DaftarPenjual.class));
            }
        });

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), DashboardPenjual.class));
            }
        });

    }
}

