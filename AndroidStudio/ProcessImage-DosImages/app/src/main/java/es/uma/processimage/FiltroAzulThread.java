package es.uma.processimage;

import android.graphics.Bitmap;
import android.graphics.Color;

public class FiltroAzulThread implements FiltroImagen
{
    private Bitmap imagen;

    public FiltroAzulThread(Bitmap imagen)
    {
        this.imagen = imagen;
    }

    @Override
    public void filtra(Bitmap imagen)
    {
        int fWidth  = imagen.getWidth();
        int fHeight = imagen.getHeight();

        for (int x = 0; x < fWidth ; x++)
            for (int y = 0; y < fHeight; y++)
            {
                int azul = Color.blue(imagen.getPixel(x, y));
                imagen.setPixel(x, y, Color.rgb(0,0,azul));
            }
    }
}
