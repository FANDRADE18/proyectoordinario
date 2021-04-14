package com.fandrade.codeline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class mision extends AppCompatActivity {
    TextView usuario;
    SharedPreferences preferences;
    ImageView salir;
    Button regresar,contacto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mision);

        usuario=(TextView)findViewById(R.id.textusuario2);
        salir=(ImageView) findViewById(R.id.btnsalir);
        regresar=(Button) findViewById(R.id.btnregresar);
        contacto=(Button) findViewById(R.id.btncontactanos);



        leercredenciales();
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),menu.class);
                startActivity(i);
            }
        });
        contacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),contacto.class);
                startActivity(i);
            }
        });
    }
    private void leercredenciales() {
        preferences=getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        usuario.setText("USUARIO: "+preferences.getString("user",""));
    }
}