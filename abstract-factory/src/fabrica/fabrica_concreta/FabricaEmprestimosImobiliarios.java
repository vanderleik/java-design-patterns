package src.fabrica.fabrica_concreta;

import src.enums.TipoEmprestimo;
import src.fabrica.FabricaEmprestimo;
import src.produtos.Emprestimo;
import src.produtos.produtos_concretos.EmprestimoImobiliarioPJ;

/**
 * Implementaçao concreta da fábrica de empréstimos imobiliários
 */
public class FabricaEmprestimosImobiliarios implements FabricaEmprestimo {

    @Override
    public Emprestimo criarEmprestimo(TipoEmprestimo tipoEmprestimo, double valor, int prazo, double taxaJuros) {
        if (tipoEmprestimo == TipoEmprestimo.IMOBILIARIO) {
            return new EmprestimoImobiliarioPJ(valor, prazo, taxaJuros);
        } else {
            throw new IllegalArgumentException("Tipo de empréstimo inválido: " + tipoEmprestimo);
        }
    }
}
