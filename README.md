<p>Resolver problemas é a tarefa mais importante de um desenvolvedor de software. Diariamente precisamos lidar com situações que em algum momento no passado nós tratamos, ou foram tratadas por algum colega de trabalho. Se analisarmos com cuidado encontraremos certos padrões nesses problemas, e a melhor forma de resolver isso é utilizando modelos testados que comprovadamente são eficientes para lidar com essas situações. O que eu estou querendo dizer é que, para resolver problemas que se repetem como em um padrão, devemos igualmente adotar um padrão para solucionar, ou seja, um Design Pattern. </p>
<p>Conceitualmente falando, e citando o <a href="https://refactoring.guru/design-patterns">Refactoring Guru</a>, 
</p>
<blockquote cite="https://refactoring.guru/pt-br/design-patterns">
  <p>"<strong>Padrões de projeto</strong> (design patterns) são soluções típicas para problemas comuns em projeto de software. Cada padrão é como uma planta de construção que você pode customizar para resolver um problema de projeto particular em seu código."</p>
</blockquote>

<p>Quando estamos construindo uma casa nós nos baseamos em plantas para diferentes tipos de ambientes que se adaptam às nossas necessidades. Com os Design Patterns a lógica é parecida, resolvemos problemas usando soluções comprovadas e que seguem um determinado padrão, tornando o código fácil de entender e dar manutenção, adaptável a mudanças futuras e, cujos códigos podem ser reutilizados em oturos projetos.</p>

<p>Para facilitar o estudo dos padrões de projeto eu dividi eles em três grandes grupos:</p>
<ul>
    <li>Padrões Essenciais (Conhecimento Básico);</li>
    <li>Padrões Intermediários (Aprofundamento);</li>
    <li>Padrões Avançados (Para Casos Específicos).</li>
</ul>

<h3>Padrões Essenciais (Conhecimento Básico):</h3>
<p>Começar pelos Padrões Essenciais nos dá uma base sólida em conceitos fundamentais de design de software. Ao estudá-los entenderemos como resolver problemas comuns com soluções reutilizáveis. Essa base é muito importante para absorver e aplicar os padrões mais complexos posteriormente.</p>

<p>Os padrões que serão objetos de estudo são:</p>
<ul>
    <li><strong>Criacionais:</strong>
        <ul>
            <li><strong>Factory Method:</strong> Abstrai a criação de objetos, permitindo que você personalize o processo.</li>
            <li><strong>Abstract Factory:</strong> Cria famílias de objetos relacionados, ideal para cenários com múltiplas configurações.</li>
            <li><strong>Singleton: </strong>Garante que apenas uma instância de uma classe seja criada, útil para gerenciar recursos compartilhados.</li>
        </ul>
    </li>
    <li><strong>Estruturais:</strong>
        <ul>
            <li><strong>Adapter:</strong> Permite que classes com interfaces incompatíveis trabalhem juntas.</li>
            <li><strong>Decorator: </strong>Adiciona funcionalidades dinamicamente a um objeto, sem modificá-lo diretamente.</li>
        </ul>
    </li>
    <li><strong>Comportamentais:</strong>
        <ul>
            <li><strong>Observer:</strong> Permite que objetos dependentes sejam notificados de mudanças em um objeto observável.</li>
            <li><strong>Strategy:</strong> Permite que você altere o algoritmo de um objeto em tempo de execução.</li>
            <li><strong>Template Method:</strong> Define o esqueleto de um algoritmo, deixando detalhes específicos para subclasses.</li>
        </ul>
    </li>
</ul>

<h3>Padrões Intermediários (Aprofundamento):</h3>
<p>Depois de estudar os padrões essenciais nós vamos nos aprofundar um pouco partindo para os de nível intermediário. Aqui exploraremos:</p>
<ul>
    <li><strong>Criacionais:</strong></li>
    <ul>
        <li><strong>Builder:</strong> Constrói objetos complexos passo a passo, oferecendo flexibilidade e controle.</li>
        <li><strong>Prototype:</strong> Cria novas instâncias clonando objetos existentes, economizando tempo e recursos.</li>
    </ul>
    <li><strong>Estruturais:</strong></li>
    <ul>
        <li><strong>Facade: </strong>Fornece uma interface simplificada para um subsistema complexo.</li>
        <li><strong>Composite: </strong>Compõe objetos em estruturas hierárquicas, permitindo tratar objetos individuais e composições da mesma forma.</li>
    </ul>
    <li><strong>Comportamentais:</strong></li>
        <ul>
            <li><strong>Command: </strong>Encapsula uma requisição como um objeto, permitindo desacoplar o emissor da requisição do executor.</li>
            <li><strong>Iterator: </strong>Permite percorrer os elementos de um objeto agregado sem expor sua representação interna.</li>
            <li><strong>Mediator: </strong>Define um objeto que encapsula a interação entre um conjunto de objetos, simplificando a comunicação e evitando acoplamentos diretos.</li>
        </ul>
</ul>

<h3>Padrões Avançados (Para Casos Específicos):</h3>

<p>Por fim, precisamos conhecer alguns casos específicos de padrões, ou seja os de complexidade maior o que requererá um tempo maior de estudo e aperfeiçoamento. Abaixo so padrões que serão estudados:</p>

<ul>
    <li><strong>Criacionais:</strong></li>
    <ul>
        <li><strong>Flyweight: </strong>Compartilha objetos imutáveis para otimizar o uso de memória.</li>
    </ul>
    <li><strong>Estruturais:</strong></li>
    <ul>
        <li><strong>Proxy: </strong>Fornece um substituto para outro objeto, controlando o acesso a ele.</li>
    </ul>
    <li><strong>Comportamentais:</strong></li>
    <ul>
        <li><strong>Chain of Responsibility:</strong> Encadeia objetos que podem tratar uma requisição.</li>
        <li><strong>State: </strong>Permite que um objeto altere seu comportamento em tempo de execução, dependendo de seu estado interno.</li>
        <li><strong>Memento: </strong>Captura e preserva o estado interno de um objeto, permitindo restaurar para um estado anterior.</li>
    </ul>
</ul>

<h3>Dicas para Dominar os Padrões:</h3>
<ul>
    <li>Aprenda os princípios SOLID: Eles guiam a utilização dos padrões e ajudam a escrever código mais limpo, flexível e manutenível.</li>
    <li>Pratique: Implemente os padrões em seus próprios projetos. Comece com exemplos simples e depois vá para casos mais complexos.</li>
    <li>Estude exemplos: Explore bibliotecas e frameworks Java populares para ver como eles usam padrões de projeto.</li>
    <li>Refatore seu código: Utilize padrões para melhorar o código existente, tornando-o mais flexível e reutilizável.</li>
    <li>Participe da comunidade: Interaja com outros desenvolvedores para aprender, compartilhar experiências e discutir boas práticas.</li>
    <li>Lembre-se: dominar padrões de projeto não é um processo rápido, mas o esforço vale a pena. Com a prática e a dedicação, você se tornará um programador Java mais eficiente, criativo e capaz de construir sistemas de software robustos e escaláveis.# java-design-patterns.</li>
</ul>
