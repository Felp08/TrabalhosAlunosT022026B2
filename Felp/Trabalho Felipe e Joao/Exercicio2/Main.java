package Exercicio2;

public class Main {

    public static void main(String[] args) {
        MaquinaRefrigerante maquina = new MaquinaRefrigerante(5);
        maquina.exibirEstado();

        System.out.println();
        System.out.println("--- Compra 1: 2 refrigerantes pagando R$ 10,00 ---");
        maquina.comprar(2, 10.00);

        System.out.println();
        System.out.println("--- Compra 2: 6 refrigerantes pagando R$ 30,00 ---");
        maquina.comprar(6, 30.00);

        System.out.println();
        maquina.reporEstoque(10);

        System.out.println();
        maquina.exibirEstado();
    }
}
