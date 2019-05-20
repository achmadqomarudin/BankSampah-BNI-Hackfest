package com.example.achmadqomarudin.banksampah.pengepul.nasabah;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.example.achmadqomarudin.banksampah.R;

public class BankNasabahActivity extends AppCompatActivity {

    private RadioGroup radioG;
    private CardView cardUang, cardBarang;
    private LinearLayout line1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengepul_banknasabah);

        radioG     = (RadioGroup) findViewById(R.id.gRadio);
        line1      = (LinearLayout) findViewById(R.id.line1);
        cardUang   = (CardView) findViewById(R.id.cardUang);
        cardBarang = (CardView) findViewById(R.id.cardBarang);

        line1.removeView(cardBarang);

        radioG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rB1:
                        line1.removeView(cardBarang);
                        line1.addView(cardUang);
                        break;
                    case R.id.rB2:
                        line1.removeView(cardUang);
                        line1.addView(cardBarang);
                        break;
                }
            }
        });
    }
}
