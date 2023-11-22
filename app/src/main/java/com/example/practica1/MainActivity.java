package com.example.practica1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import models.Problema;

public class MainActivity extends AppCompatActivity {

    Problema[] problemasArray = new Problema[6];

    TextView problem_editText;

    EditText input_x, input_y;

    TextView label_result;

    Button btn_calculate;

    int numeroAleatorio = 0;

    Random random = new Random();


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Iniciar componentes
        label_result = findViewById(R.id.label_result);
        problem_editText = findViewById(R.id.problem_editText);
        input_x = findViewById(R.id.input_x);
        input_y = findViewById(R.id.input_y);
        btn_calculate = findViewById(R.id.btn_calculate);

        inicializarProblemas();

        numeroAleatorio = random.nextInt(6);

        //Agregar problema aleatorio
        problem_editText.setText(problemasArray[numeroAleatorio].getProblema());

        btn_calculate.setOnClickListener(listerner);


    }


    View.OnClickListener listerner = (View v) ->{

        if(btn_calculate.getText().equals("Calcular")){
            if(input_x.getText().toString().trim().length()>0 && input_y.getText().toString().trim().length()>0){

                if(problemasArray[numeroAleatorio].isTipo()){
                    int resultadoMCM = calcularMCM(Integer.parseInt(""+input_x.getText()), Integer.parseInt(""+input_y.getText()));
                    label_result.setText("El minimo comun multiplo es: " + resultadoMCM);
                }
                else {
                    int resultadoMCD = calcularMCD(Integer.parseInt(""+input_x.getText()), Integer.parseInt(""+input_y.getText()));
                    label_result.setText("El maximo comun divisor es: " + resultadoMCD);
                }

                btn_calculate.setText("Generar nuevo problema");

            }else{
                Toast.makeText(this,"Campos incompletos",Toast.LENGTH_LONG);
            }
        }
        else{
            if(btn_calculate.getText().equals("Generar nuevo problema")){

                numeroAleatorio = random.nextInt(6);

                //Agregar problema aleatorio
                problem_editText.setText(problemasArray[numeroAleatorio].getProblema());


                btn_calculate.setText("Calcular");
                label_result.setText("");
                input_x.setText("");
                input_y.setText("");
            }
        }

    };



    // MCM
    public int calcularMCM(int a, int b) {
        int mcd = calcularMCD(a, b);
        return (a * b) / mcd;
    }

    // MCD
    public int calcularMCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }





    private void inicializarProblemas(){

        //true = mcm
        //false = mcd


        problemasArray[0] = new Problema("Dos viajeros provenientes de la CDMX viajan a la ciudad de Celaya. Uno de ellos viaja a la " +
                "cada X(18) días y otro cada Y(24) días. El día de hoy ambos se encontraron en la CDMX. " +
                "¿Dentro de cuantos días volverán a encontrarse en la CDMX para viajar a Celaya?", true);

        problemasArray[1] = new Problema("Queremos cortar en cuadrados iguales, lo más grande que se pueda, un folio que mide X(36) " +
                "cm de largo y Y(24) cm de ancho. ¿Cuál será el ancho de cada cuadrado?", false);

        problemasArray[2] = new Problema("Alan y Pedro comen en la misma taquería, pero Alan asiste cada X(20) días y Pedro cada " +
                "Y(38). ¿Cuándo volverán a encontrarse?", true);

        problemasArray[3] = new Problema("David tiene X(24) dulces para repartir y Fernando tiene Y(18). Si desean regalar los dulces a " +
                "sus respectivos familiares de modo que todos tengan la misma cantidad y que sea la mayor " +
                "posible, ¿cuántos dulces repartirán a cada persona?", false);

        problemasArray[4] = new Problema("Juan tiene gripa y toma un jarabe cada X(8) horas y una pastilla cada Y(12) horas. Acaba de " +
                "tomar los dos medicamentos a la vez. ¿De aquí a cuantas horas volverá a tomárselos a la " +
                "vez?", true);

        problemasArray[5] = new Problema("Elia tiene una cuerda roja de X(15) m. y una azul de Y(20) m. Las quiere cortar en trozos de " +
                "la misma longitud, de forma que no sobre nada. ¿Cuál es la longitud máxima de cada trozo " +
                "de cuerda que puede cortar?", false);


    }



}