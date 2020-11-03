package com.example.myapplication.Common;

import com.example.myapplication.Cuestiones.CurrentPreguntas;
import com.example.myapplication.Cuestiones.Preguntas;
import com.example.myapplication.Temas.Tematicas;

import java.util.ArrayList;
import java.util.List;

public class Comun {
    public static final int TOTAL_TIME = 20*60*1000;
    public static Tematicas selectTematica=new Tematicas();
    public static List<Preguntas> listaPreguntas=new ArrayList<>();
    public static List<CurrentPreguntas>listPreguntas=new ArrayList<>();
    public enum ANSWER_TYPE{
        NO_ANSWER,WRONG_ANSWER,RIGHT_ANSWER
    }
}
