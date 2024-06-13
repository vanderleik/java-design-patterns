package src;

import java.util.HashMap;
import java.util.Map;

/**
 * BankAccountManager
 * Classe que gerencia contas bancárias de pessoa física.
 */
public class BankAccountManager {

    //Única instância da classe
    private static BankAccountManager instance;

    //Lista para armazenar contas bancárias de pessoa física
    private Map<String, BankAccount> accounts;

    //Construtor privado para evitar instanciamento externo
    private BankAccountManager() {
        accounts = new HashMap<>();
    }

    //Método para obter a instância única da classe
    public static synchronized BankAccountManager getInstance() {
        if (instance == null) {
            instance = new BankAccountManager();
        }
        return instance;
    }

    //Método para criar uma nova conta bancária
    public void createAccount(String accountNumber, String ownerName, double initialBalance) {
        BankAccount account = new BankAccount(accountNumber, ownerName, initialBalance);
        accounts.put(accountNumber, account);
    }

    //Método para obter uma conta bancária por número da conta
    public BankAccount getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

}
