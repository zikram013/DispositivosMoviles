package com.example.myapplication;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Common.Comun;
import com.example.myapplication.Cuestiones.CurrentPreguntas;
import com.example.myapplication.Cuestiones.PreguntasAdapter;
import com.example.myapplication.DBHelper.DBHelper;
import com.github.javiersantos.materialstyleddialogs.MaterialStyledDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ActivityQuestion extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    int time_lay= Comun.TOTAL_TIME;
    boolean isAnswerModeView=false;
    CountDownTimer contador;
    RecyclerView answer_sheet_view;
    PreguntasAdapter preguntasAdapter;
    TextView textView;

    @Override
    protected void onDestroy() {
        if(contador!=null){
            contador.cancel();
        }
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        takePregunta();

        if(Comun.listaPreguntas.size()>0){
            textView=(TextView)findViewById(R.id.txt_question_right);
        }
        answer_sheet_view=(RecyclerView)findViewById((R.id.answer));
        answer_sheet_view.setHasFixedSize(true);
        if(Comun.listaPreguntas.size()>5){
            answer_sheet_view.setLayoutManager(new GridLayoutManager(this,Comun.listaPreguntas.size()/2));
            preguntasAdapter=new PreguntasAdapter(this,Comun.listPreguntas);
            answer_sheet_view.setAdapter(preguntasAdapter);
        }
    }

    private void takePregunta() {
        Comun.listaPreguntas= DBHelper.getInstance(this).getPreguntasbyTematica(Comun.selectTematica.getId_tematica());
        if(Comun.listaPreguntas.size()==0){
            Toast.makeText(this, "No preguntas", Toast.LENGTH_SHORT).show();
        }else{
            for(int i=0;i<Comun.listaPreguntas.size();i++){
                Comun.listPreguntas.add(new CurrentPreguntas(i,Comun.ANSWER_TYPE.NO_ANSWER));
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_question, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}