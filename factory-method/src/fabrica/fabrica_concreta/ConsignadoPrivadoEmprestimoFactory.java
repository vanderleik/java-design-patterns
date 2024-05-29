package fabrica.fabrica_concreta;

import fabrica.EmprestimoFactory;
import interfaces.Emprestimo;
import produtos_concretos.ConsignadoPrivadoEmprestimo;

public class ConsignadoPrivadoEmprestimoFactory extends EmprestimoFactory {

    @Override
    public Emprestimo criarEmprestimo() {
        return new ConsignadoPrivadoEmprestimo();
    }
}
