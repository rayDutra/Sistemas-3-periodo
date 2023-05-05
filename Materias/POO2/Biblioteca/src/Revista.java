public class Revista extends Item {
    private int numEdicao;
    private String editora;

    public Revista(String titulo, String autor, boolean disponivel, int numEdicao, String editora) {
        super(titulo, autor, disponivel);
        this.numEdicao = numEdicao;
        this.editora = editora;
    }

    public int getNumEdicao() {
        return numEdicao;
    }

    public void setNumEdicao(int numEdicao) {
        this.numEdicao = numEdicao;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }
}
