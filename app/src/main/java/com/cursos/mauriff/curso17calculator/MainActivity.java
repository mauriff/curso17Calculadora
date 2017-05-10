package com.cursos.mauriff.curso17calculator;

import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.mariuszgromada.math.mxparser.Expression;
import org.mariuszgromada.math.mxparser.mXparser;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button botonCero = (Button) findViewById(R.id.button0);
        Button botonUno = (Button) findViewById(R.id.button1);
        Button botonDos = (Button) findViewById(R.id.button2);
        Button botonTres = (Button) findViewById(R.id.button3);
        Button botonCuatro = (Button) findViewById(R.id.button4);
        Button botonCinco = (Button) findViewById(R.id.button5);
        Button botonSeis = (Button) findViewById(R.id.button6);
        Button botonSiete = (Button) findViewById(R.id.button7);
        Button botonOcho = (Button) findViewById(R.id.button8);
        Button botonNueve = (Button) findViewById(R.id.button9);
        Button botonSuma = (Button) findViewById(R.id.buttonSuma);
        Button botonResta = (Button) findViewById(R.id.buttonResta);
        Button botonDivision = (Button) findViewById(R.id.buttonDiv);
        Button botonMultiplicacion = (Button) findViewById(R.id.buttonMult);
        Button botonPunto = (Button) findViewById(R.id.buttonDot);
        Button botonIgual = (Button) findViewById(R.id.buttonEqual);
        Button botonClean= (Button) findViewById(R.id.buttonLimpiar);
        Button botonExit= (Button) findViewById(R.id.buttonExit);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button botonPresionado = (Button)v;
                TextView editText = (TextView) findViewById(R.id.editResultado) ;
                StringBuilder contenido = new StringBuilder(editText.getText());
                contenido.append(botonPresionado.getText());
                editText.setText(contenido.toString() );
            }
        };

        View.OnClickListener cleanListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView editText = (TextView) findViewById(R.id.editResultado) ;
                editText.setText("");
            }
        };

        View.OnClickListener listenerIgual = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView editText = (TextView) findViewById(R.id.editResultado) ;
                Expression e = new Expression(editText.getText().toString());
                editText.setText(String.valueOf(e.calculate()));
            }
        };

        View.OnClickListener listenerExit = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage(R.string.are_sure)
                        .setCancelable(false)
                        .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                MainActivity.this.finish();
                            }
                        })
                        .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();


            }
        };
        botonExit.setOnClickListener(listenerExit);

        botonClean.setOnClickListener(cleanListener);
        botonCero.setOnClickListener(listener);
        botonUno.setOnClickListener(listener);
        botonDos.setOnClickListener(listener);
        botonTres.setOnClickListener(listener);
        botonCuatro.setOnClickListener(listener);
        botonCinco.setOnClickListener(listener);
        botonSeis.setOnClickListener(listener);
        botonSiete.setOnClickListener(listener);
        botonOcho.setOnClickListener(listener);
        botonNueve.setOnClickListener(listener);
        botonSuma.setOnClickListener(listener);
        botonResta.setOnClickListener(listener);
        botonDivision.setOnClickListener(listener);
        botonMultiplicacion.setOnClickListener(listener);
        botonPunto.setOnClickListener(listener);
        botonIgual.setOnClickListener(listenerIgual);







    }





}
