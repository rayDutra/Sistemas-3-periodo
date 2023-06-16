package Exercicio04;

public class ProdutoTransferenciaBancaria extends Produto {
    public ProdutoTransferenciaBancaria(String descricao, double preco) {
        super(descricao, preco);
    }

    @Override
    public String formaPagamento() {
        return "Transferência Bancária";
    }
}
