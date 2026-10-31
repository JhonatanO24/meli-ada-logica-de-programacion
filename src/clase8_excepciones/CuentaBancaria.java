package clase8_excepciones;

import java.util.Scanner;

public class CuentaBancaria {

    private static double saldo = 1000.0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- 🏦 SISTEMA BANCARIO ---");
        System.out.println("Saldo actual disponible: $" + saldo);
        System.out.print("👉 Ingresa el monto que deseas retirar: ");

        try {
            double montoRetiro = sc.nextDouble();

            // Llamamos al método que lanza la excepción personalizada
            retirar(montoRetiro);

        } catch (SaldoInsuficienteException e) {
            // Atrapamos la excepción personalizada
            System.out.println("❌ Error detectado: " + e.getMessage());
        } catch (Exception e) {
            // Un catch general por si el usuario escribe letras en lugar de un número
            System.out.println("❌ Error: Debes ingresar un valor numérico válido.");
        } finally {
            // 💡 El bloque finally SIEMPRE se ejecuta al final de todo (haya error o no)
            System.out.println("\n--- Ejecutando limpieza de recursos :D ---");
            sc.close();
            System.out.println("🔒 Cerrado correctamente.");
        }

        System.out.println("✨ Fin del programa.");
    }

    public static void retirar(double monto) throws SaldoInsuficienteException {
        if (monto > saldo) {
            throw new SaldoInsuficienteException("Fondos insuficientes. Intentaste retirar $" + monto + ", pero tu saldo es de solo $" + saldo);
        }

        saldo -= monto;
        System.out.println("✅ Retiro exitoso. Nuevo saldo: $" + saldo);
    }
}
