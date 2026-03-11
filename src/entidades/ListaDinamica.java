package entidades;

public class ListaDinamica implements ListaOperacoes {
    No inicio;

    public ListaDinamica() {
        this.inicio = new No(null);
        System.out.println("Lista dinâmica criada com sucesso!");
    }

    public void adicionarElemento(String elemento) {
        if (this.inicio.getConteudo() == null) {
            this.inicio.setConteudo(elemento);

        } else {
            No aux = this.inicio;
            No novoNo = new No(elemento);

            while (aux.getProx() != null) {
                aux = aux.getProx();
            }

            aux.setProx(novoNo);
        }
    }

    public void exibir() {
        if (inicioVazio()) {
            System.out.println("Não existem elementos na lista dinâmica.");
        } else {
            No aux = this.inicio;

            while (aux != null) {
                System.out.println(aux.getConteudo());
                aux = aux.getProx();
            }
        }
    }

    private boolean inicioVazio() {
        if (this.inicio.getConteudo() == null) {
            return true;
        } else {
            return false;
        }
    }

    public void removerElemento(String elemento) {
        //verifica lista vazia
        if (inicioVazio()) {
            System.out.println("Não existem elementos a serem removidos.");
            return;
        }

        //caso o primeiro elemento seja removido
        if (this.inicio.getConteudo().equals(elemento)) {
            this.inicio = this.inicio.getProx(); //o início muda

            //se a lista estiver, recria o nó padrão
            if (this.inicio == null) {
                this.inicio = new No(null); //início nulo
            }
            System.out.println("Elemento " + elemento + " removido!");
            return;
        }
        No aux = this.inicio;
        while (aux.getProx() != null) { //garante que existe um nó próximo antes de acessar
            if (aux.getProx().getConteudo().equals(elemento)) { //percorre a lista e verifica o nó
                aux.setProx(aux.getProx().getProx()); //remove o nó
                System.out.println("Elemento " + elemento + " removido! ");
                return;
            }
            aux = aux.getProx(); //avança a lista
        }
        System.out.println("Elemento não encontrado.");
    }

    public boolean procurarElemento(String elemento) {
        if (inicioVazio()) {
            System.out.println("Não existem elementos a serem procurados.");
        }
        No aux = this.inicio;
        while (aux != null) {
            if (aux.getConteudo() != null && aux.getConteudo().equals(elemento)) {
                System.out.println("Elemento " + elemento + " encontrado.");
                return true;
            }
            aux = aux.getProx();
        }
        System.out.println("Elemento não existe na lista.");

        return false;
    }

    //Júlio
    @Override
    public int removerTodas(String elemento) {
        int contador = 0;

        //verifica inicio vazio
        if (inicioVazio()) {
            System.out.println("Não há elementos a serem removidos.");
            return 0;
        }

        //remove ocorrências no início da lista
        while (this.inicio != null && this.inicio.getConteudo() != null && this.inicio.getConteudo().equals(elemento)) {
            this.inicio = this.inicio.getProx(); //avança o início
            contador++;
        }
        //se todos os elementos foram removidos
        if (this.inicio == null) {
            this.inicio = new No(null); // recria nó padrão da lista
            System.out.println("O elemento " + elemento + " foi removido " + contador + " vezes da lista.");
            return contador;
        }
        //percorre a lista removendo ocorrências no meio ou fim
        No aux = this.inicio;

        while (aux != null && aux.getProx() != null) {
            if (aux.getProx().getConteudo() != null && aux.getProx().getConteudo().equals(elemento)) {
                aux.setProx(aux.getProx().getProx()); //remove o nó
                contador++;
            } else {
                aux = aux.getProx(); //avança na lista
            }
        }
        System.out.println("O elemento " + elemento + " Foi removido " + contador + " vezes da lista.");
        return contador;
    }

    //Yuji
    @Override
    public int contar() {
        if (inicioVazio()) {
            System.out.println("A lista possui 0 elementos.");
            return 0;
        }
        int quantidade = 0;
        No aux = this.inicio;

        while (aux != null) {
            quantidade++;
            aux = aux.getProx();
        }
        System.out.println("A lista possui " + quantidade + " elementos.");

        return quantidade;
    }

    //Guilherme
    @Override
    public int adicionarVarios(String[] elementos) {
        int adicionados = 0;
        if (inicioVazio()) {
            this.inicio = new No(elementos[0]);
            adicionados = 1;
            No aux = this.inicio;
            for (int i = 1; i < elementos.length; i++) {
                No novoNo = new No(elementos[i]);
                aux.setProx(novoNo);
                aux = aux.getProx();
                adicionados++;
            }
        } else {
            No aux = this.inicio;
            while (aux.getProx() != null) {
                aux = aux.getProx();
            }
            for (int i = 0; i < elementos.length; i++) {
                No novoNo = new No(elementos[i]);
                aux.setProx(novoNo);
                aux = aux.getProx();
                adicionados++;
            }
        }
        System.out.println("Parabéns, os " + adicionados + " itens foram adicionados");
        return adicionados;
    }

