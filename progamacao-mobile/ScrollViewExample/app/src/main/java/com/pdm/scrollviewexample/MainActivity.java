package com.pdm.scrollviewexample;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void somar(View view){
        EditText baseNumero1 = findViewById(R.id.editNumero1);
        EditText baseNumero2 = findViewById(R.id.editNumero2);
        TextView baseResultado = findViewById(R.id.showResultado);

        Double numero1 = Double.parseDouble(baseNumero1.getText().toString());
        Double numero2 = Double.parseDouble(baseNumero2.getText().toString());
        Double resultado = numero1 + numero2;
        String resultadoTexto = String.format(java.util.Locale.US, "%.2f", resultado);

        baseResultado.setText(resultadoTexto);
    }

    public void subtrair(View view){
        EditText baseNumero1 = findViewById(R.id.editNumero1);
        EditText baseNumero2 = findViewById(R.id.editNumero2);
        TextView baseResultado = findViewById(R.id.showResultado);

        Double numero1 = Double.parseDouble(baseNumero1.getText().toString());
        Double numero2 = Double.parseDouble(baseNumero2.getText().toString());
        Double resultado = numero1 - numero2;
        String resultadoTexto = String.format(java.util.Locale.US, "%.2f", resultado);

        baseResultado.setText(resultadoTexto);
    }

    public void multiplicar(View view){
        EditText baseNumero1 = findViewById(R.id.editNumero1);
        EditText baseNumero2 = findViewById(R.id.editNumero2);
        TextView baseResultado = findViewById(R.id.showResultado);

        Double numero1 = Double.parseDouble(baseNumero1.getText().toString());
        Double numero2 = Double.parseDouble(baseNumero2.getText().toString());
        Double resultado = numero1 * numero2;
        String resultadoTexto = String.format(java.util.Locale.US, "%.2f", resultado);

        baseResultado.setText(resultadoTexto);
    }

    public void dividir(View view){
        EditText baseNumero1 = findViewById(R.id.editNumero1);
        EditText baseNumero2 = findViewById(R.id.editNumero2);
        TextView baseResultado = findViewById(R.id.showResultado);

        Double numero1 = Double.parseDouble(baseNumero1.getText().toString());
        Double numero2 = Double.parseDouble(baseNumero2.getText().toString());
        Double resultado = numero1 / numero2;
        String resultadoTexto = String.format(java.util.Locale.US, "%.2f", resultado);

        baseResultado.setText(resultadoTexto);
    }

}