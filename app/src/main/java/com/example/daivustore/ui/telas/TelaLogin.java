package com.example.daivustore.ui.telas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.daivustore.R;

public class TelaLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
        EditText etEmail = findViewById(R.id.etEmail);
        EditText etPassword = findViewById(R.id.etPassword);
        Button btLogin = findViewById(R.id.btLogin);

        getSupportActionBar().hide();

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences ler = getSharedPreferences("dados", MODE_PRIVATE);
                String emailGravado = ler.getString("email", "");
                String senhaGravada = ler.getString("senha", "");

                if (emailGravado.equals(etEmail.getText().toString()) && senhaGravada.equals(etPassword.getText().toString())) {
                    Toast.makeText(TelaLogin.this, "Acesso Liberado", Toast.LENGTH_SHORT).show();


                    Intent intent = new Intent(TelaLogin.this, TelaPrincipal.class);
                    startActivity(intent);
                    Toast.makeText(TelaLogin.this, "Acesso Liberado", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(TelaLogin.this, "Email ou Senha Incorreto!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}