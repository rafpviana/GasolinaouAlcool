package com.example.rafaelpinheiro.gasolinaoualcool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText caixaTextoPrecoAlcool;
    private EditText caixaTextoPrecoGasolina;
    private Button botaoVerificar;
    private TextView textoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        caixaTextoPrecoAlcool = (EditText) findViewById(R.id.caixaTextoPrecoAlcoolId);
        caixaTextoPrecoGasolina = (EditText) findViewById(R.id.caixaTextoPrecoGasolinaId);
        botaoVerificar = (Button) findViewById(R.id.botaoVerificarId);
        textoResultado = (TextView) findViewById(R.id.textoResultadoId);

        botaoVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String precoAlcoolString = caixaTextoPrecoAlcool.getText().toString();
                String precoGasolinaString = caixaTextoPrecoGasolina.getText().toString();

                if(precoAlcoolString.isEmpty() || precoGasolinaString.isEmpty()){
                    Toast.makeText(MainActivity.this, "Digitel um valor válido", Toast.LENGTH_SHORT).show();
                }
                else{
                    double precoAlcoolDouble = Double.parseDouble(precoAlcoolString);
                    double precoGasolinaDouble = Double.parseDouble(precoGasolinaString);

                    double resultado = precoAlcoolDouble/precoGasolinaDouble;

                    if(resultado >= 0.7){
                        textoResultado.setText("É melhor utilizar Gasolina");
                    }
                    else{
                        textoResultado.setText("É melhor utilizar Alcool");
                    }
                }
            }
        });
    }
}
