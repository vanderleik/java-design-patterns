<h1>Abstract Factory</h1>

<h4>Texto publicado originalmente no <a href="https://www.linkedin.com/pulse/abstract-factory-criando-fam%25C3%25ADlias-de-objetos-vanderlei-kleinschmidt-my2rf">Linkedin</a></h4>

<p>O Abstract Factory é um padrão de projeto criacional para criar famílias de objetos. 
Ele fornece uma abstração para a criação de objetos, onde você escolhe a família sem precisar conhecer
a implementação específica de cada uma delas, promovendo maior flexibilidade e adaptabilidade do código 
a mudanças.</p>

<p>Embora compartilhem o mesmo nome, o Factory Method (descrito <a href="https://www.linkedin.com/pulse/factory-method-uma-abordagem-modular-para-cria%2525C3%2525A7%2525C3%2525A3o-de-kleinschmidt-bosaf/?trackingId=RzQAuhwBQdGNqINkRqwshg%3D%3D" target="_blank">aqui</a>
) e o Abstract Factory possuem diferenças importantes. Enquanto o primeiro define um
método abstrato para criar objetos, distribuindo a responsabilidade pela criação entre a classe abstrata
e suas subclasses, o segundo define uma interface abstrata para criar famílias 
de objetos relacionados, concentrando a lógica de criação nas fábricas concretas.</p>

<p>O quadro abaixo apresenta a diferença entre esses dois padrões de projetos:</p>
<table>
    <thead>
        <tr>
            <th>Característica</th>
            <th>Factory Method</th>
            <th>Abstract Factory</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>Nível de abstração</td>
            <td>Método abstrato</td>
            <td>Interface abstrata</td>
        </tr>
        <tr>
            <td>Gerenciamento de famílias de produtos</td>
            <td>Um tipo de objeto por vez</td>
            <td>Famílias de objetos relacionados</td>
        </tr>
        <tr>
            <td>Flexibilidade</td>
            <td>Permite personalização pelas subclasses</td>
            <td>Maior flexibilidade para troca de famílias de produtos</td>
        </tr>
    </tbody>
</table>

<h2>Analogia entre Factory Method e Abstract Factory em Empréstimos Bancários</h2>

<p>Considere um banco que oferece uma variedade de empréstimos aos seus clientes. 
Os padrões <strong>Factory Method</strong> e <strong>Abstract Factory</strong> podem ser utilizados para modelar o processo de criação de empréstimos da seguinte maneira:</p>

<ul>
    <li><strong>Factory Method</strong>:</li>
        <ul>
            <li><strong>Agência bancária</strong>: Funciona como a classe abstrata.</li>
            <li><strong>Gerente de crédito</strong>: Funciona como o método abstrato criarEmprestimo().</li>
            <li><strong>Tipos de empréstimo</strong>: Funciona como as subclasses (EmprestimoPessoal, EmprestimoImobiliario, EmprestimoAuto).</li>
            <li><strong>Cliente</strong>: Solicita um empréstimo ao gerente de crédito.</li>
            <li><strong>Processo</strong>: O gerente de crédito analisa o perfil do cliente e decide qual tipo de empréstimo é mais adequado. Ele então instancia a classe concreta correspondente (por exemplo, EmprestimoPessoal) e configura os detalhes do empréstimo.</li>
        </ul>
    <li><strong>Abstract Factory</strong>:</li>
        <ul>
            <li><strong>Banco</strong>: Funciona como a interface abstrata.</li>
            <li><strong>Fábricas de empréstimos</strong>: Funciona como as fábricas concretas (FabricaEmprestimosPessoais, FabricaEmprestimosImobiliarios, FabricaEmprestimosAuto).</li>
            <li><strong>Tipos de empréstimo</strong>: Cada fábrica de empréstimos cria seus próprios tipos de empréstimo (por exemplo, EmprestimoPessoalPF, EmprestimoImobiliarioPJ, EmprestimoAutoUsado).</li>
            <li><strong>Cliente</strong>: Seleciona a fábrica de empréstimos desejada e solicita um empréstimo.</li>
            <li><strong>Processo</strong>: A fábrica de empréstimos selecionada cria o tipo de empréstimo específico e configura os detalhes do empréstimo.</li>
        </ul>
    <li><strong>Diferenças</strong>:</li>
        <ul>
            <li><strong>Factory Method</strong>: Cada cliente recebe um único tipo de empréstimo, definido pelo gerente de crédito.</li>
            <li><strong>Abstract Factory</strong>: Cada cliente pode receber um conjunto de empréstimos relacionados, de acordo com a fábrica de empréstimos selecionada.</li>
        </ul>
</ul>

<p>Vamos ilustrar como isso funciona na prática por meio de um exemplo onde criaremos um banco que oferece empréstimos para seus clientes pessoa física. Portanto, o primeiro passo é definir uma interface abstrata para representar o banco:</p>

