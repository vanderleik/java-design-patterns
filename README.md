<h1>Explorando Design Patterns: Um Caminho para Soluções Eficientes em Desenvolvimento de Software</h1>

<h4>Texto publicado originalmente no <a href="https://www.linkedin.com/pulse/explorando-design-patterns-um-caminho-para-solu%25C3%25A7%25C3%25B5es-em-kleinschmidt-2uimf">Linkedin</a></h4>

<h3>Introdução</h3>

<p>Resolver problemas é a tarefa mais importante de um desenvolvedor de software. Diariamente, lidamos com situações que já enfrentamos no passado ou que foram resolvidas por algum colega de trabalho. Ao analisarmos esses problemas com cuidado, percebemos certos padrões. Para lidar com essas situações repetitivas de forma eficiente, a melhor abordagem é utilizar modelos testados e comprovadamente eficazes, os chamados Design Patterns. Em outras palavras, para resolver problemas que se repetem de forma padronizada, devemos adotar um padrão de solução, ou seja, um Design Pattern.</p>
<p>Conceitualmente falando, e citando o <a href="https://refactoring.guru/design-patterns">Refactoring Guru</a>, 
</p>
<blockquote cite="https://refactoring.guru/pt-br/design-patterns">
  <p>"<strong>Padrões de projeto</strong> (design patterns) são soluções típicas para problemas comuns em projeto de software. Cada padrão é como uma planta de construção que você pode customizar para resolver um problema de projeto particular em seu código."</p>
</blockquote>

<p>Quando construímos uma casa, nos baseamos em plantas para diferentes tipos de ambientes que se adaptam às nossas necessidades. Com os Design Patterns, a lógica é similar: resolvemos problemas usando soluções comprovadas que seguem um determinado padrão, tornando o código fácil de entender e de dar manutenção, adaptável a mudanças futuras e reutilizável em outros projetos.</p>

<p>Para facilitar o estudo dos padrões de projeto, dividi-os em três grandes grupos:</p>
<ul>
    <li>Padrões Essenciais (Conhecimento Básico);</li>
    <li>Padrões Intermediários (Aprofundamento);</li>
    <li>Padrões Avançados (Para Casos Específicos).</li>
</ul>

<h3>Padrões Essenciais (Conhecimento Básico):</h3>

<p>Começar pelos Padrões Essenciais nos fornece uma base sólida em conceitos fundamentais de design de software. Ao estudá-los, entenderemos como resolver problemas comuns com soluções reutilizáveis. Essa base é crucial para absorver e aplicar os padrões mais complexos posteriormente.</p>

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
<p>Depois de estudar os padrões essenciais, daremos um passo adiante, expandindo os conceitos aprendidos anteriormente e adicionando sofisticação e flexibilidade. Com isso, estaremos aptos a lidar com problemas mais complexos, porém, dentro de um contexto familiar.</p>
<p>Aqui exploraremos:</p>
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

<p>Por fim, precisamos conhecer alguns casos específicos de padrões, ou seja, os de complexidade maior, como otimização de desempenho ou gerenciamento de estado. Para isso, precisamos de uma base sólida e não podemos queimar etapas.</p>
<p>Abaixo so padrões que serão estudados:</p>

<ul>    
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

<h3>Conclusão</h3>
<p>Estudar os padrões de projeto é um passo fundamental para qualquer desenvolvedor que busca soluções eficientes e reutilizáveis para problemas recorrentes. Para conseguir evoluir nos estudos, precisamos de uma sequência lógica, como a que apresentei aqui neste artigo, começando com os conceitos básicos e evoluindo para os casos mais complexos.</p>
<p>O repositório com o estudo completo está disponível no meu <a href="https://github.com/vanderleik/java-design-patterns">GitHub</a>. Talvez no momento em que você está lendo este artigo, nem todos os padrões estejam lá com seus exemplos, mas à medida que eu conseguir tempo para montar o estudo com exemplos práticos, irei atualizando o repositório.</p>
