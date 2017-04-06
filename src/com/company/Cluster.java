package com.company;

import java.util.ArrayList;

/**
 * Created by alvaro-mac on 5/4/17.
 */
public class Cluster {

    //Atributos
    private int id_cluster;                                     // ID_KEY
    private String nombre;
    private ArrayList<Encuesta_Respondida> lista_respuestas;    //Lista de Encuestas respondidas asociadas al cluster
    private Centroide  centroide;                               //Centroide del Cluster



    // Constructor
    public Cluster(int id_cluster, String nombre, ArrayList<Encuesta_Respondida> lista_respuestas, Centroide centroide) {
        this.id_cluster = id_cluster;
        this.nombre = nombre;
        this.lista_respuestas = lista_respuestas;
        this.centroide = centroide;
    }

    public int getId_cluster() {
        return id_cluster;
    }

    public void setId_cluster(int id_cluster) {
        this.id_cluster = id_cluster;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Encuesta_Respondida> getLista_respuestas() {
        return lista_respuestas;
    }

    public void setLista_respuestas(ArrayList<Encuesta_Respondida> lista_respuestas) {
        this.lista_respuestas = lista_respuestas;
    }

    public Centroide getCentroide() {
        return centroide;
    }

    public void setCentroide(Centroide centroide) {
        this.centroide = centroide;
    }
}


