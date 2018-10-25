package com.example.wind.orderfoodapp.Modelo;

public class Usuario {
    private String Nombre;
    private String Contraseña;

    public Usuario() {
    }

    public Usuario(String nombre, String contraseña) {
        Nombre = nombre;
        Contraseña = contraseña;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }
}
