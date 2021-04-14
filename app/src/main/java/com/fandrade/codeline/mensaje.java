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
import android.widget.Toast;

public class mensaje extends AppCompatActivity {
    TextView mensaje;
    SharedPreferences preferences;
    Button aceptar,regresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje);
        mensaje=(TextView)findViewById(R.id.textmensaje);
        aceptar=(Button) findViewById(R.id.btnaceptar);
        regresar=(Button) findViewById(R.id.btnregresa);


        leercredenciales();
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),menu.class);
                Toast.makeText(getApplicationContext(),"SUS DATOS FUERON ENVIADOS CORRECTAMENTE, ¡GRACIAS POR SU PREFERENCIA!",Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
        });
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),contacto.class);
                startActivity(i);
            }
        });
    }
    private void leercredenciales() {
        preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        mensaje.setText("Estimado "+preferences.getString("nombre","")
                +" le confirmamos sus datos: su número telefonico es "+preferences.getString("telefono","")
                +" su correo es "+preferences.getString("correo","")
                +" el mensaje que nos escribio es "+preferences.getString("mensaje","")+". Si sus datos son correctos presione el botón de ACEPTAR de lo contrario presione REGRESAR. ");
    }
}