package com.h5170062.kadir_enes_isler_final.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5170062.kadir_enes_isler_final.R;

public class BilimAdamiViewHolder extends RecyclerView.ViewHolder {

    ImageView imgBilimAdami;
    TextView txtAdiSoyadi;
    TextView txtAlani;
    TextView txtDogumYili;
    public BilimAdamiViewHolder(@NonNull View itemView, BilimAdamiAdapter.OnItemClickListener listener) {
        super(itemView);
        imgBilimAdami = itemView.findViewById(R.id.imgBilimAdami);
        txtAdiSoyadi = itemView.findViewById(R.id.txtAdiSoyadi);
        txtAlani = itemView.findViewById(R.id.txtAlan);
        txtDogumYili = itemView.findViewById(R.id.txtDogumTarihi);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(getAdapterPosition());
            }
        });
    }
}
