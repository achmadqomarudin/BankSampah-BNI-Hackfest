package com.example.achmadqomarudin.banksampah.penjual.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Achmad Qomarudin on 12/09/2017.
 */

public class SliderPagerAdapter extends FragmentStatePagerAdapter{

    private static final String TAG = "SliderPagerAdapter";
    List<Fragment> mFrags = new ArrayList<>();

    public SliderPagerAdapter(FragmentManager fm, List<Fragment> frags) {
        super(fm);
        mFrags = frags;
    }

    @Override
    public Fragment getItem(int position) {
        int index = position % mFrags.size();
        Log.d(TAG, "position: " + position);
        Log.d(TAG, "index: " + index);
        return FragmentSlider.newInstance(mFrags.get(index).getArguments().getString("params"));
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }
}
