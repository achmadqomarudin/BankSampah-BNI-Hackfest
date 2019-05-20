package com.example.achmadqomarudin.banksampah.pengepul.fragment;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.achmadqomarudin.banksampah.R;
import com.example.achmadqomarudin.banksampah.adapter.Penjual;
import com.example.achmadqomarudin.banksampah.adapter.PenjualCustomAdapter;
import com.example.achmadqomarudin.banksampah.database.DataHelper;
import com.example.achmadqomarudin.banksampah.utils.SwipeUtilDelete;
import com.example.achmadqomarudin.banksampah.utils.SwipeUtilEdit;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NasabahFragment extends Fragment {

    private static final String TAG = "RecyclerViewFragment";
    private static final String KEY_LAYOUT_MANAGER = "layoutManager";
    private static final int SPAN_COUNT = 2;

    List<Penjual> penjualList;

    private enum LayoutManagerType {
        LINEAR_LAYOUT_MANAGER
    }

    protected NasabahFragment.LayoutManagerType mCurrentLayoutManagerType;
    protected RecyclerView mRecyclerView;
    protected PenjualCustomAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pengepul_nasabah, container, false);
        rootView.setTag(TAG);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);

        mLayoutManager = new LinearLayoutManager(getActivity());

        mCurrentLayoutManagerType = NasabahFragment.LayoutManagerType.LINEAR_LAYOUT_MANAGER;

        if (savedInstanceState != null) {
            mCurrentLayoutManagerType = (NasabahFragment.LayoutManagerType) savedInstanceState
                    .getSerializable(KEY_LAYOUT_MANAGER);
        }
        setRecyclerViewLayoutManager(mCurrentLayoutManagerType);

        penjualList = new ArrayList<>();
        mAdapter = new PenjualCustomAdapter(penjualList);

        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mAdapter);

        initDataset();
        setSwipeForRecyclerView();

        return rootView;
    }

    public void setRecyclerViewLayoutManager(NasabahFragment.LayoutManagerType layoutManagerType) {
        int scrollPosition = 0;

        // If a layout manager has already been set, get current scroll position.
        if (mRecyclerView.getLayoutManager() != null) {
            scrollPosition = ((LinearLayoutManager) mRecyclerView.getLayoutManager())
                    .findFirstCompletelyVisibleItemPosition();
        }

        mLayoutManager = new LinearLayoutManager(getActivity());
        mCurrentLayoutManagerType = NasabahFragment.LayoutManagerType.LINEAR_LAYOUT_MANAGER;
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.scrollToPosition(scrollPosition);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save currently selected layout manager.
        savedInstanceState.putSerializable(KEY_LAYOUT_MANAGER, mCurrentLayoutManagerType);
        super.onSaveInstanceState(savedInstanceState);
    }

    private void initDataset() {
        try {
            DataHelper dataHelper = new DataHelper(getActivity());
            SQLiteDatabase db = dataHelper.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM tb_penjual ORDER BY nama_penjual ASC", null);
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                    Penjual penjual = new Penjual(cursor.getString(0), cursor.getString(1), R.drawable.png_profile_login);
                    penjualList.add(penjual);

            }

        } catch (Exception e) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                    .setMessage(e.getMessage());
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
    }


    public void setSwipeForRecyclerView() {

        SwipeUtilDelete swipeHelper = new SwipeUtilDelete(0, ItemTouchHelper.LEFT, getActivity()) {
            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                final int swipedPosition = viewHolder.getAdapterPosition();
                PenjualCustomAdapter adapter = (PenjualCustomAdapter) mRecyclerView.getAdapter();
            }
        };

        ItemTouchHelper mItemTouchHelper = new ItemTouchHelper(swipeHelper);
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
        swipeHelper.setLeftcolorCode(ContextCompat.getColor(getActivity(), R.color.colorRed));

        SwipeUtilEdit swipeHelpers = new SwipeUtilEdit(0, ItemTouchHelper.RIGHT, getActivity()) {
            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                int swipedPosition = viewHolder.getAdapterPosition();
                PenjualCustomAdapter adapter = (PenjualCustomAdapter) mRecyclerView.getAdapter();
            }
        };

        ItemTouchHelper mItemTouchHelpers = new ItemTouchHelper(swipeHelpers);
        mItemTouchHelpers.attachToRecyclerView(mRecyclerView);
        swipeHelpers.setLeftcolorCode(ContextCompat.getColor(getActivity(), R.color.colorPrimary));

    }
}