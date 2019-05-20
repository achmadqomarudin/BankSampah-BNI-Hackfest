package com.example.achmadqomarudin.banksampah.penjual.fragment;


import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.achmadqomarudin.banksampah.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BerandaFragment extends Fragment implements View.OnClickListener {

    /**Menu Slider*/
    private SliderPagerAdapter mAdapter;
    private SliderIndicator mIndicator;
    private SliderView sliderView;
    private LinearLayout mLinearLayout;

    private Dialog dialog;
    private CardView cBotol, cGelas, cEmber, cKoran, cBukuTulis, cKardus, cMajalah, cHvs,
    cKantongSemen, cPaku, cKawat, cPipa;

    public BerandaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_penjual_beranda, container, false);

        sliderView = (SliderView) rootView.findViewById(R.id.sliderView);
        mLinearLayout = (LinearLayout) rootView.findViewById(R.id.pagesContainer);
        setupSlider();

        cBotol = rootView.findViewById(R.id.cBotol);
        cBotol.setOnClickListener(this);
        cGelas = rootView.findViewById(R.id.cGelas);
        cGelas.setOnClickListener(this);
        cEmber = rootView.findViewById(R.id.cEmber);
        cEmber.setOnClickListener(this);
        cKoran = rootView.findViewById(R.id.cKoran);
        cKoran.setOnClickListener(this);
        cBukuTulis = rootView.findViewById(R.id.cBukuTulis);
        cBukuTulis.setOnClickListener(this);
        cKardus = rootView.findViewById(R.id.cKardus);
        cKardus.setOnClickListener(this);
        cMajalah = rootView.findViewById(R.id.cMajalah);
        cMajalah.setOnClickListener(this);
        cHvs = rootView.findViewById(R.id.cHvs);
        cHvs.setOnClickListener(this);
        cKantongSemen = rootView.findViewById(R.id.cKantongSemen);
        cKantongSemen.setOnClickListener(this);
        cPaku = rootView.findViewById(R.id.cPaku);
        cPaku.setOnClickListener(this);
        cKawat = rootView.findViewById(R.id.cKawat);
        cKawat.setOnClickListener(this);
        cPipa = rootView.findViewById(R.id.cPipa);
        cPipa.setOnClickListener(this);

        // Inflate the layout for this fragment
        return rootView;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cBotol:
                dialogTambah();
                break;
            case R.id.cGelas:
                dialogTambah();
                break;
            case R.id.cEmber:
                dialogTambah();
                break;
            case R.id.cKoran:
                dialogTambah();
                break;
            case R.id.cBukuTulis:
                dialogTambah();
                break;
            case R.id.cKardus:
                dialogTambah();
                break;
            case R.id.cMajalah:
                dialogTambah();
                break;
            case R.id.cHvs:
                dialogTambah();
                break;
            case R.id.cKantongSemen:
                dialogTambah();
                break;
            case R.id.cPaku:
                dialogTambah();
                break;
            case R.id.cKawat:
                dialogTambah();
                break;
            case R.id.cPipa:
                dialogTambah();
                break;
            default:
                break;
        }
    }

    private void setupSlider() {
        sliderView.setDurationScroll(1000);
        List<Fragment> fragments = new ArrayList<>();

        fragments.add(FragmentSlider.newInstance("https://image.tmdb.org/t/p/w250_and_h141_bestv2/zYFQM9G5j9cRsMNMuZAX64nmUMf.jpg"));
        fragments.add(FragmentSlider.newInstance("https://image.tmdb.org/t/p/w250_and_h141_bestv2/rXBB8F6XpHAwci2dihBCcixIHrK.jpg"));
        fragments.add(FragmentSlider.newInstance("https://image.tmdb.org/t/p/w250_and_h141_bestv2/biN2sqExViEh8IYSJrXlNKjpjxx.jpg"));
        fragments.add(FragmentSlider.newInstance("https://image.tmdb.org/t/p/w250_and_h141_bestv2/o9OKe3M06QMLOzTl3l6GStYtnE9.jpg"));

        mAdapter = new SliderPagerAdapter(getFragmentManager(), fragments);
        sliderView.setAdapter(mAdapter);
        mIndicator = new SliderIndicator(this, mLinearLayout, sliderView, R.drawable.indicator_circle);
        mIndicator.setPageCount(fragments.size());
        mIndicator.show();
    }

    private void dialogTambah(){
        dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_tambah);
        dialog.setCanceledOnTouchOutside(false);
        ImageButton mExitDialog = dialog.findViewById(R.id.exit_dialog);
        Button mBotolSetor = dialog.findViewById(R.id.cBotolSetor);
        mBotolSetor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Data berhasil disimpan", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        mExitDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        dialog.getWindow().setLayout((6 * width) / 7, LinearLayout.LayoutParams.WRAP_CONTENT);
        dialog.show();
    }
}
