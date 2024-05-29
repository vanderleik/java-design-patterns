<h1>Factory Method</h1>

<p>O padrão de projeto Factory Method é um padrão criacional que define uma interface para a criação de objetos, promovendo a independência entre a criação e a utilização de um objeto. Isso permite que o sistema dependa de abstrações em vez de implementações concretas, que está em linha com o Dependency Inversion Principle (DIP) do S.O.L.I.D. e também com o Open/Close Principle (OCP) (tenho um artigo que fala sobre SOLID <a href="https://www.linkedin.com/pulse/princ%25C3%25ADpios-de-design-software-solid-vanderlei-kleinschmidt-klawe/?trackingId=Remz6xNjSzmLNzoJRpIDQQ%3D%3D">aqui</a>).</p>

<p>Esse é um dos padrões mais usados em Java, e resolve principalmente o problema de criação de objetos sem especificar a classe exata dos objetos que serão criados. Assim, a superclasse não sabe exatamente quais os tipos de objetos ela precisa criar, delegando a responsabilidade de criação para a subclasse, promovendo a reutilização de código, a flexibilidade do sistema e tornando a manutenção mais fácil.</p>

<p>O Factory Method Pattern é útil em diversas situações específicas, onde suas características de criação de objetos e desacoplamento podem trazer benefícios significativos. Algumas dessas situações são:</p>
<ul>
    <li>Quando a classe concreta a ser instanciada é desconhecida, podemos criar uma classe cujos tipos exatos são definidos pelas subclasses.</li>
    <li>Usamos para desacoplar o código cliente da lógica de criação de objetos.</li>
    <li>Para centralizar e encapsular a lógica de criação de objetos, especialmente quando essa lógica é complexa.</li>
    <li>Para facilitar a adição de novos tipos de objetos, sem modificar o código existente.</li>
</ul>

<p>O uso do Factory Method Pattern oferece diversas vantagens, como a redução do acoplamento entre o código que utiliza os objetos e as classes concretas, facilitando a adição de novos tipos de instâncias, além de simplificar a manutenção em função da centralização da lógica de criação. O padrão contribui significativamente para a aplicação dos princípios SOLID, como o DIP e o OCP.</p>

<p>Apesar de oferecer diversas vantagens, o Factory Method Pattern também apresenta algumas desvantagens que devem ser consideradas. O aumento da complexidade do código pode ser uma delas, pois sua utilização introduz múltiplas classes e interfaces, o que pode tornar o sistema como um todo mais difícil de entender e manter, especialmente se a equipe de desenvolvimento tiver pouca experiência.</p>

<p>Em projetos pequenos, o uso desse padrão pode parecer redundante (boilerplate) devido à necessidade de criar muitas classes e métodos, o que pode dificultar o rastreamento do fluxo de criação dos objetos.</p>

<p>Por esses motivos, o Factory Method Pattern deve ser evitado em projetos pequenos e simples, ou quando a criação de objetos simples é o objetivo. Também devemos evitar esse padrão quando a composição for preferível à herança, ou seja, quando a construção de classes envolve o uso de referências a outras classes, delegando o comportamento a esses objetos através da injeção de dependências.</p>

<p>Para ilustrar o uso do Factory Method Pattern na prática, imagine um banco que oferece empréstimos para seus clientes pessoas físicas. O mercado bancário oferece diversos tipos de empréstimos, como empréstimo pessoal com ou sem garantia, consignado (para aposentados, pensionistas, colaboradores de empresas privadas ou funcionários públicos), crédito pessoal, cheque especial, antecipação do FGTS, do 13º salário e da restituição do Imposto de Renda, financiamentos de imóveis, veículos ou eletrodomésticos, entre muitos outros.</p>

<p>Na prática, podemos criar uma estrutura em que cada tipo de empréstimo é tratado como um produto concreto, e uma fábrica é responsável por criar instâncias desses produtos. O primeiro passo, então, é definir uma interface para os empréstimos.</p>

```java
package interfaces;

public interface Emprestimo {
    void calcularJuros();
}
```
<p>O próximo passo é implementar cada tipo de empréstimo de forma concreta.</p>

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

<p>Em seguida, definimos uma fábrica, ou classe abstrata "EmpréstimoFactory", com um método para criar empréstimos.</p>

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

<p>Em seguida, criamos as fábricas concretas, ou subclasses, para cada tipo de empréstimo.</p>

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

<p>Por fim, podemos usar as fábricas para criar e processar diferentes tipos de empréstimos.</p>

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
<p>Vamos analisar o código apresentado. A interface "Empréstimo" define a interface comum para todos os tipos de empréstimos. As classes concretas "CdcEmprestimo", "ConsignadoInssEmprestimo" e "BemImovelEmprestimo" implementam a interface "Empréstimo" e fornecem a lógica específica para cada tipo de empréstimo.</p>

<p>A classe abstrata “EmprestimoFactory” define o método abstrato “criarEmprestimo” e um método concreto “processarEmprestimo” que utiliza o produto criado. Cada fábrica concreta (”CdcEmprestimoFactory”, “ConsignadoInssEmprestimoFactory” e “BemImovelEmprestimoFactory”) implementa o método “criarEmprestimo” para retornar uma instância específica do tipo de empréstimo.</p>
