package com.example.contectbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Contactadapter extends RecyclerView.Adapter<Contactadapter.Myclass> {
    AllContactActivity allContactActivity;
    ArrayList<String> nameList;
    ArrayList<String> numberList;
    ArrayList<Integer> idlist;

    public Contactadapter(AllContactActivity allContactActivity, ArrayList<String> nameList, ArrayList<String> numberList, ArrayList<Integer> idlist) {
        this.allContactActivity = allContactActivity;
        this.nameList = nameList;
        this.numberList = numberList;
        this.idlist = idlist;
    }

    @NonNull
    @Override
    public Contactadapter.Myclass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(allContactActivity).inflate(R.layout.contact_item_layout,parent,false);
        Myclass myclass = new Myclass(view);
        return myclass;
    }

    @Override
    public void onBindViewHolder(@NonNull Contactadapter.Myclass holder, int position) {

        int userid = idlist.get(position);
        String name = nameList.get(position);
        String number = numberList.get(position);

        holder.tvcapital.setText(name);
        holder.tvname.setText(name);
        holder.tvnumber.setText(number);

    }

    @Override
    public int getItemCount() {
        return idlist.size();
    }

    public class Myclass extends RecyclerView.ViewHolder {

        TextView tvcapital;
        TextView tvname;
        TextView tvnumber;
        public Myclass(@NonNull View itemView) {
            super(itemView);

            tvcapital = itemView.findViewById(R.id.tvcapital);
            tvname = itemView.findViewById(R.id.tvname);
            tvnumber = itemView.findViewById(R.id.tvnumber);

        }
    }
}
