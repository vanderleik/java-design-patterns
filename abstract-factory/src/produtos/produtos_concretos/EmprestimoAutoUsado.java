package src.produtos.produtos_concretos;

import src.produtos.Emprestimo;

/**
 * Classe concreta para representar o empréstimo para automóveis usados
 */
public class EmprestimoAutoUsado extends Emprestimo {

    public EmprestimoAutoUsado(double valor, int prazo, double taxaJuros) {
        super(valor, prazo, taxaJuros);
    }

    @Override
    public double calcularParcela(double valor, int prazo, double taxaJuros) {
        return valor * (taxaJuros / 100 / 12) * Math.pow(1 + taxaJuros / 100 / 12, prazo) / (Math.pow(1 + taxaJuros / 100 / 12, prazo) - 1);
    }

    @Override
    public void imprimirDetalhes() {
        super.imprimirDetalhes();
    }

}
