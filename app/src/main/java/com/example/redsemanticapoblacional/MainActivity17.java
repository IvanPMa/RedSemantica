package com.example.redsemanticapoblacional;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity17 extends AppCompatActivity {
    private RecyclerView recyclerViewDatos;
    private datosAdaptador adaptadorDatos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main17);

        recyclerViewDatos = (RecyclerView) findViewById(R.id.recyclerDatos);
        recyclerViewDatos.setLayoutManager(new LinearLayoutManager(this));

        creacionBase conexion = new creacionBase(getApplicationContext());
        adaptadorDatos = new datosAdaptador(conexion.mostrarDatos());
        recyclerViewDatos.setAdapter(adaptadorDatos);

    }

    //Datos con los que vamos a trabajar
    //public List<datosModelo> obtenerDatos() {
    //    List<datosModelo> datos = new ArrayList<>();
    //    datos.add(new datosModelo("22", "Femenino", "Gerente", "2 años", R.drawable.sujeto));
    //    return datos;
   // }
}