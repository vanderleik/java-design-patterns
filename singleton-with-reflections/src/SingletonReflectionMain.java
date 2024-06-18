package src;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonReflectionMain {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        //Obtendo a instância única da classe BankAccountManager
        BankAccountManagerReflection manager1 = BankAccountManagerReflection.getInstance();
        BankAccountManagerReflection manager2 = BankAccountManagerReflection.getInstance();

        System.out.println("Instâncias iguais: " + (manager1 == manager2)); //true
        System.out.println("Manager1: " + manager1.hashCode()); //1595428806
        System.out.println("Manager2: " +manager2.hashCode()); //1595428806

        //Quebrando o Singleton
        Constructor<BankAccountManagerReflection> declaredConstructors = BankAccountManagerReflection.class.getDeclaredConstructor();
        declaredConstructors.setAccessible(true); //Tornando o construtor acessível
        manager1 = declaredConstructors.newInstance();
        manager2 = declaredConstructors.newInstance();

        System.out.println("\nInstâncias diferentes: " + (manager1 == manager2)); //false
        System.out.println("Manager1: " + manager1.hashCode()); //1072408673
        System.out.println("Manager2: " + manager2.hashCode()); //1531448569


        //Criando novas contas bancárias
//        manager.createAccount("123456", "Alice", 1000.0);
//        manager.createAccount("654321", "Bob", 1500.0);
//
//        //Obtendo e exibindo informações da conta de Alice
//        BankAccountReflection aliceAccount = manager.getAccount("123456");
//        System.out.println(aliceAccount); //AccountNumber: 123456, Owner: Alice, Balance: 1000.0
//
//        //Realizando operações na conta da Alice
//        aliceAccount.deposit(500.0);
//        aliceAccount.withdraw(200.0);
//        System.out.println(aliceAccount); //AccountNumber: 123456, Owner: Alice, Balance: 1300.0
//
//        //Obtendo e exibindo informações da conta de Bob
//        BankAccountReflection bobAccount = manager.getAccount("654321");
//        System.out.println(bobAccount); //AccountNumber: 654321, Owner: Bob, Balance: 1500.0

    }
}
