package clase4_funciones;

import java.util.Scanner;

public class CalculadoraPreciosIVA {

    public static double calcularIVA(double precio) {
        return precio * 0.19;
    }

    public static double calcularPrecioFinal(double precio) {
        return precio + calcularIVA(precio);
    }

    public static double calcularDescuento(double precio, double porcentaje) {
        return precio * porcentaje;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double precioBase = 50000.0;

        System.out.println("=== 🏪 CALCULADORA DE PRECIOS CON IVA ===");
        System.out.println("Producto de prueba: $" + precioBase + " COP\n");

        double iva = calcularIVA(precioBase);
        double precioFinal = calcularPrecioFinal(precioBase);
        double descuento15 = calcularDescuento(precioBase, 0.15);
        double precioConDescuento = precioBase - descuento15;

        System.out.printf("📌 IVA (19%%): $%.2f%n", iva);
        System.out.printf("📌 Precio final (con IVA): $%.2f%n", precioFinal);
        System.out.printf("📌 Descuento del 15%%: $%.2f%n", descuento15);
        System.out.printf("✨ Precio final aplicando el descuento del 15%%: $%.2f%n", precioConDescuento);

        System.out.println("\n----------------------------------------");
        System.out.println("🎮 MODO INTERACTIVO");

        System.out.print("Ingresa el precio de otro producto: ");
        double precioUsuario = sc.nextDouble();

        System.out.print("Ingresa el porcentaje de descuento (ej. 15 para 15%): ");
        double porcentajeInput = sc.nextDouble();
        double porcentajeUsuario = porcentajeInput / 100.0;

        double ivaUsuario = calcularIVA(precioUsuario);
        double precioFinalUsuario = calcularPrecioFinal(precioUsuario);
        double descuentoUsuario = calcularDescuento(precioUsuario, porcentajeUsuario);
        double totalConDescuentoUsr = precioUsuario - descuentoUsuario;

        System.out.printf("-> IVA calculado (19%%): $%.2f%n", ivaUsuario);
        System.out.printf("-> Precio Final con IVA: $%.2f%n", precioFinalUsuario);
        System.out.printf("-> Descuento del (%.0f%%): $%.2f%n", porcentajeInput, descuentoUsuario);
        System.out.printf("✨ Precio final aplicando el descuento: $%.2f%n", totalConDescuentoUsr);

        sc.close();
    }
}
