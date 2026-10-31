package clase5_condicionales;

import java.util.Scanner;

public class EvaluadordeNotas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== EVALUADOR FINAL CON ENUM ===");

        // 1. Pedir datos
        System.out.print("Ingresa la nota 1: ");
        double nota1 = sc.nextDouble();

        System.out.print("Ingresa la nota 2: ");
        double nota2 = sc.nextDouble();

        System.out.print("Ingresa la nota 3: ");
        double nota3 = sc.nextDouble();

        System.out.print("Ingresa el % de asistencia en decimal (ej. 0.80 para 80%): ");
        double asistencia = sc.nextDouble();

        double promedio = (nota1 + nota2 + nota3) / 3.0;

        // 2. Receta clara -> pide datos -> evalúa -> imprime
        Estado estadoActual = evaluar(promedio, asistencia);

        System.out.println("\n----------------------------------------");
        System.out.printf("✨ Tu promedio final es: %.2f%n", promedio);

        // 3. Imprimir resultado usando la función requerida
        imprimirResultado(estadoActual);

        System.out.println("----------------------------------------");

        sc.close();
    }

    // Función evaluar que retorna un tipo de dato Estado
    public static Estado evaluar(double promedio, double asistencia) {
        if (promedio >= 3.0 && asistencia >= 0.75) {
            return Estado.APROBADO;
        } else if (promedio < 3.0 && asistencia >= 0.75) {
            return Estado.REPROBADO;
        } else if (promedio >= 3.0 && asistencia < 0.75) {
            return Estado.REPROBADO_POR_ASISTENCIA;
        } else {
            return Estado.REPROBADO;
        }
    }

    // Función imprimirResultado que recibe el Estado
    public static void imprimirResultado(Estado estado) {
        // Uso del operador ternario para asignar un emoji según el estado
        String emoji = (estado == Estado.APROBADO) ? "🎉" : "😢";

        // if / else if / else como pide la diapositiva
        if (estado == Estado.APROBADO) {
            System.out.println("Estado: APROBADO " + emoji + " ¡Felicidades, pasaste!");
        } else if (estado == Estado.REPROBADO) {
            System.out.println("Estado: REPROBADO " + emoji + " Reprobado por nota baja");
        } else if (estado == Estado.REPROBADO_POR_ASISTENCIA) {
            System.out.println("Estado: REPROBADO POR ASISTENCIA " + emoji + " Reprobado por asistencia insuficiente");
        }
    }
}
