package com.example.myapplication.Temas;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Common.Comun;
import com.example.myapplication.QuestionAnswerActivity;
import com.example.myapplication.R;

import java.util.List;

public class TematicasAdapter extends RecyclerView.Adapter<TematicasAdapter.MyViewHolder> {
    Context context;
    List<Tematicas> tematicasList;

    public TematicasAdapter(Context context, List<Tematicas> tematicasList) {
        this.context = context;
        this.tematicasList = tematicasList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(context).inflate(R.layout.layout_tematica_item,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nombreTematica.setText(tematicasList.get(position).getNombreTematica());
    }

    @Override
    public int getItemCount() {
        return tematicasList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CardView card_tematica;
        TextView nombreTematica;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            card_tematica=(CardView)itemView.findViewById(R.id.card_tematica);
            nombreTematica=(TextView)itemView.findViewById(R.id.txt_nombreTematica);
            card_tematica.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Comun.selectTematica=tematicasList.get(getAdapterPosition());
                    Intent intent=new Intent(context, QuestionAnswerActivity.class);
                    context.startActivity(intent);
                }
            });


        }
    }
}
