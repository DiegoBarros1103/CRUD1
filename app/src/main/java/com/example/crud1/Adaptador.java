package com.example.crud1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {
    ArrayList<Contacto> lista;
    daoContacto dao;
    Contacto c;
    Activity a;
public Adaptador(Activity a, ArrayList<Contacto> lista, daoContacto dao) {
    this.lista = lista;
    this.a = a;
    this.dao = dao;

}


    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Contacto getItem(int i) {
        c=lista.get(i);
        return null;
    }

    @Override
    public long getItemId(int i) {
        c=lista.get(i);
        return c.getId();
    }

    @Override
    public View getView(int posicion, View view, ViewGroup viewGroup) {
        View v= view;
        if(v!=null) {
            LayoutInflater li=(LayoutInflater) a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=li.inflate(R.layout.item,null);

        }
        c=lista.get(posicion);
        TextView nombre=(TextView)v.findViewById(R.id.t_nombre);
        TextView tel=(TextView)v.findViewById(R.id.t_telefono);
        TextView email=(TextView)v.findViewById(R.id.t_email);
        TextView edad=(TextView)v.findViewById(R.id.t_edad);
        Button editar=(Button)v.findViewById(R.id.editar);
        Button eliminar=(Button)v.findViewById(R.id.eliminar);
        nombre.setText(c.getNombre());
        tel.setText(c.getTelefono());
        email.setText(c.getEmail());
        edad.setText(c.getEdad());
        editar.setTag(posicion);
        eliminar.setTag(posicion);
        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Dialogo de edita Dialogo.xml

            }
        });

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Dialogo para confirmar Si o NO
            }
        });

        return v;
    }
}
