package Exercicio4;

public class Main {

    public static void main(String[] args) {
        Cofrinho cofrinho = new Cofrinho("Felipe", 500.00);

        cofrinho.depositar(200.00);
        cofrinho.depositar(150.00);
        cofrinho.depositar(100.00);
        cofrinho.depositar(-30.00);

        cofrinho.retirar(1000.00);

        System.out.println();
        cofrinho.exibirSaldo();
        System.out.println();

        cofrinho.verificarMeta();
    }
}
