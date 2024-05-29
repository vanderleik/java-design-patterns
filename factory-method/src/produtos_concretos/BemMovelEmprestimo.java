package produtos_concretos;

import interfaces.Emprestimo;

public class BemMovelEmprestimo implements Emprestimo {

    @Override
    public void calcularJuros() {
        System.out.println("Calculando juros para o empréstimo de bem móvel...");
    }

}
