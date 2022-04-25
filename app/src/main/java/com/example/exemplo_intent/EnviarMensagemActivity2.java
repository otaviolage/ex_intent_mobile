package com.example.exemplo_intent;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class EnviarMensagemActivity2 extends AppCompatActivity {

    EditText textMensagem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviar_mensagem2);
    }

    public void btnEnviarMensagemClick(View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, textMensagem.getText().toString());
        startActivity(intent);
    }

    public void btnTelefonarClick(View view){
        Uri uri = Uri.parse("tel: 01530133056");
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);
        //startActivity(intent);

        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);

        if(permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
        } else {
            startActivity(intent);
        }
    }

    public void btnAbrirNavegadorClick(View view){
        Uri uri = Uri.parse("https://www.tripadvisor.com.br/Restaurant_Review-g303632-d8097433-Reviews-Dini_s_Burger-Sorocaba_State_of_Sao_Paulo.html");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void btnAbrirMapa(View view){
        Uri uri = Uri.parse("google.streetview:cbll=-23.4882751,-47.5110693,12");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

    public void btnVoltarClick(View view) {
        finish();
    }


}