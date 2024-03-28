package com.example.contectbook;

import android.media.MediaDrm;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Contactadapter extends RecyclerView.Adapter<Contactadapter.Myclass> {
    AllContactActivity allContactActivity;
    ArrayList<User> userlist;

    public Contactadapter(AllContactActivity allContactActivity, ArrayList<User> userlist) {
        this.allContactActivity = allContactActivity;
        this.userlist = userlist;
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

        User user = userlist.get(position);
        int id = user.getUserid();
        String name = user.getName();
        String number = user.getNumber();

        holder.tvcapital.setText(name);
        holder.tvname.setText(name);
        holder.tvnumber.setText(number);

        holder.ivoption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }

    @Override
    public int getItemCount() {
        return userlist.size();
    }

    public class Myclass extends RecyclerView.ViewHolder {
        TextView tvcapital;
        TextView tvname;
        TextView tvnumber;
        ImageView ivoption;
        public Myclass(@NonNull View itemView) {
            super(itemView);
            tvcapital = itemView.findViewById(R.id.tvcapital);
            tvname = itemView.findViewById(R.id.tvname);
            tvnumber = itemView.findViewById(R.id.tvnumber);
            ivoption = itemView.findViewById(R.id.ivoption);
        }
    }
}
