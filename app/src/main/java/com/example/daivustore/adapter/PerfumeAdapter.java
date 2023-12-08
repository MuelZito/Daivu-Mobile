package com.example.daivustore.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.daivustore.classe.Perfume;
import com.example.daivustore.databinding.PerfumeItemBinding;

import java.util.ArrayList;

public class PerfumeAdapter extends RecyclerView.Adapter<PerfumeAdapter.PerfumeViewHolder> {

    private final ArrayList<Perfume> perfumeList;
    private final Context context;

    public PerfumeAdapter(ArrayList<Perfume> perfumeList, Context context) {
        this.perfumeList = perfumeList;
        this.context = context;
    }


    @NonNull
    @Override
    public PerfumeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PerfumeItemBinding listItem;
        listItem = PerfumeItemBinding.inflate(LayoutInflater.from(context), parent, false);

        return new PerfumeViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull PerfumeViewHolder holder, int position) {
        holder.binding.imgPerfume.setImageResource(perfumeList.get(position).getImgPerfume());
        holder.binding.textPerfume.setText(perfumeList.get(position).getNome());
        holder.binding.descricaoPerfume.setText(perfumeList.get(position).getDescricao());
        holder.binding.textPreco.setText(perfumeList.get(position).getPreco());
        holder.binding.btAddCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, "Adicionado ao carrinho", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return perfumeList.size();
    }

    public static class PerfumeViewHolder extends RecyclerView.ViewHolder {
        PerfumeItemBinding binding;

        public PerfumeViewHolder(PerfumeItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
