package com.example.dm2.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Main extends AppCompatActivity  implements ListadoFragment.LibrosListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListadoFragment frgListado = (ListadoFragment)getSupportFragmentManager().findFragmentById(R.id.fragment);
        frgListado.setLibrosListener(this);
    }
    @Override
    public void onLibroSeleccionado(Libro l){
        boolean hayDetalle = (getSupportFragmentManager().findFragmentById(R.id.frgDetalle)!=null);
        if(hayDetalle)
            ((FragmentDetalle)getSupportFragmentManager().findFragmentById(R.id.frgDetalle)).mostrarDetalle(l.toString());
        else{
            Intent i = new Intent(this, Detalle.class);
            i.putExtra(Detalle.EXTRA_TEXTO, l.toString());
            startActivity(i);
        }
    }

}
