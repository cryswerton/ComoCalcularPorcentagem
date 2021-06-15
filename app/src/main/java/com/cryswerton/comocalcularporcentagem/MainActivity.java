package com.cryswerton.comocalcularporcentagem;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Lock the screen orientation to portrait mode.
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public void mostrarTextoEntender(View view){

        EditText campoTaxa = findViewById(R.id.campoTaxa);
        EditText campoPrincipal = findViewById(R.id.campoPrincipal);
        EditText campoPorcentagem = findViewById(R.id.campoPorcentagem);
        TextView textoResposta = findViewById(R.id.textoResposta);

        String i = campoTaxa.toString();
        String C = campoPrincipal.toString();
        String porcentagem = campoPorcentagem.toString();

        if(amountOfEmptyFields(campoTaxa, campoPrincipal, campoPorcentagem) >= 2){
            textoResposta.setTextColor(Color.RED);
            textoResposta.setText("Você precisa preencher pelo menos 2 campos.");
        }else{
            textoResposta.setTextColor(Color.BLUE);
            textoResposta.setText(createResponse(textoResposta, getFieldValue(campoTaxa), getFieldValue(campoPrincipal), getFieldValue(campoPorcentagem)));
        }



    }

    private boolean isEmpty(EditText editText) {
        if (editText.getText().toString().trim().length() > 0)
            return false;

        return true;
    }

    private Integer amountOfEmptyFields(EditText edt1, EditText edt2, EditText edt3){
        int numeroDeCamposVazios = 0;
        if (isEmpty(edt1))
            numeroDeCamposVazios += 1;
        if (isEmpty(edt2))
            numeroDeCamposVazios += 1;
        if (isEmpty(edt3))
            numeroDeCamposVazios += 1;

        return numeroDeCamposVazios;
    }

    private Double getFieldValue(EditText editText){
        String temp = editText.getText().toString();
        double value = 0;
        if (!temp.isEmpty())
            value = Double.parseDouble(temp);

        return value;
    }

    private String createResponse(TextView textView, double i, double c, double p){
        Double taxa = i;
        Double capital = c;
        Double porcentagem = p;

        String text = "Taxa = i; Capital = C; Porcentagem = p.\n\n" +
                          "i = " + taxa.toString() + "(%)" +
                        "   ; C = " + capital.toString() + "(R$)" +
                        "   ; p = " + porcentagem.toString() + "(R$).";

        return text;
    }
}
