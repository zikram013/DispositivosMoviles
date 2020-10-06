package com.example.preguntados;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import pl.droidsonroids.gif.GifImageView;

public class FinDeJuego extends AppCompatActivity implements View.OnClickListener {
    private Button sig,atras;
    private ImageButton a,b,c,d;
    private int puntuacion=0;
    private Intent i,recibe,vueltaAtras;
    private Bundle bolsa;
    private GifImageView gif;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.findeljuego);
        vueltaAtras=new Intent(FinDeJuego.this,MainActivity.class);
        atras=findViewById(R.id.volver);
        atras.setOnClickListener(this);
        gif=findViewById(R.id.imageView);
    }

    @Override
    public void onClick(View v) {
        startActivity(vueltaAtras);
    }
}
