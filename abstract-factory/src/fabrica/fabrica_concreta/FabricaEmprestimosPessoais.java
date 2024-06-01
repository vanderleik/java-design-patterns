package src.fabrica.fabrica_concreta;


import src.enums.TipoEmprestimo;
import src.fabrica.FabricaEmprestimo;
import src.produtos.Emprestimo;
import src.produtos.produtos_concretos.EmprestimoPessoalPF;

/**
 * Implementaçao concreta da fábrica de empréstimos pessoais
 */
public class FabricaEmprestimosPessoais implements FabricaEmprestimo {

    @Override
    public Emprestimo criarEmprestimo(TipoEmprestimo tipoEmprestimo, double valor, int prazo, double taxaJuros) {
        if (tipoEmprestimo == TipoEmprestimo.PESSOAL) {
            return new EmprestimoPessoalPF(valor, prazo, taxaJuros);
        } else {
            throw new IllegalArgumentException("Tipo de empréstimo inválido: " + tipoEmprestimo);
        }
    }
}
