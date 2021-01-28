package com.example.redsemanticapoblacional;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity9 extends AppCompatActivity {
    Button empezar,siguiente;
    EditText palabra1,palabra2,palabra3,palabra4,palabra5;
    TextView title,prueba;
    Chronometer chronometro;
    Boolean correr=false;
    long detenerse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        empezar = (Button) findViewById(R.id.inicio);
        siguiente = (Button) findViewById(R.id.fin);
        palabra1 = (EditText) findViewById(R.id.uno1);
        palabra2 = (EditText) findViewById(R.id.uno2);
        palabra3 = (EditText) findViewById(R.id.uno3);
        palabra4 = (EditText) findViewById(R.id.uno4);
        palabra5 = (EditText) findViewById(R.id.uno5);
        title = (TextView) findViewById(R.id.titulo);
        prueba = (TextView) findViewById(R.id.prueba);
        chronometro =(Chronometer)findViewById(R.id.chronometro);
        final creacionBase creacionbase = new creacionBase(getApplicationContext());
        empezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Hacemos visibles los campos a llenar y la palabra
                title.setVisibility(View.VISIBLE);
                palabra1.setVisibility(View.VISIBLE);
                palabra2.setVisibility(View.VISIBLE);
                palabra3.setVisibility(View.VISIBLE);
                palabra4.setVisibility(View.VISIBLE);
                palabra5.setVisibility(View.VISIBLE);

                empezar.setVisibility(View.INVISIBLE);
                siguiente.setVisibility(View.VISIBLE);
                startChronometro();

            }
        });
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Guardamos los valores ingresados por el usuario
                String b1 = palabra1.getText().toString();
                String b2 = palabra2.getText().toString();
                String b3 = palabra3.getText().toString();
                String b4 = palabra4.getText().toString();
                String b5 = palabra5.getText().toString();
                String tiempo = chronometro.getText().toString();
                if  (b1.isEmpty() || b2.isEmpty() || b3.isEmpty() || b4.isEmpty()){
                    prueba.setText("Llene todos los campos para continuar");
                }
                else{
                    stopChronometro();
                    //Llamado a al metodo agregarPalabra
                    creacionbase.agregarPalabras ("Motivacion",b1,b2,b3,b4,b5,tiempo);
                    //Verificar si los datos fueron agregados correctamente
                    Toast.makeText(getApplicationContext(),"Datos guardados 8/15",Toast.LENGTH_SHORT).show();
                    Intent siguiente = new Intent(MainActivity9.this, MainActivity10.class);
                    startActivity(siguiente);
                }
            }
        });
    }
    private void stopChronometro() {
        if(correr){
            chronometro.stop();
            detenerse = SystemClock.elapsedRealtime() - chronometro.getBase();
            correr = false;
        }
    }

    private void startChronometro() {
        if (!correr) {
            chronometro.setBase(SystemClock.elapsedRealtime());
            chronometro.start();
            correr = true;
        }
    }
}