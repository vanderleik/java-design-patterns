package src.interfaces;

import src.produtos.Emprestimo;
import src.enums.TipoEmprestimo;

/**
 * Interface abstrata para representar o Banco
 */
public interface Banco {

    Emprestimo criarEmprestimo(TipoEmprestimo tipoEmprestimo, double valor, int prazo, double taxaJuros);
}
