package fag;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import fag.objetos.Livro;
import fag.objetos.Pessoa;

public class Principal {

    static Scanner scan = new Scanner(System.in);
    static List<Livro> listaLivros = new ArrayList<Livro>();
    static List<Pessoa> listaUsuarios = new ArrayList<Pessoa>();

    public static void main(String[] args) {
        popularTabela();

        System.out.println("Sistema de Biblioteca iniciado!");
        mostrarMenu();
    }

    private static void popularTabela() {
        listaUsuarios.add(new Pessoa("Patrick"));
        listaUsuarios.add(new Pessoa("Gabriel"));
        listaUsuarios.add(new Pessoa("Theo"));

        listaLivros.add(new Livro("Dom Casmurro", "Machado de Assis", "Romance"));
        listaLivros.add(new Livro("O Hobbit", "J. R. R. Tolkien", "Fantasia"));
        listaLivros.add(new Livro("1984", "George Orwell", "Ficção"));
        listaLivros.add(new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", "Infantil"));
        listaLivros.add(new Livro("It: A Coisa", "Stephen King", "Terror"));
    }

    public static void mostrarMenu() {
        int escolhaUsuario;

        do {
            System.out.println("\\n-------------------- BIBLIOTECA --------------------");
            System.out.println("1 - Listar livros");
            System.out.println("2 - Cadastrar livro");
            System.out.println("3 - Excluir livro");
            System.out.println("4 - Emprestar livro");
            System.out.println("5 - Devolver livro");
            System.out.println("6 - Cadastrar usuário");
            System.out.println("7 - Listar usuários");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            escolhaUsuario = lerInteiro();
            validarEscolha(escolhaUsuario);

        } while (escolhaUsuario != 0);

        scan.close();
    }

    public static void validarEscolha(int escolhaUsuario) {
        switch (escolhaUsuario) {
            case 0:
                System.out.println("Sistema encerrado. Obrigado por utilizar!");
                break;
            case 1:
                listarLivros();
                break;
            case 2:
                cadastrarLivro();
                break;
            case 3:
                excluirLivro();
                break;
            case 4:
                emprestarLivro();
                break;
            case 5:
                devolverLivro();
                break;
            case 6:
                cadastrarUsuario();
                break;
            case 7:
                listarUsuarios();
                break;
            default:
                System.out.println("Insira uma opção válida!");
        }
    }

    private static int lerInteiro() {
        while (true) {
            try {
                return Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Digite um número válido: ");
            }
        }
    }

    private static void listarLivros() {
        System.out.println("\\n-------- LISTA DE LIVROS --------");

        if (listaLivros.isEmpty()) {
            System.out.println("Não existem livros cadastrados.");
            return;
        }

        for (int i = 0; i < listaLivros.size(); i++) {
            Livro livro = listaLivros.get(i);
            System.out.printf("%d) %s - %s / %s%n",
                    i + 1, livro.getTitulo(), livro.getAutor(),
                    livro.getGenero() + " / " + livro.validarDisponibilidade());
        }
    }

    private static void cadastrarLivro() {
        System.out.println("\\n-------- CADASTRAR LIVRO --------");

        System.out.print("Informe o título do livro: ");
        String titulo = scan.nextLine().trim();

        System.out.print("Informe o autor do livro: ");
        String autor = scan.nextLine().trim();

        System.out.print("Informe o gênero do livro: ");
        String genero = scan.nextLine().trim();

        if (titulo.isEmpty() || autor.isEmpty() || genero.isEmpty()) {
            System.out.println("Todos os campos devem ser preenchidos.");
            return;
        }

        listaLivros.add(new Livro(titulo, autor, genero));
        System.out.println("Livro cadastrado com sucesso!");
    }

    private static void excluirLivro() {
        if (listaLivros.isEmpty()) {
            System.out.println("Não existem livros para excluir.");
            return;
        }

        listarLivros();
        System.out.print("Informe o número do livro que deseja excluir: ");
        int escolha = lerInteiro() - 1;

        if (escolha < 0 || escolha >= listaLivros.size()) {
            System.out.println("Número de livro inválido!");
            return;
        }

        if (listaLivros.get(escolha).getDataEmprestimo() != null) {
            System.out.println("O livro está emprestado e não pode ser excluído!");
            return;
        }

        listaLivros.remove(escolha);
        System.out.println("Livro excluído com sucesso!");
    }

    private static void emprestarLivro() {
        if (listaUsuarios.isEmpty()) {
            System.out.println("Não existem usuários cadastrados.");
            return;
        }

        if (listaLivros.isEmpty()) {
            System.out.println("Não existem livros cadastrados.");
            return;
        }

        listarUsuarios();
        System.out.print("Informe o número do usuário que fará o empréstimo: ");
        int usuario = lerInteiro() - 1;

        if (usuario < 0 || usuario >= listaUsuarios.size()) {
            System.out.println("Usuário inválido!");
            return;
        }

        Pessoa pessoa = listaUsuarios.get(usuario);

        if (pessoa.getLivrosEmprestados().size() >= 2) {
            System.out.println("O usuário já está com o máximo de 2 livros emprestados.");
            return;
        }

        listarLivros();
        System.out.print("Informe o número do livro que deseja emprestar: ");
        int indiceLivro = lerInteiro() - 1;

        if (indiceLivro < 0 || indiceLivro >= listaLivros.size()) {
            System.out.println("Livro inválido!");
            return;
        }

        Livro livro = listaLivros.get(indiceLivro);

        if (livro.getDataEmprestimo() != null) {
            System.out.println("Este livro já está emprestado!");
            return;
        }

        pessoa.getLivrosEmprestados().add(livro);
        livro.setDataEmprestimo(new Date());

        System.out.println("Livro emprestado com sucesso!");
    }

    private static void devolverLivro() {
        if (listaUsuarios.isEmpty()) {
            System.out.println("Não existem usuários cadastrados.");
            return;
        }

        listarUsuarios();
        System.out.print("Informe o número do usuário que fará a devolução: ");
        int usuario = lerInteiro() - 1;

        if (usuario < 0 || usuario >= listaUsuarios.size()) {
            System.out.println("Usuário inválido!");
            return;
        }

        Pessoa pessoa = listaUsuarios.get(usuario);

        if (pessoa.getLivrosEmprestados().isEmpty()) {
            System.out.println("Este usuário não possui livros emprestados.");
            return;
        }

        System.out.println("\\nLivros emprestados por " + pessoa.getNome() + ":");
        for (int i = 0; i < pessoa.getLivrosEmprestados().size(); i++) {
            Livro livro = pessoa.getLivrosEmprestados().get(i);
            System.out.printf("%d) %s - %s%n", i + 1, livro.getTitulo(), livro.getAutor());
        }

        System.out.print("Informe o número do livro que será devolvido: ");
        int indiceLivro = lerInteiro() - 1;

        if (indiceLivro < 0 || indiceLivro >= pessoa.getLivrosEmprestados().size()) {
            System.out.println("Número de livro inválido!");
            return;
        }

        Livro livro = pessoa.getLivrosEmprestados().remove(indiceLivro);
        livro.setDataEmprestimo(null);

        System.out.println("Livro devolvido com sucesso!");
    }

    private static void cadastrarUsuario() {
        System.out.println("\\n-------- CADASTRAR USUÁRIO --------");
        System.out.print("Informe o nome do usuário: ");
        String nome = scan.nextLine().trim();

        if (nome.isEmpty()) {
            System.out.println("O nome não pode ficar vazio.");
            return;
        }

        listaUsuarios.add(new Pessoa(nome));
        System.out.println("Usuário cadastrado com sucesso!");
    }

    private static void listarUsuarios() {
        System.out.println("\\n-------- LISTA DE USUÁRIOS --------");

        if (listaUsuarios.isEmpty()) {
            System.out.println("Não existem usuários cadastrados.");
            return;
        }

        for (int i = 0; i < listaUsuarios.size(); i++) {
            Pessoa pessoa = listaUsuarios.get(i);
            System.out.printf("%d) %s%n", i + 1, pessoa.getNome());

            if (pessoa.getLivrosEmprestados().isEmpty()) {
                System.out.println("   Nenhum livro emprestado.");
            } else {
                for (int j = 0; j < pessoa.getLivrosEmprestados().size(); j++) {
                    Livro livro = pessoa.getLivrosEmprestados().get(j);
                    System.out.printf("   %d) %s - %s%n",
                            j + 1, livro.getTitulo(), livro.getAutor());
                }
            }
        }
    }
}
