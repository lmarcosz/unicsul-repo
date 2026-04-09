package com.pdm.atividadeaula02;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

    public void calcularSalario(View view){
        EditText baseNome = findViewById(R.id.editNome);
        EditText baseSalario = findViewById(R.id.editSalario);
        EditText baseTotalVendas = findViewById(R.id.editTotalVendas);
        TextView resultado = findViewById(R.id.editResultado);

        String nome = baseNome.getText().toString();
        Double salario = Double.parseDouble(baseSalario.getText().toString());
        Double totalVendas = Double.parseDouble(baseTotalVendas.getText().toString());
        Double valorRecebido = salario + totalVendas * 0.15;
        String valorRecebidoFormatado = String.format(java.util.Locale.US, "%.2f", valorRecebido);

        resultado.setText("Nome: " + nome + "\nTotal a receber: R$" + valorRecebidoFormatado);
    }
}