package com.example.sauceda.patrondiseoobserver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sauceda.patrondiseoobserver.Modelo.Boletos;

import java.util.Observable;
import java.util.Observer;

public class VistadeJuan extends AppCompatActivity implements Observer {

    Button btnMostrar, btnComprar;
    int i=1;
    Boletos boletos=new Boletos();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vistade_juan);
        btnMostrar=findViewById(R.id.btnObservar);
        btnComprar=findViewById(R.id.btnComprar);
        boletos.addObserver(this);



        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(boletos.getBoleto()>0) {
                    String valor=((String.valueOf(boletos.getBoleto())));
                    Toast.makeText(VistadeJuan.this,valor, Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(VistadeJuan.this, "Boletos Agotados", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(boletos.getBoleto()>0) {
                    boletos.setBoleto(i);

                }else{
                    Toast.makeText(VistadeJuan.this, "Boletos Agotados", Toast.LENGTH_SHORT).show();
                }




            }
        });

    }

    @Override
    public void update(Observable o, Object arg) {
        Toast.makeText(this, "Quedan: "+arg+" Boletos", Toast.LENGTH_SHORT).show();


    }
}
