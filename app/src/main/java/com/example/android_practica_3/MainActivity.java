package com.example.android_practica_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private EditText calculation, resultado;
    private String curr, res;
    private Button botoncero, boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8, boton9, botonAC, botonDel, botonDiv, botonMulti, botonMenos, botonMas, botonpunto, botonigual;

    private boolean dot_inserted, operator_inserted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculation = (EditText) findViewById(R.id.calculation);
        resultado = (EditText) findViewById(R.id.resultado);

        curr = "";
        res = "";
        dot_inserted = false;
        operator_inserted = false;


        botoncero = (Button) findViewById(R.id.botoncero);
        boton1 = (Button) findViewById(R.id.boton1);
        boton2 = (Button) findViewById(R.id.boton2);
        boton3 = (Button) findViewById(R.id.boton3);
        boton4 = (Button) findViewById(R.id.boton4);
        boton5 = (Button) findViewById(R.id.boton5);
        boton6 = (Button) findViewById(R.id.boton6);
        boton7 = (Button) findViewById(R.id.boton7);
        boton8 = (Button) findViewById(R.id.boton8);
        boton9 = (Button) findViewById(R.id.boton9);
        botonAC = (Button) findViewById(R.id.botonAC);
       //botonDel = (Button) findViewById(R.id.botonDel);
        botonDiv = (Button) findViewById(R.id.botonDiv);
        botonMulti = (Button) findViewById(R.id.botonMulti);
        botonMenos = (Button) findViewById(R.id.botonMenos);
        botonMas = (Button) findViewById(R.id.botonMas);
        botonpunto = (Button) findViewById(R.id.botonpunto);
        botonigual = (Button) findViewById(R.id.botonigual);

        botoncero.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                curr = curr + "0";
                displayOne();
            }
        });

        boton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                curr = curr + "1";
                displayOne();
            }
        });

        boton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                curr = curr + "2";
                displayOne();
            }
        });

        boton3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                curr = curr + "3";
                displayOne();
            }
        });

        boton4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                curr = curr + "4";
                displayOne();
            }
        });

        boton5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                curr = curr + "5";
                displayOne();
            }
        });

        boton6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                curr = curr + "6";
                displayOne();
            }
        });

        boton7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                curr = curr + "7";
                displayOne();
            }
        });

        boton8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                curr = curr + "8";
                displayOne();
            }
        });

        boton9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                curr = curr + "9";
                displayOne();
            }
        });

        botonpunto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
               if(curr.isEmpty()){
                   curr = "0.";
                   dot_inserted = true;
               }

               if(dot_inserted == false){
                   curr = curr + ".";
                   dot_inserted = true;
               }
               displayOne();
            }
        });


        botonAC.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                clear();
                displayOne();
                displayTwo();
            }
        });

        //botonDel.setOnClickListener(new View.OnClickListener() {
          //  @Override
            //public void onClick(View view) {
              //  backspace();
                //displayOne();
            //}
        //});

        botonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dot_inserted = false;

                if(!curr.isEmpty()){
                    if(curr.substring(curr.length()-1, curr.length()).equals(".")){
                        backspace();
                    }

                    if(operator_inserted == false){
                        curr = curr + " / ";
                        operator_inserted = true;
                    }
                }
                displayOne();
            }
        });

        botonMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dot_inserted = false;

                if(!curr.isEmpty()){
                    if(curr.substring(curr.length()-1, curr.length()).equals(".")){
                        backspace();
                    }

                    if(operator_inserted == false){
                        curr = curr + " x ";
                        operator_inserted = true;
                    }
                }
                displayOne();
            }
        });

        botonMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dot_inserted = false;

                if(!curr.isEmpty()){
                    if(curr.substring(curr.length()-1, curr.length()).equals(".")){
                        backspace();
                    }

                    if(operator_inserted == false){
                        curr = curr + " - ";
                        operator_inserted = true;
                    }
                }
                displayOne();
            }
        });

        botonMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dot_inserted = false;

                if(!curr.isEmpty()){
                    if(curr.substring(curr.length()-1, curr.length()).equals(".")){
                        backspace();
                    }

                    if(operator_inserted == false){
                        curr = curr + " + ";
                        operator_inserted = true;
                    }
                }
                displayOne();
            }
        });

        botonigual.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operator_inserted==true && !curr.substring(curr.length()-1, curr.length()).equals(" ")){

                    String [] tokens = curr.split(" ");

                    switch (tokens[1].charAt(0)){

                        case '+':
                            res = Double.toString(Double.parseDouble(tokens[0]) + Double.parseDouble(tokens[2]));
                            break;

                        case '-':
                            res = Double.toString(Double.parseDouble(tokens[0]) - Double.parseDouble(tokens[2]));
                            break;

                        case '/':
                            res = Double.toString(Double.parseDouble(tokens[0]) / Double.parseDouble(tokens[2]));
                            break;

                        case 'x':
                            res = Double.toString(Double.parseDouble(tokens[0]) * Double.parseDouble(tokens[2]));
                            break;

                    }
                    displayTwo();

                }
            }
        }));

    }

    public  void displayOne(){
        calculation.setText(curr);
    }

    public  void displayTwo(){
        resultado.setText(res);
    }

    public void clear(){
        curr = "";
        res = "";
        dot_inserted = false;
        operator_inserted = false;
    }

    public  void backspace(){
        if(!curr.isEmpty()){

            if(curr.substring(curr.length()-1, curr.length()).equals(".")){
                dot_inserted = false;
            }

            if(curr.substring(curr.length()-1, curr.length()).equals(" ")){
                curr = curr.substring(0, curr.length()-3);
                operator_inserted = false;
            }
            else{
                curr = curr.substring(0, curr.length()-1);
            }

            curr = curr.substring(0,curr.length()-1);
        }
    }
}