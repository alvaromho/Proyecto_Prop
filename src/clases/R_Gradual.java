package clases;

/**
 * Created by Alvaro Muñoz.
 */
public class R_Gradual extends Respuesta{

    private int valor;

    public R_Gradual(Pregunta pregunta, boolean no_sabe, boolean no_contesta, int valor) {
        super(pregunta, no_sabe, no_contesta);
        this.valor = valor;
    }

    public int getValor() {return valor;}
    public void setValor(int valor) {this.valor = valor;}

    @Override
    public float distancia(Respuesta respuesta) {
        return super.distancia(respuesta);
    }
}
