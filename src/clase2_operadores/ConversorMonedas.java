package clase2_operadores;

import java.util.Scanner;

public class ConversorMonedas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Tasas de cambio fijas de ejemplo
        double tasaUSD_a_COP = 4000.0;
        double tasaUSD_a_EUR = 0.92;

        System.out.println("=== 💰 CONVERSOR DE MONEDAS BÁSICO ===");
        System.out.println("1. Dólares (USD) a Pesos Colombianos (COP)");
        System.out.println("2. Dólares (USD) a Euros (EUR)");
        System.out.print("👉 Elige una opción: ");
        int opcion = scanner.nextInt();

        System.out.print("🔢 Ingresa la cantidad en USD: ");
        double dolares = scanner.nextDouble();

        double resultado = 0.0;

        // Uso de condicionales y operadores lógicos/aritméticos
        if (opcion == 1) {
            resultado = dolares * tasaUSD_a_COP;
            System.out.printf("✅ Equivale a: %.2f COP%n", resultado);
        } else if (opcion == 2) {
            resultado = dolares * tasaUSD_a_EUR;
            System.out.printf("✅ Equivale a: %.2f EUR%n", resultado);
        } else {
            System.out.println("❌ Opción no válida.");
        }

        scanner.close();
    }
}
