package e.android9ed.androidevaluacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ActividadDos extends AppCompatActivity
{
    TextView datosActividadUno, textoDivisores;
    public static String valorDeVuelta = "ValorDeVuelta";
    List<Integer> div;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_dos);

        datosActividadUno = findViewById(R.id.textoDatoActividad1);
        textoDivisores = findViewById(R.id.textoDivisores);

        div = new ArrayList<>();
        Intent intent = getIntent();

        if (intent != null)
        {
            String valorActividadUno = intent.getStringExtra(ActividadUno.datosEntrada);
            datosActividadUno.setText(valorActividadUno);

            int numero = Integer.valueOf(valorActividadUno);
            div = calcularDivisores(numero);
            textoDivisores.setText(div.toString());

            // Toast.makeText(this, "Valor enviado: " + valorActividadUno, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onBackPressed()
    {
        devolverInformacion();
        super.onBackPressed();
    }

    private void devolverInformacion()
    {
        Intent intent = getIntent();
        intent.putExtra(valorDeVuelta, div.size());
        setResult(RESULT_OK, intent);
    }

    public void volver(View v)
    {
        devolverInformacion();
        finish();
    }

    private List<Integer> calcularDivisores(int num)
    {
        List<Integer> divisores = new ArrayList<>();

        for (int i = 1; i <= num / 2; i++)
            if (num % i == 0)
                divisores.add(i);

        divisores.add(num);

        return divisores;
    }
}
