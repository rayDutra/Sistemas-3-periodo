package Exercicio02;

class DescontoFixo extends Desconto {
    private double valorFixo;

    public DescontoFixo(double valorFixo) {
        this.valorFixo = valorFixo;
    }

    @Override
    public double calcularDesconto(double preco) {
        return preco - valorFixo;
    }
}