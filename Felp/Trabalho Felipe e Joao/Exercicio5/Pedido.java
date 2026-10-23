package Exercicio5;

public class Pedido {

    private String nomeCliente;
    private int quantidadeLanches;
    private double precoLanche;
    private double taxaEntrega;
    private String status;

    public Pedido(String nomeCliente) {
        this.nomeCliente = nomeCliente;
        this.quantidadeLanches = 0;
        this.precoLanche = 18.00;
        this.taxaEntrega = 7.00;
        this.status = "Em aberto";
    }

    public boolean adicionarLanches(int quantidade) {
        if (status.equals("Finalizado")) {
            System.out.println("Não é possível adicionar lanches: o pedido já foi finalizado.");
            return false;
        }
        if (quantidade <= 0) {
            System.out.println("Não é possível adicionar lanches: a quantidade deve ser maior que zero.");
            return false;
        }
        quantidadeLanches += quantidade;
        System.out.println(quantidade + " lanche(s) adicionado(s) ao pedido.");
        return true;
    }

    private double calcularValorLanches() {
        return quantidadeLanches * precoLanche;
    }

    private double calcularDesconto() {
        if (quantidadeLanches >= 3) {
            return calcularValorLanches() * 0.10;
        }
        return 0;
    }

    public double calcularTotal() {
        return calcularValorLanches() - calcularDesconto() + taxaEntrega;
    }

    public void finalizarPedido() {
        if (status.equals("Finalizado")) {
            System.out.println("O pedido já está finalizado.");
            return;
        }
        if (quantidadeLanches == 0) {
            System.out.println("Não é possível finalizar um pedido sem lanches.");
            return;
        }
        status = "Finalizado";
        System.out.println("Pedido finalizado com sucesso.");
    }

    public void exibirPedido() {
        System.out.println("===== Pedido de " + nomeCliente + " =====");
        System.out.println("Quantidade de lanches: " + quantidadeLanches);
        System.out.printf("Preço por lanche: R$ %.2f%n", precoLanche);
        System.out.printf("Valor dos lanches: R$ %.2f%n", calcularValorLanches());
        System.out.printf("Desconto: R$ %.2f%n", calcularDesconto());
        System.out.printf("Taxa de entrega: R$ %.2f%n", taxaEntrega);
        System.out.printf("Total: R$ %.2f%n", calcularTotal());
        System.out.println("Status: " + status);
    }
}
