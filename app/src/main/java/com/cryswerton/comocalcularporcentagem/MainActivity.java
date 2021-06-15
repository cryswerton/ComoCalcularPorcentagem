package com.cryswerton.comocalcularporcentagem;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.pm.ActivityInfo;
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

        textoResposta.setText(quantidadeCamposVazios(campoTaxa, campoPrincipal, campoPorcentagem).toString());

    }

    private boolean isEmpty(EditText editText) {
        if (editText.getText().toString().trim().length() > 0)
            return false;

        return true;
    }

    private Integer quantidadeCamposVazios(EditText edt1, EditText edt2, EditText edt3){
        int numeroDeCamposVazios = 0;
        if (isEmpty(edt1))
            numeroDeCamposVazios += 1;
        if (isEmpty(edt2))
            numeroDeCamposVazios += 1;
        if (isEmpty(edt3))
            numeroDeCamposVazios += 1;

        return numeroDeCamposVazios;
    }
}
