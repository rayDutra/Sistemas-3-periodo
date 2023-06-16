package Exercicio05;
public class Main {
    public static void main(String[] args) {
        // Criando uma instância do serviço de dedução para Minas Gerais (MG)
        ServicoDeducao servicoDeducaoMg = new ServicoDeducaoMg();

        // Criando uma instância do serviço de pagamento com o serviço de dedução para MG
        ServicoPagamento servicoPagamentoMg = new ServicoPagamento(servicoDeducaoMg);

        // Calculando o imposto para um valor de pagamento
        double valorPagamento = 1000.0;
        double impostoMg = servicoPagamentoMg.calcularImposto(valorPagamento);

        // Imprimindo o valor do imposto calculado
        System.out.println("Imposto (MG): " + impostoMg);

        // Criando uma instância do serviço de dedução para São Paulo (SP)
        ServicoDeducao servicoDeducaoSp = new ServicoDeducaoSp();

        // Criando uma instância do serviço de pagamento com o serviço de dedução para SP
        ServicoPagamento servicoPagamentoSp = new ServicoPagamento(servicoDeducaoSp);

        // Calculando o imposto para um valor de pagamento
        double impostoSp = servicoPagamentoSp.calcularImposto(valorPagamento);

        // Imprimindo o valor do imposto calculado
        System.out.println("Imposto (SP): " + impostoSp);
    }
}