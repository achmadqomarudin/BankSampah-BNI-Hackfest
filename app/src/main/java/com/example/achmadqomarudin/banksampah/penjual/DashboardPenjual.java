package com.example.achmadqomarudin.banksampah.penjual;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.achmadqomarudin.banksampah.R;
import com.example.achmadqomarudin.banksampah.penjual.fragment.BerandaFragment;
import com.example.achmadqomarudin.banksampah.penjual.fragment.ProfilePenjualFragment;
import com.example.achmadqomarudin.banksampah.penjual.fragment.SaldoPenjualFragment;

public class DashboardPenjual extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_beranda:
                    startFragment(R.id.content, new BerandaFragment());
                    setTitle("Menu Beranda");
                    return true;
                case R.id.nav_saldo:
                    startFragment(R.id.content, new SaldoPenjualFragment());
                    setTitle("Menu Saldo");
                    return true;
                case R.id.nav_profile:
                    startFragment(R.id.content, new ProfilePenjualFragment());
                    setTitle("Menu Profile");
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penjual_dashboard);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .add(R.id.content, new BerandaFragment())
                .commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void startFragment(int container, Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .replace(container, fragment)
                .commit();
    }
}
