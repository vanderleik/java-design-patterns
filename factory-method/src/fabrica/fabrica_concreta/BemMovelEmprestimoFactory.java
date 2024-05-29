package fabrica.fabrica_concreta;

import fabrica.EmprestimoFactory;
import interfaces.Emprestimo;
import produtos_concretos.BemMovelEmprestimo;

public class BemMovelEmprestimoFactory extends EmprestimoFactory {

    @Override
    public Emprestimo criarEmprestimo() {
        return new BemMovelEmprestimo();
    }

}
