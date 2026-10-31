package clase4_funciones.reto.utilidades;

public class Salida {

    public static void imprimirMenu() {
        System.out.println("\n=== 📚 GESTOR DE NOTAS ALUMNO ===");
        System.out.println("1️⃣ Calcular promedio simple de 3 notas");
        System.out.println("2️⃣ Salir");
        System.out.print("👉 Seleccione una opción: ");
    }

    public static void imprimirResultado(double promedio) {
        System.out.println("\n📊 --- RESULTADO ---");
        System.out.printf("✨ El promedio simple de las notas es: %.2f%n", promedio);
    }
}

