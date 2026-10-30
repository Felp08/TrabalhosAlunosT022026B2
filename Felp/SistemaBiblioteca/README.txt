SISTEMA DE BIBLIOTECA - JAVA

Estrutura:
src/
  fag/
    Principal.java
    objetos/
      Livro.java
      Pessoa.java

Como executar:
1. Abra a pasta SistemaBiblioteca no VS Code.
2. Abra src/fag/Principal.java.
3. Execute o método main (Run Java).
4. Se preferir usar o terminal, na pasta src execute:
   javac fag/objetos/Livro.java fag/objetos/Pessoa.java fag/Principal.java
   java fag.Principal

O sistema mantém os dados apenas enquanto o programa está em execução.
Cada usuário pode ficar com até 2 livros emprestados simultaneamente.
