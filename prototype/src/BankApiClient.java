package src;

public class BankApiClient {
    public static void main(String[] args) {
        // Criação do protótipo de uma transação de depósito
        BankTransaction depositPrototype = new BankTransaction("deposit", 0.00, "1234", "Depósito inicial");

        // Clonando e configurando novas transações baseadas no protótipo
        BankTransaction deposit1 = depositPrototype.clone();
        deposit1.setAmount(100.00);
        deposit1.setDetails("Depósito de Salário");

        BankTransaction deposit2 = depositPrototype.clone();
        deposit2.setAmount(500.00);
        deposit2.setDetails("Depósito de Bonificação");

        // Criação do protótipo de uma transação de saque
        BankTransaction withdrawalPrototype = new BankTransaction("withdrawal", 0.00, "1234", "Saque");

        // Clonando e configurando novas transações baseadas no protótipo
        BankTransaction withdrawal1 = withdrawalPrototype.clone();
        withdrawal1.setAmount(50.00);
        withdrawal1.setDetails("Saque em em caixa eletrônico");

        BankTransaction withdrawal2 = withdrawalPrototype.clone();
        withdrawal2.setAmount(300.00);
        withdrawal2.setDetails("Saque na boca do caixa na agência");

        // Exibindo as transações
        System.out.println(deposit1); // BankTransaction{type='deposit', amount=100.0, accountNumber='1234', details='Depósito de Salário'}
        System.out.println(deposit2); // BankTransaction{type='deposit', amount=500.0, accountNumber='1234', details='Depósito de Bonificação'}
        System.out.println(withdrawal1); // BankTransaction{type='withdrawal', amount=50.0, accountNumber='1234', details='Saque em em caixa eletrônico'}
        System.out.println(withdrawal2); // BankTransaction{type='withdrawal', amount=300.0, accountNumber='1234', details='Saque na boca do caixa na agência'}

    }
}
