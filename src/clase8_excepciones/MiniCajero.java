package clase8_excepciones;

import java.util.Scanner;

public class MiniCajero {

    private static double saldo = 1000.0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        System.out.println("=== 🏧 BIENVENIDO AL MINI-CAJERO ===");

        // Un bucle while para que el cajero se mantenga activo y nunca se crashee...
        while (!salir) {
            System.out.println("\n----------------------------------------");
            System.out.println("💰 Saldo actual disponible: $" + saldo);
            System.out.println("¿Qué deseas hacer?");
            System.out.println("1. Depositar dinero");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Salir");
            System.out.print("👉 Elige una opción (1-3): ");

            try {
                // Vamos a leer la opción como texto y la convertimos a entero de forma segura
                int opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.print("👉 Ingresa el monto a depositar: ");
                        double montoDeposito = Double.parseDouble(sc.nextLine());

                        if (montoDeposito <= 0) {
                            System.out.println("❌ Error: El depósito debe ser mayor a 0.");
                        } else {
                            saldo += montoDeposito;
                            System.out.println("✅ Depósito exitoso. Nuevo saldo: $" + saldo);
                        }
                        break;

                    case 2:
                        System.out.print("👉 Ingresa el monto a retirar: ");
                        double montoRetiro = Double.parseDouble(sc.nextLine());

                        // Llamaremos al método que puede lanzar nuestra excepción personalizada
                        retirar(montoRetiro);
                        break;

                    case 3:
                        salir = true;
                        System.out.println("👋 Gracias por usar el mini-cajero. ¡Hasta pronto!");
                        break;

                    default:
                        System.out.println("❌ Opción inválida. Por favor elige 1, 2 o 3.");
                        break;
                }

            } catch (NumberFormatException e) {
                // Aqui atrapa si el usuario escribe letras en lugar de números
                System.out.println("❌ Error de formato: Debes ingresar un valor numérico válido.");
            } catch (SaldoInsuficienteException e) {
                // AEntonces atrapa nuestra excepción personalizada de fondos insuficientes
                System.out.println("❌ Error bancario: " + e.getMessage());
            } catch (Exception e) {
                // Y un catch general por seguridad para que el programa nunca crashe
                System.out.println("❌ Ocurrió un error inesperado: " + e.getMessage());
            }
        }

        // Cierre de recursos al salir del cajero
        sc.close();
    }

    // Método para retirar que lanza la excepción propia si supera el saldo
    public static void retirar(double monto) throws SaldoInsuficienteException {
        if (monto <= 0) {
            System.out.println("❌ Error: El retiro debe ser mayor a 0.");
            return;
        }

        if (monto > saldo) {
            throw new SaldoInsuficienteException("Fondos insuficientes. Intentaste retirar $" + monto + ", pero tu saldo es de solo $" + saldo);
        }

        saldo -= monto;
        System.out.println("✅ Retiro exitoso. Nuevo saldo: $" + saldo);
    }
}