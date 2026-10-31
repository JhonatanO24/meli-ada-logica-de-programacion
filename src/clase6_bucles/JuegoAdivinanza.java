package clase6_bucles;

import java.util.Scanner;

public class JuegoAdivinanza {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String jugarDeNuevo;

        System.out.println("=== 🎮 BIENVENIDO AL JUEGO DE ADIVINANZA ===");

        do {
            int numeroSecreto = (int) (Math.random() * 100) + 1;
            int intento;
            int intentosTotales = 0;
            boolean acerto = false;

            System.out.println("\nHe generado un número secreto entre 1 y 100. ¡Intenta adivinarlo!");

            do {
                System.out.print("👉 Ingresa tu intento: ");
                intento = sc.nextInt();
                intentosTotales++;

                if (intento == numeroSecreto) {
                    acerto = true;
                } else {
                    int distancia = Math.abs(intento - numeroSecreto);

                    if (distancia > 20) {
                        System.out.println("❄️ ¡Muy lejos!");
                    } else if (distancia <= 10) {
                        System.out.println("🔥 ¡Caliente!");
                    }

                    if (intento < numeroSecreto) {
                        System.out.println("📈 Pista: El número secreto es más alto.");
                    } else {
                        System.out.println("📉 Pista: El número secreto es más bajo.");
                    }
                }

            } while (!acerto);

            System.out.println("\n----------------------------------------");
            System.out.println("🎉 ¡Felicidades! Adivinaste el número " + numeroSecreto + " en " + intentosTotales + " intentos.");

            if (intentosTotales <= 3) {
                System.out.println("🏆 ¡Eres un genio!");
            } else if (intentosTotales <= 7) {
                System.out.println("👍 Bien hecho.");
            } else {
                System.out.println("😅 Por fin lo lograste.");
            }
            System.out.println("----------------------------------------");

            System.out.print("¿Deseas jugar otra vez? (s/n): ");
            jugarDeNuevo = sc.next();

        } while (jugarDeNuevo.equalsIgnoreCase("s"));

        System.out.println("\n✨ ¡Gracias por jugar! Hasta pronto.");
        sc.close();
    }
}