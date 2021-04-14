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
    ImageView mision;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        usuario=(TextView)findViewById(R.id.textusuario);
        mision=(ImageView) findViewById(R.id.btnmision);
        leercredenciales();

        mision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),mision.class);
                GuardarCredenciales(usuario.getText().toString());
                startActivity(i);
            }
        });
    }
    private void leercredenciales() {
        preferences=getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        usuario.setText(preferences.getString("user",""));
    }

    private void GuardarCredenciales(String nombre) {
        preferences=getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= preferences.edit();
        editor.putString("user",nombre);
        editor.commit();
    }
}