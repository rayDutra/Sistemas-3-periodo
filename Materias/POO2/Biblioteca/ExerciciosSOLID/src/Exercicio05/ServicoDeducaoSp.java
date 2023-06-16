package Exercicio05;

class ServicoDeducaoSp implements ServicoDeducao {
    private static final double TAXA_DEDUCAO_SP = 0.10; // 10%

    @Override
    public double calcularDeducao(double valor) {
        return valor * TAXA_DEDUCAO_SP;
    }
}