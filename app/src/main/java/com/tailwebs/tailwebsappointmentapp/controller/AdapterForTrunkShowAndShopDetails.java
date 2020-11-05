package com.tailwebs.tailwebsappointmentapp.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tailwebs.tailwebsappointmentapp.R;
import com.tailwebs.tailwebsappointmentapp.model.Sales_person_shops_List;
import com.tailwebs.tailwebsappointmentapp.model.Trunk_shows_list;
import com.tailwebs.tailwebsappointmentapp.utils.GlobalValue;
import com.tailwebs.tailwebsappointmentapp.view.DashboardActivity;

import java.util.ArrayList;

public class AdapterForTrunkShowAndShopDetails  extends RecyclerView.Adapter  {
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private Context context;
    private ArrayList<Sales_person_shops_List> arrayList;
    private ArrayList<Trunk_shows_list> trunkShowsListArrayList;
    public AdapterForTrunkShowAndShopDetails(Context context, ArrayList<Sales_person_shops_List> arrayList, ArrayList<Trunk_shows_list> trunkShowsListArrayList){
        this.context = context;
        this.arrayList = arrayList;
        this.trunkShowsListArrayList = trunkShowsListArrayList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            // Here Inflating your recyclerview item layout
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout_for_shop_recycler, parent, false);
            return new ItemViewHolder(itemView);
        } else if (viewType == TYPE_HEADER) {
            // Here Inflating your header view
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout_for_header, parent, false);
            return new HeaderViewHolder(itemView);
        }
        else return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HeaderViewHolder){

            HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;

            // You have to set your header items values with the help of model class and you can modify as per your needs

            if (position == 0){
                headerViewHolder.textView.setText("STORE");
            }else {
                headerViewHolder.textView.setText("TRUNK SHOWS");
            }

        }
        else if (holder instanceof ItemViewHolder){

            final ItemViewHolder itemViewHolder = (ItemViewHolder) holder;

            // Following code give a row of header and decrease the one position from listview items


            // You have to set your listview items values with the help of model class and you can modify as per your needs
            if (position > arrayList.size()){
                itemViewHolder.name.setText(trunkShowsListArrayList.get(position - arrayList.size()-2).getCode());
                itemViewHolder.address.setText(trunkShowsListArrayList.get(position -arrayList.size() - 2).getAddress().getLine1());
                int color = Color.parseColor(trunkShowsListArrayList.get(position-arrayList.size()-2).getColor_code().getLight_color());
                itemViewHolder.linearLayout.setBackgroundColor(color);
            }else {
                itemViewHolder.name.setText(arrayList.get(position - 1).getShop().getName());
                itemViewHolder.address.setText(arrayList.get(position -1 ).getShop().getAddress().getLine1());
                int color = Color.parseColor(arrayList.get(position-1).getShop().getLight_color_code());
                itemViewHolder.linearLayout.setBackgroundColor(color);

            }
            itemViewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (position>arrayList.size()){
                        GlobalValue.setTrunk_shows_lists(new ArrayList<>());
                        GlobalValue.getTrunk_shows_lists().add(trunkShowsListArrayList.get(position - arrayList.size()-2));
                        GlobalValue.setShopName(trunkShowsListArrayList.get(position - arrayList.size() - 2).getCode());
                        GlobalValue.setSelectedId(trunkShowsListArrayList.get(position - arrayList.size() - 2).getId());
                        GlobalValue.Companion.setSelectedShop(false);
                        GlobalValue.Companion.setSelectedTrunkShow(true);
                        GlobalValue.Companion.setFromAdapter(true);
                    }else {
                        GlobalValue.setShops_lists(new ArrayList<>());
                        GlobalValue.getShops_lists().add(arrayList.get(position - 1));
                        GlobalValue.setShopName(arrayList.get(position - 1).getShop().getName());
                        GlobalValue.setSelectedId(arrayList.get(position - 1).getShop().getId());
                        GlobalValue.Companion.setSelectedShop(true);
                        GlobalValue.Companion.setSelectedTrunkShow(false);
                        GlobalValue.Companion.setFromAdapter(true);
                    }
                    Intent intent = new Intent(context, DashboardActivity.class);
                    context.startActivity(intent);
                    ((Activity)context).finish();
                }
            });

        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        }else if (position == arrayList.size() + 1){
            return TYPE_HEADER;
        }
        return TYPE_ITEM;
    }
    @Override
    public int getItemCount() {
        return trunkShowsListArrayList.size()+ arrayList.size()+2;
    }

    private class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public HeaderViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.textId);

        }
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView name ,address,time_slot;
        LinearLayout linearLayout;
        public ItemViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textview1Id);
            address = itemView.findViewById(R.id.textview3Id);
            time_slot = itemView.findViewById(R.id.textview2Id);
            linearLayout = itemView.findViewById(R.id.layoutId);

        }
    }
}
