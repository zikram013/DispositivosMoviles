package com.example.trivialix;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BaseDatos extends SQLiteOpenHelper {
    private  static String DB_PATH = "/data/data/com.example.trivialix/databases/";
    private static String DB_NOMBRE = "dbTrivialix";
    private SQLiteDatabase BBDD;
    private final Context context;

    public BaseDatos(Context context, String nombre, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, nombre, factory, version);
        this.context = context;
        //this. DB_PATH = context.getDatabasePath(BaseDatos.DB_NOMBRE).toString();
        //System.out.println(DB_PATH);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Nada
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //Para los cambios en esctructura
    }
    public void createDataBase () throws IOException {
        boolean bbddExiste = checkDataBase();
        if (bbddExiste) {
            // Si existe, ¡no hacemos nada!
        } else {
            // Llamando a este método se crea la base de datos vacía en la ruta
            // por defecto del sistema de nuestra aplicación por lo que
            // podremos sobreescribirla con nuestra base de datos.
            this.getReadableDatabase();

            try {
                copyDataBase();

            } catch (IOException e) {

                throw new Error("Error copiando database");
            }
        }
    }

    private boolean checkDataBase() {
        //comprobar si existe la BBDD interna
        SQLiteDatabase checkDB = null;
        try{
            String path = DB_PATH + DB_NOMBRE;
            checkDB = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e){
            System.out.println("Base de datos no creada");
        }

        if (checkDB != null){
            checkDB.close();
        }
        return  checkDB !=null;
    }

    public void openDataBase() throws SQLException {
        String path = DB_PATH + DB_NOMBRE;
        BBDD = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);
    }

    public synchronized void close() {
        if (BBDD != null)
            BBDD.close();
        super.close();
    }

  private void copyDataBase() throws IOException {
        OutputStream dataBaseOutputStream = new FileOutputStream( ""+ DB_PATH + DB_NOMBRE);
        InputStream  dataBaseInputStream;

        byte[] buffer = new byte[1024];
        int length;

        dataBaseInputStream = context.getAssets().open("dbTrivialix");
        while ((length =dataBaseInputStream.read(buffer)) > 0) {
            dataBaseOutputStream.write(buffer);
        }
        dataBaseInputStream.close();
        dataBaseOutputStream.flush();
        dataBaseOutputStream.close();
    }
}