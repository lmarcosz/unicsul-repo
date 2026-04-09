package com.pdm.imc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalculoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculo);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    public void calcularIMC(View view){
        EditText alturaTx = findViewById(R.id.altura);
        EditText pesoTx = findViewById(R.id.peso);
        TextView resultadoTx = findViewById(R.id.resultado);

        Double altura = Double.parseDouble(alturaTx.getText().toString())*0.01;
        Double peso = Double.parseDouble(pesoTx.getText().toString());
        Double resultadoIMC = peso/(Math.pow(altura, 2));
        String imcFormatado = String.format("%.2f", resultadoIMC);

        String classificacaoIMC = "";

        if(resultadoIMC < 18.5){
            classificacaoIMC = "Magreza";
        } else if (resultadoIMC >= 18.5 && resultadoIMC < 25){
            classificacaoIMC = "Normal";
        } else if (resultadoIMC >= 25 && resultadoIMC < 30){
            classificacaoIMC = "Sobrepeso";
        } else if (resultadoIMC >= 30 && resultadoIMC < 40){
            classificacaoIMC = "Obesidade";
        } else{
            classificacaoIMC = "Obesidade grave";
        }

        resultadoTx.setText("IMC: " + imcFormatado + "\n" + classificacaoIMC);
    }
    public void retrocederPagina(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}