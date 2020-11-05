package com.example.trivialix.DBHelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.example.trivialix.Cuestiones.Preguntas;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME="trivialixV3.db";
    private static final int DATABASE_VERSION=1;
    private static DBHelper instance;

    public static synchronized  DBHelper getInstance(Context context){
        if(instance==null){
            instance=new DBHelper(context);
        }
        return  instance;
    }


    public DBHelper(@Nullable Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

   public List<Preguntas>getAllPreguntas(){
       List<Preguntas>listaDePreguntas=new ArrayList<>();
       SQLiteDatabase db=instance.getWritableDatabase();
       Cursor cursor=db.rawQuery("select * from Preguntas",null);
           if (cursor.moveToFirst()) {
               while (!cursor.isAfterLast()){
                   Preguntas pregunta=new Preguntas(cursor.getInt(cursor.getColumnIndex("id_pregunta")),
                           cursor.getString(cursor.getColumnIndex("enunciado")),
                           cursor.getString(cursor.getColumnIndex("imagen")),
                           cursor.getString(cursor.getColumnIndex("audio")),
                           cursor.getString(cursor.getColumnIndex("OpcionA")),
                           cursor.getString(cursor.getColumnIndex("OpcionB")),
                           cursor.getString(cursor.getColumnIndex("OpcionC")),
                           cursor.getString(cursor.getColumnIndex("OpcionD")),
                           cursor.getString(cursor.getColumnIndex("OpcionCorrecta")),
                           cursor.getInt(cursor.getColumnIndex("TieneImagenAudio")),
                           cursor.getInt(cursor.getColumnIndex("id_tema")));
                   listaDePreguntas.add(pregunta);
                   cursor.moveToNext();
               }
           }
           cursor.close();
           return listaDePreguntas;
   }

}
