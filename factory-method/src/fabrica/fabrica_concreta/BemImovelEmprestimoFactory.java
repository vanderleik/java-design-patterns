package fabrica.fabrica_concreta;

import fabrica.EmprestimoFactory;
import interfaces.Emprestimo;
import produtos_concretos.BemImovelEmprestimo;

public class BemImovelEmprestimoFactory extends EmprestimoFactory {

    @Override
    public Emprestimo criarEmprestimo() {
        return new BemImovelEmprestimo();
    }

}
