package fabrica;

import interfaces.Emprestimo;

public abstract class EmprestimoFactory {

    public abstract Emprestimo criarEmprestimo();

    public void processarEmprestimo() {
        Emprestimo emprestimo = criarEmprestimo();
        emprestimo.calcularJuros();
    }
}
