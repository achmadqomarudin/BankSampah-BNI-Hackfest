package com.example.achmadqomarudin.banksampah.pengepul.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.achmadqomarudin.banksampah.R;
import com.example.achmadqomarudin.banksampah.pengepul.nasabah.BankNasabahActivity;
import com.example.achmadqomarudin.banksampah.pengepul.nasabah.LuarNasabahActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class BerandaPengepulFragment extends Fragment {

    private CardView cardBank, cardLuar;

    public BerandaPengepulFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pengepul_beranda, container, false);

        cardBank = rootView.findViewById(R.id.cardBank);
        cardLuar = rootView.findViewById(R.id.cardLuar);

        cardBank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), BankNasabahActivity.class));
            }
        });

        cardLuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), LuarNasabahActivity.class));
            }
        });

        return rootView;
    }

}
