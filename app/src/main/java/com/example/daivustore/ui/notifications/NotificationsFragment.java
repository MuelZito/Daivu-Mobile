package com.example.daivustore.ui.notifications;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.daivustore.databinding.FragmentNotificationsBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;
    private ImageView imageView;
    private FloatingActionButton button;

    // Identificador para solicitação de permissão
    private static final int CAMERA_PERMISSION_REQUEST_CODE = 101;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        imageView = binding.perfilFoto;
        button = binding.buttonCamera;

        // Solicitar permissão da câmera se ainda não estiver concedida
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(requireActivity(), new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION_REQUEST_CODE);
        }

        // Configurar o clique do botão
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verificar permissão da câmera antes de abrir a câmera
                if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                    // Criar intent para abrir a câmera
                    Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    // Iniciar o Activity Result Launcher para obter a imagem
                    startForResult.launch(cameraIntent);
                } else {
                    // Solicitar permissão novamente se não for concedida
                    ActivityCompat.requestPermissions(requireActivity(), new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION_REQUEST_CODE);
                }
            }
        });

        return root;
    }

    // Activity Result Launcher para capturar a imagem da câmera
    private final ActivityResultLauncher<Intent> startForResult = registerForActivityResult(
            new androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == getActivity().RESULT_OK) {
                    // Se a imagem for capturada com sucesso, obtenha a imagem
                    Bundle extras = result.getData().getExtras();
                    if (extras != null) {
                        Bitmap imageBitmap = (Bitmap) extras.get("data");
                        // Defina a imagem no ImageView
                        imageView.setImageBitmap(imageBitmap);
                    }
                }
            });

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
