package entities;

public class ListaCircular {

    private No inicial;
    private No aux;
    private int contador;

    public boolean ListaVazia() {
        return contador == 0;
    }    

    public void add(String informacao){
        if(inicial == null){
            No novoNo = new No(informacao);
            novoNo.setAnterior(novoNo);
            novoNo.setProximo(novoNo);  
            inicial = novoNo;
            aux = novoNo;
            contador++;
        } else{
            No novoNo = new No(informacao);
            novoNo.setAnterior(aux);
            aux.setProximo(novoNo);
            novoNo.setProximo(inicial);
            inicial.setAnterior(novoNo);
            aux = novoNo;
            contador++;
        }
    }

    public void remover(int posicao){
        No inicio; 
        No auxiliar;
        inicio = inicial;
        auxiliar = inicio;
        if(ListaVazia()){
            System.out.println("Lista vazia.");;
        }else if(posicao == 1){
            inicial = inicio.getProximo();
            inicio.getProximo().setAnterior(inicio.getAnterior());
            inicio.getAnterior().setProximo(inicio.getProximo());
            inicio.setAnterior(null);
            inicio.setProximo(null);
        }else {
            for(int i = 1; i < posicao; i++){
                auxiliar = inicio;
                inicio = inicio.getProximo();
            }

                inicio.setAnterior(null);
                auxiliar.setProximo(inicio.getProximo());
                inicio.getProximo().setAnterior(auxiliar);
                inicio.setProximo(null);
                inicio = null;
        } 
    }

    public void imprimir(){
        No auxiliar = inicial;
        if(contador == 0){
            System.out.println("Lista vazia");
        } else{
            for(int i = 0; i < contador; i++){
                System.out.println(auxiliar.getInformacao());
                auxiliar = auxiliar.getProximo();
            }
        }
    }


    public String buscarElemento(int posicao){

        No inico = inicial;
        No auxiliar = null;
        int contar = 0;

        if (ListaVazia()) {
            return "Lista vazia!";
        }
        do{
            auxiliar = inico;
            inico = inico.getProximo();
            contar++;
        }while(contar <= posicao);
            if(contar == posicao){
                return auxiliar.getInformacao();
            } else{
                return "Não possui a posição informada!";
            }
    }
}
