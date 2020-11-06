package com.example.trivialix;
import android.provider.BaseColumns;
public final class QuizContract {
    private QuizContract() {
    }
    public static class TematicasTable implements BaseColumns {
        public static final String TABLATEMATICAS = "Tematicas";
        public static final String NOMBRETEMATICAS = "nombreTematicaw";
    }
    public static class PreguntasTable implements BaseColumns {
        public static final String TABLAPREGUNTAS = "Preguntas";
        public static final String ENUNCIADO = "enunciado";
        public static final String IMAGEN = "imagen";
        public static final String AUDIO = "audio";
        public static final String OPCIONA = "OpcionA";
        public static final String OPCIONB = "OpcionB";
        public static final String OPCIONC = "OpcionC";
        public static final String OPCIOND = "OpcionD";
        public static final String OPCIONCORRECTA = "OpcionCorrecta";
        public static final String TIENEIMAGENAUDIO = "TieneImagenAudio";
        public static final String IDTEMA = "id_tema";
    }
}