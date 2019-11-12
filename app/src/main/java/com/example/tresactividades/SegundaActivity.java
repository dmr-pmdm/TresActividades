package com.example.tresactividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    private Button btnRetorno;
    private TextView txtMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        txtMensaje = findViewById(R.id.txtMensaje);
        btnRetorno = findViewById(R.id.btnRetorno);
        Intent i = getIntent();

        txtMensaje.setText(i.getStringExtra("mensaje2"));

        btnRetorno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int aleatorio = (int) (Math.random()*100);
                Intent i = new Intent();
                i.putExtra("aleatorioEntero", aleatorio);
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }
}
