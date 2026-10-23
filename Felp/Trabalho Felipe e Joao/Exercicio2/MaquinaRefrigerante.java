package Exercicio2;

public class MaquinaRefrigerante {

    private int quantidadeEstoque;
    private double preco;
    private double dinheiroArrecadado;

    public MaquinaRefrigerante(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque < 0 ? 0 : quantidadeEstoque;
        this.preco = 4.50;
        this.dinheiroArrecadado = 0;
    }

    public boolean comprar(int quantidade, double valorPago) {
        if (quantidade <= 0) {
            System.out.println("Compra não realizada: a quantidade deve ser maior que zero.");
            return false;
        }
        if (quantidade > quantidadeEstoque) {
            System.out.println("Compra não realizada: estoque insuficiente. Disponível: " + quantidadeEstoque + " unidade(s).");
            return false;
        }

        double total = quantidade * preco;

        if (valorPago < total) {
            System.out.printf("Compra não realizada: dinheiro insuficiente. Total: R$ %.2f | Pago: R$ %.2f | Faltam: R$ %.2f%n",
                    total, valorPago, total - valorPago);
            return false;
        }

        quantidadeEstoque -= quantidade;
        dinheiroArrecadado += total;
        System.out.printf("Compra realizada: %d refrigerante(s) por R$ %.2f.%n", quantidade, total);

        double troco = valorPago - total;
        if (troco > 0) {
            System.out.printf("Troco: R$ %.2f%n", troco);
        }
        return true;
    }

    public void reporEstoque(int quantidade) {
        if (quantidade <= 0) {
            System.out.println("Reposição não realizada: a quantidade deve ser maior que zero.");
            return;
        }
        quantidadeEstoque += quantidade;
        System.out.println(quantidade + " refrigerante(s) adicionado(s) ao estoque.");
    }

    public void exibirEstado() {
        System.out.println("===== Estado da Máquina =====");
        System.out.println("Estoque: " + quantidadeEstoque + " unidade(s)");
        System.out.printf("Preço unitário: R$ %.2f%n", preco);
        System.out.printf("Dinheiro arrecadado: R$ %.2f%n", dinheiroArrecadado);
    }
}
