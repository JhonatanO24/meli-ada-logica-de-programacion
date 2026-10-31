package clase8_excepciones;

import java.util.Scanner;

public class ValidarNumeroTryCatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int maxIntentos = 3;
        int intentosFallidos = 0;
        boolean exito = false;
        int numero = 0;

        System.out.println("--- 🛡️ CONTROL DE EXCEPCIONES Y ENTRADAS ---");

        // Se mientras no haya éxito y queden intentos
        while (!exito && intentosFallidos < maxIntentos) {
            System.out.print("👉 Ingresa un número entero: ");

            try {
                // convertir la línea leída a entero
                numero = Integer.parseInt(sc.nextLine());
                exito = true; // Si llega aquí, significa que fue exitoso

            } catch (NumberFormatException e) {
                // Si el usuario escribe algo inválido, atrapamos el error aquí
                intentosFallidos++;
                int intentosRestantes = maxIntentos - intentosFallidos;

                System.out.println("❌ Error: Eso no es un número válido.");
                if (intentosRestantes > 0) {
                    System.out.println("⚠️ Te quedan " + intentosRestantes + " intentos.\n");
                }
            }
        }

        System.out.println("\n----------------------------------------");
        if (exito) {
            System.out.println("🎉 ¡Muy bien! Procesamos con éxito el número: " + numero);
        } else {
            System.out.println("🚨 Has superado los 3 intentos fallidos. El programa se ha detenido por seguridad.");
        }
        System.out.println("----------------------------------------");

        sc.close();
    }
}
