package src;

import src.enums.TipoEmprestimo;
import src.fabrica.BancoNacional;
import src.interfaces.Banco;
import src.produtos.Emprestimo;

public class Main {
    public static void main(String[] args) {
        Banco banco = new BancoNacional();
        double valor = 100.0;
        int prazo = 10;
        double taxaJuros = 1.5;

        //Solicitando um empréstimo pessoal
        Emprestimo emprestimoPessoal = banco.criarEmprestimo(TipoEmprestimo.PESSOAL, valor, prazo, taxaJuros);
        System.out.println("\nEmpréstimo pessoal PF criado: ");
        emprestimoPessoal.imprimirDetalhes();

        //Solicitando um empréstimo imobiliário
        Emprestimo emprestimoImobiliario = banco.criarEmprestimo(TipoEmprestimo.IMOBILIARIO, valor, prazo, taxaJuros);
        System.out.println("\nEmpréstimo imobiliário criado: ");
        emprestimoImobiliario.imprimirDetalhes();

        //Solicitando um empréstimo auto
        Emprestimo emprestimoAuto = banco.criarEmprestimo(TipoEmprestimo.AUTO, valor, prazo, taxaJuros);
        System.out.println("\nEmpréstimo auto criado: ");
        emprestimoAuto.imprimirDetalhes();


    }
}
