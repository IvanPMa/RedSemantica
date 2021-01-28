package com.example.redsemanticapoblacional;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class creacionBase extends SQLiteOpenHelper {
    private static final String NombreBD="poblacional.bd";
    private static final int version=1;
    private static final String TablaDatos= ("CREATE TABLE Datos(EDAD TEXT,SEXO TEXT,Puesto TEXT,Antiguedad TEXT)");
    private static final String TablaPalabras = ("CREATE TABLE Palabras(PRINCIPAL TEXT, PALABRA1 TEXT,PALABRA2 TEXT,PALABRA3 TEXT,PALABRA4 TEXT,PALABRA5 TEXT,TIEMPO TEXT)");

    public creacionBase(Context context) {
        super(context, NombreBD, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TablaDatos);
        sqLiteDatabase.execSQL(TablaPalabras);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + TablaDatos);
        sqLiteDatabase.execSQL(TablaDatos);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" +TablaPalabras);
        sqLiteDatabase.execSQL(TablaDatos);
    }

    public void agregarDatos(String edad, String sexo, String puesto, String antiguedad){
        SQLiteDatabase bd=getWritableDatabase();
        if (bd != null){
            bd.execSQL("INSERT INTO Datos VALUES('"+edad+"','"+sexo+"','"+puesto+"','"+antiguedad+"')");
            bd.close();
        }
    }
    public void agregarPalabras(String principal, String palabra1, String palabra2,String palabra3,String palabra4,String palabra5,String tiempo){
        SQLiteDatabase bd=getWritableDatabase();
        if (bd != null){
            bd.execSQL("INSERT INTO Palabras VALUES ('"+principal+"','"+palabra1+"','"+palabra2+"','"+palabra3+"','"+palabra4+"','"+palabra5+"','"+tiempo+"')");
            bd.close();
        }
    }
    public List<datosModelo> mostrarDatos(){
        SQLiteDatabase bd=getReadableDatabase();
        Cursor cursor=bd.rawQuery("SELECT * FROM Datos",null);
        List<datosModelo> datos = new ArrayList<>();
        //Verificar si hay al menos un registro
        if(cursor.moveToFirst()){
            //Recorrer el cursor
            do{
                datos.add(new datosModelo(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3)));
            } while(cursor.moveToNext());
            //retornamos la lista con los registros ya encontrados

        }//if
        return datos;
    }//list

}
