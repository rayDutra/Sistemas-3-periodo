import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private String email;
    private String endereco;
    private List<Item> carrinho;

    public Usuario(String nome, String email, String endereco) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.carrinho = new ArrayList<Item>();
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Item> getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(List<Item> carrinho) {
        this.carrinho = carrinho;
    }

    // Método para adicionar item ao carrinho
    public void escolherItem(Item item) {
        carrinho.add(item);
    }

    // Método para remover item do carrinho
    public void devolverItem(Item item) {
        carrinho.remove(item);
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\nEmail: " + email + "\nEndereço: " + endereco;
    }
}
