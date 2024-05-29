<h1>Factory Method</h1>

<p>O Factory Method Pattern é um padrão criacional de projetos que define uma interface para criar um objeto, promovendo a independência entre a criação de um objeto e a sua utilização, permitindo que o sistema dependa de abstrações em vez de implementações concretas. Isso está em linha com o Dependency Inversion Principle (DIP) do S.O.L.I.D. e também o Open/Close Principle (OCP) (tenho um artigo que fala sobre SOLID aqui).</p>

<p>Esse é um dos patterns mais usados em Java, e resolve principalmente o problema de criação de objetos sem especificar a classe exata dos objetos que serão criados. Assim, a superclasse não sabe exatamente quais os tipos de objetos ela precisa criar, delegando a responsabilidade de criação para a subclasse, promovendo a reutilização de código, a flexibilidade do sistema e facilitando a sua manutenção.</p>

<p>O Factory Method Pattern deve ser usado em várias situações específicas onde suas características de criação de objetos e desacoplamento podem trazer benefícios significativos. Aqui estão algumas dessas situações:</p>
<ul>
    <li>Quando ainda não tenho certeza sobre qual classe concreta eu devo instanciar, podemos criar uma classe cujos tipos exatos só são conhecidos pelas subclasses.</li>
    <li>Usamos para desacoplar o código Cliente da lógica de criação de objetos.</li>
    <li>Para centralizar e encapsular a lógica de criação de objetos (quando ela é complexa).</li>
    <li>Para facilitar a adição de novos tipos de objetos.</li>
</ul>

<p>Usar o Factory Method Pattern traz muitas vantagens como a redução do acoplamento entre o código que usa os objetos e as classes concretas dos objetos, adicionar novos tipos de objetos é facilitada, assim como a sua manutenção em função da centralização da lógica de criação, e principalmente para promover o uso dos princípios SOLID como o DIP e o OCP.</p>

<p>Embora ofereça várias vantagens, ele também apresenta algumas desvantagens que devemos considerar. O aumento da complexidade do código pode ser uma delas porque com o uso do Factory Method estamos introduzindo múltiplas classes e interfaces que pode tornar o sistema como um todo mais difícil de entender e manter, principalmente se a senioridade do time de desenvolvedores for muito júnior.</p>

<p>Usar esse padrão em projetos pequenos pode parecer boilerplate por causa da necessidade de criar muitas classes e métodos, o que também pode causar uma certa dificuldade em rastrear o fluxo de criação dos objetos.</p>

<p>Por esses motivos, devemos evitar o Factory Method Pattern em projetos pequenos e simples, ou quando queremos criar objetos simples. Também devemos evitar esse padrão quando preferirmos a composição ao invés da herança, ou seja, construir classes usando referências a outras classes, delegando o comportamento para esses objetos através da injeção de dependências.</p>

<p>Para trazemos esse padrão de projetos para a vida real, vamos pensar em um banco que oferece empréstimos para seus clientes pessoas físicas. São vários os tipos de empréstimo disponível no mercado bancário, como por exemplo empréstimo pessoal com garantia ou sem garantia, consignado (para aposentados e pensionistas, colaboradores de empresas privadas ou funcionários públicos), crédito pessoal, cheque especial, antecipação do FTGS, do 13º salário e da restituição do Imposto de Renda, financiamentos diversos como o de imóveis, veículos ou eletrodomésticos, entre muitos outros.</p>

<p>Em termos práticos, podemos criar uma estrutura onde cada tipo de empréstimo é tratado como um produto concreto, e uma fábrica é responsável por criar instâncias desses produtos. O primeiro passo então, é definir uma interface para os empréstimos.</p>

```java
package interfaces;

public interface Emprestimo {
    void calcularJuros();
}
```
<p>O próximo passo é  fazer as implementações concretas para cada tipo de empréstimo.</p>

