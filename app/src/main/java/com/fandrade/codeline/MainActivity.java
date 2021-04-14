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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText user,pass;
    Button iniciarsesion;
    ImageView salir;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciarsesion = (Button)findViewById(R.id.btniniciarsesion);
        user= (EditText)findViewById(R.id.edituser);
        pass= (EditText)findViewById(R.id.editpass);
        salir = (ImageView) findViewById(R.id.btnEXIT);


        iniciarsesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String V_USR = user.getText().toString();
                String V_PASS = pass.getText().toString();
                if (V_USR.equals("Android") && V_PASS.equals("7777"))
                {
                    Intent i= new Intent(getApplicationContext(),menu.class);
                    GuardarCredenciales(user.getText().toString());
                    Toast.makeText(getApplicationContext(),"HA INICIADO SESIÓN CORRECTAMENTE",Toast.LENGTH_SHORT).show();

                    startActivity(i);
                }else{
                    Toast.makeText(getApplicationContext(),"CAMPO VACÍO O USUARIO/CONTRASEÑA INCORRECTO",Toast.LENGTH_SHORT).show();
                }

            }
        });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

    }
    private void GuardarCredenciales(String nombre) {
        preferences=getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= preferences.edit();
        editor.putString("user",nombre);
        editor.commit();
    }
}