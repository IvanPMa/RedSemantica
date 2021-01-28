package com.example.redsemanticapoblacional;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class datosAdaptador extends RecyclerView.Adapter<datosAdaptador.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView eda,sex,puest,antigueda;
        //ImageView imgSujet;

        public ViewHolder(View itemView) {
            super(itemView);
            eda = (TextView) itemView.findViewById(R.id.edad);
            sex = (TextView) itemView.findViewById(R.id.sexo);
            puest = (TextView) itemView.findViewById(R.id.puesto);
            antigueda = (TextView) itemView.findViewById(R.id.antiguedad);
            //imgSujet = (ImageView) itemView.findViewById(R.id.imgSujeto);
        }
    }
    public List<datosModelo> datosLista;

    public datosAdaptador(List<datosModelo> datosLista) {
        this.datosLista = datosLista;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_datos,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.eda.setText(datosLista.get(position).getEdad());
        holder.sex.setText(datosLista.get(position).getSexo());
        holder.puest.setText(datosLista.get(position).getPuesto());
        holder.antigueda.setText(datosLista.get(position).getAntiguedad());
    }

    @Override
    public int getItemCount() {
        return datosLista.size();
    }
}
