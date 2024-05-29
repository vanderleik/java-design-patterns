import fabrica.EmprestimoFactory;
import fabrica.fabrica_concreta.*;

public class Main {
    public static void main(String[] args) {

        EmprestimoFactory factory;

        //Processar empréstimo CDC
        factory = new CdcEmprestimoFactory();
        factory.processarEmprestimo(); //Output: Calculando juros para o CDC...

        // Processar empréstimo consignado para funcionários públicos
        factory = new ConsignadoPublicoEmprestimoFactory();
        factory.processarEmprestimo(); //Output: Calculando juros para o empréstimo consignado público...

        // Processar empréstimo consignado para funcionários privados
        factory = new ConsignadoPrivadoEmprestimoFactory();
        factory.processarEmprestimo(); //Output: Calculando juros para o empréstimo consignado privado...

        // Processar empréstimo consignado para aposentados e pensionistas do INSS
        factory = new ConsignadoInssEmprestimoFactory();
        factory.processarEmprestimo(); //Output: Calculando juros para o empréstimo consignado INSS...

        // Processar empréstimo para compra de bens móveis
        factory = new BemMovelEmprestimoFactory();
        factory.processarEmprestimo(); // Output: Calculando juros para o empréstimo de bem móvel...

        // Processar empréstimo para compra de bens imóveis
        factory = new BemImovelEmprestimoFactory();
        factory.processarEmprestimo(); // Output: Calculando juros para o empréstimo com bem imóvel...
    }

}
