package Exercicio4;

public class Cofrinho {

    private String dono;
    private double saldo;
    private double metaEconomia;

    public Cofrinho(String dono, double metaEconomia) {
        this.dono = dono;
        this.saldo = 0;
        this.metaEconomia = metaEconomia;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Depósito não realizado: o valor deve ser positivo.");
            return;
        }
        saldo += valor;
        System.out.printf("Depósito de R$ %.2f realizado.%n", valor);
    }

    public void retirar(double valor) {
        if (valor <= 0) {
            System.out.println("Retirada não realizada: o valor deve ser positivo.");
            return;
        }
        if (valor > saldo) {
            System.out.printf("Retirada de R$ %.2f não permitida: saldo insuficiente (saldo atual: R$ %.2f).%n", valor, saldo);
            return;
        }
        saldo -= valor;
        System.out.printf("Retirada de R$ %.2f realizada.%n", valor);
    }

    public boolean verificarMeta() {
        if (saldo >= metaEconomia) {
            System.out.printf("Parabéns, %s! A meta de economia de R$ %.2f foi atingida!%n", dono, metaEconomia);
            return true;
        }
        System.out.printf("A meta ainda não foi atingida. Faltam R$ %.2f para chegar a R$ %.2f.%n", metaEconomia - saldo, metaEconomia);
        return false;
    }

    public void exibirSaldo() {
        System.out.println("===== Cofrinho de " + dono + " =====");
        System.out.printf("Saldo: R$ %.2f%n", saldo);
        System.out.printf("Meta de economia: R$ %.2f%n", metaEconomia);
    }
}