```java
package produtos_concretos;

import interfaces.Emprestimo;

public class ConsignadoInssEmprestimo implements Emprestimo {

    @Override
    public void calcularJuros() {
        System.out.println("Calculando juros para o empréstimo consignado INSS...");
    }

}
```

```java
package produtos_concretos;

import interfaces.Emprestimo;

public class CdcEmprestimo implements Emprestimo {

    @Override
    public void calcularJuros() {
        System.out.println("Calculando juros para o CDC...");
    }

}
```

```java
package produtos_concretos;

import interfaces.Emprestimo;

public class BemImovelEmprestimo implements Emprestimo {

    @Override
    public void calcularJuros() {
        System.out.println("Calculando juros para o empréstimo com bem imóvel...");
    }

}
```

<p>A seguir, definimos uma fábrica ou classe abstrata “EmprestimoFactory” com um método para criar empréstimos.</p>

```java
package fabrica;

import interfaces.Emprestimo;

public abstract class EmprestimoFactory {

    public abstract Emprestimo criarEmprestimo();

    public void processarEmprestimo() {
        Emprestimo emprestimo = criarEmprestimo();
        emprestimo.calcularJuros();
    }
}
```

<p>Depois criamos as fábricas concretas ou subclasses para cada tipo de empréstimo.</p>

```java
package fabrica.fabrica_concreta;

import fabrica.EmprestimoFactory;
import interfaces.Emprestimo;
import produtos_concretos.ConsignadoInssEmprestimo;

public class ConsignadoInssEmprestimoFactory extends EmprestimoFactory {

    @Override
    public Emprestimo criarEmprestimo() {
        return new ConsignadoInssEmprestimo();
    }

}
```

```java
package fabrica.fabrica_concreta;

import fabrica.EmprestimoFactory;
import interfaces.Emprestimo;
import produtos_concretos.CdcEmprestimo;

public class CdcEmprestimoFactory extends EmprestimoFactory {

    @Override
    public Emprestimo criarEmprestimo() {
        return new CdcEmprestimo();
    }

}
```

```java
package fabrica.fabrica_concreta;

import fabrica.EmprestimoFactory;
import interfaces.Emprestimo;
import produtos_concretos.BemImovelEmprestimo;

public class BemImovelEmprestimoFactory extends EmprestimoFactory {

    @Override
    public Emprestimo criarEmprestimo() {
        return new BemImovelEmprestimo();
    }

}
```

<p>Finalmente, podemos usar as fábricas para criar diferentes tipos de empréstimos e processá-los.</p>

```java
import fabrica.EmprestimoFactory;
import fabrica.fabrica_concreta.*;

public class Main {
    public static void main(String[] args) {

        EmprestimoFactory factory;

        //Processar empréstimo CDC
        factory = new CdcEmprestimoFactory();
        factory.processarEmprestimo(); //Output: Calculando juros para o CDC...
        
        // Processar empréstimo consignado para aposentados e pensionistas do INSS
        factory = new ConsignadoInssEmprestimoFactory();
        factory.processarEmprestimo(); //Output: Calculando juros para o empréstimo consignado INSS...
        
        // Processar empréstimo para compra de bens imóveis
        factory = new BemImovelEmprestimoFactory();
        factory.processarEmprestimo(); // Output: Calculando juros para o empréstimo com bem imóvel...
    }
    
}
```
<p>Vamos entender o código acima. A interface “Emprestimo” define a interface comum para todos os tipos de empréstimos. As classes concretas “CdcEmprestimo”, “ConsignadoInssEmprestimo” e “BemImovelEmprestimo” implementam a interface “Emprestimo” e fornecem a lógica para cada tipo de empréstimo.</p>

<p>A classe abstrata “EmprestimoFactory” define o método abstrato “criarEmprestimo” e um método concreto “processarEmprestimo” que utiliza o produto criado. Cada fábrica concreta (”CdcEmprestimoFactory”, “ConsignadoInssEmprestimoFactory” e “BemImovelEmprestimoFactory”) implementa o método “criarEmprestimo” para retornar uma instância específica do tipo de empréstimo.</p>
