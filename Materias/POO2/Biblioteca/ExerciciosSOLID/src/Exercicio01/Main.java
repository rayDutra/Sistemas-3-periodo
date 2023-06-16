package Exercicio01;

public class Main {
    public static void main(String[] args) {
        // Criando produtos
        Produto produto1 = new Produto("Produto 1", 10.0);
        Produto produto2 = new Produto("Produto 2", 20.0);
        Produto produto3 = new Produto("Produto 3", 15.0);

        // Criando carrinho de compras
        CarrinhoCompras carrinho = new CarrinhoCompras();

        // Adicionando produtos ao carrinho
        carrinho.addItem(produto1, 2);
        carrinho.addItem(produto2, 1);
        carrinho.addItem(produto3, 3);

        // Calculando o preço total
        carrinho.calcularPrecoTotal();

        // Processando o pagamento
        Pagamento pagamento = new Pagamento(carrinho);
        pagamento.processaPagamento();

        // Enviando o email de confirmação
        ConfirmacaoEmail confirmacaoEmail = new ConfirmacaoEmail(pagamento);
        confirmacaoEmail.enviarEmailConfirmacao();
    }
}
