package Exercicio04;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();

        // Criando instâncias de diferentes tipos de produtos
        ProdutoCartaoCredito produto1 = new ProdutoCartaoCredito("Produto 1", 100.0);
        ProdutoBoletoBancario produto2 = new ProdutoBoletoBancario("Produto 2", 50.0);
        ProdutoTransferenciaBancaria produto3 = new ProdutoTransferenciaBancaria("Produto 3", 75.0);

        // Adicionando os produtos à lista
        produtos.add(produto1);
        produtos.add(produto2);
        produtos.add(produto3);

        // Percorrendo a lista de produtos
        for (Produto produto : produtos) {
            // Imprimindo a descrição, o preço e a forma de pagamento
            System.out.println("Descrição: " + produto.getDescricao());
            System.out.println("Preço: " + produto.getPreco());
            System.out.println("Forma de Pagamento: " + produto.formaPagamento());
            System.out.println();
        }
    }
}
