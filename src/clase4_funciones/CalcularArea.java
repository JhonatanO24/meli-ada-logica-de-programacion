package clase4_funciones;

import java.util.Scanner;

public class CalcularArea {

    public static double calcularArea(double base, double altura) {
        return  base * altura;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== REFACTORIZANDO CALCULAR ÁREA ===");

        double area1 = calcularArea(10.0, 5.0);
        double area2 = calcularArea(7.3, 3.2);
        double area3 = calcularArea(12.5, 6.0);

        System.out.println("Rectángulo 1 (Base: 10.0, Altura: 5.0) -> Área: " + area1);
        System.out.println("Rectángulo 2 (Base: 7.5, Altura: 3.2) -> Área: " + area2);
        System.out.println("Rectángulo 3 (Base: 12.5, Altura: 6.0) -> Área: " + area3);

        // Extra :)
        System.out.println("\n--- 🎮 MODO INTERACTIVO ---");
        System.out.print("Ingresa la base de tu propio rectángulo: ");
        double baseUsuario = sc.nextDouble();

        System.out.print("Ingresa la altura de tu propio rectángulo: ");
        double alturaUsuario = sc.nextDouble();

        double areaUsuario = calcularArea(baseUsuario, alturaUsuario);
        System.out.println("✨ El área de tu rectángulo personalizado es: " + areaUsuario);

        sc.close();
    }
}
