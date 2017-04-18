package clases;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Alvaro Muñoz
 */
public class Respuesta {


    private static int id_siguiente=1;
    /*
     * Atributos:
     *
     */
    protected int id;
    protected boolean no_contesta;
    protected Pregunta pregunta;

    public Respuesta() {
        this.setId();
        this.setNo_contesta(false);
    }
    public Respuesta(boolean no_contesta) {
        this.setId();
        this.setNo_contesta(no_contesta);
    }

    public Respuesta(Respuesta otro) {
        this.setId();
        this.pregunta = otro.pregunta;
        this.no_contesta = otro.no_contesta;

    }

    public Respuesta(Pregunta pregunta, boolean no_contesta) {
        this.setId();
        this.pregunta = pregunta;
        this.no_contesta = no_contesta;
    }

    public int getId() {
        return id;
    }

    public void setId() { this.id = id_siguiente++;}

    public boolean isNo_contesta() {
        return no_contesta;
    }

    public void setNo_contesta(boolean no_contesta) {
        this.no_contesta = no_contesta;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    /*
     * Se define la funcion distancia, getValor y set valor para  sobreescribirlas en cada subclase
     */
    public float distancia(Respuesta respuesta){return 0;}
    public Object getValor(){return null;}
    public void setValor(Object object){}

    public boolean getIsMultirespuesta(){
        R_Multiopcion r = new R_Multiopcion((R_Multiopcion) this);
        return (r.getPregunta().getMax_alternativas() == 1 ) ? false : true;

    }

    public void Calcular_Centroide(ArrayList<Encuesta_Respondida> muestra, int index_respuesta) {

        if (this instanceof R_Gradual) {
            R_Gradual r = (R_Gradual)this;
            r.Calcular_Centroide(muestra, index_respuesta);
        } else if (this instanceof R_Multiopcion) {
            R_Multiopcion r = (R_Multiopcion) this;
            r.Calcular_Centroide(muestra, index_respuesta);
        } else if (this instanceof R_Numerico) {
            R_Numerico r = (R_Numerico) this;
            r.Calcular_Centroide(muestra, index_respuesta);
        } else if (this instanceof R_Texto) {
            R_Texto r = (R_Texto) this;
            r.Calcular_Centroide(muestra, index_respuesta);
        }

    }

}
