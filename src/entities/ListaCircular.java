package entities;

public class ListaCircular {

    private No inicial;
    private No aux;
    private int contador;

    public No getInicial() {
        return inicial;
    }

    public void setInicial(No inicial) {
        this.inicial = inicial;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public boolean ListaVazia() {
        return contador == 0;
    }

    public void addPosicao(String informacao, int posicao) {
        No prox = inicial;
        No ant = null;
        if(contador == 0){
            No novoNo = new No(informacao);
            inicial = novoNo;
            aux = novoNo;
            contador++;
            novoNo.setIndice(contador);
        }else if(posicao == 1){
            No novoNo = new No(informacao);
            novoNo.setProximo(prox);
            prox.getAnterior().setProximo(novoNo);
            novoNo.setAnterior(prox.getAnterior());
            prox.setAnterior(novoNo);
            contador++; 
            atualizarIndicesAdicao();          
        }else  if(posicao > 1){
            for(int i = 1; i < posicao; i++){
                ant = prox;
                prox = prox.getProximo();
            }
            No novoNo = new No(informacao);
            novoNo.setProximo(prox);
            novoNo.setAnterior(ant);
            prox.setAnterior(novoNo);
            ant.setProximo(novoNo);
            contador++;
            atualizarIndicesAdicao();
        }
    }
    public void addUltimo(String informacao) {
        if(contador == 0){
            No novoNo = new No(informacao);
            inicial = novoNo;
            aux = novoNo;
            contador++;
            novoNo.setIndice(1);
        }else{
            No novoNo = new No(informacao);
            novoNo.setProximo(inicial);
            inicial.setAnterior(novoNo);
            aux.setProximo(novoNo);
            novoNo.setAnterior(aux);
            aux = novoNo;
            contador++;
            novoNo.setIndice(contador);
        }
    }


    public void remover(int posicao) {
        No pos;
        No auxiliar;
        pos = inicial;
        auxiliar = null;
        if (ListaVazia()) {
            System.out.println("Lista vazia.");
        }else if(posicao == 1){
            inicial = inicial.getProximo();
            pos.getProximo().setAnterior(pos.getAnterior());
            pos.getAnterior().setProximo(pos.getProximo());
            pos.setAnterior(null);
            pos.setProximo(null);
            pos = null;
            atualizarIndiceRemovido();
            contador--;

        } else{
            for(int i = 1; i < posicao; i++){
                auxiliar = pos;
                pos = pos.getProximo();
            }
            if(pos != null){
                auxiliar.setProximo(pos.getProximo());
                pos.getProximo().setAnterior(pos.getAnterior());
                pos.setAnterior(null);
                pos.setProximo(null);
                pos = null;
                atualizarIndiceRemovido();
                contador--;

            }
        }
    }

    public void imprimir() {
        No auxiliar = inicial;
        if (contador == 0) {
            System.out.println("Lista vazia");
        } else if (contador == 1) {
            System.out.println(contador + " - " + auxiliar.getInformacao());
        } else {
            for (int i = 0; i < contador; i++) {
                System.out.println((i + 1) + " - " + auxiliar.getInformacao() + " - Indice: " + auxiliar.getIndice());
                auxiliar = auxiliar.getProximo();
            }
        }

    }

    public String buscarElemento(int posicao) {

        No inico = inicial;
        No auxiliar = null;
        int contar = 1;

        if (ListaVazia()) {
            return "Lista vazia!";
        }
        do {
            auxiliar = inico;
            inico = inico.getProximo();
            if (contar == posicao) {
                return auxiliar.getInformacao();
            } 
            contar++;
        } while (contar <= posicao);
        return auxiliar.getInformacao();
    }

    private void atualizarIndicesAdicao() { 
        No aux = inicial;
        for (int i = 0; i <= contador; i++) {
            aux.getAnterior().setIndice(i);
            aux = aux.getProximo();
        }
    }

    private void atualizarIndiceRemovido() { 
        No aux = inicial;
        for (int i = 1; i <= contador; i++) {
            aux.getAnterior().setIndice(i - 1);
            aux = aux.getProximo();
        }
    }
}
