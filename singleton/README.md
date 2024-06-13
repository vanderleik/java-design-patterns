<h1>Singleton: Uma Instância Única</h1>

<h4>Texto publicado originalmente no <a href="https://www.linkedin.com/pulse/singleton-uma-inst%25C3%25A2ncia-%25C3%25BAnica-vanderlei-kleinschmidt-jdcpf">Linkedin.</a></h3>
<p>Em um dos meus primeiros <a href="https://www.linkedin.com/pulse/explorando-design-patterns-um-caminho-para-solu%2525C3%2525A7%2525C3%2525B5es-em-kleinschmidt-2uimf/?trackingId=zqORpZZxby8t3aVyZaCCdQ%3D%3D">artigos</a>, abordei os padrões de projeto, categorizando-os em essenciais, intermediários e avançados. Para cada grupo, apresentei exemplos de padrões criacionais, estruturais e comportamentais. Em seguida, iniciei a discussão sobre os padrões essenciais, focando inicialmente nos padrões criacionais de fábrica, o <a href="https://www.linkedin.com/pulse/factory-method-uma-abordagem-modular-para-cria%25C3%25A7%25C3%25A3o-de-kleinschmidt-bosaf/?trackingId=Xo9WAy6MSka%2BTKonZItryg%3D%3D">Factory Method</a> e o <a href="https://www.linkedin.com/pulse/abstract-factory-criando-fam%25C3%25ADlias-de-objetos-vanderlei-kleinschmidt-my2rf/?trackingId=Xo9WAy6MSka%2BTKonZItryg%3D%3D">Abstract Factory</a>. Hoje, aprofundaremos nosso conhecimento sobre o padrão Singleton, finalizando esta série de padrões criacionais essenciais.</p>
<p>O site do <a href="https://refactoring.guru/pt-br/design-patterns/singleton">Rector Guru</a> define o Singleton como</p>
<blockquote>"... um padrão de projeto criacional que garante que uma classe tenha apenas uma instância, fornecendo ao mesmo tempo um ponto de acesso global para essa instância".</blockquote>

<p>Para compreender melhor esse padrão, imagine o momento em que você faz login no aplicativo do seu banco. Após o login, o sistema cria uma sessão para você. Essa sessão pode ser considerada um objeto Singleton, pois existe apenas uma instância da sua sessão durante todo o período em que você estiver logado. Ao consultar o extrato da sua conta ou realizar uma transferência bancária, o sistema acessa essa sessão para verificar se você está logado, sem criar novas sessões a cada interação.</p>

<p>Para exemplificar, considere um software bancário que gerencia contas de correntistas físicos. Comecemos criando a classe <code>BankAccount</code> que possui métodos para depósito e saque:</p>

```java
public class BankAccount {
    private String accountNumber;
    private String ownerName;
    private double balance;

    public BankAccount(String accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }
    //  Métodos getter e setter omitidos

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    @Override
    public String toString() {
        return "AccountNumber: " + accountNumber + ", Owner: " + ownerName + ", Balance: " + balance;
    }
}
```

<p>O próximo passo é criar a classe <code>BankAccountManager</code> responsável por gerenciar as contas de correntistas pessoa física e garantir que apenas uma instância dessa classe exista durante a execução do programa:</p>

```java
public class BankAccountManager {

    // A única instância de BankAccountManager
    private static BankAccountManager instance;

    // Lista para armazenar contas bancárias de pessoa física
    private Map<String, BankAccount> accounts;

    // Construtor privado para evitar instanciamento externo
    private BankAccountManager() {
        accounts = new HashMap<>();
    }

    // Método para obter a instância única do BankAccountManager
    public static synchronized BankAccountManager getInstance() {
        if (instance == null) {
            instance = new BankAccountManager();
        }
        return instance;
    }

    // Método para criar uma nova conta bancária
    public void createAccount(String accountNumber, String ownerName, double initialBalance) {
        BankAccount account = new BankAccount(accountNumber, ownerName, initialBalance);
        accounts.put(accountNumber, account);
    }

    // Método para obter uma conta bancária por número da conta
    public BankAccount getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }
}
```

<p>A classe <code>BankAccountManager</code> possui um construtor privado para impedir a criação de novas instâncias fora da classe (encapsulamento) e um método <code>getInstance()</code> para garantir que apenas uma instância da classe seja criada, fornecendo um ponto de acesso global a essa instância.</p>

<p>O uso do padrão Singleton é demonstrado na classe <code>Main</code>:</p>

```java
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
```
<p>A classe <code>SingletonMain</code> demonstra como obter a instância única de <code>BankAccountManager</code> e realizar operações de criação de contas, depósitos e saques. Este exemplo ilustra como o padrão Singleton pode ser utilizado para garantir que apenas uma instância do gerenciador de contas bancárias exista, facilitando o acesso e a manipulação de contas de forma centralizada e eficiente.</p>