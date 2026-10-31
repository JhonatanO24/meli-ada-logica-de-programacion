package clase4_funciones.reto;

import clase4_funciones.reto.utilidades.Calculadora;
import clase4_funciones.reto.utilidades.Entrada;
import clase4_funciones.reto.utilidades.Salida;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            // Salida.imprimirMenu()
            Salida.imprimirMenu();

            if (!sc.hasNextInt()) {
                System.out.println("❌ Por favor ingresa un número válido.");
                sc.next();
                continue;
            }
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\n📝 Ingrese las 3 notas del alumno:");
                    // Usamos Entrada para pedir los datos
                    double nota1 = Entrada.pedirNota("Nota 1: ");
                    double nota2 = Entrada.pedirNota("Nota 2: ");
                    double nota3 = Entrada.pedirNota("Nota 3: ");

                    // Usamos Calculadora para obtener el promedio
                    double promedio = Calculadora.calcularPromedioSimple(nota1, nota2, nota3);

                    // Usamos Salida para mostrar el resultado formateado
                    Salida.imprimirResultado(promedio);
                    break;

                case 2:
                    System.out.println("✨ ¡Gracias por usar el programa! Hasta luego.");
                    break;

                default:
                    System.out.println("⚠️ Opción no válida.");
            }
        } while (opcion != 2);

        sc.close();
    }
}
