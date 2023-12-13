package com.example.daivustore.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.daivustore.R;
import com.example.daivustore.adapter.PerfumeAdapter;
import com.example.daivustore.classe.Perfume;
import com.example.daivustore.databinding.FragmentProdutosBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentProdutosBinding binding;
    private PerfumeAdapter perfumeAdapter;
    private ArrayList<Perfume> perfumesList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentProdutosBinding.inflate(getLayoutInflater());
        RecyclerView recyclerViewPerfume = binding.RecycleViewPerfume;
        recyclerViewPerfume.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewPerfume.setHasFixedSize(true);
        SearchView pesquisar =binding.searchView;
        pesquisar.clearFocus();
        pesquisar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });


        // Preencha a lista de perfumes chamando a função getPerfume
        getPerfume();

        perfumeAdapter = new PerfumeAdapter(perfumesList, getContext());
        recyclerViewPerfume.setAdapter(perfumeAdapter);


        View root = binding.getRoot();
        return root;
    }

    private void filterList(String newText) {
        List<Perfume> listaFiltrada = new ArrayList<>();
        for (Perfume perfume : perfumesList) {
            if (perfume.getNome().toLowerCase().contains(newText.toLowerCase())) {
                listaFiltrada.add(perfume);
            }
        }
        if (listaFiltrada.isEmpty()) {
            Toast.makeText(getContext(), "Não encontrado", Toast.LENGTH_SHORT).show();
        } else {
            perfumeAdapter.setFilteredList((ArrayList<Perfume>) listaFiltrada);
        }
    }


    private void getPerfume() {
        //Criando os objetos do perfume
        Perfume perfume1 = new Perfume(R.drawable.malbec_img, "Malbec Gold", "Fragrância ideal para homens com intensidade e que buscam atrair sempre mais atenção.", "R$ 159.90");
        Perfume perfume2 = new Perfume(R.drawable.quasar_rush, "Quasar Rush", "É preciso ter coragem e energia para se reinventar em meio às incertezas e mudanças." + " Por isso, O Boticário traz Quasar Rush Desodorante Colônia, uma fragrância da família olfativa Fougère Aquoso. ", "R$ 144.90");
        Perfume perfume3 = new Perfume(R.drawable.egeo, "Egeo FreeFire", "Pensado para quem ama a sensação de vitória,  Egeo Free Fire Desodorante Colônia vem para trazer uma " + "fragrância moderna e prazerosa para todos os públicos. ", "R$ 103.90");
        Perfume perfume4 = new Perfume(R.drawable.essencial_oud, "Essencial Oud", "A imponência do Oud, madeira mais nobre do mundo, com a sensualidade da copaíba, uma madeira da biodiversidade brasileira, " + "realçadas com um toque exótico de especiarias neste autêntico Deo Parfum Natura amadeirado. Instiga ao mesmo tempo que conquista.", "R$ 130.90");
        Perfume perfume5 = new Perfume(R.drawable.tato_deo, "Tato Deo", "O novo Deo Parfum Natura Homem Tato, amadeirado intenso, em um presente para aguçar os sentidos" + " e revelar em suas notas o poder e a sensibilidade do toque.", "R$ 120.90");
        Perfume perfume6 = new Perfume(R.drawable.malbec_bleu, "Malbec Bleu", "Inspirado pela cor azul, Malbec Bleu traz um frescor marcante para o coração amadeirado de Malbec. ", "R$ 200.90");
        Perfume perfume7 = new Perfume(R.drawable.vip_black, "212 Vip Black", "O 212 VIP Black traz o contraste entre o intenso absinto e a delicada lavanda, uma composição que combina ousadia confiante e postura destemida.", "R$ 189.90");


        //Adicionando na lista
        perfumesList.add(perfume1);
        perfumesList.add(perfume2);
        perfumesList.add(perfume3);
        perfumesList.add(perfume4);
        perfumesList.add(perfume5);
        perfumesList.add(perfume6);
        perfumesList.add(perfume7);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
