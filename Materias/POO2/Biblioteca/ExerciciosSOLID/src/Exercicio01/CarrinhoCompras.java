package Exercicio01;

import java.util.HashMap;
import java.util.Map;

public class CarrinhoCompras {
    private Map<Produto, Integer> carrinho;

    public CarrinhoCompras() {
        carrinho = new HashMap<>();
    }

    public void addItem(Produto produto, int quantidade) {
        if (carrinho.containsKey(produto)) {
            int quantidadeAtual = carrinho.get(produto);
            carrinho.put(produto, quantidadeAtual + quantidade);
        } else {
            carrinho.put(produto, quantidade);
        }
    }

    public void removeItem(Produto produto, int quantidade) {
        if (carrinho.containsKey(produto)) {
            int quantidadeAtual = carrinho.get(produto);
            quantidadeAtual -= quantidade;

            if (quantidadeAtual <= 0) {
                carrinho.remove(produto);
            } else {
                carrinho.put(produto, quantidadeAtual);
            }
        }
    }

    public void calcularPrecoTotal() {
        double precoTotal = 0.0;

        for (Map.Entry<Produto, Integer> entry : carrinho.entrySet()) {
            Produto produto = entry.getKey();
            int quantidade = entry.getValue();
            double precoItem = produto.getPreco() * quantidade;
            precoTotal += precoItem;
        }

        System.out.println("Preço Total do Carrinho: R$" + precoTotal);
    }
}
