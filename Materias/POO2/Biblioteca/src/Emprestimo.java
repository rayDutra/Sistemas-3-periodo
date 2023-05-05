import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Emprestimo {
    private Usuario usuario;
    private List<Item> itensEmprestados;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo(Usuario usuario, List<Item> itensEmprestados) {
        this.usuario = usuario;
        this.itensEmprestados = itensEmprestados;
        this.dataEmprestimo = LocalDate.now();
    }

    // Getters e setters
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Item> getItensEmprestados() {
        return itensEmprestados;
    }

    public void setItensEmprestados(List<Item> itensEmprestados) {
        this.itensEmprestados = itensEmprestados;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    // Método para registrar o empréstimo
    public void fazerEmprestimo() {
        // Registra a data do empréstimo
        this.dataEmprestimo = LocalDate.now();

        // Remove os itens do carrinho do usuário
        usuario.getCarrinho().removeAll(itensEmprestados);
    }

    // Método para registrar a devolução
    public void devolverEmprestimo() {
        // Registra a data da devolução
        this.dataDevolucao = LocalDate.now();
    }

    // Método para imprimir informações do empréstimo
    public void imprime() {
        System.out.println("Nome do usuário: " + usuario.getNome());
        System.out.println("Data do empréstimo: " + dataEmprestimo);
        System.out.println("Data de devolução: " + dataDevolucao);

        // Imprime as informações dos itens emprestados
        for (Item item : itensEmprestados) {
            System.out.println(item.toString());
        }
    }
}
