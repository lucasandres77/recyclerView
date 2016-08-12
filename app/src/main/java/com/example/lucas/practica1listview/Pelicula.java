package com.example.lucas.practica1listview;

/**
 * Created by Lucas on 5/11/16.
 */
public class Pelicula {

    private String titulo;
    private String personaje;
    private int idImagen;


    public Pelicula(String unTitulo, String unPersonaje, int unIdImagen) {
        titulo = unTitulo;
        personaje = unPersonaje;
        idImagen = unIdImagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getPersonaje() {
        return personaje;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setPersonaje(String personaje) {
        this.personaje = personaje;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    @Override
    public boolean equals(Object o) {
        Pelicula otraPelicula = (Pelicula) o;
        if (o == null) {
            return false;
        }
        if (otraPelicula.getTitulo().equals(this.getTitulo())) {

            return true;
        } else {
            return false;
        }

    }
}

