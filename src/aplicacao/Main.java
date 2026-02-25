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
    listaSimples.removerElemento("Batata");
    listaSimples.buscarElemento("Óleo");
    listaSimples.removerElemento("Óleo");
    listaSimples.buscarElemento("Óleo");
    listaSimples.buscarElemento("Arroz");
    listaSimples.exibirElementos();
    System.out.println("----------------------------------------------------------");
    ListaDinamica listaDinamica = new ListaDinamica();
    listaDinamica.adicionarElemento("Arroz");
    listaDinamica.adicionarElemento("Feijão");
    listaDinamica.adicionarElemento("Batata");
    listaDinamica.adicionarElemento("Alho");
    listaDinamica.adicionarElemento("Cebola");
    listaDinamica.removerElemento("Banana");
    listaDinamica.removerElemento("Arroz");
    listaDinamica.exibir();
    listaDinamica.contar();
}
