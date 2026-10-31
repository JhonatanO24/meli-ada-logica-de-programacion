package clase7_matrices_vectores.Matrices;

import java.util.Scanner;

public class PromedioVector {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- PROMEDIO CON VECTOR ---");

        double[] notas = new double[3];

        System.out.println("Por favor ingrese las 3 notas:");
        for (int i = 0; i < notas.length; i++) {
            System.out.print("Nota " + (i + 1) + "; ");
            notas[i] = sc.nextDouble();
        }

        double suma = 0;
        for (int i = 0; i < notas.length; i++) {
            suma += notas[i];
        }

        double promedio = suma / notas.length;

        System.out.println("\n---------------------");
        System.out.printf("El promedio final de las notas es: %.2f%n", promedio);
        System.out.println("------------------------");

        sc.close();
    }
}

