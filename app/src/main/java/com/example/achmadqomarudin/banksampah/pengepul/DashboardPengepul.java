package com.example.achmadqomarudin.banksampah.pengepul;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.achmadqomarudin.banksampah.R;
import com.example.achmadqomarudin.banksampah.pengepul.fragment.BerandaPengepulFragment;
import com.example.achmadqomarudin.banksampah.pengepul.fragment.NasabahFragment;
import com.example.achmadqomarudin.banksampah.pengepul.fragment.NotifikasiPengepulFragment;
import com.example.achmadqomarudin.banksampah.pengepul.fragment.ProfilePengepulFragment;

public class DashboardPengepul extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_beranda:
                    startFragment(R.id.content, new BerandaPengepulFragment());
                    return true;
                case R.id.nav_nasabah:
                    startFragment(R.id.content, new NasabahFragment());
                    return true;
                case R.id.nav_notif:
                    startFragment(R.id.content, new NotifikasiPengepulFragment());
                    return true;
                case R.id.nav_profile:
                startFragment(R.id.content, new ProfilePengepulFragment());
                return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengepul_dashboard);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .add(R.id.content, new BerandaPengepulFragment())
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
