package com.cabezaperro.pjgamboa.parkingmalaga;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MapActivity extends AppCompatActivity
{
    ArrayList<Parking> list_parking;
    public static final String EXTRA_LISTAPARKING = "extra_listaParking";
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        
        list_parking = new ArrayList<>();
        loadParking();
    }
    
    public void onClickMaps(View v)
    {
        Intent mapListActivity = new Intent(this, MapListActivity.class);
        
        mapListActivity.putExtra(EXTRA_LISTAPARKING, list_parking);
        startActivity(mapListActivity);
    }
    
    private void loadParking()
    {
        Parking salitre = new Parking(1,"Salitre");
        Parking cervantes = new Parking(2,"Cervantes");
        Parking elpalo = new Parking(3,"El Palo");
        Parking andalucia = new Parking(4,"Av. de Andalucía");
        Parking camas = new Parking(5,"Camas");
        Parking alcazaba = new Parking(6,"Alcazaba");
        
        salitre.setDireccion("Calle Salitre");
        salitre.setLatitude(36.7132149);
        salitre.setLongitude(-4.4276681);
        salitre.setCapacidad(342);
        salitre.setFechaAct("25/07/17 16:00");
        salitre.setLibres(308);
        
        cervantes.setDireccion("Calle Cervantes");
        cervantes.setLatitude(36.7208633);
        cervantes.setLongitude(-4.4119148);
        cervantes.setCapacidad(414);
        cervantes.setFechaAct("25/07/17 16:00");
        cervantes.setLibres(349);
        
        elpalo.setDireccion("Calle Alonso Carrillo De Albornoz");
        elpalo.setLatitude(36.7210350);
        elpalo.setLongitude(-4.3607192);
        elpalo.setCapacidad(129);
        elpalo.setFechaAct("25/07/17 16:00");
        elpalo.setLibres(93);
        
        andalucia.setDireccion("Avenida De Andalucía");
        andalucia.setLatitude(36.7171364);
        andalucia.setLongitude(-4.4277549);
        andalucia.setCapacidad(517);
        andalucia.setFechaAct("25/07/17 16:00");
        andalucia.setLibres(495);
        
        camas.setDireccion("Calle Camas");
        camas.setLatitude(36.7193031);
        camas.setLongitude(-4.4249320);
        camas.setCapacidad(308);
        camas.setFechaAct("25/07/17 16:00");
        camas.setLibres(232);
        
        alcazaba.setDireccion("Plaza La Alcazaba");
        alcazaba.setLatitude(36.7224312);
        alcazaba.setLongitude(-4.4165168);
        alcazaba.setCapacidad(344);
        alcazaba.setFechaAct("25/07/17 16:00");
        alcazaba.setLibres(96);
        
        list_parking.add(salitre);
        list_parking.add(cervantes);
        list_parking.add(elpalo);
        list_parking.add(andalucia);
        list_parking.add(camas);
        list_parking.add(alcazaba);
    }
}