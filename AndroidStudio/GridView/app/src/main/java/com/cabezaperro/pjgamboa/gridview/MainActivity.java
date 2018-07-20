package com.cabezaperro.pjgamboa.gridview;

import android.content.Context;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    GridView gridViewPaises;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        gridViewPaises = findViewById(R.id.gridView);
        
        ArrayList<Pais> paises = new ArrayList<>();
        String[] paisesString = { "brazil", "canada", "china", "france", "germany", "india", "italy", "japan", "korea", "mexico", "netherlands", "portugal", "spain", "turkey", "united_kingdom", "united_states" };
        int recursoID;
        Pais p;
        
        for (int i = 0; i < paisesString.length; i++)
        {
            recursoID = getResources().getIdentifier(paisesString[i], "drawable", getPackageName());
            p = new Pais(paisesString[i], recursoID);
            paises.add(p);
            
            Log.d("Prueba", p.getNombre() + ' ' + p.getBandera());
        }
    
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, paises);
        ImageAdapter adapterNuevo = new ImageAdapter(this, R.layout.activity_image, paises);
        gridViewPaises.setAdapter(adapterNuevo);
    }
    
    public void onClick(View v)
    {
        int numColumnas = 0;
        
        switch (v.getId())
        {
            case R.id.button:
                numColumnas = 1;
                break;
            case R.id.button2:
                numColumnas = 2;
                break;
            case R.id.button3:
                numColumnas = 3;
                break;
            case R.id.button4:
                numColumnas = 4;
                break;
        }
        
        gridViewPaises.setNumColumns(numColumnas);
    }
    
    private class ImageAdapter extends BaseAdapter
    {
        Context contexto;
        int recursoIDLayout;
        ArrayList datos;
        
        public ImageAdapter(Context contexto, int recursoIDLayout, ArrayList datos)
        {
            this.contexto = contexto;
            this.recursoIDLayout = recursoIDLayout;
            this.datos = datos;
        }
        
        @Override
        public int getCount()
        {
            return datos.size();
        }
    
        @Override
        public Object getItem(int position)     // No lo utilizaremos
        {
            return null;
        }
    
        @Override
        public long getItemId(int position)     // No lo utilizaremos
        {
            return 0;
        }
    
        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            View gridElement;
            LayoutInflater inflater = (LayoutInflater)contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            TextView textView;
            ImageView imageView;
            Pais pais;
        
            if (convertView == null)    //Nuevo es necesario
            {
                gridElement = inflater.inflate(recursoIDLayout, null);
            }
            else    //Reciclado, ya creado
            {
                gridElement = convertView;
            }
            
            textView = gridElement.findViewById(R.id.textView);
            imageView = gridElement.findViewById(R.id.imageView);
            pais = (Pais)datos.get(position);
            
            textView.setText(pais.getNombre());
            imageView.setImageResource(pais.getBandera());
            
            return gridElement;
        }
        
        /*
        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            ImageView imageView;
            Pais pais;
            
            if (convertView == null)    //Nuevo es necesario
            {
                imageView = new ImageView(contexto);
                imageView.setLayoutParams(new AbsListView.LayoutParams(85, 85));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8, 8, 8, 8);
            }
            else    //Reciclado, ya creado
            {
                imageView = (ImageView)convertView;
            }
            
            pais = (Pais)datos.get(position);
            imageView.setImageResource(pais.getBandera());
            return imageView;
        }
        */
    }
}
