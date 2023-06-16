package Exercicio01;

public class Pagamento {
    private CarrinhoCompras carrinho;
    private boolean pago;

    public Pagamento(CarrinhoCompras carrinho) {
        this.carrinho = carrinho;
        this.pago = false;
    }

    public void processaPagamento() {
        // Lógica para processar o pagamento

        // Após o processamento bem-sucedido
        pago = true;
    }

    public boolean isPago() {
        return pago;
    }
}