    //Yuji
    @Override
    public String obter(int indice) {
        //verifica a lista vazia
        if (inicioVazio()) {
            return "A lista está vazia.";
        }
        //verifica índice negativo
        if (indice < 0) {
            return "Índice inválido.";
        }
        No aux = this.inicio;
        for (int i = 0; i < indice; i++) {
            //se chegar ao final antes do índice
            if (aux.getProx() == null) {
                return "Índice fora do alcance da lista.";
            }
            aux = aux.getProx();
        }
        return "O elemento '" + aux.getConteudo() + "' está no índice " + indice + ".";
    }

    //Eduardo
    @Override
    public boolean inserir(int indice, String elemento) {
        if (indice < 0) {
            System.out.println("Índice inválido.");
            return false;
        }

        No novoNo = new No(elemento);

        if (indice == 0) {
            if (inicioVazio()) {
                this.inicio.setConteudo(elemento);
            } else {
                novoNo.setProx(this.inicio);
                this.inicio = novoNo;
            }
        } else {
            No aux = this.inicio;
            for (int i = 0; i < indice - 1; i++) { // isso garante que não haverá um nullpointerexception
                if (aux.getProx() == null) {
                    System.out.println("Índice fora do alcance.");
                    return false;
                }
                aux = aux.getProx();
            }
            novoNo.setProx(aux.getProx()); //novoNo aponta para quem estava no indice, aux aponta para novoNo
            aux.setProx(novoNo);
        }
        System.out.println("Elemento '" + elemento + "' inserido no índice " + indice + ".");
        return true;
    }

    //Yuji
    @Override
    public String removerPorIndice(int indice) {
        //verificação da lista vazia
        if (inicioVazio()) {
            return "A lista está vazia, não é possível remover o elemento.";
        }
        //verificação do índice negativo
        if (indice < 0) {
            System.out.println("Índice inválido.");
            return null;
        }
        String removido = "";
        //remove o primeiro elemento
        if (indice == 0) {
            removido = this.inicio.getConteudo();
            this.inicio = this.inicio.getProx();

            if (this.inicio == null) {
                this.inicio = new No(null);
                // mantém o padrão da lista
            }
            return "Elemento '" + removido + "' removido do índice 0.";
        }
        No aux = this.inicio; //variável que percorre a lista
        for (int i = 0; i < indice - 1; i++) { //percorre até o nó anterior do removido
            if (aux.getProx() == null) { //verifica se o índice é maior que o tamanho da lista
                return "Índice fora do alcance da lista.";
            }
            aux = aux.getProx();
        }

        if (aux.getProx() == null) { //verifica se existe o elemento
            return "Índice fora do alcance da lista.";
        }

        removido = aux.getProx().getConteudo(); //guarda o elemento a ser removido
        aux.setProx(aux.getProx().getProx()); //remove o elemento

        return "Elemento '" + removido + "' removido do índice " + indice + ".";
    }

    //Eduardo
    @Override
    public void limpar() {
        this.inicio = new No(null);
        System.out.println("Lista limpa com sucesso!");
    }

    //Guilherme
    @Override
    public int ultimoIndiceDe(String elemento) {
        No aux = this.inicio;
        if (elemento == null) {
            return -1;
        }
        String comparador = elemento.toLowerCase().trim();
        int ultimoIndice = -1;
        int indice = 0;
        if (inicioVazio()) {
            System.out.println("Não existe elementos na Lista (Lista vazia)");
            return ultimoIndice;
        } else if (contarOcorrencias(elemento) == 0) {
            return ultimoIndice;
        } else {
            do {
                if (aux.getConteudo() != null &&
                        aux.getConteudo().trim().toLowerCase().equals(comparador)) {
                    ultimoIndice = indice;
                }
                indice++;
                aux = aux.getProx();
            } while (aux != null);
            return ultimoIndice;
        }
    }

    //Guilherme
    @Override
    public int contarOcorrencias(String elemento) {
        No aux = this.inicio;
        if (elemento == null) {
            return 0;
        }
        String comparador = elemento.trim().toLowerCase();
        int contador = 0;
        if (inicioVazio()) {
            System.out.println("Não há elementos na lista para contar sua ocorrência");
            return 0;
        } else {
            while (aux != null) {
                if (aux.getConteudo() != null && aux.getConteudo().trim().toLowerCase().equals(comparador)) {
                    contador++;
                }
                aux = aux.getProx();
            }
            if (contador == 0) {
                System.out.println("O elemento " + elemento + " não existe na lista");
            }
            return contador;
        }
    }
    //Eduardo
    @Override
    public int substituir (String antigo, String novo){
        if (antigo == null || novo == null) {
            System.out.println("Não é possível substituir valores nulos.");
            return 0;
        }

        int quantidade = 0;

        No aux = this.inicio;
        while (aux != null) {
            if (aux.getConteudo() != null && aux.getConteudo().equals(antigo)) {
                aux.setConteudo(novo);
                quantidade++;
            }
            aux = aux.getProx();
        }

        System.out.println("Operação realizada com sucesso! " + quantidade +
                " ocorrências do elemento " + antigo + " foram substituídas por " + novo);
        return quantidade;
    }
}
