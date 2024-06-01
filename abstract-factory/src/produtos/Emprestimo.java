package src.produtos;

public abstract class Emprestimo {

    private double valor;
    private int prazo;
    private double taxaJuros;

    public Emprestimo(double valor, int prazo, double taxaJuros) {
        this.valor = valor;
        this.prazo = prazo;
        this.taxaJuros = taxaJuros;
    }

    public Emprestimo() {
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getPrazo() {
        return prazo;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    public abstract double calcularParcela(double valor, int prazo, double taxaJuros);

    public void imprimirDetalhes() {
        System.out.println("Valor do empréstimo: R$ " + valor);
        System.out.println("Prazo: " + prazo + " meses");
        System.out.println("Taxa de juros: " + taxaJuros + "%");
        System.out.printf("Parcela: R$ %.2f%n", calcularParcela(valor, prazo, taxaJuros));
    }

}
