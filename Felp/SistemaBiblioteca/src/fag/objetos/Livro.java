package fag.objetos;

import java.util.Date;

public class Livro {

    private String titulo;
    private String autor;
    private String genero;
    private Date dataEmprestimo;

    public Livro() {
    }

    public Livro(String titulo, String autor, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String validarDisponibilidade() {
        String VERDE = "\u001B[32m";
        String VERMELHO = "\u001B[31m";
        String RESET = "\u001B[0m";

        if (dataEmprestimo == null) {
            return VERDE + "Disponível" + RESET;
        } else {
            return VERMELHO + "Emprestado" + RESET;
        }
    }
}
