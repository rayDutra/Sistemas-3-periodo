package Exercicio02;

public class Main {
    public static void main(String[] args) {
        Produto produto1 = new ProdutoConcreto("Produto 1", 100.0);
        Produto produto2 = new ProdutoConcreto("Produto 2", 50.0);

        Desconto descontoFixo = new DescontoFixo(10.0);
        Desconto descontoPercentual = new DescontoPercentual(20.0);

        CalculadoraDesconto calculadoraDesconto = new CalculadoraDesconto();

        // Aplicando desconto fixo
        double novoPreco1 = calculadoraDesconto.aplicarDesconto(produto1, descontoFixo);
        System.out.println("Novo preço do Produto 1 (Desconto Fixo): " + novoPreco1);

        // Aplicando desconto percentual
        double novoPreco2 = calculadoraDesconto.aplicarDesconto(produto2, descontoPercentual);
        System.out.println("Novo preço do Produto 2 (Desconto Percentual): " + novoPreco2);
    }
}