package es.uam.eps.unaprimeraapp;

import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class ActividadPrincipal extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /* CAMBIO 3
         * Rellena el argumento del metodo setContentView usando el identificador
         * de layout adecuado de los recursos
         */
        setContentView(R.layout.actividad_principal);
        
        /* CAMBIO 6
         * 	Debes añadir el codigo necesario para cambiar el color de fondo del botón con 
         *  id boton1 a blanco opaco. Nota: para cambiar el color de fondo debes usar el 
         *  metodo setBackgroundColor.  
         */
        findViewById(R.id.button1).setBackgroundColor(0xFF888888);
    }

    public void botonArribaClick(View v){
    	v.setVisibility(View.GONE);
    }
    
    public void botonAbajoClick(View v){
    	
    	/* CAMBIO 4:
    	 * Substituye null por la llamada necesaria para obtener la referencia al boton2. 
    	 *   Pista: el método a usar es findViewById 
    	 */
		((Button)findViewById(R.id.button2)).setText(getResources().getString(R.string.otra_etiqueta_boton2));
    	Button boton2 = (Button) findViewById(R.id.button2);
    	
    	/* CAMBIO 5:
    	 * Substituye "" por la llamada necesaria para obtener la cadena definida en los
    	 *    recursos con nombre otra_etiqueta_boton2. 
    	 *   Pista: para obtener acceso a los recursos hay que usar el metodo getResources() 
    	 */
    	String texto = getResources().getString(R.string.otra_etiqueta_boton2);
    	boton2.setText(texto);
    }

}
