/*
* Copyright (C) 2014 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.achmadqomarudin.banksampah.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.achmadqomarudin.banksampah.R;

import java.util.List;


public class PenjualCustomAdapter extends RecyclerView.Adapter<PenjualCustomAdapter.ViewHolder> {
    private List<Penjual> penjualList;
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvNama, tvId;
        public ImageView ivIcon;

        public ViewHolder(View v) {
            super(v);
            tvNama = v.findViewById(R.id.tvNama);
            tvId   = v.findViewById(R.id.tvId);
            ivIcon = v.findViewById(R.id.ivIcon);
        }

    }

    public PenjualCustomAdapter(List<Penjual> penjualList) {
        this.penjualList = penjualList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_penjual_item, viewGroup, false);

        return new ViewHolder(v);
    }

    public void add(Penjual s){
        penjualList.add(s);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Penjual penjual = penjualList.get(position);
        viewHolder.tvNama.setText(penjual.getNama());
        viewHolder.tvId.setText(penjual.getId());
        viewHolder.ivIcon.setBackgroundResource(penjual.getIcon());
    }

    @Override
    public int getItemCount() {
        return penjualList.size();
    }


}
