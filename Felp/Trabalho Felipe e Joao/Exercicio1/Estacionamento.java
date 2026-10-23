package Exercicio1;

public class Estacionamento {

    private String placa;
    private String modelo;
    private int minutosEstacionado;
    private double valorPago;

    public Estacionamento(String placa, String modelo) {
        this.placa = placa;
        this.modelo = modelo;
        this.minutosEstacionado = 0;
        this.valorPago = 0;
    }

    public void adicionarTempo(int minutos) {
        if (minutos < 0) {
            System.out.println("Erro: o tempo estacionado não pode ser negativo.");
            return;
        }
        minutosEstacionado += minutos;
        System.out.println(minutos + " minutos adicionados ao veículo " + placa + ".");
    }

    public double calcularValor() {
        if (minutosEstacionado == 0) {
            valorPago = 0;
        } else if (minutosEstacionado <= 30) {
            valorPago = 5.00;
        } else {
            valorPago = 5.00 + (minutosEstacionado - 30) * 0.10;
        }
        if (valorPago > 30.00) {
            valorPago = 30.00;
        }
        return valorPago;
    }

    public void exibirResumo() {
        System.out.println("===== Resumo do Estacionamento =====");
        System.out.println("Placa: " + placa);
        System.out.println("Modelo: " + modelo);
        System.out.println("Tempo estacionado: " + minutosEstacionado + " minutos");
        System.out.printf("Valor a pagar: R$ %.2f%n", calcularValor());
    }
}
