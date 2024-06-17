<h1>O Padrão Builder na Construção de Objetos Complexos</h1>

<p>O Builder é um padrão de design utilizado para a construção de objetos complexos passo a passo. Sua simplicidade e facilidade de compreensão o tornam um poderoso aliado para o desenvolvedor. A essência desse padrão reside na separação da construção do objeto de sua representação, permitindo que o mesmo processo gere diferentes representações.</p>

<p>A implementação do padrão Builder se inicia com a definição de um produto que representa o objeto complexo a ser construído. Em seguida, é definida a interface Builder, responsável pela criação das partes do objeto. Na sequência, os métodos específicos dessa interface são implementados em um construtor concreto. Por fim, o Diretor encapsula a construção do produto utilizando uma instância do Builder, definindo a ordem da construção e invocando as operações de construção.</p>

<p>Para ilustrar melhor o padrão Builder, consideremos a construção de uma conta corrente bancária:</p>
<ul>
  <li><strong>ContaCorrente (Product)</strong>: Representa o objeto complexo a ser construído.</li>
  <li><strong>ContaCorrenteBuilder (Builder)</strong>: Define a interface para a construção da conta.</li>
  <li><strong>ContaCorrenteConcreteBuilder (ConcreteBuilder)</strong>: Implementa a interface Builder e constrói a conta.</li>
  <li><strong>ContaCorrenteDirector (Director)</strong>: Constrói a conta utilizando a interface Builder.</li>
</ul>

<p>Vamos começar com a classe ContaCorrente (Product), que representa o objeto complexo a ser construído. Ela possui métodos set para definir seus atributos.</p>

```java
public class ContaCorrente {

    private String numeroConta;
    private String agencia;
    private double saldo;
    private String titular;
    private boolean chequeEspecial;

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void setChequeEspecial(boolean chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "numeroConta='" + numeroConta + '\'' +
                ", agencia='" + agencia + '\'' +
                ", saldo=" + saldo +
                ", titular='" + titular + '\'' +
                ", chequeEspecial=" + chequeEspecial +
                '}';
    }
}
```
<p>Em seguida criamos a interface ContaCorrenteBuilder (Builder), que define os métodos necessários para construir as partes do Product.</p>

```java
public interface ContaCorrenteBuilder {

    void buildNumeroConta(String numeroConta);
    void buildAgencia(String agencia);
    void buildSaldo(double saldo);
    void buildTitular(String titular);
    void buildChequeEspecial(boolean chequeEspecial);

    ContaCorrente getContaCorrente();

}
```

<p>Na sequência, a classe ContaCorrenteConcreteBuilder (CocreteBuilder) que implementa a interface Builder e constrói as partes específicas do Product, mantendo a instância de ContaCorrente e a retornando quando solicitado.</p>


```java
public class ContaCorrenteConcreteBuilder implements ContaCorrenteBuilder {

    private ContaCorrente contaCorrente;

    public ContaCorrenteConcreteBuilder() {
        this.contaCorrente = new ContaCorrente();
    }

    @Override
    public void buildNumeroConta(String numeroConta) {
        contaCorrente.setNumeroConta(numeroConta);
    }

    @Override
    public void buildAgencia(String agencia) {
        contaCorrente.setAgencia(agencia);
    }

    @Override
    public void buildSaldo(double saldo) {
        contaCorrente.setSaldo(saldo);
    }

    @Override
    public void buildTitular(String titular) {
        contaCorrente.setTitular(titular);
    }

    @Override
    public void buildChequeEspecial(boolean chequeEspecial) {
        contaCorrente.setChequeEspecial(chequeEspecial);
    }

    @Override
    public ContaCorrente getContaCorrente() {
        return this.contaCorrente;
    }

}
```

<p>Por fim, a classe ContaCorrenteDirector (Director), que recebe uma instância de Builder e define a ordem de construção do Product, utilizando os métodos do Builder para construir o Product passo a passo.</p>

```java
public class ContaCorrenteDirector {

    private ContaCorrenteBuilder builder;

    public ContaCorrenteDirector(ContaCorrenteBuilder builder) {
        this.builder = builder;
    }

    public void construirContaCorrente(String numeroConta, String agencia, double saldo, String titular, boolean chequeEspecial) {
        builder.buildNumeroConta(numeroConta);
        builder.buildAgencia(agencia);
        builder.buildSaldo(saldo);
        builder.buildTitular(titular);
        builder.buildChequeEspecial(chequeEspecial);
    }

    public ContaCorrente getContaCorrente() {
        return builder.getContaCorrente();
    }

}
```

<p>Nesta etapa, exploraremos a utilização dos componentes para criar instâncias de ContaCorrente. Primeiramente, instanciamos um objeto ConcreteBuilder e outro Director. Em seguida, utilizamos o Director para construir a ContaCorrente, definindo os atributos desejados. Por fim, obtemos a instância final do Product.</p>

```java
public class BuilderMain {
    public static void main(String[] args) {

        ContaCorrenteBuilder builder = new ContaCorrenteConcreteBuilder();
        ContaCorrenteDirector director = new ContaCorrenteDirector(builder);

        director.construirContaCorrente("123456", "001", 1000.00, "Joe Doe", true);
        ContaCorrente conta1 = director.getContaCorrente();
        System.out.println(conta1); //ContaCorrente{numeroConta='123456', agencia='001', saldo=1000.0, titular='Joe Doe', chequeEspecial=true}        

        director.construirContaCorrente("654321", "002", 2000.00, "Jane Doe", false);
        ContaCorrente conta2 = director.getContaCorrente();
        System.out.println(conta2);//ContaCorrente{numeroConta='654321', agencia='002', saldo=2000.0, titular='Jane Doe', chequeEspecial=false}

    }
}
```
<p>Este exemplo demonstra como o padrão Builder facilita a construção de objetos complexos de forma organizada e estruturada, separando a lógica de construção dos detalhes internos do objeto. Essa abordagem oferece diversos benefícios:</p>
<ul>
    <li><strong>Flexibilidade na Criação de Representações</strong>: A mesma estrutura de construção pode gerar diferentes representações do objeto, atendendo a diversas necessidades.</li>
    <li><strong>Modularidade Aprimorada</strong>: O processo de construção é dividido em etapas menores e bem definidas, cada uma responsável por uma parte específica do produto. Essa modularidade facilita a compreensão, o reuso de código e a manutenção.</li>
    <li><strong>Expansão Simplificada</strong>: A introdução de novos tipos de produtos ou etapas de construção se torna um processo mais simples e sem impacto no código existente, preservando a integridade da base de código.</li>
</ul>

<p>Vale ressaltar que existem outras duas maneiras de utilizar o padrão Builder, além da abordagem tradicional apresentada neste exemplo:</p>
<ul>
    <li><strong>Builder Simplificado</strong>: Uma versão simplificada do padrão Builder está disponível no repositório de código do artigo no Github. Essa variante oferece uma sintaxe mais concisa para casos de uso mais simples.</li>
    <li><strong>Anotação @Builder do Lombok</strong>: O Projeto Lombok fornece uma anotação @Builder que pode ser utilizada para simplificar ainda mais a implementação do padrão Builder, reduzindo a quantidade de código repetitivo.</li>
</ul>

<p>Portanto, o padrão Builder se destaca como uma ferramenta valiosa para a construção de objetos complexos em software, proporcionando organização, flexibilidade e facilidade de manutenção. A escolha da variante ideal depende das necessidades específicas do projeto e da preferência do desenvolvedor.</p>
