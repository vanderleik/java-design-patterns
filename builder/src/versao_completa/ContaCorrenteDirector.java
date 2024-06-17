package src.versao_completa;

public class ContaCorrenteDirector {

    private ContaCorrenteBuilder builder;

    public ContaCorrenteDirector(ContaCorrenteBuilder builder) {
        this.builder = builder;
    }

    public void construirContaCorrente(String numeroConta, String agencia, double saldo, String titular, boolean chequeEspecial) {
        builder.buildNumeroConta(numeroConta);
        builder.buildAgencia(agencia);
        builder.buildSaldo(saldo);
        builder.buildTitular(titular);
        builder.buildChequeEspecial(chequeEspecial);
    }

    public ContaCorrente getContaCorrente() {
        return builder.getContaCorrente();
    }

}
