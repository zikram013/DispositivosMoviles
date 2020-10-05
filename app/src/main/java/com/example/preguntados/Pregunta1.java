package com.example.preguntados;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.graphics.BlendMode.COLOR;

public class Pregunta1 extends AppCompatActivity implements View.OnClickListener {
    private Button a,b,c,d,sig,atras;
    private int puntuacion=0;
    private Intent i,vueltaAtras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pregunta1);
        i=new Intent(Pregunta1.this,Pregunta2.class);
        vueltaAtras=new Intent(Pregunta1.this,MainActivity.class);
        a= findViewById(R.id.respuesta1);
        b= findViewById(R.id.respuesta2);
        c= findViewById(R.id.respuesta3);
        d= findViewById(R.id.respuesta4);
        sig= findViewById(R.id.siguientePregunta);
        sig.setVisibility(View.INVISIBLE);
        atras=findViewById(R.id.volver);
        atras.setVisibility(View.INVISIBLE);

        a.setOnClickListener(this);
        b.setOnClickListener(this);
        c.setOnClickListener(this);
        d.setOnClickListener(this);
        atras.setOnClickListener(this);
        sig.setOnClickListener(this);
        sig.setEnabled(false);
        atras.setEnabled(false);
    }

    @Override
    public void onClick(View arg0){
        switch (arg0.getId()){
            case R.id.respuesta1:
                puntuacion= puntuacion-2;
                a.setBackgroundColor(Color.RED);
                d.setBackgroundColor(Color.GREEN);
                a.setEnabled(false);
                b.setEnabled(false);
                c.setEnabled(false);
                d.setEnabled(false);
                sig.setEnabled(true);
                atras.setEnabled(true);
                sig.setVisibility(View.VISIBLE);
                atras.setVisibility(View.VISIBLE);
                break;
            case R.id.respuesta2:
                puntuacion= puntuacion-2;
                b.setBackgroundColor(Color.RED);
                d.setBackgroundColor(Color.GREEN);
                a.setEnabled(false);
                b.setEnabled(false);
                c.setEnabled(false);
                d.setEnabled(false);
                sig.setEnabled(true);
                atras.setEnabled(true);
                sig.setVisibility(View.VISIBLE);
                atras.setVisibility(View.VISIBLE);
                break;
            case R.id.respuesta3:
                puntuacion= puntuacion-2;
                c.setBackgroundColor(Color.RED);
                d.setBackgroundColor(Color.GREEN);
                a.setEnabled(false);
                b.setEnabled(false);
                c.setEnabled(false);
                d.setEnabled(false);
                sig.setEnabled(true);
                atras.setEnabled(true);
                sig.setVisibility(View.VISIBLE);
                atras.setVisibility(View.VISIBLE);
                break;
            case R.id.respuesta4:
                puntuacion= puntuacion+3;
                d.setBackgroundColor(Color.GREEN);
                a.setEnabled(false);
                b.setEnabled(false);
                c.setEnabled(false);
                d.setEnabled(false);
                sig.setEnabled(true);
                sig.setVisibility(View.VISIBLE);
                break;
            case R.id.siguientePregunta:
                startActivity(i);

            case R.id.volver:
                startActivity(vueltaAtras);

            default:
        }
        System.out.print("Puntuacion: ");
       System.out.println(puntuacion);
        i.putExtra("puntuacion",puntuacion);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
