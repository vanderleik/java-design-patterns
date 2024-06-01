package src.fabrica;

import src.produtos.Emprestimo;
import src.enums.TipoEmprestimo;

/**
 * Interface abstrata para representar a fábrica de empréstimos
 */
public interface FabricaEmprestimo {

    Emprestimo criarEmprestimo(TipoEmprestimo tipoEmprestimo, double valor, int prazo, double taxaJuros);
}
