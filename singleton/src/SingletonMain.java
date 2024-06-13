package src;

public class SingletonMain {

    public static void main(String[] args) {

        //Obtendo a instância única da classe BankAccountManager
        BankAccountManager manager = BankAccountManager.getInstance();

        //Criando novas contas bancárias
        manager.createAccount("123456", "Alice", 1000.0);
        manager.createAccount("654321", "Bob", 1500.0);

        //Obtendo e exibindo informações da conta de Alice
        BankAccount aliceAccount = manager.getAccount("123456");
        System.out.println(aliceAccount); //AccountNumber: 123456, Owner: Alice, Balance: 1000.0

        //Realizando operações na conta da Alice
        aliceAccount.deposit(500.0);
        aliceAccount.withdraw(200.0);
        System.out.println(aliceAccount); //AccountNumber: 123456, Owner: Alice, Balance: 1300.0

        //Obtendo e exibindo informações da conta de Bob
        BankAccount bobAccount = manager.getAccount("654321");
        System.out.println(bobAccount); //AccountNumber: 654321, Owner: Bob, Balance: 1500.0

    }
}
