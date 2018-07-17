package com.cabezaperro.pjgamboa.batterybr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    TextView textoBateria;
    TextView textoPantalla;
    ReceptorIntentPhone bateria;
    ReceptorPantalla pantalla;
    int pantallaOFF = 0, pantallaON = 0;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        textoBateria = findViewById(R.id.bateria);
        textoPantalla = findViewById(R.id.pantalla);
        bateria = new ReceptorIntentPhone();
        
        IntentFilter filterCargador = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(bateria, filterCargador);
        
        pantalla = new ReceptorPantalla();
        IntentFilter filterPantalla = new IntentFilter(Intent.ACTION_SCREEN_OFF);
        filterPantalla.addAction(Intent.ACTION_SCREEN_ON);
        registerReceiver(pantalla, filterPantalla);
    }
    
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        unregisterReceiver(bateria);
    }
    
    private class ReceptorPantalla extends BroadcastReceiver
    {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            String action = intent.getAction();
    
            // Pantalla OFF
            if (action.compareTo(Intent.ACTION_SCREEN_OFF) == 0)
            {
                pantallaOFF++;
                Log.d("Broadcast", "Pantalla OFF: " + pantallaOFF);
            }
            // Pantalla ON
            else
            {
                pantallaON++;
                Log.d("Broadcast", "Pantalla ON: " + pantallaON);
            }
            
            textoPantalla.setText("Pantalla ON: " + pantallaON + "\nPantalla OFF: " + pantallaOFF);
        }
    }
    
    private class ReceptorIntentPhone extends BroadcastReceiver
    {
        public void onReceive(Context context, Intent intent)
        {
            int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
            boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING ||
                    status == BatteryManager.BATTERY_STATUS_FULL;
            
            if (isCharging)
            {
                int chargePlug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
                boolean usbCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB;
                boolean acCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_AC;
                
                if (usbCharge)
                    textoBateria.setText("Cargando por USB.");
                if (acCharge)
                    textoBateria.setText("Cargando por red eléctrica.");
            }
            else
                textoBateria.setText("Sin cargar.");
            
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            String msg = textoBateria.getText().toString();
            
            msg = msg.concat(" Nivel batería: " + level);
            textoBateria.setText(msg);
        }
    }
}