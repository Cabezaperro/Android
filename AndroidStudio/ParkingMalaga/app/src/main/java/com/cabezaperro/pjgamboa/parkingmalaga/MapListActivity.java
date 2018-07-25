package com.cabezaperro.pjgamboa.parkingmalaga;

import android.content.Context;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MapListActivity extends AppCompatActivity
{
    ListView listaParking;
    ParkingAdapter parkingAdapter;
    ArrayList<Parking> parkings;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_list);
        
        listaParking = findViewById(R.id.listViewParking);
        parkings = (ArrayList<Parking>)getIntent().getExtras().get(MapActivity.EXTRA_LISTAPARKING);
        parkingAdapter = new ParkingAdapter(this, R.layout.parkingitem, parkings);
        
        listaParking.setAdapter(parkingAdapter);
    }
    
    public void onClickCercano(View v)
    {
        Location greenRay = new Location("Green Ray");
        Location parking;
        Location masCercano = null;
        
        greenRay.setLatitude(36.71853911463124);
        greenRay.setLongitude(-4.496980905532837);
        
        for (Parking p : parkings)
        {
            parking = new Location(p.getNombre());
            parking.setLatitude(p.getLatitude());
            parking.setLongitude(p.getLongitude());
            
            if (masCercano == null || parking.distanceTo(greenRay) < masCercano.distanceTo(greenRay))
                masCercano = parking;
        }
    
        Toast.makeText(this, "El parking más cercano a " + greenRay.getProvider() + " es: " + masCercano.getProvider(), Toast.LENGTH_LONG).show();
    }
    
    public class ParkingAdapter extends BaseAdapter
    {
        private Context _context;
        private int _resource;
        private ArrayList<Parking> _lp;
        
        ParkingAdapter(Context context, int resource, ArrayList<Parking> lp)
        {
            _context = context;
            _resource = resource;
            _lp = lp;
        }
        
        @Override
        public int getCount()
        {
            return _lp.size();
        }
    
        @Override
        public Object getItem(int position) { return null; }
    
        @Override
        public long getItemId(int position) { return 0; }
    
        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            View gridElement;
            LayoutInflater inflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            
            if (convertView == null)    // Es necesario crear uno nuevo
                gridElement = inflater.inflate(_resource, null);
            else                        // Reciclado, ya creado
                gridElement = convertView;
            
            TextView textViewID = gridElement.findViewById(R.id.text_ID);
            TextView textViewNombre = gridElement.findViewById(R.id.text_Nombre);
            TextView textViewCapacidad = gridElement.findViewById(R.id.text_Capacidad);
            
            textViewID.setText(String.format("%d", _lp.get(position).getId()));
            textViewNombre.setText(_lp.get(position).getNombre());
            textViewCapacidad.setText(String.format("%d", _lp.get(position).getCapacidad()));
            
            return gridElement;
        }
    }
}
