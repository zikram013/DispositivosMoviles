package com.example.myapplication.DBHelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.Cuestiones.Preguntas;
import com.example.myapplication.Temas.Tematicas;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteAssetHelper {

    private static final String DB_NAME="trivialixV3.db";
    private static final int DB_VER=1;

    private static DBHelper instance;

    public static synchronized DBHelper getInstance(Context context){
        if(instance==null){
            instance=new DBHelper(context);
        }
        return instance;
    }

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    //obtener las tematicas
    public List<Tematicas> getAllTematicas(){
        SQLiteDatabase db=instance.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from Tematicas",null);
        List<Tematicas>temas=new ArrayList<>();
        if (cursor.moveToFirst()) {

            while (!cursor.isAfterLast()){
                Tematicas tematicas=new Tematicas(cursor.getInt(cursor.getColumnIndex("id_tematica")),
                        cursor.getString(cursor.getColumnIndex("nombreTematica")));
                temas.add(tematicas);
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();
        return temas;
    }

    //Obtener las preguntas
    public List<Preguntas>getPreguntasbyTematica(int idTematica){
        SQLiteDatabase db=instance.getWritableDatabase();
        Cursor cursor=db.rawQuery(String.format("select * from Preguntas where id_tema =%d order by Random(); ",idTematica),null);
        List<Preguntas>preguntas=new ArrayList<>();
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
                preguntas.add(pregunta);
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();
        return preguntas;
    }

}
