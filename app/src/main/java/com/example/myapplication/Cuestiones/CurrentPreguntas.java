package com.example.myapplication.Cuestiones;

import com.example.myapplication.Common.Comun;

public class CurrentPreguntas {

    private int indexPreguntas;
    private Comun.ANSWER_TYPE type;

    public CurrentPreguntas(int indexPreguntas, Comun.ANSWER_TYPE type) {
        this.indexPreguntas = indexPreguntas;
        this.type = type;
    }

    public int getIndexPreguntas() {
        return indexPreguntas;
    }

    public void setIndexPreguntas(int indexPreguntas) {
        this.indexPreguntas = indexPreguntas;
    }

    public Comun.ANSWER_TYPE getType() {
        return type;
    }

    public void setType(Comun.ANSWER_TYPE type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CurrentPreguntas{" +
                "indexPreguntas=" + indexPreguntas +
                ", type=" + type +
                '}';
    }
}
