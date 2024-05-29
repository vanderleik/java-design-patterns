package fabrica.fabrica_concreta;

import fabrica.EmprestimoFactory;
import interfaces.Emprestimo;
import produtos_concretos.CdcEmprestimo;

public class CdcEmprestimoFactory extends EmprestimoFactory {

    @Override
    public Emprestimo criarEmprestimo() {
        return new CdcEmprestimo();
    }

}
