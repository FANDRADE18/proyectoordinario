package com.fandrade.codeline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class contacto extends AppCompatActivity {
    TextView usuario;
    SharedPreferences preferences;
    ImageView salir;
    EditText nombre,telefono,correo,mensaje;
    Button enviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        usuario=(TextView)findViewById(R.id.textusuario6);
        salir=(ImageView) findViewById(R.id.btnsalir5);
        enviar=(Button) findViewById(R.id.btnenviar);
        nombre=(EditText) findViewById(R.id.editnombre);
        telefono=(EditText) findViewById(R.id.edittelefono);
        correo=(EditText) findViewById(R.id.editcorreo);
        mensaje=(EditText) findViewById(R.id.editmensaje);


        leercredenciales();
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),mensaje.class);
                GuardarCredenciales(nombre.getText().toString(), telefono.getText().toString(), correo.getText().toString(),mensaje.getText().toString());
                startActivity(i);
            }

        });

    }
    private void leercredenciales() {
        preferences=getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        usuario.setText("USUARIO: "+preferences.getString("user",""));
    }
    private void GuardarCredenciales(String nombre, String telefono, String correo, String mensaje) {
        preferences=getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= preferences.edit();
        editor.putString("nombre",nombre);
        editor.putString("telefono",telefono);
        editor.putString("correo",correo);
        editor.putString("mensaje",mensaje);
        editor.commit();
    }
}