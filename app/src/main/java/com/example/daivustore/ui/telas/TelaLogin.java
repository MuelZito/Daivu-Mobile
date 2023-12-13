package com.example.daivustore.ui.telas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daivustore.R;
import com.example.daivustore.classe.Usuario;

public class TelaLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
        EditText etEmail = findViewById(R.id.etEmail);
        EditText etPassword = findViewById(R.id.etPassword);
        Button btLogin = findViewById(R.id.btLogin);
        TextView txtRegistrar = findViewById(R.id.txtRegistrar);

        getSupportActionBar().hide();
        txtRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaLogin.this, TelaCadastro.class);
                startActivity(intent);
            }
        });

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences ler = getSharedPreferences("dados", MODE_PRIVATE);
                String emailGravado = ler.getString("email", "");
                String senhaGravada = ler.getString("senha", "");
                String nomeGravado = ler.getString("nome", ""); // Adicione esta linha para obter o nome

                if (emailGravado.equals(etEmail.getText().toString()) && senhaGravada.equals(etPassword.getText().toString())) {
                    Toast.makeText(TelaLogin.this, "Acesso Liberado", Toast.LENGTH_SHORT).show();

                    // Criar um objeto Usuario com os dados
                    Usuario usuario = new Usuario(nomeGravado, emailGravado, senhaGravada);

                    // Após criar o objeto Usuario e antes de iniciar a TelaPrincipal
                    Intent intent = new Intent(TelaLogin.this, TelaPrincipal.class);
                    intent.putExtra("usuario", usuario);

                    // Armazena o nome nas preferências compartilhadas
                    SharedPreferences prefs = getSharedPreferences("dados", MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("nome", usuario.getNome());
                    editor.apply();

                    startActivity(intent);
                } else {
                    Toast.makeText(TelaLogin.this, "Email ou Senha Incorreto!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}