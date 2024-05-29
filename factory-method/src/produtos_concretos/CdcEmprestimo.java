package produtos_concretos;

import interfaces.Emprestimo;

public class CdcEmprestimo implements Emprestimo {

    @Override
    public void calcularJuros() {
        System.out.println("Calculando juros para o CDC...");
    }

}
