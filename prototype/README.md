<h1>Otimização de Transações Bancárias com o Padrão de Projeto Prototype em Java</h1>

<h4>Texto publicado originalmente no <a href="https://www.linkedin.com/pulse/otimiza%25C3%25A7%25C3%25A3o-de-transa%25C3%25A7%25C3%25B5es-banc%25C3%25A1rias-com-o-padr%25C3%25A3o-em-kleinschmidt-34smf">Linkedin</a>.</h4>

<p>O Prototype é um padrão de projeto criacional, de nível de dificuldade de entendimento intermediário, utilizado para copiar objetos. Para isso, é criada uma interface comum (protótipo) para todos os objetos, permitindo que você faça a clonagem sem acoplamento. Durante o processo, você delega a operação ao próprio objeto que será clonado.</p>

<p>A estrutura do padrão envolve uma interface (Prototype), uma classe que a implementa (ConcretePrototype) e uma classe que cria novos objetos (Client) por meio da clonagem de protótipos.</p>

<p>As vantagens de utilizar esse padrão de projeto incluem a redução de custos (em termos de tempo), especialmente se a criação do objeto for complexa. Além disso, a clonagem apresenta um desempenho melhor, sendo mais rápida do que a criação e inicialização de um novo objeto. Finalmente, é mais flexível, pois permite a criação de objetos com estado inicial variável.</p>

<p>Para ilustrar o uso do padrão Prototype, podemos considerar um cenário em que precisamos criar várias instâncias de objetos de transações bancárias, como depósitos, saques e transferências, com configurações semelhantes, mas que podem variar em alguns detalhes.</p>

<p>Primeiro, definimos a interface `TransactionPrototype`, que estende a interface `Cloneable`, do `java.lang`:</p>

```java
package src;

public interface TransactionPrototype extends Cloneable {
    TransactionPrototype clone();
}
```

<p>O `java.lang.Cloneable` é uma interface de marcação. Quando implementamos `Cloneable` em uma classe, estamos indicando que podemos copiar campo por campo as instâncias dessa classe. Caso contrário, uma exceção do tipo `CloneNotSupportedException` é lançada.</p>

<p>Em seguida, criamos uma classe concreta `BankTransaction` que implementa a interface `TransactionPrototype` e define os atributos e o método de clonagem:</p>

```java
package src;

public class BankTransaction implements TransactionPrototype {

    private String type;
    private double amount;
    private String accountNumber;
    private String details;

    public BankTransaction(String type, double amount, String accountNumber, String details) {
        this.type = type;
        this.amount = amount;
        this.accountNumber = accountNumber;
        this.details = details;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public TransactionPrototype clone() {
        try {
            return (BankTransaction) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "BankTransaction{" +
                "type='" + type + '\'' +
                ", amount=" + amount +
                ", accountNumber='" + accountNumber + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
```

<p>Agora, criamos o `Client` que usa o protótipo para criar novas transações:</p>

```java
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
        withdrawal1.setDetails("Saque em caixa eletrônico");

        BankTransaction withdrawal2 = withdrawalPrototype.clone();
        withdrawal2.setAmount(300.00);
        withdrawal2.setDetails("Saque na boca do caixa na agência");

        // Exibindo as transações
        System.out.println(deposit1); // BankTransaction{type='deposit', amount=100.0, accountNumber='1234', details='Depósito de Salário'}
        System.out.println(deposit2); // BankTransaction{type='deposit', amount=500.0, accountNumber='1234', details='Depósito de Bonificação'}
        System.out.println(withdrawal1); // BankTransaction{type='withdrawal', amount=50.0, accountNumber='1234', details='Saque em caixa eletrônico'}
        System.out.println(withdrawal2); // BankTransaction{type='withdrawal', amount=300.0, accountNumber='1234', details='Saque na boca do caixa na agência'}
    }
}
```

<p>O `BankApiClient` cria protótipos para diferentes tipos de transações (depósito e saque), clona esses protótipos para criar novas transações com valores e detalhes específicos e exibe as transações clonadas. Essa abordagem facilita a criação de múltiplas instâncias de transações bancárias similares, reduzindo a duplicação de código e melhorando a eficiência na criação de objetos.</p>

<p>O padrão de projeto Prototype é uma poderosa ferramenta para otimizar a criação de objetos complexos, permitindo que sejam clonados de maneira eficiente e flexível. Em nosso exemplo, isso pode significar melhorias significativas na performance e na manutenção do código, especialmente quando lidamos com várias transações similares. Implementar o padrão Prototype pode trazer benefícios consideráveis em termos de tempo e recursos, facilitando a gestão e a escalabilidade do projeto.</p>
