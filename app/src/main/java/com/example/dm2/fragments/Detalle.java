package com.example.dm2.fragments;

import android.os.Bundle;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;

public class Detalle extends AppCompatActivity {

    public static final String EXTRA_TEXTO = "com.example.amaia.fragmentos.EXTRA_TEXTO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        FragmentDetalle detalle = (FragmentDetalle)getSupportFragmentManager().findFragmentById(R.id.frgDetalle);
        detalle.mostrarDetalle(getIntent().getStringExtra(EXTRA_TEXTO));
    }
}
