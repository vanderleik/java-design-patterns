package produtos_concretos;

import interfaces.Emprestimo;

public class BemImovelEmprestimo implements Emprestimo {

    @Override
    public void calcularJuros() {
        System.out.println("Calculando juros para o empréstimo com bem imóvel...");
    }

}
