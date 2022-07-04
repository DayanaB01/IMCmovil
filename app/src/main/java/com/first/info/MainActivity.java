package com.first.info;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText nom, ape, em, tel, ed, gen, alt, pes;
    Button agrega, muestra;
    LinkedList<Persona>lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = new  LinkedList<Persona>();
        nom=findViewById(R.id.nombre);
        ape=findViewById(R.id.apellido);
        em=findViewById(R.id.email);
        tel=findViewById(R.id.telefono);
        ed=findViewById(R.id.edad);
        gen=findViewById(R.id.genero);
        alt=findViewById(R.id.altura);
        pes=findViewById(R.id.peso);
        agrega=findViewById(R.id.agregar);
        muestra=findViewById(R.id.mostrar);
        muestra.setOnClickListener(this);
        agrega.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.agregar){
        Persona nueva = new Persona (nom.getText().toString(),ape.getText().toString(),em.getText().toString(),
                tel.getText().toString(),Double.parseDouble(ed.getText().toString()),gen.getText().toString(),
                Double.parseDouble(alt.getText().toString()),Double.parseDouble(pes.getText().toString()));
        lista.add(nueva);
        nom.setText(" ");
        ape.setText(" ");
        em.setText(" ");
        tel.setText(" ");
        ed.setText(" ");
        gen.setText(" ");
        alt.setText(" ");
        pes.setText(" ");
        }else if (v.getId()==R.id.mostrar){
        Intent info = new Intent();
        info.setClass(MainActivity.this,Grafico.class);
        info.putExtra("lista",lista);
        startActivity(info);
        }
    }
}
