package entities;

public class No {
    private String informacao;
    private No proximo;
    private No anterior;
    private int indice;

    public No(){
    }

    public No(String informacao) {
        this.informacao = informacao;
        this.proximo = null;
        this.anterior = null;
    }

    public String getInformacao() {
        return informacao;
    }

    public void setInformacao(String informacao) {
        this.informacao = informacao;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public No getAnterior() {
        return anterior;
    }

    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
}