package clase7_matrices_vectores.Arrays;

public class ContadorParesImpares {

    // Función que analiza ael array y retorna el String formateado
    public static String contarParesImpares(int[] numeros) {
        int pares = 0;
        int impares = 0;

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 == 0) {
                pares++;
            } else {
                impares++;
            }
        }

        // Prural según la salida esperada
        String textoPares = (pares == 1) ? "1 par" : pares + " pares";
        String textoImpares = (impares == 1) ? "1 impar" : impares + " impares";

        return textoPares + ", " + textoImpares;
    }

    public static void main(String[] args) {

        int[] array1 = {1, 2, 3, 6, 9};
        int[] array2 = {2, 3, 6};

        System.out.println("--- PARES E IMPARES ---");
        System.out.println("Entrada: {1, 2, 3, 6, 9} -> Salida: \"" + contarParesImpares(array1) + "\"");
        System.out.println("Entrada: {2, 3, 6}         -> Salida: \"" + contarParesImpares(array2) + "\"");
    }
}
