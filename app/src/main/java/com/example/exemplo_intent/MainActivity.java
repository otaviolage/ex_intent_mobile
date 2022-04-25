package com.example.exemplo_intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnAbrirTelaMsgClick(View view) {
        Intent intent = new Intent(this, EnviarMensagemActivity.class);
        startActivity(intent);
    }

    public void btnAbrirTelaMsgClick2(View view) {
        Intent intent = new Intent(this, EnviarMensagemActivity2.class);
        startActivity(intent);
    }

    public void btnAbrirTelaMsgClick3(View view) {
        Intent intent = new Intent(this, EnviarMensagemActivity3.class);
        startActivity(intent);
    }

    public void btnAbrirFotoVideoClick(View view) {
        Intent intent = new Intent(this, EnviarFotoVideoActivity.class);
        startActivity(intent);
    }

    public void btnTelefonarClick(View view){
        Uri uri = Uri.parse("tel: 015991257409");
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
        Uri uri = Uri.parse("https://facens.br/");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void btnAbrirMapa(View view){
        Uri uri = Uri.parse("geo:0,0=Avenida+general+carneiro+1427");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

    public void btnNavegarClick(View view){
        Uri uri = Uri.parse("google.navigation:q=Avenida+general+carneiro+1427");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}