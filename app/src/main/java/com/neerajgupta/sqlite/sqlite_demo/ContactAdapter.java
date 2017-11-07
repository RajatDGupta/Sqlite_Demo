package com.neerajgupta.sqlite.sqlite_demo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Neeraj on 06-Nov-17.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MyHolder> {

    private Context context;
    ArrayList<Contact> arrayList;

    public ContactAdapter(Context context, ArrayList<Contact> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_get_all_data, parent, false);
        return new MyHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.tv_id.setText(String.valueOf(arrayList.get(position).get_id()));
        holder.tv_name.setText(arrayList.get(position).get_name());
        holder.tv_phone.setText(arrayList.get(position).get_phone_number());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    final class MyHolder extends RecyclerView.ViewHolder {

        TextView tv_id, tv_name, tv_phone;

        public MyHolder(View itemView) {
            super(itemView);

            tv_id = itemView.findViewById(R.id.tv_id);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_phone = itemView.findViewById(R.id.tv_mobile);
        }
    }
}
