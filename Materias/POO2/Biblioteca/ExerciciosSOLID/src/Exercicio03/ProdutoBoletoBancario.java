package Exercicio03;
public class ProdutoBoletoBancario extends Produto {
    public ProdutoBoletoBancario(String descricao, double preco) {
        super(descricao, preco);
    }

    @Override
    public String formaPagamento() {
        return "Boleto Bancário";
    }
}