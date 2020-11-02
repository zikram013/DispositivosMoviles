package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.DisplayMetrics;

import com.example.myapplication.Common.SpaceDecoration;
import com.example.myapplication.DBHelper.DBHelper;
import com.example.myapplication.Temas.TematicasAdapter;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {

  Toolbar toolbar;
  RecyclerView reciclerTematica;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //toolbar= findViewById(R.id.toolbar);
       // toolbar.setTitle("Trivialix");
       // setSupportActionBar(toolbar);

        reciclerTematica=(RecyclerView)findViewById(R.id.recycler_tematica);
        reciclerTematica.setHasFixedSize(true);
        reciclerTematica.setLayoutManager(new GridLayoutManager(this,2));

        //mostrar tematicas
        DisplayMetrics displayMetrics=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height=displayMetrics.heightPixels/8;
        TematicasAdapter tematicasAdapter=new TematicasAdapter(MainActivity.this, DBHelper.getInstance(this).getAllTematicas());
        int spaceinPixel=4;
        reciclerTematica.addItemDecoration(new SpaceDecoration(spaceinPixel));
        reciclerTematica.setAdapter(tematicasAdapter);
    }

}