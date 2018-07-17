package e.android9ed.androidevaluacion;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import io.michaelrocks.libphonenumber.android.NumberParseException;
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil;
import io.michaelrocks.libphonenumber.android.Phonenumber;

public class ActividadUno extends AppCompatActivity {

    EditText textoEntrada;
    final int reqCall = 1;
    Intent llamar;
    public static String datosEntrada = "DatosEntrada";
    public final int PERMISO_LLAMADA = 10;
    public final int REQUEST_CODE_ACTIVIDAD2 = -1;
    String input = textoEntrada.getText().toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_uno);

        textoEntrada = (EditText) findViewById(R.id.informacionEntrada);
    }

    public void onClick(View v) {
        Log.d("ActividadUno:onClick", "El número es: " + input);

        if (input.isEmpty()) {
            Toast.makeText(getApplicationContext(), R.string.numVacio, Toast.LENGTH_LONG).show();
        } else {
            switch (v.getId()) {
                case R.id.botonCalcular:
                    Intent actividadDos = new Intent(this, ActividadDos.class);
                    actividadDos.putExtra("numero", input);
                    startActivity(actividadDos);
                    break;
                case R.id.botonLlamar:
                    PhoneNumberUtil util = PhoneNumberUtil.createInstance(getApplicationContext());
                    Phonenumber.PhoneNumber number;

                    try {
                        number = util.parse(input, "ES");
                        if (util.isValidNumber(number)) {
                            Llamar();
                        } else
                            Toast.makeText(this, "Número de teléfono no válido", Toast.LENGTH_LONG).show();
                    } catch (NumberParseException e) {
                        Toast.makeText(this, "Excepción: Número de teléfono no válido", Toast.LENGTH_LONG).show();
                    }
                    break;
            }
        }
    }

    private void Llamar() {
        String uriTelefono = "tel:" + input;
        Intent llamar = new Intent(Intent.ACTION_CALL, Uri.parse(uriTelefono));

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            Log.d("ActividadUno:Permiso", "Error Mensaje");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, reqCall);
        } else
            startActivity(llamar);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case reqCall:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.d("ActividadUno:Call", "Permiso concedido");
                    startActivity(llamar);
                } else
                    Log.d("ActividadUno:Call", "Permiso denegado.");
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQUEST_CODE_ACTIVIDAD2:
                if (resultCode == RESULT_OK)
                    if (data != null) {
                        int divisores = data.getIntExtra(ActividadDos.valorDeVuelta, -1);

                        if (divisores == 2)
                            Toast.makeText(this, "Número primo", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(this, "Tiene " + divisores + " divisores", Toast.LENGTH_LONG).show();
                    }

                break;
        }
    }
}
