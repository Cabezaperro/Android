package e.android9ed.appcliente;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    EditText textoEntrada;
    public static final String EXTRA_NUM = "extra_num";
    public static final String EXTRA_LISTA_NUM = "extra_lista_num";
    ArrayList<Integer> listaNums;
    public final int PERMISOS_INTERNET = 10;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        listaNums = new ArrayList<>();
        textoEntrada = findViewById(R.id.editTextEntrada);
        
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, PERMISOS_INTERNET);
        else
            Toast.makeText(this, "Permisos internet concedidos", Toast.LENGTH_LONG).show();
    }
    
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        switch (requestCode)
        {
            case PERMISOS_INTERNET:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    Toast.makeText(this, "Permisos internet concedidos", Toast.LENGTH_LONG).show();
                break;
        }
    }
    
    public void onClick(View v)
    {
        String cadenaEntrada = textoEntrada.getText().toString();
        
        if (cadenaEntrada.length() > 0)
        {
            int num = Integer.parseInt(cadenaEntrada);
            listaNums.add(num);
            
            if (num > 195)
                Toast.makeText(this, "La entrada debe estar entre 0 y 195", Toast.LENGTH_LONG).show();
            else
            {
                Intent actividadGrid = new Intent(this, GridViewActivity.class);
                actividadGrid.putExtra(EXTRA_NUM, num);
                actividadGrid.putExtra(EXTRA_LISTA_NUM, listaNums);
                startActivity(actividadGrid);
                
                textoEntrada.setText("");
            }
        }
        else
            Toast.makeText(this, "La entrada no puede estar vacía", Toast.LENGTH_LONG).show();
    }
}
