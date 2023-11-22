package com.example.practica1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {


    TextView label_result, label_problem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle recibirDatos = getIntent().getExtras();
        String problema = recibirDatos.getString("problem");
        int resultado = recibirDatos.getInt("resultado", 0);



        label_result = findViewById(R.id.label_result);

        label_problem = findViewById(R.id.label_problem);

        //Intent intent = getIntent();
        //String problema = intent.getStringExtra("problem");
        //int resultado = intent.getIntExtra("resultado", 0);


        label_problem.setText(problema);
        label_result.setText("El resultado es: " + resultado);


    }
}