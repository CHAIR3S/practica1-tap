package models;

public class Problema {

    private String problema;

    private boolean tipo;


    public Problema(String problema, boolean tipo) {
        this.problema = problema;
        this.tipo = tipo;
    }

    public Problema() {
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }
}
