package fabrica.fabrica_concreta;

import fabrica.EmprestimoFactory;
import interfaces.Emprestimo;
import produtos_concretos.ConsignadoPublicoEmprestimo;

public class ConsignadoPublicoEmprestimoFactory extends EmprestimoFactory {

    @Override
    public Emprestimo criarEmprestimo() {
        return new ConsignadoPublicoEmprestimo();
    }

}
