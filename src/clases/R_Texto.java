package clases;

/**
 * Created by Alvaro Muñoz.
 */
public class R_Texto extends Respuesta {

    private String valor;

    public R_Texto(Pregunta pregunta, boolean no_sabe, boolean no_contesta, String valor) {
        super(pregunta, no_sabe, no_contesta);
        this.valor = valor;
    }

    public String getValor() {return valor;}
    public void setValor(String valor) {this.valor = valor;}

    @Override
    public float distancia(Respuesta respuesta) {
        return super.distancia(respuesta);
    }
}
