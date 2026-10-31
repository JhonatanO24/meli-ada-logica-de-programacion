package clase7_matrices_vectores.Arrays;

public class SecuenciaFibonacci {

    // Función que genera la secuencia de Fibonacci en formato de String
    public static String generarFibonacci(int limite) {
        if (limite < 0) {
            return "";
        }

        int a = 0;
        int b = 1;
        String resultado = String.valueOf(a);

        if (limite == 0) {
            return resultado;
        }

        while (b <= limite) {
            resultado += ", " + b;
            int siguiente = a + b;
            a = b;
            b = siguiente;
        }

        return resultado;
    }

    public static void main(String[] args) {
        int caso1 = 4;
        int caso2 = 0;
        int caso3 = 8;

        System.out.println("--- SECUENCIA DE FIBONACCI ---");
        System.out.println("Entrada: " + caso1 + " -> Salida: \"" + generarFibonacci(caso1) + "\"");
        System.out.println("Entrada: " + caso2 + " -> Salida: \"" + generarFibonacci(caso2) + "\"");
        System.out.println("Entrada: " + caso3 + " -> Salida: \"" + generarFibonacci(caso3) + "\"");
    }
}