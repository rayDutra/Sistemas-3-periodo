package Exercicio01;

public class ConfirmacaoEmail {
    private Pagamento pagamento;

    public ConfirmacaoEmail(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public void enviarEmailConfirmacao() {
        if (pagamento.isPago()) {
            // Lógica para enviar o email de confirmação para o cliente
            System.out.println("Email de confirmação enviado.");
        } else {
            System.out.println("Pagamento não foi processado ainda.");
        }
    }
}

