package Exercicio05;
class ServicoDeducaoMg implements ServicoDeducao {
    private static final double TAXA_DEDUCAO_MG = 0.12; // 12%

    @Override
    public double calcularDeducao(double valor) {
        return valor * TAXA_DEDUCAO_MG;
    }
}