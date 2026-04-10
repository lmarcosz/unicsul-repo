package com.pdm.cepapi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONObject;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
public class MainActivity extends AppCompatActivity {
    private EditText edCep;
    private Button btBuscar;
    private TextView txResultado;
    private OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private boolean isCepValido(String cep) {
        return !TextUtils.isEmpty(cep) && cep.length() == 8;
    }

    private void buscarCep(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        Request request = new Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(() -> {
                    txResultado.setText("Falha na requisição: " + e.getMessage());
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) {
                    final String msg = "Erro na resposta: " + response.code();
                    runOnUiThread(() -> txResultado.setText(msg));
                    return;
                }
                final String body = response.body() != null ? response.body().string() : "";
                try {
                    JSONObject json = new JSONObject(body);
                    if (json.has("erro") && json.getBoolean("erro")) {
                        runOnUiThread(() -> txResultado.setText("CEP não encontrado."));
                        return;
                    }
                    final String logradouro = json.optString("logradouro", "");
                    final String complemento = json.optString("complemento", "");
                    final String bairro = json.optString("bairro", "");
                    final String localidade = json.optString("localidade", "");
                    final String uf = json.optString("uf", "");
                    final String ddd = json.optString("ddd", "");
                    final String resultado = String.format(
                            "%s %s\n%s\n%s - %s\nDDD: %s",
                            logradouro,
                            complemento.isEmpty() ? "" : "(" + complemento + ")",
                            bairro,
                            localidade,
                            uf,
                            ddd
                    ).replaceAll(" +\\)", ")").trim();
                    runOnUiThread(() -> txResultado.setText(resultado.isEmpty() ? "Sem dados disponíveis." : resultado));
                } catch (Exception e) {
                    e.printStackTrace();
                    runOnUiThread(() -> txResultado.setText("Erro ao interpretar resposta."));
                }
            }
        });
    }

    public void buscarCep(View view) {
        edCep = findViewById(R.id.edtCep);
        btBuscar = findViewById(R.id.btBuscar);
        txResultado = findViewById(R.id.txResultado);
        btBuscar.setOnClickListener(v -> {
            String cep = edCep.getText().toString().replaceAll("\\D+", "");
            if (isCepValido(cep)) {
                buscarCep(cep);
            } else {
                Toast.makeText(MainActivity.this, "CEP inválido. Digite 8 números.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}