package com.example.trivialix;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Pregunta5 extends AppCompatActivity implements View.OnClickListener {
    private Button sig,atras;
    private ImageButton a,b,c,d;
    private int puntuacion=0;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pregunta5);

        TextView mostrarPuntuacion = findViewById(R.id.puntuacionFinal);
        a= findViewById(R.id.respuesta1);
        b= findViewById(R.id.respuesta2);
        c= findViewById(R.id.respuesta3);
        d= findViewById(R.id.respuesta4);
        sig= findViewById(R.id.siguientePregunta);
        sig.setVisibility(View.INVISIBLE);
        atras=findViewById(R.id.reintentar);
        atras.setVisibility(View.INVISIBLE);
        try{
            Intent recibe = getIntent();
            Bundle bolsa = recibe.getExtras();
            assert bolsa != null;
            puntuacion= bolsa.getInt("puntuacion");
            if(puntuacion<0){
                puntuacion=0;
            }
        }catch (Exception e){
            Toast.makeText(this,"Error al recibir datos",Toast.LENGTH_SHORT).show();
        }

        a.setOnClickListener(this);
        b.setOnClickListener(this);
        c.setOnClickListener(this);
        d.setOnClickListener(this);
        atras.setOnClickListener(this);
        sig.setOnClickListener(this);
        sig.setEnabled(false);
        atras.setEnabled(false);
        mostrarPuntuacion.setText("Su puntuación es: " + puntuacion+ " puntos");
    }

    @SuppressLint({"WrongConstant", "NonConstantResourceId", "ShowToast"})
    @Override
    public void onClick(View arg0){
        switch (arg0.getId()){
            case R.id.respuesta1:
                puntuacion= puntuacion+3;
                a.setBackgroundColor(Color.GREEN);
                a.setEnabled(false);
                b.setEnabled(false);
                c.setEnabled(false);
                d.setEnabled(false);
                sig.setEnabled(true);
                atras.setEnabled(true);
                sig.setVisibility(View.VISIBLE);
                Toast.makeText(this,"Respuesta correcta +3 puntos",5).show();
                break;
            case R.id.respuesta2:
                puntuacion= puntuacion-2;
                b.setBackgroundColor(Color.RED);
                a.setBackgroundColor(Color.GREEN);
                a.setEnabled(false);
                b.setEnabled(false);
                c.setEnabled(false);
                d.setEnabled(false);
                sig.setEnabled(true);
                atras.setEnabled(true);
                sig.setVisibility(View.VISIBLE);
                atras.setVisibility(View.VISIBLE);
                Toast.makeText(this,"Respuesta incorrecta -2 puntos",5).show();
                break;
            case R.id.respuesta3:
                puntuacion= puntuacion-2;
                c.setBackgroundColor(Color.RED);
                a.setBackgroundColor(Color.GREEN);
                a.setEnabled(false);
                b.setEnabled(false);
                c.setEnabled(false);
                d.setEnabled(false);
                sig.setEnabled(true);
                atras.setEnabled(true);
                sig.setVisibility(View.VISIBLE);
                atras.setVisibility(View.VISIBLE);
                Toast.makeText(this,"Respuesta incorrecta -2 puntos",5).show();
                break;
            case R.id.respuesta4:
                puntuacion= puntuacion-2;
                d.setBackgroundColor(Color.RED);
                a.setBackgroundColor(Color.GREEN);
                a.setEnabled(false);
                b.setEnabled(false);
                c.setEnabled(false);
                d.setEnabled(false);
                sig.setEnabled(true);
                atras.setEnabled(true);
                sig.setVisibility(View.VISIBLE);
                atras.setVisibility(View.VISIBLE);
                Toast.makeText(this,"Respuesta incorrecta -2 puntos",5).show();
                break;
            case R.id.siguientePregunta:
                Intent i = new Intent(Pregunta5.this, FinDeJuego.class);
                sig= findViewById(R.id.siguientePregunta);
                i.putExtra("puntuacion",puntuacion);
                startActivity(i);
                break;
            case R.id.reintentar:
                Intent vueltaAtras = new Intent(Pregunta5.this, MainActivity.class);
                atras=findViewById(R.id.reintentar);
                startActivity(vueltaAtras);
                break;
            default:
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }


}