package src;

import java.util.HashMap;
import java.util.Map;

/**
 * BankAccountManager
 * Classe que gerencia contas bancárias de pessoa física.
 */
public enum BankAccountManagerReflection {

    //Única instância da classe
    INSTANCE;

    //Lista para armazenar contas bancárias de pessoa física
    private Map<String, BankAccountReflection> accounts;

    //Construtor privado para evitar instanciamento externo
    BankAccountManagerReflection() {
        accounts = new HashMap<>();
    }

    //Método para obter a instância única da classe
    public static synchronized BankAccountManagerReflection getInstance() {
        return INSTANCE;
    }

    //Método para criar uma nova conta bancária
    public void createAccount(String accountNumber, String ownerName, double initialBalance) {
        BankAccountReflection account = new BankAccountReflection(accountNumber, ownerName, initialBalance);
        accounts.put(accountNumber, account);
    }

    //Método para obter uma conta bancária por número da conta
    public BankAccountReflection getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

}
