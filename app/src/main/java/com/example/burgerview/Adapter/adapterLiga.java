package com.example.burgerview.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.burgerview.Model.ModelLiga;
import com.example.burgerview.R;

import java.util.ArrayList;

public class adapterLiga extends RecyclerView.Adapter<adapterLiga.MyViewHolder> {
    Context context;
    ArrayList<ModelLiga> liga;

    ItemClickListener mClickListener;

    public adapterLiga(Context context, ArrayList<ModelLiga> liga) {
        this.context = context;
        this.liga = liga;
    }
    @NonNull
    @Override
    public adapterLiga.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item, parent, false);
        return new adapterLiga.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapterLiga.MyViewHolder holder, int position) {
        final ModelLiga object = this.liga.get(position);
        holder.tvNama.setText(object.getTitle());
        holder.tvStadion.setText(object.getStadion());
        Glide.with(holder.itemView.getContext()).load(object.getImage()).into(holder.ivClub);
    }

    @Override
    public int getItemCount() {
        return liga.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView ivClub;

        TextView tvNama;

        TextView tvStadion;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ivClub = itemView.findViewById(R.id.ivItem);
            tvNama = itemView.findViewById(R.id.tvNamaObject);
            tvStadion = itemView.findViewById(R.id.tvStadion);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mClickListener != null) mClickListener.onItemClick(v, getAdapterPosition());
        }
    }
    public void setClickListener(ItemClickListener itemClickListener){
        this.mClickListener = itemClickListener;
    }
    public interface ItemClickListener{
        void onItemClick(View view,int position);
    }

}
