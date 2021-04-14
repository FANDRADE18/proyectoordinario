package com.fandrade.codeline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class objetivo extends AppCompatActivity {
    TextView usuario;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objetivo);
        usuario=(TextView)findViewById(R.id.textusuario4);
        leercredenciales();
    }
    private void leercredenciales() {
        preferences=getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        usuario.setText("USUARIO: "+preferences.getString( "user",""));
    }
}