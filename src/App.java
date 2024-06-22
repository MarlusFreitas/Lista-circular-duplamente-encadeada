import java.util.Scanner;

import entities.ListaCircular;
import entities.No;

public class App {
    private static Scanner sc = new Scanner(System.in);
    private static ListaCircular list = new ListaCircular();
    public static void main(String[] args) throws Exception {
        

        int opcao;

        do{
            exibirMenu();
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    adicionarElemento();
                    break;
				case 2:
                    adicionarElementoPosicao();
                    break;
                case 3:
                    removerElemento();
                    break;    
                case 4:
                    buscarElemento();
                    break;
                case 5:
                    imprimirLista();
                    break; 
				case 6:
					insertionSort(list);
                    break; 
                case 0:
                    System.out.println("Saindo do sistema...");
                    break; 
                default:
                    System.out.println("Opção invalida!");
                    break;
            }

        } while(opcao != 0);

    }

    private static void exibirMenu(){
        System.out.println("-------- Menu --------");
        System.out.println("1 - Adicionar elemento: ");
		System.out.println("2 - Adicionar elemento na posicao: ");
        System.out.println("3 - Remover elemento: ");
        System.out.println("4 - Buscar elemento: ");
        System.out.println("5 - Imprimir lista.");
		System.out.println("6 - InsertionSort.");
        System.out.println("0 - Sair.");
        System.out.print("Digite a opção:");
    }

    private static void adicionarElemento(){
        System.out.print("Qual informação deseja adicionar: ");
        String informacao = sc.nextLine();
        list.addUltimo(informacao);
        System.out.println("Informação adicionada!");
    }

	private static void adicionarElementoPosicao(){
        System.out.print("Qual informação deseja adicionar: ");
        String informacao = sc.nextLine();
        System.out.print("Informe a posição que deseja adicionar a informação: ");
        int posicao = sc.nextInt();
        list.addPosicao(informacao, posicao);
        System.out.println("Informação adicionada!");
        sc.nextLine();
    }

    private static void removerElemento(){
        System.out.print("Informe o elemento a ser removido: ");
        int posicao = sc.nextInt();
        list.remover(posicao);
        System.out.println("Elemento removido");
        sc.nextLine();
    }

    private static void buscarElemento() {
        System.out.print("Informe a posição do elemento a ser buscado: ");
        int posicao = sc.nextInt();
    
        String elementoEncontrado = list.buscarElemento(posicao);
    
        if (elementoEncontrado != null) {
            System.out.println("Elemento encontrado: " + elementoEncontrado);
        } else {
            System.out.println("Elemento não encontrado na posição informada.");
        }
    
        sc.nextLine();
    }

    private static void imprimirLista(){
        if(list.ListaVazia()){
            System.out.println("Lista vazia!");
        } else{
            System.out.println("Lista: ");
            list.imprimir();
        }
    }

	private static void insertionSort(ListaCircular list) {
    No auxiliar = list.getInicial();

    if (auxiliar == null) {
        System.out.println("Vazia!");
    }

    while (auxiliar.getProximo() != list.getInicial()) {
        No atual = auxiliar.getProximo();
        String valorAtual = atual.getInformacao();
        No anterior = list.getInicial();

        while (anterior != null && anterior.getProximo().getInformacao().compareTo(valorAtual) > 0) {
            anterior = anterior.getProximo();
        }

        if (anterior == null || anterior.getProximo().getInformacao().compareTo(valorAtual) <= 0) {
            continue; 
        }

        
        list.remover(atual.getIndice()); 
        list.addPosicao(valorAtual, anterior.getProximo().getIndice());

        atual = anterior.getProximo();
    }
}
	
}
