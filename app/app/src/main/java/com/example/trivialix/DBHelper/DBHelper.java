package com.example.trivialix.DBHelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.example.trivialix.Cuestiones.Preguntas;
import com.example.trivialix.QuizContract;
import com.example.trivialix.Temas.Tematicas;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME="trivialixV3.db";
    private static final String DB_PATH="src\\main\\java\\com\\example\\trivialix\\database\\trivialixV3.db";
    private static final int DATABASE_VERSION=1;
    private SQLiteDatabase db;
    private static DBHelper instance;

    public static synchronized DBHelper getInstance(Context context){
        if(instance==null){
            instance=new DBHelper(context.getApplicationContext());
        }
        return instance;
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

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    public List<Tematicas>getAllTematicas() throws SQLException {
        List<Tematicas>listaTematicas=new ArrayList<>();
        db=getWritableDatabase();
        Connection m_Connection = DriverManager.getConnection(String.valueOf(db));
        Statement m_Statement = m_Connection.createStatement();
        String myQuery = "SELECT * FROM Tematicas";
        ResultSet m_ResultSet = m_Statement.executeQuery(myQuery);
        //Cursor cursor=db.rawQuery(myQuery,null);
        if (m_ResultSet.first()) {
            while (!m_ResultSet.isAfterLast()){
                Tematicas tematicas=new Tematicas();
                tematicas.setId_tematica(m_ResultSet.getInt(m_ResultSet.findColumn("id_tematica")));
                tematicas.setNombreTematica(m_ResultSet.getString(m_ResultSet.findColumn("nombreTematica")));
                listaTematicas.add(tematicas);
                m_ResultSet.next();
            }
        }
        m_ResultSet.close();
        db.close();
        return listaTematicas;
    }

    public List<Preguntas>getAllPreguntas(int idTematica){
       List<Preguntas>listaDePreguntas=new ArrayList<>();
       db=getWritableDatabase();
       String myQuery = "SELECT * FROM  Preguntas";
       Cursor cursor=db.rawQuery(myQuery,null);
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
