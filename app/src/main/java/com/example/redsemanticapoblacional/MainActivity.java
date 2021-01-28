package com.example.redsemanticapoblacional;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Declaracion de los componentes de la interfaz
    Button empezar;
    EditText edad,sexo,puesto,age;
    TextView prueba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Poner icono action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        //Identacion de variable
        empezar = (Button) findViewById(R.id.b1);
        edad = (EditText) findViewById(R.id.ed1);
        sexo = (EditText) findViewById(R.id.ed2);
        puesto = (EditText) findViewById(R.id.ed4);
        age = (EditText) findViewById(R.id.ed4);
        prueba = (TextView) findViewById(R.id.salida);
        //Metodo para llamar la BD
        final creacionBase creacionbase = new creacionBase(getApplicationContext());


        //Metodo al darle click al boton
        empezar.setOnClickListener(new View.OnClickListener() {
            @Override
            //Metodo set on click listener
            public void onClick(View view) {
                String a1 = edad.getText().toString();
                String a2 = sexo.getText().toString();
                String a3 = puesto.getText().toString();
                String a4 = age.getText().toString();
                //prueba.setText("Enviando al formulario");
                if  (a1.isEmpty() || a2.isEmpty() || a3.isEmpty() || a4.isEmpty()){
                    prueba.setText("Llene todos los campos para continuar");
                }
                else {
                    prueba.setText("");
                    //Llamado a al metodo agregarDatos
                    creacionbase.agregarDatos(a1,a2,a3,a4);
                    //Verificar si los datos fueron agregados correctamente
                    Toast.makeText(getApplicationContext(),"Datos guardados",Toast.LENGTH_SHORT).show();

                    AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                    alerta.setMessage("A continuación se le mostrará un formulario en el cual usted debe llenar " +
                            "las cinco palabras que se le vengan a la mente con la palabra que se le muestra arriba " +
                            "de forma cronometrada, una vez finalizado se generara un listado " +
                            "con sus resultados el cual debera mandarlo a su aplicador correspondiente")
                            .setCancelable(false)
                            .setPositiveButton("Lo tengo", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent empezar = new Intent(MainActivity.this, MainActivity2.class);
                                    startActivity(empezar);
                                }
                            });
                    AlertDialog titulo = alerta.create();
                    titulo.setTitle("Antes de comenzar");
                    titulo.show();
                }
            }
        });
    }
}