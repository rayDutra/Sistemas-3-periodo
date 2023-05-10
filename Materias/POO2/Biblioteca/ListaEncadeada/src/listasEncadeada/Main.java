package listasEncadeada;

public class Main {

	public static void main(String[] args) {
	    ListaEncadeada<String> listaSimples = new ListaSimples<>();
	    listaSimples.adicionar("Fernanda");
	    listaSimples.adicionar("Jorge");
	    listaSimples.adicionar("Carlor");
	    listaSimples.imprimir(); 
	    listaSimples.remover("Jorge");
	    listaSimples.imprimir(); 
	    ListaEncadeada<Integer> listaCircular = new ListaCircular<>();
	    listaCircular.adicionar(1);
	    listaCircular.adicionar(2);
	    listaCircular.adicionar(3);
	    listaCircular.imprimir(); 
	    listaCircular.remover(1);
	    listaCircular.imprimir(); 
	}


}
