package com.example.daivustore.adapter;



import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.daivustore.classe.Perfume;
import com.example.daivustore.databinding.PerfumeItemBinding;
import com.example.daivustore.ui.telas.DetalhesProduto;


import java.util.ArrayList;

public class    PerfumeAdapter extends RecyclerView.Adapter<PerfumeAdapter.PerfumeViewHolder> {

    private final ArrayList<Perfume> perfumeList;
    private final Context context;
    private OnItemClickListener onItemClickListener; // Adicionado

    public PerfumeAdapter(ArrayList<Perfume> perfumeList, Context context) {
        this.perfumeList = perfumeList;
        this.context = context;
    }

    // Adicionado
    public interface OnItemClickListener {
        void onItemClick(int position, View view);
    }

    // Adicionado
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
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

        // Adicionado
        holder.itemView.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(position, v);
            }
        });
        holder.binding.btComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int clickedPosition = holder.getAdapterPosition(); // Obter a posição clicada

                Perfume perfume = perfumeList.get(clickedPosition); // Corrigir aqui

                Intent intent = new Intent(context, DetalhesProduto.class);
                intent.putExtra("imagem_perfume", perfumeList.get(clickedPosition).getImgPerfume());
                intent.putExtra("nome_perfume", perfume.getNome());

                context.startActivity(intent);
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
