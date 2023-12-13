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

public class TelaCadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);
        EditText etName = findViewById(R.id.etFullName);
        EditText etEmail = findViewById(R.id.etEmail);
        EditText etPassword = findViewById(R.id.etPassword);
        Button btRegister = findViewById(R.id.btRegister);
        TextView txtConta = findViewById(R.id.jaTemConta); // ID do TextView

        getSupportActionBar().hide();
        txtConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaCadastro.this, TelaLogin.class);
                startActivity(intent);
            }
        });

        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtenha os dados inseridos pelo usuário
                String nome = etName.getText().toString();
                String email = etEmail.getText().toString();
                String senha = etPassword.getText().toString();

                if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                    Toast.makeText(TelaCadastro.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                } else {
                    SharedPreferences.Editor gravar = getSharedPreferences("dados", MODE_PRIVATE).edit();
                    gravar.putString("nome", nome);
                    gravar.putString("email", email);
                    gravar.putString("senha", senha);

                    if (gravar.commit()) {
                        Toast.makeText(TelaCadastro.this, "Cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                        Usuario usuario = new Usuario(nome, email, senha);

                        // Iniciar tanto a TelaPrincipal quanto a TelaLogin
                        Intent intentPrincipal = new Intent(TelaCadastro.this, TelaPrincipal.class);
                        intentPrincipal.putExtra("usuario", usuario);
                        startActivity(intentPrincipal);

                        Intent intentLogin = new Intent(TelaCadastro.this, TelaLogin.class);
                        intentLogin.putExtra("usuario", usuario);
                        startActivity(intentLogin);

                        finish();
                    } else {
                        Toast.makeText(TelaCadastro.this, "Não foi possível cadastrar", Toast.LENGTH_SHORT).show();
                    }


                }
            }
        });
    }
}