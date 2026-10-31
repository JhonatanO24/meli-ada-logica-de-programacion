package clase3_scanner;

import java.util.Scanner;

public class FichaAlumno {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingresa el nombre completo del alumno: ");
        String nombre = sc.nextLine();

        System.out.print("Ingresa la edad: ");
        int edad = sc.nextInt();

        System.out.print("Ingresa la nota 1: ");
        double nota1 = sc.nextDouble();

        System.out.print("Ingresa la nota 2: ");
        double nota2 = sc.nextDouble();

        System.out.print("Ingresa la nota 3: ");
        double nota3 = sc.nextDouble();

        double promedio = (nota1 + nota2 + nota3) / 3.0;

        System.out.println("\n--- FICHA DEL ALUMNO ---");

        System.out.printf("Nombre: %s%n", nombre);

        System.out.printf("Edad: %d años | Promedio: %.2f%n", edad, promedio);

        System.out.printf("Nota 1: %.1f | Nota 2: %.1f | Nota 3: %.1f%n", nota1, nota2, nota3);

        sc.close();
    }
}
