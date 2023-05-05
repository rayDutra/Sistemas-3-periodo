public class Livro extends Item {
    private int anoPublicacao;
    private int numPaginas;
    private String editora;

    public Livro(String titulo, String autor, boolean disponivel, int anoPublicacao, int numPaginas, String editora) {
        super(titulo, autor, disponivel);
        this.anoPublicacao = anoPublicacao;
        this.numPaginas = numPaginas;
        this.editora = editora;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }
}
