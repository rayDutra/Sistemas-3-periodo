package Exercicio02;

class DescontoPercentual extends Desconto {
    private double percentual;

    public DescontoPercentual(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double calcularDesconto(double preco) {
        double valorDesconto = preco * (percentual / 100.0);
        return preco - valorDesconto;
    }
}