```java
public interface Banco {
    Emprestimo criarEmprestimo(TipoEmprestimo tipoEmprestimo, double valor, int prazo, double taxaJuros);
}
```

<p>O código define uma interface chamada <code>Banco</code> com um único 
método, <code>criarEmprestimo</code>. Este método recebe quatro parâmetros:</p>

<ol>
    <li><code>tipoEmprestimo</code>: Um valor de <code>enum</code> que representa o tipo de empréstimo.</li>
    <li><code>valor</code>: O valor do empréstimo.</li>
    <li><code>prazo</code>: O prazo do empréstimo em meses.</li>
    <li><code>taxaJuros</code>: A taxa de juros.</li>
</ol>

<p>O uso de um enum para <code>TipoEmprestimo</code> promove a integridade dos dados e a segurança do tipo.
Os parâmetros do método <code>criarEmprestimo</code> representam os atributos essenciais de um empréstimo.
Retornar um objeto abstrato <code>Emprestimo</code> permite diferentes implementações concretas de empréstimos.
</p>
<p>A criação de uma interface FabricaEmprestimo está alinhada com o princípio SOLID de responsabilidade única.</p>
<p>O próximo passo é criar as fábricas de empréstimo, e seguindo os princípios <code>SOLID</code>, 
primeiro criamos uma interface para a <code>FabricaEmprestimo</code>:</p>

```java
public interface FabricaEmprestimo {

    Emprestimo criarEmprestimo(TipoEmprestimo tipoEmprestimo, double valor, int prazo, double taxaJuros);
}
```

<p>Em seguida criamos as fábricas concretas:</p>

```java
public class FabricaEmprestimosPessoais implements FabricaEmprestimo {

    @Override
    public Emprestimo criarEmprestimo(TipoEmprestimo tipoEmprestimo, double valor, int prazo, double taxaJuros) {
        if (tipoEmprestimo == TipoEmprestimo.PESSOAL) {
            return new EmprestimoPessoalPF(valor, prazo, taxaJuros);
        } else {
            throw new IllegalArgumentException("Tipo de empréstimo inválido: " + tipoEmprestimo);
        }
    }
}
```

```java
public class FabricaEmprestimosAuto implements FabricaEmprestimo {

    @Override
    public Emprestimo criarEmprestimo(TipoEmprestimo tipoEmprestimo, double valor, int prazo, double taxaJuros) {
        if (tipoEmprestimo == TipoEmprestimo.AUTO) {
            return new EmprestimoAutoUsado(valor, prazo, taxaJuros);
        } else {
            throw new IllegalArgumentException("Tipo de empréstimo inválido: " + tipoEmprestimo);
        }
    }

}
```

```java
public class FabricaEmprestimosImobiliarios implements FabricaEmprestimo {

    @Override
    public Emprestimo criarEmprestimo(TipoEmprestimo tipoEmprestimo, double valor, int prazo, double taxaJuros) {
        if (tipoEmprestimo == TipoEmprestimo.IMOBILIARIO) {
            return new EmprestimoImobiliarioPJ(valor, prazo, taxaJuros);
        } else {
            throw new IllegalArgumentException("Tipo de empréstimo inválido: " + tipoEmprestimo);
        }
    }
}
```

<p>Cada classe de fábrica concreta implementa o método <code>criarEmprestimo</code>, que recebe quatro parâmetros:</p>

<ol>
    <li><code>tipoEmprestimo</code>: O tipo de empréstimo como valor de <code>enum</code>.</li>
    <li><code>valor</code>: O valor do empréstimo.</li>
    <li><code>prazo</code>: O prazo do empréstimo em meses.</li>
    <li><code>taxaJuros</code>: A taxa de juros.</li>
</ol>

<p>O método <code>criarEmprestimo</code> primeiro verifica o parâmetro <code>tipoEmprestimo</code> 
para determinar o tipo de empréstimo a ser criado. Se o <code>tipoEmprestimo</code> corresponder 
ao tipo de empréstimo oferecido pela fábrica, ele instancia o objeto de empréstimo concreto apropriado
(por exemplo, <code>EmprestimoImobiliarioPJ</code>, <code>EmprestimoAutoUsado</code>, <code>EmprestimoPessoalPF</code>)
utilizando os parâmetros do empréstimo fornecidos.</p>
<p>Se o <code>tipoEmprestimo</code> não corresponder ao tipo de empréstimo da fábrica, uma 
<code>IllegalArgumentException</code> é lançada, indicando que os argumentos de entrada são inválidos.</p>

<p>Observe que cada fábrica de empréstimo possui um tipo de empréstimo concreto específico. Esses tipos podem ser visualizados a seguir:</p>

