package com.example.trivialix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.trivialix.DBHelper.DBHelper;
import com.example.trivialix.Temas.Tematicas;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final int REQUESTCODEQUIZ=1;
    public static final String ID_TEMATICA="IDTematica";
    public static final String TEMATICA="NombreTematica";

    private Spinner eligeTematica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cargarTematicas();

        eligeTematica=findViewById(R.id.tematicas);
        Button iniciar=findViewById(R.id.startTrivialix);
        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inicio();
            }
        });
    }

    private void cargarTematicas() {
        DBHelper dbHelper=DBHelper.getInstance(this);
        List<Tematicas> listaTematicas = new ArrayList<>();
        try{
            listaTematicas =dbHelper.getAllTematicas();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        ArrayAdapter<Tematicas>adapterTematicas=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,listaTematicas);
        adapterTematicas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        eligeTematica.setAdapter(adapterTematicas);

    }

    private void inicio() {
        Tematicas tematicas=(Tematicas)eligeTematica.getSelectedItem();
        int idTematica=tematicas.getId_tematica();
        String nombreTematica=tematicas.getNombreTematica();

        Intent i=new Intent(this,QuizActivity.class);
        i.putExtra(ID_TEMATICA,idTematica);
        i.putExtra(nombreTematica,TEMATICA);
        startActivityForResult(i,REQUESTCODEQUIZ);
    }
}