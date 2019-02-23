package com.example.introduccion.recyclerview.sevenwonders.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.introduccion.recyclerview.sevenwonders.Models.Wonders;
import com.example.introduccion.recyclerview.sevenwonders.R;
import com.example.introduccion.recyclerview.sevenwonders.WondersDetailActivity;

import java.util.ArrayList;

public class WondersAdapter extends RecyclerView.Adapter<WondersAdapter.ViewHolder>{

    Context context;
    ArrayList<Wonders> wonders;

    public WondersAdapter(Context context, ArrayList<Wonders> wonders) {
        this.context = context;
        this.wonders = wonders;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_wonders,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        final Wonders wonder = wonders.get(i);

        viewHolder.tituloCard.setText(wonder.getTitle());
        viewHolder.descripcionCard.setText(wonder.getDescription());
        viewHolder.vistos.setText(wonder.getLikes());

        Glide.with(context)
                .load(wonder.getImgCard())
                .into(viewHolder.imageCards);

        viewHolder.relativeLayoutCards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, WondersDetailActivity.class);
                intent.putExtra("detail",wonder);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return wonders.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageCards;
        TextView  tituloCard,descripcionCard,vistos;
        RelativeLayout relativeLayoutCards;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageCards = itemView.findViewById(R.id.imgsCards);
            tituloCard = itemView.findViewById(R.id.tituloCards);
            descripcionCard = itemView.findViewById(R.id.descripcionCards);
            vistos = itemView.findViewById(R.id.reviews);
            relativeLayoutCards = itemView.findViewById(R.id.wondersItem);
        }
    }
}
