package Exercicio5;

public class Main {

    public static void main(String[] args) {
        Pedido pedido = new Pedido("João");

        pedido.adicionarLanches(1);
        pedido.adicionarLanches(2);

        System.out.printf("Total do pedido: R$ %.2f%n", pedido.calcularTotal());

        pedido.finalizarPedido();

        boolean permitido = pedido.adicionarLanches(1);
        if (permitido) {
            System.out.println("Resultado: a operação foi permitida.");
        } else {
            System.out.println("Resultado: a operação não foi permitida.");
        }

        System.out.println();
        pedido.exibirPedido();
    }
}
