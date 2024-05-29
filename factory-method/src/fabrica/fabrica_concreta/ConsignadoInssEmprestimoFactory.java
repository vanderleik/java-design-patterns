package fabrica.fabrica_concreta;

import fabrica.EmprestimoFactory;
import interfaces.Emprestimo;
import produtos_concretos.ConsignadoInssEmprestimo;

public class ConsignadoInssEmprestimoFactory extends EmprestimoFactory {

    @Override
    public Emprestimo criarEmprestimo() {
        return new ConsignadoInssEmprestimo();
    }

}
