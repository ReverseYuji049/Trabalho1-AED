package entidades;

public class ListaSimples implements ListaOperacoes {
    public String[] lista;

    public ListaSimples(int tamanho) {
        this.lista = new String[tamanho];
        System.out.println("Operação realizada com sucesso! Existem " + tamanho + " posições disponíveis.");
    }
    public void adicionarElemento(String elemento) {
        if (elemento == null) {
            System.out.println("Não é possível adicionar elemento nulo.");
            return;
        }
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
        //verifica lista vazia
        if (estaVazio()) {
            System.out.println("Não há elementos a serem removidos.");
            return;
        }
        boolean removido = false;
        //percorre a lista
        for (int i = 0; i < lista.length; i++) {
            //verifica se o elemento existe antes de comparar
            if (this.lista[i] != null && this.lista[i].equals(elemento)) {
                this.lista[i] = null;
                removido = true;
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
        //verifica lista vazia
        if (estaVazio()) {
            System.out.println("Não há elementos a serem procurados.");
            return;
        }
        //percorre a lista
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null && lista[i].equals(elemento)) { //verifica se o elemento não é nulo e se existe
                System.out.println("O elemento " + elemento + " existe na lista.");
                return;
            }
        }
        System.out.println("O elemento " + elemento + " não existe na lista.");
    }

    //Júlio
    @Override
    public int removerTodas(String elemento) {
        if (estaVazio()) {
            System.out.println("A lista está vazia.");
            return 0;
        }
        int qtd = 0;
        for(int i = 0; i < this.lista.length; i++){
            if(this.lista[i] != null && this.lista[i].equals(elemento)){
                this.lista[i] = null;
                qtd++;
            }
        }
        System.out.println("O elemento " + elemento + " foi apagado " + qtd + " vezes na lista.");
        return qtd;
    }

    //Yuji
    @Override
    public int contar() {
        int quantidade = 0;
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null) {
                quantidade++;
            }
        }
        System.out.println("A lista possui " + quantidade + " elementos.");
        return quantidade;
    }

    //Júlio
    @Override
    public int adicionarVarios(String[] elementos) {
        int contador = 0;
        for(int i = 0; i < elementos.length; i++){
            if(!this.estaCheio()) {
                this.adicionarElemento(elementos[i]);
                contador++;
            } else {
                break;
            }
        }
        System.out.println(contador + " Elementos foram adicionados.");
        return contador;
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
        //verifica lista vazia
        if (estaVazio()) {
            return "Não há elementos a serem removidos.";
        }
        //verifica se o índice é válido
        if (indice < 0 || indice >= lista.length) {
            return "Índice inválido.";
        }
        //se não houver elemento na posição
        if (lista[indice] == null) {
            return "Não existe elemento neste índice.";
        }
        //guarda o elemento removido
        String removido = lista[indice];
        //desloca os elementos para a esquerda
        for (int i = indice; i < lista.length - 1; i++) {
            lista[i] = lista[i + 1];
        }
        //limpa a última posição
        lista[lista.length - 1] = null;

        return "Elemento '" + removido + "' removido do índice " + indice;
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
        int ultimoIndice = -1;
        String comparador = elemento.trim().toLowerCase();
        if (contarOcorrencias(elemento) == 0) {
            System.out.println("Não existe "+elemento+" na lista");
            return ultimoIndice;
        } else {
            for (int i = 0; i<this.lista.length; i++) {
                if (this.lista[i] != null && comparador.equals(this.lista[i].trim().toLowerCase())) {
                    ultimoIndice = i;
                }
            }
            return ultimoIndice;
        }
    }

    //Júlio
    @Override
    public int contarOcorrencias(String elemento) {
        if(elemento == null){
            return 0;
        }
        if(estaVazio()) {
            System.out.println("Não há elementos na lista.");
            return 0;
        }
        int ocorrencias = 0;
        for (int i = 0; i < this.lista.length; i++) {
            if (this.lista[i] != null && this.lista[i].equals(elemento)) {
                ocorrencias++;

            }
        }
        if(ocorrencias == 0){
            System.out.println("O elemento " + elemento + " não foi encontrado.");
        }
        return ocorrencias;
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
