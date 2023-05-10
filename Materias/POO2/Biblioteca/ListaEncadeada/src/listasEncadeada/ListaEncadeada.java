package listasEncadeada;

public interface ListaEncadeada<T> {
    void adicionar(T valor);
    No<T> remover(T valor);
    void imprimir();
}