```java
public class EmprestimoPessoalPF extends Emprestimo {

    public EmprestimoPessoalPF(double valor, int prazo, double taxaJuros) {
        super(valor, prazo, taxaJuros);
    }

    @Override
    public double calcularParcela(double valor, int prazo, double taxaJuros) {
        return valor * (taxaJuros / 100 / 12) * Math.pow(1 + taxaJuros / 100 / 12, prazo) / (Math.pow(1 + taxaJuros / 100 / 12, prazo) - 1);
    }

    @Override
    public void imprimirDetalhes() {
        super.imprimirDetalhes();
    }
}
```
```java
public class EmprestimoAutoUsado extends Emprestimo {

    public EmprestimoAutoUsado(double valor, int prazo, double taxaJuros) {
        super(valor, prazo, taxaJuros);
    }

    @Override
    public double calcularParcela(double valor, int prazo, double taxaJuros) {
        return valor * (taxaJuros / 100 / 12) * Math.pow(1 + taxaJuros / 100 / 12, prazo) / (Math.pow(1 + taxaJuros / 100 / 12, prazo) - 1);
    }

    @Override
    public void imprimirDetalhes() {
        super.imprimirDetalhes();
    }

}
```

```java
public class EmprestimoImobiliarioPJ extends Emprestimo {

    public EmprestimoImobiliarioPJ(double valor, int prazo, double taxaJuros) {
        super(valor, prazo, taxaJuros);
    }

    @Override
    public double calcularParcela(double valor, int prazo, double taxaJuros) {
        return valor * (taxaJuros / 100 / 12) * Math.pow(1 + taxaJuros / 100 / 12, prazo) / (Math.pow(1 + taxaJuros / 100 / 12, prazo) - 1);
    }

    @Override
    public void imprimirDetalhes() {
        super.imprimirDetalhes();
    }

}
```
<p>As classes <code>EmprestimoPessoalPF</code>, <code>EmprestimoAutoUsado</code> e <code>EmprestimoImobiliarioPJ</code> 
são subclasses da classe abstrata <code>Emprestimo</code>. Elas representam diferentes tipos de empréstimos com características 
e métodos específicos. Todas herdam os seus atributos e métodos, como valor, prazo, 
taxa e métodos para calcular juros e imprimir detalhes. As classes diferenciam-se no método <code>calcularParcela</code>, que implementa a fórmula específica para calcular a parcela 
mensal do empréstimo, considerando o tipo e as suas características.
</p>

<p>Agora, o cliente se dirige ao banco, seleciona a fábrica de empréstimos desejada e solicita um empréstimo. A fábrica de empréstimos selecionada, por sua vez, cria o tipo de empréstimo específico e configura os seus detalhes.</p>

```java
public class Main {
    public static void main(String[] args) {
        Banco banco = new BancoNacional();
        double valor = 100.0;
        int prazo = 10;
        double taxaJuros = 1.5;

        //Solicitando um empréstimo pessoal
        Emprestimo emprestimoPessoal = banco.criarEmprestimo(TipoEmprestimo.PESSOAL, valor, prazo, taxaJuros);
        System.out.println("\nEmpréstimo pessoal PF criado: ");
        emprestimoPessoal.imprimirDetalhes();

        //Solicitando um empréstimo imobiliário
        Emprestimo emprestimoImobiliario = banco.criarEmprestimo(TipoEmprestimo.IMOBILIARIO, valor, prazo, taxaJuros);
        System.out.println("\nEmpréstimo imobiliário criado: ");
        emprestimoImobiliario.imprimirDetalhes();

        //Solicitando um empréstimo auto
        Emprestimo emprestimoAuto = banco.criarEmprestimo(TipoEmprestimo.AUTO, valor, prazo, taxaJuros);
        System.out.println("\nEmpréstimo auto criado: ");
        emprestimoAuto.imprimirDetalhes();

    }
}
```

<p>Um objeto <code>Banco</code> é criado utilizando a implementação concreta <code>BancoNacional</code>. O código itera por três tipos de empréstimos: pessoal, imobiliário e auto. Para cada tipo, um objeto <code>Emprestimo</code> é criado usando o método <code>banco.criarEmprestimo</code>, especificando o tipo, valor, prazo e taxa de juros. Os detalhes são impressos usando o método <code>emprestimo.imprimirDetalhes()</code>.</p>

<p>Portanto, o Abstract Factory se destaca como um padrão de projeto para criar famílias de objetos de forma flexível e adaptável. No contexto de empréstimos bancários, permite que os bancos ofereçam uma variedade de opções aos seus clientes, atendendo às suas necessidades e preferências de maneira personalizada. Ele também garante a utilização dos princípios do SOLID, dando maior flexibilidade, facilitando a adaptação a mudanças, reuso de código e maior testabilidade.</p>