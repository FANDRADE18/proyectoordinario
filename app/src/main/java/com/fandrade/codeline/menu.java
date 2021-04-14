package com.fandrade.codeline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class menu extends AppCompatActivity {
    TextView usuario;
    ImageView mision,vision,objetivo,valores;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        usuario=(TextView)findViewById(R.id.textusuario);
        mision=(ImageView) findViewById(R.id.btnmision);
        vision=(ImageView) findViewById(R.id.btnvision);
        objetivo=(ImageView) findViewById(R.id.btnobjetivos);
        valores=(ImageView) findViewById(R.id.btnvalores);


        leercredenciales();

        mision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),mision.class);
                startActivity(i);
            }
        });

        vision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),vision.class);
                startActivity(i);
            }
        });
        objetivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),objetivo.class);
                startActivity(i);
            }
        });
        valores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),valores.class);
                startActivity(i);
            }
        });
    }
    private void leercredenciales() {
        preferences=getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        usuario.setText("USUARIO: "+preferences.getString("user",""));
    }


}