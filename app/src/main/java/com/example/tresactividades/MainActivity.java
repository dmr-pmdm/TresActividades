package com.example.tresactividades;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btnA2, btnA3, btnExterno;
    private static final int COD_LLAMADA_A2 = 1, COD_LLAMADA_A3 = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnA2 = findViewById(R.id.btnA2);
        btnA3 = findViewById(R.id.btnA3);
        btnExterno = findViewById(R.id.btnExterno);

        btnA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SegundaActivity.class);
                String mensaje2 = "Mensaje para la actividad 2";
                i.putExtra("mensaje2", mensaje2);
                startActivityForResult(i, COD_LLAMADA_A2);
            }
        });

        btnA3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, TerceraActivity.class);
                String mensaje3 = "Mensaje para la actividad 3";
                i.putExtra("mensaje3", mensaje3);
                startActivityForResult(i, COD_LLAMADA_A3);
            }
        });

        btnExterno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClassName("com.example.giraetiqueta", "com.example.giraetiqueta.MainActivity");
                PackageManager pm = getPackageManager();
                List actividadesPosibles = pm.queryIntentActivities(i, PackageManager.MATCH_DEFAULT_ONLY);
                if (actividadesPosibles.size()>0){
                    startActivity(i);
                } else {
                    Toast.makeText(MainActivity.this, "Ninguna actividad puede realizar esta acción", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == COD_LLAMADA_A2 && resultCode == RESULT_OK) {
            int num = data.getIntExtra("aleatorioEntero", 0);
            String respuesta = "He recibido de la actividad 2 el entero " + num;
            Toast.makeText(this, respuesta, Toast.LENGTH_SHORT).show();
        }
        if(requestCode == COD_LLAMADA_A3 && resultCode == RESULT_OK) {
            double num = data.getDoubleExtra("aleatorioDecimal", 0);
            String respuesta = "He recibido de la actividad 3 el decimal " + (double)Math.round(num*100d)/100d;
            Toast.makeText(this, respuesta, Toast.LENGTH_SHORT).show();
        }
    }
}
