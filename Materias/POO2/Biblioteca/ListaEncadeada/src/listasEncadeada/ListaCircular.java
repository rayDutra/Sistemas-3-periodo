package listasEncadeada;

public class ListaCircular<T> implements ListaEncadeada<T> {
    private No<T> primeiro;
    private No<T> ultimo;

    public ListaCircular() {
        this.primeiro = null;
        this.ultimo = null;
    }

    public void adicionar(T valor) {
        No<T> novoNo = new No<T>(valor);

        if (primeiro == null) {
            primeiro = novoNo;
            ultimo = novoNo;
            ultimo.setProximo(primeiro);
        } else {
            ultimo.setProximo(novoNo);
            novoNo.setProximo(primeiro);
            ultimo = novoNo;
        }
    }

    public No<T> remover(T valor) {
        No<T> noAnterior = null;
        No<T> noAtual = primeiro;

        do {
            if (noAtual == null) {
                return null;
            } else if (noAtual.getValor().equals(valor)) {
                if (noAtual == primeiro) {
                    primeiro = noAtual.getProximo();
                    ultimo.setProximo(primeiro);
                } else if (noAtual == ultimo) {
                    ultimo = noAnterior;
                    ultimo.setProximo(primeiro);
                } else {
                    noAnterior.setProximo(noAtual.getProximo());
                }

                return noAtual;
            }

            noAnterior = noAtual;
            noAtual = noAtual.getProximo();
        } while (noAtual != primeiro);

        return null;
    }
    public void imprimir() {
        No<T> noAtual = primeiro;

        if (noAtual != null) {
            do {
                System.out.print(noAtual.getValor() + " ");
                noAtual = noAtual.getProximo();
            } while (noAtual != primeiro);
        }

        System.out.println();
    }
}
