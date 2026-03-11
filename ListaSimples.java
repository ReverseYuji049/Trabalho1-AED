package entidades;

public class ListaSimples implements ListaOperacoes {
    String [] lista;
    public ListaSimples(int tamanho) {
        this.lista = new String[tamanho];
        System.out.println("Lista criada com sucesso! Existem " + tamanho + " posições disponíveis.");
    }

    public void adicionarElemento(String elemento) {
        if(!this.estaCheia()) {
            this.lista[encontrarPosicao()] = elemento;
            System.out.println("Elemento " + elemento + " adicionado com sucesso!");
        }
    }

    public boolean estaCheia() {
        for (int i = 0; i < this.lista.length; i++) {
            if(this.lista[i] == null) {
                return false;
            }
        }
        System.out.println("Não há espaço disponível na lista.");
        return true;
    }

    public boolean estaVazia() {
        for (int i = 0; i < this.lista.length; i++) {
            if(this.lista[i] != null) {
                return false;
            }
        }
        return true;
    }

    private int encontrarPosicao() {
        int i;
        for (i = 0; i < this.lista.length; i++) {
            if(this.lista[i] == null) {
               break;
            }
        }
        return i;
    }

    public void exibirElementos() {
        for (int i = 0; i < this.lista.length; i++) {
            System.out.println("Lista[" + i + "] = " + this.lista[i]);
        }
    }

    public void removerElemento(String elemento) {
        boolean removido = false;
        if(!estaVazia()) {
            for (int i = 0; i < this.lista.length; i++) {
                if(this.lista[i] != null && this.lista[i].equals(elemento)) {
                    this.lista[i] = null;
                    removido = true;
                }
            }
        }
        if(removido) {
            System.out.println("O elemento " + elemento + " foi removido com sucesso!");
        } else {
            System.out.println("O elemento " + elemento + " não existe na lista.");
        }
    }

    public void buscarElemento(String elemento) {
        boolean encontrado = false;
        if(!estaVazia()) {
            for (int i = 0; i < this.lista.length; i++) {
                if(this.lista[i] != null && this.lista[i].equals(elemento)) {
                    encontrado = true;
                }
            }
        }
        if(encontrado) {
            System.out.println("O elemento " + elemento + " existe na lista!");
        } else {
            System.out.println("O elemento " + elemento + " não existe na lista.");
        }
    }

    public int contarOcorrencias(String elemento){
        if(elemento == null){
            return 0;
        }
        if(estaVazia()) {
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

    public int removerTodas(String elemento) {
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

    public int adicionarVarios(String[] elementos) {
        int contador = 0;
        for(int i = 0; i < elementos.length; i++){
            if(!this.estaCheia()) {
                this.adicionarElemento(elementos[i]);
                contador++;
            }else{
                break;
            }
        }
        System.out.println(contador + " Elementos foram adicionados.");
       return contador;
    }

}
