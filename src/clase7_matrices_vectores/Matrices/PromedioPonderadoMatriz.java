package clase7_matrices_vectores.Matrices;

public class PromedioPonderadoMatriz {
    public static void main(String[] args) {

        double[][] notas = {
                {7, 8, 6},
                {9, 5, 7},
                {6, 6, 9}
        };

        double[] pesos = {0.2, 0.3, 0.5};

        System.out.println(" --- PROMEDIO PONDERADO DE ESTUDIANTES ---\n ");

        for (int f = 0; f < notas.length; f++) {
            double sumaPonderada = 0;

            for (int c = 0; c < notas[f].length; c++) {
                sumaPonderada += notas[f][c] * pesos[c];
            }

            String estado = (sumaPonderada >= 6.0) ? "Aprobado" : "Reprobado";

            System.out.printf("Estudiante %d -> Promedio Ponderado: %.2f | Estado: %s%n",
                    (f + 1), sumaPonderada, estado);
        }

        System.out.println("\n-----------------------");
    }
}
