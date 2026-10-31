package clase4_funciones.reto.utilidades;

import java.util.Scanner;

public class Entrada {
    private static Scanner sc = new Scanner(System.in);

    public static double pedirNota(String mensaje) {
        System.out.print(mensaje);
        while (!sc.hasNextDouble()) {
            System.out.println("❌ Valor no válido. Intenta de nuevo: ");
        }
        return sc.nextDouble();
    }
}

