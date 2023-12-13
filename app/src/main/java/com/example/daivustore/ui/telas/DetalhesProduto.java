package com.example.daivustore.ui.telas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.daivustore.R;
import com.example.daivustore.classe.Perfume;
import com.example.daivustore.ui.home.HomeFragment;

public class DetalhesProduto extends AppCompatActivity {
    private ImageView picPerfume, iconVoltar;
    private Perfume perfume;
    private TextView txtNome, txtPreco, txtDescricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_produto);
        // Para Remover a Barra de Cima
        getSupportActionBar().hide();

        inicializarComponentes();
        getBundle();
    }

    private void getBundle() {
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("imagem_perfume")) {
            int imagemPerfume = intent.getIntExtra("imagem_perfume", 0);
            String nomePerfume = intent.getStringExtra("nome_perfume");
            String precoPerfume = intent.getStringExtra("preco_perfume");
            String descricaoPerfume = intent.getStringExtra("descricao_perfume");

            picPerfume.setImageResource(imagemPerfume);
            txtNome.setText(nomePerfume);
            txtPreco.setText(precoPerfume);
            txtDescricao.setText(descricaoPerfume);
        }
    }

    private void inicializarComponentes() {
        picPerfume = findViewById(R.id.picPerfume);
        iconVoltar = findViewById(R.id.iconVoltar);
        txtNome = findViewById(R.id.nomePerfume);
        txtPreco = findViewById(R.id.precoPerfume);
        txtDescricao = findViewById(R.id.descricaoPerfume);

        iconVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navegar de volta para a atividade anterior (ou para a atividade principal)
                Intent intent = new Intent(DetalhesProduto.this, TelaPrincipal.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
