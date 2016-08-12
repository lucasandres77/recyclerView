package com.example.lucas.practica1listview;

import android.net.NetworkRequest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //ArrayList<String> arrPeliculas;
    AdaptadorPeliculas miAdaptadorPeliculas;

    ArrayList<Pelicula> arrPeliculas;

    RecyclerView recyclerView;


    public void apretadoRegistrar(View view) {

        EditText txtNuevaPelicula;
        txtNuevaPelicula = (EditText) findViewById(R.id.editTextNombrePelicula);

        EditText txtNuevoPersonaje;
        txtNuevoPersonaje = (EditText)findViewById(R.id.editTextNombrePersonaje);

        String titulo = null;
        if (txtNuevaPelicula.getText().toString().length() > 0){
            titulo = txtNuevaPelicula.getText().toString();
        }else {
            Toast.makeText(this, "Por favor ingrese una pelicula", Toast.LENGTH_LONG).show();
            return;
        }

        String personaje = txtNuevoPersonaje.getText().toString();

        int imgDefault = -1;
        Pelicula nuevaPelicula = new Pelicula(titulo, personaje, imgDefault);

        if (arrPeliculas.contains(nuevaPelicula)) {
            Toast.makeText(this, "La pelicula ya existe", Toast.LENGTH_LONG).show();
        } else {
            arrPeliculas.add(nuevaPelicula);
            miAdaptadorPeliculas.notifyDataSetChanged();

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Toolbar unToolbar;
        unToolbar = (Toolbar)findViewById(R.id.app_bar_Toolbar);
        setSupportActionBar(unToolbar);



       recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


        arrPeliculas = new ArrayList<>();
        LlenarPeliculas();

        miAdaptadorPeliculas = new AdaptadorPeliculas(arrPeliculas);


        AdaptadorPeliculas unAdaptadorPeliculas = new AdaptadorPeliculas(arrPeliculas);

        recyclerView.setAdapter(unAdaptadorPeliculas);

        //crear listener de pelicula

        ListenerPeliculasDos unListenerDePeliculas = new ListenerPeliculasDos();
        miAdaptadorPeliculas.setOnClickListener(unListenerDePeliculas);


       /* ListView lstListaPeliculas;
        lstListaPeliculas = (ListView)findViewById(R.id.Listview_listaPeliculas);


        miAdaptadorPeliculas = new AdaptadorPeliculas(this,arrPeliculas);

        lstListaPeliculas.setAdapter(miAdaptadorPeliculas);

        ListenerPeliculas unListenerPeliculas;

        unListenerPeliculas = new ListenerPeliculas();

        lstListaPeliculas.setOnItemClickListener(unListenerPeliculas);

*/
    }

    private void LlenarPeliculas(){
        Pelicula unaPelicula;
        unaPelicula = new Pelicula("Volver al futuro", "Marty Mc Fly",R.drawable.volver_al_futuro);

        arrPeliculas.add(unaPelicula);

        arrPeliculas.add(new Pelicula("Forrest Gump", "Forrest Gump", R.drawable.forrest_gump));

        arrPeliculas.add(new Pelicula("El Padrino", "Al Pacino", R.drawable.el_padrino));

        arrPeliculas.add(new Pelicula("Corazon Valiente", "Wallace", R.drawable.corazon_valiente));

        arrPeliculas.add(new Pelicula("Toy story", "Woody", R.drawable.toy_story));
    }


    private class ListenerPeliculasDos implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), "me apretaron" + recyclerView.getChildPosition(view),Toast.LENGTH_LONG).show();

        }
    }

}

