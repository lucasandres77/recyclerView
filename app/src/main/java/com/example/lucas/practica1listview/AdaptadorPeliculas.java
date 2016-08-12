package com.example.lucas.practica1listview;

import android.content.Context;
import android.location.GpsStatus;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Lucas on 5/10/16.
 */
public class AdaptadorPeliculas extends RecyclerView.Adapter implements View.OnClickListener{

    private View.OnClickListener listener;
    private ArrayList<Pelicula> unaListaDeDatos;

    public AdaptadorPeliculas(ArrayList<Pelicula> unaListaDeDatos) {
        this.unaListaDeDatos = unaListaDeDatos;
    }

    public void setOnClickListener(View.OnClickListener unListener){
        listener = unListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //inflar la vista
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_detalle_pelicula, parent, false);

        //crear viewholder
        PeliculasViewHolder unaPeliculaViewHolder = new PeliculasViewHolder(itemView);

        itemView.setOnClickListener(this);

        return unaPeliculaViewHolder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Pelicula unaPelicula = unaListaDeDatos.get(position);

        PeliculasViewHolder unaPeliculaViewHolder = (PeliculasViewHolder) holder;

        unaPeliculaViewHolder.bindPelicula(unaPelicula);

    }


    @Override
    public int getItemCount() {
        return unaListaDeDatos.size();
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(v.getContext(),"apretaste una pelicula",Toast.LENGTH_LONG).show();
    }


    public static class PeliculasViewHolder extends RecyclerView.ViewHolder {


        private ImageView imagen;
        private TextView txtTitulo;
        private TextView txtPersonaje;

        public PeliculasViewHolder(View itemView) {
            super(itemView);

            imagen = (ImageView) itemView.findViewById(R.id.ImageView_Foto);
            txtTitulo = (TextView) itemView.findViewById(R.id.TextView_Titulo_Pelicula);
            txtPersonaje = (TextView) itemView.findViewById(R.id.TextView_Personaje);

        }

        public void bindPelicula(Pelicula unaPelicula) {

            imagen.setImageResource(unaPelicula.getIdImagen());
            txtTitulo.setText(unaPelicula.getTitulo());
            txtPersonaje.setText(unaPelicula.getPersonaje());
        }
    }
}






    /* public AdaptadorPeliculas(Context contexto, ArrayList<Pelicula> listaDeDatos){

        this.unContexto = contexto;
        this.unaListaDeDatos = listaDeDatos;
    }




    public Pelicula getItem(int posicion){
        return this.unaListaDeDatos.get(posicion);

    }

    public long getItemId(int posicion){
        return posicion;
    }

    public int getCount(){
        return this.unaListaDeDatos.size();
    }

    public View getView(int posicionActual, View vistaActual, ViewGroup grupoActual){

        LayoutInflater miInfladorDePeliculas;
        miInfladorDePeliculas = (LayoutInflater)unContexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        vistaActual = miInfladorDePeliculas.inflate(R.layout.layout_detalle_pelicula,grupoActual,false);

        TextView txtTitulo, txtPersonaje;

        txtTitulo = (TextView)vistaActual.findViewById(R.id.TextView_Titulo_Pelicula);
        txtPersonaje = (TextView)vistaActual.findViewById(R.id.TextView_Personaje);

        Pelicula unaPeliculaActual;
        unaPeliculaActual = getItem(posicionActual);

        txtTitulo.setText(unaPeliculaActual.getTitulo());
        txtPersonaje.setText(unaPeliculaActual.getPersonaje());


        ImageView imageView = (ImageView) vistaActual.findViewById(R.id.ImageView_Foto);
        if(unaPeliculaActual.getIdImagen() != -1){
            imageView.setImageResource(unaPeliculaActual.getIdImagen());
        }

        return vistaActual;

    }*/


