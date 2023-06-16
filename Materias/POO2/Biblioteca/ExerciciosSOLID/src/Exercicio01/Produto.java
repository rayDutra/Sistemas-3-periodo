package Exercicio01;

public class Produto {
    private String name;
    private double preco;

    public Produto(String name, double preco) {
        this.name = name;
        this.preco = preco;
    }

    // Getters e Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
