# iFace
<h2> Para executar: </h2>
- Pasta Main e executar a classe main "iFace"
<h2> Exceptions </h2>
<h3> Exceptions do JAVA utilizadas </h3>
<ul>
  <li><strong>NumberFormatException</strong>: Para tratar entradas que só podem ser números.</li>
  <li><strong>IndexOutOfBoundsException</strong>: Para tratar acesso à um index inexistente.</li>
</ul>
<h3> Exceptions criadas utilizadas para regras de negócio </h3>
<ul>
  <li><strong>CpfValidoException</strong>: Verifica se o cpf é válido com 11 dígitos.</li>
  <li><strong>NaoEhEmailException</strong>: Verifica se o e-mail tem pelo menos um '@', caso contrário é inválido.</li>
  <li><strong>NaoEhOpcaoException</strong>: Verifica se a opção do menu existe.</li>
  <li><strong>SomenteLetrasException</strong>: Verifica se a entrada tem somente letras, para tratar o nome do usuário.</li> 
  <li><strong>SomenteNumeroException</strong>: Verifica se a entrada tem somente números, em caso de verificar a idade ou CPF do usuário.</li>
</ul>
<h2> Code Smells </h2>
<ol>
  <li><strong>Código grande (Bloaters)</strong></li>
  <ul>
  <li><strong>A presença de menus na classe main</strong>: Poderia estar em uma classe de menus </li>
    <ul>
      <li>Linha 49 da classe main "Iface"</li>
      <li>Linha 92 da classe main "Iface"</li>
      <li>Linha 125 da classe main "Iface"</li>
      <li>Linha 264 da classe main "Iface"</li>
  </ul>
    <li><strong>"switch case" não deveria ter muitas linhas</strong>: Poderia colocar as linhas em métodos e no switch só chamar esses métodos.</li>
     <ul>
      <li>Linha 325 da classe main "Iface"</li>
  </ul>
  </ul>
  <li><strong>"switch case" não deveria ter muitas linhas</strong>: Poderia colocar as linhas em métodos e no switch só chamar esses métodos.</li>
  </ul>
  <li><strong>Switch dentro de outro switch</strong></li>
  <ul>
  <li><strong>Linha: 176 da classe main "Iface"</strong>:Um switch dentro de outro switch que tem o papel de administrar as opções do menu. Poderia ser feito era um método com as funções desse switch e só precisar chamar. </li>
  <li><strong>Linha: 278 da classe main "Iface"</strong>:Um switch dentro de outro switch que está dentro de outro switch e tem o papel de administrar novamente um menu das comunidades. Poderia ser resolvido com a criação de um método dentro da classe "Comunidade" e depois só chamar.</li>
  </ul>
  <li><strong>Trechos desnecessários de código</strong></li>
    <ul>
      <li><strong>Variáveis desnecessárias: </strong> </li>
        <ul>
          <li>Linha 33 da classe main "Iface"</li>
          <li>Linhas 53, 61, 69, 96 e 100 da classe main "Iface": Poderia colocar direto em um objeto e depois colocar como parâmetro no método chamado.</li>
          <li>Linhas 199, 227, 261, 284 da classe main "Iface": Poderiam ser substituídas por somente uma variável (a que foi criada na linha 122), já que elas tem uma única função de ler a opção.</li>
          <li>Linhas 148, 155, 170, 189 e 212  da classe "Conta": Poderiam ser substituídas por somente uma variável (criada fora do switch), já que elas tem uma única função de ler a entrada de String.</li>
        </ul>
      <li><strong>Parâmetros nunca utilizados: </strong> </li>
  
        <ul>
          <li>Linha 29  classe "Iface"</li>
          <li>Linhas 53, 61, 69, 96 e 100 da classe main "Iface": Poderia colocar direto em um objeto e depois colocar como parâmetro no método chamado.</li>
          <li>Linhas 199, 227, 261, 284 da classe main "Iface": Poderiam ser substituídas por somente uma variável (a que foi criada na linha 122), já que elas tem uma única função de ler a opção.</li>
          <li>Linhas 148, 155, 170, 189 e 212  da classe "Conta": Poderiam ser substituídas por somente uma variável (criada fora do switch), já que elas tem uma única função de ler a entrada de String.</li>
        </ul>
    </ul>
</ol>
