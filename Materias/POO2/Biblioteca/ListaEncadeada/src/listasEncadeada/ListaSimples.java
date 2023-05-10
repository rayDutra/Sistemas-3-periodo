package listasEncadeada;

public class ListaSimples<T> implements ListaEncadeada<T> {
    private No<T> primeiro;
    private No<T> ultimo;

    public ListaSimples() {
        this.primeiro = null;
        this.ultimo = null;
    }

    public void adicionar(T valor) {
        No<T> novoNo = new No<T>(valor);

        if (primeiro == null) {
            primeiro = novoNo;
            ultimo = novoNo;
        } else {
            ultimo.setProximo(novoNo);
            ultimo = novoNo;
        }
    }

    public No<T> remover(T valor) {
        No<T> noAnterior = null;
        No<T> noAtual = primeiro;

        while (noAtual != null && !noAtual.getValor().equals(valor)) {
            noAnterior = noAtual;
            noAtual = noAtual.getProximo();
        }

        if (noAtual == null) {
            return null;
        } else if (noAnterior == null) {
            primeiro = noAtual.getProximo();
            if (primeiro == null) {
                ultimo = null;
            }
        } else {
            noAnterior.setProximo(noAtual.getProximo());
            if (noAtual == ultimo) {
                ultimo = noAnterior;
            }
        }

        return noAtual;
    }

    public void imprimir() {
        No<T> noAtual = primeiro;

        while (noAtual != null) {
            System.out.print(noAtual.getValor() + " ");
            noAtual = noAtual.getProximo();
        }

        System.out.println();
    }
}

