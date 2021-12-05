package com.example.currencyconverterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_CurrencyConverterApp);
        setContentView(R.layout.activity_main);

        this.mViewHolder.editValue = findViewById(R.id.edit_value);
        this.mViewHolder.textDolar = findViewById(R.id.text_dolar);
        this.mViewHolder.textEuro = findViewById(R.id.text_euro);
        this.mViewHolder.buttonCalculate = findViewById(R.id.button_calculate);

        this.clearValues();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button_calculate){
            String value = this.mViewHolder.editValue.getText().toString();
            if("".equals(value)){
                // Mostrar uma mensagem de alerta para o usuário
                Toast.makeText(this, this.getString(R.string.informe_valor), Toast.LENGTH_LONG).show();
                this.clearValues();
            }else{
                Double valueCurrency = Double.valueOf(value);

                this.mViewHolder.textDolar.setText(String.format("U$$ %.2f", valueCurrency/5.63));
                this.mViewHolder.textEuro.setText(String.format("£ %.2f", valueCurrency/6.36));
            }
        }
    }

    private void clearValues(){
        this.mViewHolder.textDolar.setText("");
        this.mViewHolder.textEuro.setText("");
    }

    private static class ViewHolder {
        EditText editValue;
        TextView textDolar;
        TextView textEuro;
        Button buttonCalculate;
    }
}