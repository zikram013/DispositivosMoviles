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

public class Pregunta1 extends Activity implements View.OnClickListener {
    private Button a,b,c,d,sig;
    private int puntuacion=0;
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i=new Intent(Pregunta1.this,Pregunta2.class);
        a= findViewById(R.id.respuesta1a);
        b= findViewById(R.id.respuesta2);
        c= findViewById(R.id.respuesta3);
        d= findViewById(R.id.respuesta4);
        sig= findViewById(R.id.siguientePregunta);

        a.setOnClickListener(this);
        b.setOnClickListener(this);
        c.setOnClickListener(this);
        d.setOnClickListener(this);
        sig.setOnClickListener(this);
        sig.setEnabled(false);

    }

    @Override
    public void onClick(View arg0){
        switch (arg0.getId()){
            case R.id.respuesta1a:
            case R.id.respuesta3:
            case R.id.respuesta2:
                puntuacion=0;
                bloquearBoton();
                break;
            case R.id.respuesta4:
                puntuacion=1;
                bloquearBoton();
                break;
            case R.id.siguientePregunta:
                startActivity(i);
            default:
        }
        i.putExtra("puntuacion",puntuacion);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    public void bloquearBoton(){
        a.setBackgroundColor(Color.RED);
        b.setBackgroundColor(Color.RED);
        c.setBackgroundColor(Color.RED);
        d.setBackgroundColor(Color.GREEN);
        a.setEnabled(false);
        b.setEnabled(false);
        c.setEnabled(false);
        d.setEnabled(false);
        sig.setEnabled(true);
    }
}
