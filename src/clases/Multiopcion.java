package clases;
import java.util.*;

/**
 * 
 */
public class Multiopcion extends Pregunta {



    private ArrayList<String> enunciado_opcion;
    private int min_alternativas;
    private int max_alternativas;


    public Multiopcion(int id_pregunta, String enunciado, boolean no_sabe) {
        super(id_pregunta, enunciado, no_sabe);
    }

    public ArrayList<String> getEnunciado_opcion() {
        return enunciado_opcion;
    }

    public void setEnunciado_opcion(ArrayList<String> enunciado_opcion) {
        this.enunciado_opcion = enunciado_opcion;
    }

    public int getMin_alternativas() {
        return min_alternativas;
    }

    public void setMin_alternativas(int min_alternativas) {
        this.min_alternativas = min_alternativas;
    }

    public int getMax_alternativas() {
        return max_alternativas;
    }

    public void setMax_alternativas(int max_alternativas) {
        this.max_alternativas = max_alternativas;
    }
}