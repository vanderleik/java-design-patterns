package src.versao_completa;

public class ContaCorrente {

    private String numeroConta;
    private String agencia;
    private double saldo;
    private String titular;
    private boolean chequeEspecial;

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void setChequeEspecial(boolean chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "numeroConta='" + numeroConta + '\'' +
                ", agencia='" + agencia + '\'' +
                ", saldo=" + saldo +
                ", titular='" + titular + '\'' +
                ", chequeEspecial=" + chequeEspecial +
                '}';
    }
}
