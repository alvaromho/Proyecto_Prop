package com.company;

/**
 *
 */
public class Centroide {


    // Atributos
    private int id_centroide;
    public float[] vector_centroide;
    private Encuesta_Respondida representante;


    public Centroide(int id_centroide, float[] vector_centroide, Encuesta_Respondida representante) {
        this.id_centroide = id_centroide;
        this.vector_centroide = vector_centroide;
        this.representante = representante;
    }

    public int getId_centroide() {
        return id_centroide;
    }

    public void setId_centroide(int id_centroide) {
        this.id_centroide = id_centroide;
    }

    public float[] getVector_centroide() {
        return vector_centroide;
    }

    public void setVector_centroide(float[] vector_centroide) {
        this.vector_centroide = vector_centroide;
    }

    public Encuesta_Respondida getRepresentante() {
        return representante;
    }

    public void setRepresentante(Encuesta_Respondida representante) {
        this.representante = representante;
    }
}