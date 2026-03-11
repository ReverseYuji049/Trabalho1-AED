package aplicacao;

import entidades.ListaDinamica;
import entidades.ListaSimples;

public class Main {
    public static void main(String[] args) {
        ListaSimples listaSimples = new ListaSimples(8);

        listaSimples.adicionarElemento("Arroz");
        listaSimples.adicionarElemento("Feijão");
        listaSimples.adicionarElemento("Sabão em Pó");
        listaSimples.adicionarElemento("Papel Higiênico");
        listaSimples.adicionarElemento("Oleo");
        listaSimples.adicionarElemento("Arroz");
        listaSimples.adicionarElemento("Arroz");
        listaSimples.adicionarElemento("Arroz");
        listaSimples.buscarElemento("Óleo");
        listaSimples.removerElemento("Óleo");
        listaSimples.buscarElemento("Óleo");
        listaSimples.exibirElementos();
        listaSimples.contarOcorrencias("Arroz");
        listaSimples.removerTodas("Arroz");
        String[] compras = {"Arroz", "Feijão", "Sabão em pó"};
        listaSimples.adicionarVarios(compras);
        listaSimples.exibirElementos();
        System.out.println("----------------------------------");
        ListaDinamica listaDinamica = new ListaDinamica();
        listaDinamica.adicionarElemento("Arroz");
        listaDinamica.adicionarElemento("Feijão");
        listaDinamica.adicionarElemento("Batata");
        listaDinamica.adicionarElemento("Alho");
        listaDinamica.adicionarElemento("Cebola");
        listaDinamica.removerElemento("Alho");
        listaDinamica.exibir();
        listaDinamica.adicionarElemento("Arroz");
        listaDinamica.adicionarElemento("Arroz");
        listaDinamica.removerTodas("Arroz");
        listaDinamica.adicionarElemento("Cebola");
        listaDinamica.exibir();
    }
}
