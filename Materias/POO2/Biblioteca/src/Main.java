import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Criando usuários
        Usuario usuario1 = new Usuario("Aparecida Costa", "aparecida@gmail.com", "Rua das Araras");
        Usuario usuario2 = new Usuario("Armando Souza", "armando@gmail.com", "Avenida Rondon Pacheco");
        Usuario usuario3 = new Usuario("Felipe Ricardo", "felipe@gmail.com", "Rua dos caminhoneiros");

        // Primeiro usuário: empréstimo de 3 itens
        List<Item> itensEmprestimo1 = new ArrayList<>();
        itensEmprestimo1.add(new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", true, 1954, 1008, "Martins Fontes"));
        itensEmprestimo1.add(new Revista("Veja", "Paulo Souza", true, 234, "Sergio Folhas"));
        itensEmprestimo1.add(new DVD("Pulp Fiction", "Fernanda", true, "Crime", 200));
        Emprestimo emprestimo1 = new Emprestimo(usuario1, itensEmprestimo1);
        emprestimo1.fazerEmprestimo();
        emprestimo1.imprime();

        // Segundo usuário: devolução de 1 item e empréstimo de 2 novos itens
        List<Item> itensEmprestimo2 = new ArrayList<>();
        itensEmprestimo2.add(new Livro("A Menina que Roubava Livros", "Markus Zusak",true, 2005, 480, "Intrínseca"));
        itensEmprestimo2.add(new DVD("Clube da Luta", "Drama",true, "Drama",139));
        usuario2.escolherItem(new Livro("Harry Potter e a Pedra Filosofal", "J.K. Rowling", true,1997, 223, "Rocco"));
        usuario2.devolverItem(new Revista("Veja","Claudio",true,1234, "Abril"));
        Emprestimo emprestimo2 = new Emprestimo(usuario2, itensEmprestimo2);
        emprestimo2.fazerEmprestimo();
        emprestimo2.imprime();

        // Terceiro usuário: empréstimo de 2 itens e devolução imediata
        List<Item> itensEmprestimo3 = new ArrayList<>();
        itensEmprestimo3.add(new DVD("Matrix", "Ficção científica", false,"Ficção",136));
        itensEmprestimo3.add(new Livro("1984", "George Orwell", true,1949, 336, "Companhia das Letras"));
        Emprestimo emprestimo3 = new Emprestimo(usuario3, itensEmprestimo3);
        emprestimo3.fazerEmprestimo();
        emprestimo3.devolverEmprestimo();
        emprestimo3.imprime();
    }

}
