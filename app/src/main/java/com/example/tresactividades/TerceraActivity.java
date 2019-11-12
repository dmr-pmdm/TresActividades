package com.example.tresactividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TerceraActivity extends AppCompatActivity {

    private Button btnRetorno;
    private TextView txtMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercera);

        txtMensaje = findViewById(R.id.txtMensaje2);
        btnRetorno = findViewById(R.id.btnRetorno2);
        Intent i = getIntent();

        txtMensaje.setText(i.getStringExtra("mensaje3"));

        btnRetorno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double aleatorio =  Math.random()*100;
                Intent i = new Intent();
                i.putExtra("aleatorioDecimal", aleatorio);
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }
}
