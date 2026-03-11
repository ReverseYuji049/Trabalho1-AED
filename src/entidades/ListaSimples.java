package entidades;

public class ListaSimples implements ListaOperacoes {
    public String[] lista;

    public ListaSimples(int tamanho) {
        this.lista = new String[tamanho];
        System.out.println("Operação realizada com sucesso! Existem " + tamanho + " posições disponíveis.");
    }
    public void adicionarElemento(String elemento) {
        if (!this.estaCheio()) {
            lista[encontrarPosicao()] = elemento;
        }
    }
    public boolean estaCheio() {
        for (int i = 0; i < lista.length; i++) {
            if (this.lista[i] == null) {
                return false;
            }
        }
        System.out.println("Não há espaço disponível na lista.");
        return true;
    }
    private int encontrarPosicao() {
        int i;
        for (i = 0; i < lista.length; i++) {
            if (this.lista[i] == null) {
                break;
            }
        }
        return i;
    }
    public void exibirElementos() {
        for (int i = 0; i < lista.length; i++) {
            System.out.println("Lista [" + i + "] = " + this.lista[i]);
        }
    }
    public void removerElemento(String elemento) {
        boolean removido = false;
        if (!estaVazio()) {
            for (int i = 0; i < lista.length; i++) {
                if (this.lista[i] != null && this.lista[i].equals(elemento)) {
                    this.lista[i] = null;
                    removido = true;
                }
            }
        }
        if (removido) {
            System.out.println("O elemento " + elemento + " foi removido com sucesso!");
        } else {
            System.out.println("O elemento " + elemento + " não existe na lista.");
        }
    }
    public boolean estaVazio() {
        for (int i = 0; i < lista.length; i++) {
            if (this.lista[i] != null) {
                return false;
            }
        }
        return true;
    }
    public void buscarElemento(String elemento) {
        boolean encontrado = false;
        if (!estaVazio()) {
            for (int i = 0; i < lista.length; i++) {
                if (this.lista[i] != null && this.lista[i].equals(elemento)) {
                    encontrado = true;
                }
            }
        }
        if (encontrado) {
            System.out.println("O elemento " + elemento + " existe na lista.");
        } else {
            System.out.println("O elemento " + elemento + " não existe na lista.");
        }
    }

    //Júlio
    @Override
    public int removerTodas(String elemento) {
        return 0;
    }

    //Yuji
    @Override
    public int contar() {
        int quantidade = 0;
        for (int i = 0; i < lista.length; i++) {
            quantidade++;
        }
        return quantidade;
    }

    //Guilherme
    @Override
    public int adicionarVarios(String[] elementos) {
        return 0;
    }

    //Yuji
    @Override
    public String obter(int indice) {
        if (indice < 0 || indice >= lista.length) {
            System.out.println("Índice inválido");
            return null;
        }
        return lista[indice];
    }

    //Eduardo
    @Override
    public boolean inserir(int indice, String elemento) {

        if (indice < 0 || indice >= lista.length) { //validar se o índice é válido
            System.out.println("Índice inválido");
            return false;
        } else if (estaCheio()){ // validar se há espaço na lista
            System.out.println("Não há espaço disponível na lista.");
            return false;
        }

        // busca o slot livre mais próximo à direita do índice
        int livreADireita = -1;
        for (int i = indice; i < lista.length; i++) {
            if (lista[i] == null) {
                livreADireita = i;
                break;
            }
        }

        if (livreADireita != -1) {
            // desloca para a direita até o slot livre
            for (int j = livreADireita; j > indice; j--) {
                lista[j] = lista[j - 1];
            }
        } else {
            // slot livre está à esquerda, então desloca para a esquerda
            int livreAEsquerda = -1;
            for (int i = indice - 1; i >= 0; i--) {
                if (lista[i] == null) {
                    livreAEsquerda = i;
                    break;
                }
            }
            for (int j = livreAEsquerda; j < indice - 1; j++) {
                lista[j] = lista[j + 1];
            }
            indice = indice - 1;
        }
        lista[indice] = elemento;

        System.out.println("Operação realizada com sucesso! O elemento " + elemento + " foi inserido na posição " + indice);
        return true;
    }

    //Yuji
    @Override
    public String removerPorIndice(int indice) {
        String removido = "";
        if (indice < 0 || indice >= lista.length) {
            return "Índice inválido.";
        } else {
            removido = lista[indice]; //guarda o elemento a ser removido
            for (int i = indice; i < lista.length - 1; i++) { //percorre a lista até o último elemento
                lista[i] = lista[i + 1]; //desloca a lista à direita
            }
            lista[lista.length - 1] = null; //remove o último elemento

            return removido; //retorna o elemento removido
        }
    }
    //Eduardo
    @Override
    public void limpar() {
    lista = new String[lista.length];
        System.out.println("A lista foi limpa com sucesso!");
    }

    //Guilherme
    @Override
    public int ultimoIndiceDe(String elemento) {
        return 0;
    }

    //Júlio
    @Override
    public int contarOcorrencias(String elemento) {
        return 0;
    }

    //Eduardo
    @Override
    public int substituir(String antigo, String novo) {
        int quantidade = 0;
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null && lista[i].equals(antigo)){
                lista[i] = novo;
                quantidade++;
            }
        }
        System.out.println("Operação realizada com sucesso! " + quantidade + " ocorrências do elemento " + antigo + " foram substituídas por " + novo);
        return quantidade;
    }
}
