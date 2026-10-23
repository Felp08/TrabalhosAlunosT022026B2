package Exercicio1;

public class Main {

    public static void main(String[] args) {
        Estacionamento veiculo = new Estacionamento("ABC-1234", "Fiat Uno");

        veiculo.adicionarTempo(45);
        veiculo.adicionarTempo(20);
        veiculo.adicionarTempo(-10);

        double valor = veiculo.calcularValor();
        System.out.printf("Valor calculado: R$ %.2f%n", valor);
        System.out.println();

        veiculo.exibirResumo();
    }
}
