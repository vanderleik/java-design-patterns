package src.versao_completa;

public class ContaCorrenteConcreteBuilder implements ContaCorrenteBuilder {

    private ContaCorrente contaCorrente;

    public ContaCorrenteConcreteBuilder() {
        this.contaCorrente = new ContaCorrente();
    }

    @Override
    public void buildNumeroConta(String numeroConta) {
        contaCorrente.setNumeroConta(numeroConta);
    }

    @Override
    public void buildAgencia(String agencia) {
        contaCorrente.setAgencia(agencia);
    }

    @Override
    public void buildSaldo(double saldo) {
        contaCorrente.setSaldo(saldo);
    }

    @Override
    public void buildTitular(String titular) {
        contaCorrente.setTitular(titular);
    }

    @Override
    public void buildChequeEspecial(boolean chequeEspecial) {
        contaCorrente.setChequeEspecial(chequeEspecial);
    }

    @Override
    public ContaCorrente getContaCorrente() {
        return this.contaCorrente;
    }

}
