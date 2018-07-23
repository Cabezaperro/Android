package e.android9ed.appcliente;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class GridViewActivity extends AppCompatActivity
{
    GridView listaImagenes;
    String ip = "192.168.1.166";
    BitmapAdapter bitmapAdapter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        
        // Toast.makeText(this, "Image " + num_image, Toast.LENGTH_LONG).show();
        
        /*
        int num_image = getIntent().getIntExtra(MainActivity.EXTRA_NUM, -1);
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(num_image);
        */
    
        SharedPreferences settings = getSharedPreferences("Imagenes", 0);
        SharedPreferences.Editor editor = settings.edit();
        
        ArrayList<Integer> listaNums = (ArrayList<Integer>)getIntent().getExtras().get(MainActivity.EXTRA_LISTA_NUM);
        listaImagenes = findViewById(R.id.gridView);
        
        // ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaNums);
        bitmapAdapter = new BitmapAdapter(this, 0);
        listaImagenes.setAdapter(bitmapAdapter);
        
        for (Integer numeroImagen: listaNums)
        {
            String url = "http://" + ip + ":8080/image.php?n=" + numeroImagen;
            DescargarImagen descargarImagen = new DescargarImagen();
            descargarImagen.execute(url);
        }
    }
    
    private class BitmapAdapter extends ArrayAdapter<Bitmap>
    {
        Context contexto;
        
        public BitmapAdapter(@NonNull Context context, int resource)
        {
            super(context, resource);
            contexto = context;
        }
        
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
        {
            ImageView imagen = new ImageView(contexto);
            Bitmap bitmap = getItem(position);
            
            imagen.setImageBitmap(bitmap);
            
            return imagen;
        }
    }
    
    private class DescargarImagen extends AsyncTask<String, Void, Bitmap>
    {
        @Override
        protected Bitmap doInBackground(String... strings)
        {
            URL url;
            Bitmap bm = null;
            
            try
            {
                url = new URL(strings[0]);
                InputStream is = url.openStream();
                bm = BitmapFactory.decodeStream(is);
                
                Log.d("BYTES IMAGEN:", " " + bm.getByteCount());
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            
            return bm;
        }
    
        @Override
        protected void onPostExecute(Bitmap bitmap)
        {
            bitmapAdapter.add(bitmap);
        }
    }
}