package com.cabezaperro.pjgamboa.parkingmalaga;

import java.io.Serializable;

public class Parking implements Serializable
{
    private int _id;
    private String _nombre;
    private String _direccion;
    private double _latitude;
    private double _longitude;
    private int _capacidad;
    private String _fechaAct;
    private int _libres;
    
    Parking(int id, String nombre)
    {
        _id = id;
        _nombre = nombre;
    }
    
    public void setDireccion(String direccion) { _direccion = direccion; }
    public void setLatitude(double latitude) { _latitude = latitude; }
    public void setLongitude(double longitude) { _longitude = longitude; }
    public void setCapacidad(int capacidad) { _capacidad = capacidad; }
    public void setFechaAct(String fechaAct) { _fechaAct = fechaAct; }
    public void setLibres(int libres) { _libres = libres; }
    
    public int getId() { return _id; }
    public String getNombre() { return _nombre; }
    public String getDireccion() { return _direccion; }
    public double getLatitude() { return _latitude; }
    public double getLongitude() { return _longitude; }
    public int getCapacidad() { return _capacidad; }
    public String getFechaAct() { return _fechaAct; }
    public int getLibres() { return _libres; }
    
    @Override
    public String toString()
    {
        return getId() + ' ' + getNombre();
    }
}