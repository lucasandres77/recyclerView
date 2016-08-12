package com.example.lucas.practica1listview;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

/**
 * Created by Lucas on 5/12/16.
 */
public class ListenerPeliculas implements AdapterView.OnItemClickListener {
    @Override
    public void onItemClick(AdapterView<?> adapterQueMeInvoco, View vistaTocada, int posicionTocada, long iDelElementoTocado) {

        Pelicula unaPeliculaTocada;
        unaPeliculaTocada = (Pelicula) adapterQueMeInvoco.getItemAtPosition(posicionTocada);

        Toast.makeText(adapterQueMeInvoco.getContext(), "Tocaste una pelicula",Toast.LENGTH_LONG).show();

        //Log.d("Se toco la pelicula:" + "unaPeliculaTocada.getTitulo()");

        String tituloAMostrar, personajeAMostrar;
        tituloAMostrar = unaPeliculaTocada.getTitulo();
        personajeAMostrar = unaPeliculaTocada.getPersonaje();

        int imagenAMostrar;
        imagenAMostrar = unaPeliculaTocada.getIdImagen();

        Intent unIntent;
        unIntent = new Intent(adapterQueMeInvoco.getContext(),ActivityPantallaGrande.class);

        Bundle unBundle;
        unBundle = new Bundle();

        unBundle.putString(ActivityPantallaGrande.TITULO, tituloAMostrar);
        unBundle.putString(ActivityPantallaGrande.PERSONAJE, personajeAMostrar);
        unBundle.putInt(ActivityPantallaGrande.IMAGEN,imagenAMostrar);

        unIntent.putExtras(unBundle);

        adapterQueMeInvoco.getContext().startActivity(unIntent);



    }
}
