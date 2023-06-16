package Exercicio05;

class ServicoPagamento {
    private static final double TAXA_IMPOSTO = 0.20; // 20%
    private ServicoDeducao servicoDeducao;

    public ServicoPagamento(ServicoDeducao servicoDeducao) {
        this.servicoDeducao = servicoDeducao;
    }

    public double calcularImposto(double valorPagamento) {
        double deducao = servicoDeducao.calcularDeducao(valorPagamento);
        double valorRestante = valorPagamento - deducao;
        return valorRestante * TAXA_IMPOSTO;
    }
}