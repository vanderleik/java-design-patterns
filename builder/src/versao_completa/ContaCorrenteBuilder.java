package src.versao_completa;

public interface ContaCorrenteBuilder {

    void buildNumeroConta(String numeroConta);
    void buildAgencia(String agencia);
    void buildSaldo(double saldo);
    void buildTitular(String titular);
    void buildChequeEspecial(boolean chequeEspecial);

    ContaCorrente getContaCorrente();

}
