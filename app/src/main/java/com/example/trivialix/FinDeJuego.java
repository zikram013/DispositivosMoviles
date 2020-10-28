package com.example.trivialix;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import pl.droidsonroids.gif.GifImageView;

public class FinDeJuego extends AppCompatActivity {



    @SuppressLint("SetTextI18n")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.findeljuego);


        TextView mostrarPuntuacion = findViewById(R.id.puntuacionFinal);
        GifImageView gifBuenaPuntacion = findViewById(R.id.buenaPuntuacion);
        GifImageView gifMalaPuntacion = findViewById(R.id.malaPuntuacion);
        GifImageView gifPuntacionNormal = findViewById(R.id.puntuacionNormal);
        gifMalaPuntacion.setVisibility(View.INVISIBLE);
        gifBuenaPuntacion.setVisibility(View.INVISIBLE);
        gifPuntacionNormal.setVisibility(View.INVISIBLE);

        try {
            Intent recibe = getIntent();
            Bundle bolsa = recibe.getExtras();
            assert bolsa != null;
            int puntuacion = bolsa.getInt("puntuacion");
            if(puntuacion <=0){
                mostrarPuntuacion.setText("Su puntuación es: 0 puntos" );
            }else{
                mostrarPuntuacion.setText("Su puntuación es: " + puntuacion + " puntos");
            }

            if(puntuacion <=4){
                gifMalaPuntacion.setVisibility(View.VISIBLE);
            } else if(puntuacion <= 9){
                gifPuntacionNormal.setVisibility(View.VISIBLE);
            }else{
                gifBuenaPuntacion.setVisibility(View.VISIBLE);
            }
        }catch(Exception e){
            Toast.makeText(this,"Error al recibir datos",Toast.LENGTH_SHORT).show();
        }


    }

    public void reintento(View view) {
        Intent vueltaAtras = new Intent(FinDeJuego.this, MainActivity.class);
        startActivity(vueltaAtras);

    }


}
