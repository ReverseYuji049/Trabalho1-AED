import entidades.ListaDinamica;
import entidades.ListaSimples;

void main() {

    ListaSimples listaSimples = new ListaSimples(5);
    listaSimples.estaCheio();
    listaSimples.adicionarElemento("Arroz");
    listaSimples.adicionarElemento("Feijão");
    listaSimples.adicionarElemento("Sabão em Pó");
    listaSimples.adicionarElemento("Papel Higiênico");
    listaSimples.adicionarElemento("Óleo");
    listaSimples.exibirElementos();
    System.out.println(listaSimples.contar());
    listaSimples.obter(5);
    System.out.println(listaSimples.obter(2));
    listaSimples.removerElemento("Batata");
    listaSimples.buscarElemento("Óleo");
    listaSimples.removerElemento("Óleo");
    listaSimples.buscarElemento("Óleo");
    listaSimples.buscarElemento("Arroz");
    listaSimples.exibirElementos();
    listaSimples.removerPorIndice(2);
    listaSimples.exibirElementos();
    System.out.println("----------------------------------------------------------");
    ListaDinamica listaDinamica = new ListaDinamica();
    listaDinamica.adicionarElemento("Arroz");
    listaDinamica.adicionarElemento("Feijão");
    listaDinamica.adicionarElemento("Batata");
    listaDinamica.adicionarElemento("Alho");
    listaDinamica.adicionarElemento("Cebola");
    listaDinamica.removerElemento("Banana");
    listaDinamica.exibir();
    listaDinamica.contar();
    System.out.println(listaDinamica.obter(2));
    listaDinamica.removerPorIndice(2);
    listaDinamica.exibir();
}