package es.uma.ac.asenjo.polacainversa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    CPI cpiVisual = new CPI();
    EditText numero;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numero = (EditText) findViewById(R.id.editText);
        resultado = (TextView) findViewById(R.id.textView);
    }

        public void EntraClick (View v){
            String numeroE=numero.getText().toString();
            if (numeroE.length()>0)
            {
                int entero = Integer.parseInt(numeroE);
                cpiVisual.entra(entero);
            }
            Toast.makeText(this, numeroE, Toast.LENGTH_SHORT).show();
            Log.i("Rafa","Stack"+cpiVisual.toString());
        }

    public void SumaClick (View v){
        cpiVisual.suma();
        Toast.makeText(this, "Suma", Toast.LENGTH_SHORT).show();
    }

    public void RestaClick (View v){
        cpiVisual.resta();
        Toast.makeText(this, "Resta",Toast.LENGTH_SHORT).show();
    }

    public void MultiplicaClick (View v){
        cpiVisual.multiplica();
        Toast.makeText(this, "Multiplicación",Toast.LENGTH_SHORT).show();
    }

    public void DivideClick (View v){
        cpiVisual.divide();
        Toast.makeText(this, "División", Toast.LENGTH_SHORT).show();
    }

    public void ResultadoClick (View v){
        resultado.setText("Resultado " + cpiVisual.getResultado());
    }

}
