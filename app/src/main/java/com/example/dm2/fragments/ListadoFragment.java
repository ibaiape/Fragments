package com.example.dm2.fragments;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class ListadoFragment extends Fragment {

    private Libro[] libros = new Libro[]{
                    new Libro(123, "Libro 1", "Autor 1", "Es un libro sobre cosas"),
                    new Libro(233, "Libro 2", "Autor 2", "Es un libro sobre muchas cosas"),
                    new Libro(421, "Libro 3", "Autor 3", "Es un libro sobre muchas cosas bonitas"),
                    new Libro(520, "Libro 4", "Autor 4", "Es un libro sobre cosas feas"),
                    new Libro(666, "Necronomicón", "Mephistóteles", "SHOW ME YOUR PAIN")};
    private ListView lstListado;
    private LibrosListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listado, container, false);
    }

    @Override
    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);
        lstListado =(ListView)getView().findViewById(R.id.LstListado);
        lstListado.setAdapter(new AdaptadorLibros(this));

        lstListado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(listener!=null)
                    listener.onLibroSeleccionado((Libro)lstListado.getAdapter().getItem(position));
            }
        });
    }

    class AdaptadorLibros extends ArrayAdapter<Libro> {
        Activity context;
        AdaptadorLibros(Fragment context) {
            super(context.getActivity(), R.layout.listitem_libro, libros);
            this.context = context.getActivity();
        }
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listitem_libro, null);
            ((TextView)item.findViewById(R.id.lblTitulo)).setText(libros[position].getTitulo());
            ((TextView)item.findViewById(R.id.lblAutor)).setText(libros[position].getAutor());
            ((TextView)item.findViewById(R.id.lblResumen)).setText(libros[position].getResumen());
            return (item);
        }
    }

    public interface LibrosListener{
        void onLibroSeleccionado(Libro l);
    }
    public void setLibrosListener (LibrosListener listener){
        this.listener =listener;
    }


}
