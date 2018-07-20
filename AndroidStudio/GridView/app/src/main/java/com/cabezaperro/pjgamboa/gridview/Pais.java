package com.cabezaperro.pjgamboa.gridview;

import android.content.Context;

public class Pais
{
    private String nombre;
    private int recursoID;
    
    Pais(String nombre, int recursoID)
    {
        this.nombre = nombre;
        this.recursoID = recursoID;
    }
    
    public int getBandera()
    {
        return recursoID;
    }
    
    public String getNombre()
    {
        return nombre;
    }
    
    @Override
    public String toString()
    {
        return nombre;
    }
}
