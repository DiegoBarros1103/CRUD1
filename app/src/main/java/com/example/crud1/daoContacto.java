package com.example.crud1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.util.ArrayList;


public class daoContacto {
    SQLiteDatabase cx;
    ArrayList<Contacto> lista;
    Contacto c;
    Context ct;
    String nombreBD="BDContactos";
    String tabla="create table if not exists contacto(id integer primary key autoincrement, nombre text, telefono text, email , edad integer)";

    public daoContacto (Context c){
        this.ct = c;
        cx = c.openOrCreateDatabase(nombreBD, Context.MODE_WORLD_WRITEABLE, null);
        cx.execSQL(tabla);
    }

    public boolean insertar(Contacto c) {
        ContentValues contenedor=new ContentValues();
        contenedor.put("nombre",c.getNombre());
        contenedor.put("telefono",c.getTelefono());
        contenedor.put("email",c.getEmail());
        contenedor.put("edad",c.getEdad());
        return (cx.insert("contacto",null,contenedor))>0;



    }

    public boolean eliminar(int id) {
        return true;
    }

    public boolean editar(Contacto c) {
        return true;
    }

    public ArrayList<Contacto> verTodos() {
        return lista;
    }

    public Contacto verUno(int id) {
        return c;
    }
}
