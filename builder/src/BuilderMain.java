package src;

import src.versao_completa.ContaCorrente;
import src.versao_completa.ContaCorrenteBuilder;
import src.versao_completa.ContaCorrenteConcreteBuilder;
import src.versao_completa.ContaCorrenteDirector;

public class BuilderMain {
    public static void main(String[] args) {

        ContaCorrenteBuilder builder = new ContaCorrenteConcreteBuilder();
        ContaCorrenteDirector director = new ContaCorrenteDirector(builder);

        director.construirContaCorrente("123456", "001", 1000.00, "Joe Doe", true);
        ContaCorrente conta1 = director.getContaCorrente();
        System.out.println(conta1); //ContaCorrente{numeroConta='123456', agencia='001', saldo=1000.0, titular='Joe Doe', chequeEspecial=true}

        director.construirContaCorrente("654321", "002", 2000.00, "Jane Doe", false);
        ContaCorrente conta2 = director.getContaCorrente();
        System.out.println(conta2);//ContaCorrente{numeroConta='654321', agencia='002', saldo=2000.0, titular='Jane Doe', chequeEspecial=false}

    }
}
