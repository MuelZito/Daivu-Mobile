package com.example.daivustore.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.daivustore.R;
import com.example.daivustore.adapter.PerfumeAdapter;
import com.example.daivustore.classe.Perfume;
import com.example.daivustore.databinding.FragmentProdutosBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentProdutosBinding binding;
    private PerfumeAdapter perfumeAdaptador;
    private ArrayList<Perfume> perfumesList = new ArrayList<>();
    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentProdutosBinding.inflate(getLayoutInflater());
        RecyclerView recyclerViewPerfume = binding.RecycleViewPerfume;
        recyclerViewPerfume.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewPerfume.setHasFixedSize(true);


        // Preencha a lista de perfumes chamando a função getPerfume
        getPerfume();

        perfumeAdaptador = new PerfumeAdapter(perfumesList, getContext());
        recyclerViewPerfume.setAdapter(perfumeAdaptador);



        View root = binding.getRoot();
        return root;
    }

    private void getPerfume(){
        Perfume perfume1 = new Perfume(
                R.drawable.malbec_img,
                "Malbec Gold",
                "Fragrância ideal para homens com intensidade e que buscam atrair sempre mais atenção.",
                "R$ 189.90"
        );
        perfumesList.add(perfume1);

        Perfume perfume2 = new Perfume(
                R.drawable.perfume2,
                "Oboticario",
                "Fragrância ideal para homens com intensidade e que buscam atrair sempre mais atenção.",
                "R$ 189.90"
        );
        perfumesList.add(perfume2);

        Perfume perfume3 = new Perfume(
                R.drawable.perfume3,
                "Malbec Azul",
                "Fragrância ideal para homens com intensidade e que buscam atrair sempre mais atenção.",
                "R$ 189.90"
        );
        perfumesList.add(perfume3);

        Perfume perfume4 = new Perfume(
                R.drawable.perfume3,
                "Malbec Azul",
                "Fragrância ideal para homens com intensidade e que buscam atrair sempre mais atenção.",
                "R$ 189.90"
        );
        perfumesList.add(perfume4);

        Perfume perfume5 = new Perfume(
                R.drawable.perfume3,
                "Malbec Azul",
                "Fragrância ideal para homens com intensidade e que buscam atrair sempre mais atenção.",
                "R$ 189.90"
        );
        perfumesList.add(perfume5);

        Perfume perfume6 = new Perfume(
                R.drawable.perfume3,
                "Malbec Azul",
                "Fragrância ideal para homens com intensidade e que buscam atrair sempre mais atenção.",
                "R$ 189.90"
        );
        perfumesList.add(perfume6);

        Perfume perfume7 = new Perfume(
                R.drawable.perfume3,
                "Malbec Azul",
                "Fragrância ideal para homens com intensidade e que buscam atrair sempre mais atenção.",
                "R$ 189.90"
        );
        perfumesList.add(perfume7);



    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
