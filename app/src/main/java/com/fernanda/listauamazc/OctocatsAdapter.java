package com.fernanda.listauamazc;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fernanda.listauamazc.R.*;

/**
 * Created by monsh on 10/09/2015.
 */

//Esta clase es el adaptador
public class OctocatsAdapter extends ArrayAdapter<Octocats> {

    Context context;
    int layotResourceId;
    Octocats datos[] = null;

    public OctocatsAdapter(Context context, int layotResourceId, Octocats[] datos) {
        super(context, layotResourceId, datos);

        this.context = context;
        this.layotResourceId = layotResourceId;
        this.datos = datos;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        OctocatsHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layotResourceId, parent, false);

            holder = new OctocatsHolder();

            holder.imagen = (ImageView) row.findViewById(R.id.imagen);
            holder.texto = (TextView) row.findViewById(R.id.tv);

            row.setTag(holder);

        } else {
            holder = (OctocatsHolder) row.getTag();
        }

        Octocats octocats = datos[position];
        holder.texto.setText(octocats.nombre);
        holder.imagen.setImageResource(octocats.icon);

        return row;
    }

    static class OctocatsHolder {
        ImageView imagen;
        TextView texto;


    }
}

