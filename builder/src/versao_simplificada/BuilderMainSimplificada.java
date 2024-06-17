package src.versao_simplificada;

public class BuilderMainSimplificada {

    public static void main(String[] args) {

        ContaCorrenteSimplificada conta1 = new ContaCorrenteSimplificada.Builder()
                .numeroConta("123456")
                .agencia("001")
                .saldo(1000.00)
                .titular("Joe Doe")
                .chequeEspecial(true)
                .build();

        ContaCorrenteSimplificada conta2 = new ContaCorrenteSimplificada.Builder()
                .numeroConta("654321")
                .agencia("002")
                .saldo(2000.00)
                .titular("Jane Doe")
                .chequeEspecial(false)
                .build();

        System.out.println(conta1); //ContaCorrenteSimplificada{numeroConta='123456', agencia='001', saldo=1000.0, titular='Joe Doe', chequeEspecial=true}
        System.out.println(conta2); //ContaCorrenteSimplificada{numeroConta='654321', agencia='002', saldo=2000.0, titular='Jane Doe', chequeEspecial=false}

    }
}
