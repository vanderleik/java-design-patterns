package src.fabrica.fabrica_concreta;

import src.enums.TipoEmprestimo;
import src.fabrica.FabricaEmprestimo;
import src.produtos.Emprestimo;
import src.produtos.produtos_concretos.EmprestimoAutoUsado;

/**
 * Implementaçao concreta da fábrica de empréstimos de automóveis
 */
public class FabricaEmprestimosAuto implements FabricaEmprestimo {

    @Override
    public Emprestimo criarEmprestimo(TipoEmprestimo tipoEmprestimo, double valor, int prazo, double taxaJuros) {
        if (tipoEmprestimo == TipoEmprestimo.AUTO) {
            return new EmprestimoAutoUsado(valor, prazo, taxaJuros);
        } else {
            throw new IllegalArgumentException("Tipo de empréstimo inválido: " + tipoEmprestimo);
        }
    }

}
