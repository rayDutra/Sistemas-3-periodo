package Exercicio02;

class CalculadoraDesconto {
    public double aplicarDesconto(Produto produto, Desconto desconto) {
        double precoOriginal = produto.getPreco();
        return desconto.calcularDesconto(precoOriginal);
    }
}
