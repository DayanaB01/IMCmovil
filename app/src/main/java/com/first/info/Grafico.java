package com.first.info;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;

public class Grafico extends AppCompatActivity {
    TextView mostrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafico);
        mostrar=findViewById(R.id.vista);
        Intent aqui=getIntent();
        ArrayList<Persona> plis=(ArrayList<Persona>) aqui.getSerializableExtra("lista");

        Integer bajo = 0, medio = 0, mayor = 0, joven = 0, adulto = 0, contadorm = 0, contadorh = 0;
        Double imc, suma = 0.0;

        for (int i = 0; i < plis.size() ; i++) {
            Persona p = (Persona) plis.get(i);
            suma = suma + p.getEdad();
            imc = p.getPeso() / (p.getAltura() * p.getAltura());

            if (imc < 18.5){
               bajo = i;
            }else if (imc > 18.5 && imc < 27){
               medio = i;
            }else if (imc > 27 ){
               mayor = i;
            }
            if (p.getEdad() > plis.get(adulto).getEdad()){
                adulto = i;
            }else if (p.getEdad()<plis.get(joven).getEdad()){
                joven = i;
            }
            if (p.getGenero()!="mujer"){
                contadorh=i;
            }else{
                contadorm=i;
            }
        }
        Double promedio = suma / plis.size();
        Integer auxh=contadorh*100;
        Integer aux=contadorm;
        Integer porcentajeh=auxh/ plis.size();
        Integer porcentajem=100-porcentajeh;
        Persona adul = plis.get(adulto);
        Persona jove = plis.get(joven);

        mostrar.setText("Cantidad de personas con IMC bajo: "+bajo+"\n\n"+
                "Cantidad de personas con IMC normal: "+medio+"\n\n"+
                "Cantidad de personas con IMC alto: "+mayor+"\n\n"+
                "La persona de mayor edad es: "+adul.getNombre()+"\n\n"+
                "La persona con menor edad es: "+jove.getNombre()+"\n\n"+
                "El promedio de edad es: "+promedio+"\n\n"+
                "El porcentaje de mujeres es: "+porcentajem+"%"+"\n\n"+
                "El porcentaje de hombres es: "+porcentajeh+"%");
    }
}
