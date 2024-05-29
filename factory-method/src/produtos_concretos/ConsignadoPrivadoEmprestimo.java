package produtos_concretos;

import interfaces.Emprestimo;

public class ConsignadoPrivadoEmprestimo implements Emprestimo {

    @Override
    public void calcularJuros() {
        System.out.println("Calculando juros para o empréstimo consignado privado...");
    }

}
