package Exercicio3;

public class Main {

    public static void main(String[] args) {
        Time time1 = new Time("Tigres FC");
        Time time2 = new Time("Falcões FC");

        time1.registrarVitoria();
        time1.registrarVitoria();
        time1.registrarEmpate();
        time1.registrarDerrota();

        time2.registrarVitoria();
        time2.registrarEmpate();
        time2.registrarEmpate();
        time2.registrarDerrota();
        time2.registrarDerrota();

        time1.exibirEstatisticas();
        System.out.println();
        time2.exibirEstatisticas();
        System.out.println();

        if (time1.getPontos() > time2.getPontos()) {
            System.out.println(time1.getNome() + " está na frente com " + time1.getPontos() + " pontos.");
        } else if (time2.getPontos() > time1.getPontos()) {
            System.out.println(time2.getNome() + " está na frente com " + time2.getPontos() + " pontos.");
        } else {
            System.out.println("Houve empate na classificação: ambos os times têm " + time1.getPontos() + " pontos.");
        }
    }
}
