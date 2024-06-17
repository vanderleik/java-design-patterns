package src.versao_simplificada;

public class ContaCorrenteSimplificada {

    private String numeroConta;
    private String agencia;
    private double saldo;
    private String titular;
    private boolean chequeEspecial;

    // Construtor privado para forçar o uso do Builder
    private ContaCorrenteSimplificada(String numeroConta, String agencia, double saldo, String titular, boolean chequeEspecial) {
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
        this.titular = titular;
        this.chequeEspecial = chequeEspecial;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }

    public boolean isChequeEspecial() {
        return chequeEspecial;
    }

    @Override
    public String toString() {
        return "ContaCorrenteSimplificada{" +
                "numeroConta='" + numeroConta + '\'' +
                ", agencia='" + agencia + '\'' +
                ", saldo=" + saldo +
                ", titular='" + titular + '\'' +
                ", chequeEspecial=" + chequeEspecial +
                '}';
    }

    //Classe Builder
    public static class Builder {
        private String numeroConta;
        private String agencia;
        private double saldo;
        private String titular;
        private boolean chequeEspecial;

        public Builder numeroConta(String numeroConta) {
            this.numeroConta = numeroConta;
            return this;
        }

        public Builder agencia(String agencia) {
            this.agencia = agencia;
            return this;
        }

        public Builder saldo(double saldo) {
            this.saldo = saldo;
            return this;
        }

        public Builder titular(String titular) {
            this.titular = titular;
            return this;
        }

        public Builder chequeEspecial(boolean chequeEspecial) {
            this.chequeEspecial = chequeEspecial;
            return this;
        }

        public ContaCorrenteSimplificada build() {
            return new ContaCorrenteSimplificada(numeroConta, agencia, saldo, titular, chequeEspecial);
        }

    }

}
