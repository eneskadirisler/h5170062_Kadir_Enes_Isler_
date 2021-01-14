package com.h5170062.kadir_enes_isler_final.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5170062.kadir_enes_isler_final.R;
import com.h5170062.kadir_enes_isler_final.model.BilimAdamlari;
import com.h5170062.kadir_enes_isler_final.util.GlideUtil;

import java.util.ArrayList;
import java.util.List;

public class BilimAdamiAdapter extends RecyclerView.Adapter<BilimAdamiViewHolder> {

    List<BilimAdamlari> bilimAdamlari;
    Context context;
    OnItemClickListener listener;

    public interface OnItemClickListener
    {
        void onClick(int position);
    }

    public BilimAdamiAdapter(List<BilimAdamlari> bilimAdamlari,Context context,OnItemClickListener listener)
    {
        this.bilimAdamlari = bilimAdamlari;
        this.context = context;
        this.listener = listener;
    }


    @NonNull
    @Override
    public BilimAdamiViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_bilim_adamlari,viewGroup,false);
        return new BilimAdamiViewHolder(view,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull BilimAdamiViewHolder viewHolder, int position) {

        viewHolder.txtAdiSoyadi.setText(bilimAdamlari.get(position).getAdiSoyadi());
        viewHolder.txtAlani.setText(bilimAdamlari.get(position).getIlgiAlani());
        viewHolder.txtDogumYili.setText(bilimAdamlari.get(position).getDogumTarihi());

        GlideUtil.resmiIndirGoster(context,bilimAdamlari.get(position).getResimURL(),viewHolder.imgBilimAdami);
    }

    @Override
    public int getItemCount() {
        return bilimAdamlari.size();
    }
}
