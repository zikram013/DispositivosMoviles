package com.example.myapplication.Cuestiones;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Common.Comun;
import com.example.myapplication.R;

import java.util.List;

public class PreguntasAdapter extends RecyclerView.Adapter<PreguntasAdapter.MyViewHolder> {
    Context context;
    List<CurrentPreguntas> listaPreguntas;

    public PreguntasAdapter(Context context, List<CurrentPreguntas> listaPreguntas) {
        this.context = context;
        this.listaPreguntas = listaPreguntas;
    }

    @NonNull
    @Override
    public PreguntasAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(context).inflate(R.layout.layout_grid_answer_sheet_item,parent,false);
       return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if(listaPreguntas.get(position).getType()== Comun.ANSWER_TYPE.RIGHT_ANSWER){
            holder.preguntaView.setBackgroundResource(R.drawable.grid_question_right_answer);
        }else if(listaPreguntas.get(position).getType()== Comun.ANSWER_TYPE.WRONG_ANSWER){
            holder.preguntaView.setBackgroundResource(R.drawable.grid_question_wrong_answer);
        }else{
            holder.preguntaView.setBackgroundResource(R.drawable.grid_question_no_answer);
        }
    }

    @Override
    public int getItemCount() {
        return listaPreguntas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        View preguntaView;
        public MyViewHolder(@NonNull View view){
            super(view);

            preguntaView=view.findViewById(R.id.question_item);
        }
    }
}
