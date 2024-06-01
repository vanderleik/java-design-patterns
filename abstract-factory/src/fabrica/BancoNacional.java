package src.fabrica;

import src.enums.TipoEmprestimo;
import src.fabrica.fabrica_concreta.FabricaEmprestimosAuto;
import src.fabrica.fabrica_concreta.FabricaEmprestimosImobiliarios;
import src.fabrica.fabrica_concreta.FabricaEmprestimosPessoais;
import src.interfaces.Banco;
import src.produtos.Emprestimo;

public class BancoNacional implements Banco {

    @Override
    public Emprestimo criarEmprestimo(TipoEmprestimo tipoEmprestimo, double valor, int prazo, double taxaJuros) {
        FabricaEmprestimo fabricaEmprestimo;

        return switch (tipoEmprestimo) {
            case PESSOAL -> {
                fabricaEmprestimo = new FabricaEmprestimosPessoais();
                yield fabricaEmprestimo.criarEmprestimo(tipoEmprestimo, valor, prazo, taxaJuros);
            }
            case IMOBILIARIO -> {
                fabricaEmprestimo = new FabricaEmprestimosImobiliarios();
                yield fabricaEmprestimo.criarEmprestimo(tipoEmprestimo, valor, prazo, taxaJuros);
            }
            case AUTO -> {
                fabricaEmprestimo = new FabricaEmprestimosAuto();
                yield fabricaEmprestimo.criarEmprestimo(tipoEmprestimo, valor, prazo, taxaJuros);
            }
            default -> throw new IllegalArgumentException("Tipo de empréstimo inválido: " + tipoEmprestimo);
        };
    }
}
