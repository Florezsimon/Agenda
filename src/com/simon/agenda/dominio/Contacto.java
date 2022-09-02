package com.simon.agenda.dominio;

public class Contacto {

    private String nombre;
    private  int telefono;

    private String apellido;

    public Contacto(String nombre, int telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }
    public Contacto(String nombre) {
        this.nombre = nombre;
        this.telefono = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public boolean equals (Contacto c){
        if(this.nombre.equalsIgnoreCase(c.getNombre())){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return  "nombre =" + nombre + ", telefono=" + telefono;
    }
}
