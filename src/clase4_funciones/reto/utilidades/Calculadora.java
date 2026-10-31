package clase4_funciones.reto.utilidades;

public class Calculadora {

    // Cálculo del promedio de las 3 notas
    public static double calcularPromedioSimple(double n1, double n2, double n3) {
        return (n1 + n2 + n3) / 3.0;
    }

    // Cálculo ponderado
    public static double calcularPonderado(double n1, double p1, double n2, double p2, double n3, double p3) {
        return (n1 * p1) + (n2 * p2) + (n3 * p3);
    }
}

