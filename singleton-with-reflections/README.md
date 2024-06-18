<h1>Quebrando o Singleton com Reflection</h1>

[//]: # (<h4>Texto publicado originalmente no <a href="https://www.linkedin.com/pulse/singleton-uma-inst%25C3%25A2ncia-%25C3%25BAnica-vanderlei-kleinschmidt-jdcpf">Linkedin.</a></h3>)

<p>No Java, o padrão Singleton garante que uma classe tenha apenas uma instância em todo o ciclo de vida da aplicação, fornecendo um ponto global de acesso a essa instância. Para implementá-lo, utilizamos um construtor privado, uma instância estática da própria classe e um método estático público para obtê-la. Um exemplo detalhado pode ser encontrado em meu artigo sobre Singleton (<a href="https://www.linkedin.com/pulse/singleton-uma-inst%25C3%25A2ncia-%25C3%25BAnica-vanderlei-kleinschmidt-jdcpf">link aqui)</a>.</p>
<p>A ideia central reside no construtor privado, que impede o acesso por outras classes, evitando a criação de múltiplas instâncias. No entanto, o Reflection, uma funcionalidade do Java que permite a inspeção e manipulação do código em tempo de execução, torna possível acessar classes, métodos e atributos privados de forma dinâmica.</p>
<p>No contexto do Singleton, o Reflection pode comprometer a garantia de uma única instância. Através dele, é possível acessar e invocar o construtor privado, criando novas instâncias. Para ilustrar essa vulnerabilidade, realizaremos um "ataque" ao código do meu artigo anterior, utilizando o Reflection.</p>

```java
public static void main(String[] args)  {

    //Obtendo a instância única da classe BankAccountManager
    BankAccountManagerReflection manager1 = BankAccountManagerReflection.getInstance();
    BankAccountManagerReflection manager2 = BankAccountManagerReflection.getInstance();

    System.out.println("Instâncias iguais: " + (manager1 == manager2)); //true
    System.out.println("Manager1: " + manager1.hashCode()); //1595428806
    System.out.println("Manager2: " + manager2.hashCode()); //1595428806
}
```
<p>Neste trecho, a instância sempre retornará a mesma referência, independentemente do número de vezes que getInstance() for chamado.</p>

<p>O código abaixo simula o "ataque". Primeiramente, a classe BankAccountManagerReflection é obtida e, em seguida, o construtor privado é tornado acessível. Por fim, uma nova instância é criada, violando o princípio Singleton.</p>

```java
public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

    //Obtendo a instância única da classe BankAccountManager
    BankAccountManagerReflection manager1 = BankAccountManagerReflection.getInstance();
    BankAccountManagerReflection manager2 = BankAccountManagerReflection.getInstance();

    System.out.println("Instâncias iguais: " + (manager1 == manager2)); //true
    System.out.println("Manager1: " + manager1.hashCode()); //1595428806
    System.out.println("Manager2: " + manager2.hashCode()); //1595428806

    //Quebrando o Singleton
    Constructor<BankAccountManagerReflection> declaredConstructors = BankAccountManagerReflection.class.getDeclaredConstructor();
    declaredConstructors.setAccessible(true); //Tornando o construtor acessível
    manager1 = declaredConstructors.newInstance();
    manager2 = declaredConstructors.newInstance();

    System.out.println("\nInstâncias diferentes: " + (manager1 == manager2)); //false
    System.out.println("Manager1: " + manager1.hashCode()); //1072408673
    System.out.println("Manager2: " + manager2.hashCode()); //1531448569    
}
```
<p>Como podemos observar, os valores de hash são diferentes, confirmando a criação de múltiplas instâncias e a quebra do Singleton.</p>
<p>A melhor prática para proteger o Singleton contra ataques via Reflection é utilizar enums. O enum garante que apenas uma instância seja criada, mesmo em face do Reflection ou da serialização.</p>

```java
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
}
```
<p>Ao tentar acessar construtores via Reflection, o código lançará uma NoSuchMethodException, impedindo a quebra do Singleton e garantindo a segurança da aplicação. Com o enum, a instância é garantida, mesmo com o Reflection. Além disso, a serialização de enums é segura, pois a JVM garante que apenas uma instância seja criada, independentemente do número de vezes que o enum seja desserializado.</p>

<p>Em resumo, o Reflection é uma ferramenta poderosa, mas que deve ser utilizada com cautela. No contexto do Singleton, ele pode comprometer a garantia de uma única instância. Para proteger a aplicação, a melhor prática é utilizar enums, que garantem a segurança e a eficiência do padrão Singleton.</p>
