package com.example.trivialix.Cuestiones;

public class Preguntas {
    private int idPregunta;
    private String enunciado;
    private String imagen;
    private String audio;
    private String opcionA,opcionB,opcionC,opcionD;
    private String opcionCorrecta;
    private int tieneImagenOAudio;
    private int id_tema;

    public Preguntas(int idPregunta, String enunciado, String imagen, String audio, String opcionA, String opcionB, String opcionC, String opcionD, String opcionCorrecta, int tieneImagenOAudio, int id_tema) {
        this.idPregunta = idPregunta;
        this.enunciado = enunciado;
        this.imagen = imagen;
        this.audio = audio;
        this.opcionA = opcionA;
        this.opcionB = opcionB;
        this.opcionC = opcionC;
        this.opcionD = opcionD;
        this.opcionCorrecta = opcionCorrecta;
        this.tieneImagenOAudio = tieneImagenOAudio;
        this.id_tema = id_tema;
    }

    public Preguntas(){

    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getOpcionA() {
        return opcionA;
    }

    public void setOpcionA(String opcionA) {
        this.opcionA = opcionA;
    }

    public String getOpcionB() {
        return opcionB;
    }

    public void setOpcionB(String opcionB) {
        this.opcionB = opcionB;
    }

    public String getOpcionC() {
        return opcionC;
    }

    public void setOpcionC(String opcionC) {
        this.opcionC = opcionC;
    }

    public String getOpcionD() {
        return opcionD;
    }

    public void setOpcionD(String opcionD) {
        this.opcionD = opcionD;
    }

    public String getOpcionCorrecta() {
        return opcionCorrecta;
    }

    public void setOpcionCorrecta(String opcionCorrecta) {
        this.opcionCorrecta = opcionCorrecta;
    }

    public int getTieneImagenOAudio() {
        return tieneImagenOAudio;
    }

    public void setTieneImagenOAudio(int tieneImagenOAudio) {
        this.tieneImagenOAudio = tieneImagenOAudio;
    }

    public int getId_tema() {
        return id_tema;
    }

    public void setId_tema(int id_tema) {
        this.id_tema = id_tema;
    }

    @Override
    public String toString() {
        return "Preguntas{" +
                "idPregunta=" + idPregunta +
                ", enunciado='" + enunciado + '\'' +
                ", imagen='" + imagen + '\'' +
                ", audio='" + audio + '\'' +
                ", opcionA='" + opcionA + '\'' +
                ", opcionB='" + opcionB + '\'' +
                ", opcionC='" + opcionC + '\'' +
                ", opcionD='" + opcionD + '\'' +
                ", opcionCorrecta='" + opcionCorrecta + '\'' +
                ", tieneImagenOAudio=" + tieneImagenOAudio +
                ", id_tema=" + id_tema +
                '}';
    }
}
