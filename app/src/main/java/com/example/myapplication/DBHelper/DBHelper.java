package com.example.myapplication.DBHelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

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

}
