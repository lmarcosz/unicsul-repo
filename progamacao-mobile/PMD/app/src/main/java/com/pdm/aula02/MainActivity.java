package com.pdm.aula02;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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

    public void exibirMensagem(View view) {
        //implementacao
        EditText baseString = findViewById(R.id.editBase);
        EditText expoenteString = findViewById(R.id.editExpoente);
        Double base = Double.parseDouble(baseString.getText().toString());
        Double expoente = Double.parseDouble(expoenteString.getText().toString());
        int potencia = (int) Math.pow(base, expoente);
        Toast.makeText(this, "Resultado = "+ potencia, Toast.LENGTH_LONG).show();
    }
}
