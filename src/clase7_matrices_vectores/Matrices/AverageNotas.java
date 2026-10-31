package clase7_matrices_vectores.Matrices;

public class AverageNotas {
    public static void main(String[] args) {

        // Matriz base (filas = estudiantes, columnas = materias
        double [][] notas = {
                {7, 8, 6},
                {9, 5, 7},
                {6, 6, 9}
        };

        System.out.println("--- 📊PROMEDIO POR MATERIA ---");

        // Este for recorre las columnas (materias) y el de adentro filas (estudiantes)
        for (int c = 0; c < notas[0].length; c++) {
            double sumaMateria = 0;

            for (int f = 0;  f < notas.length; f++) {
                sumaMateria += notas[f][c];
            }

            double promedioMateria = sumaMateria / notas.length;
            System.out.printf("Materia %d -> Promedio: %.2f%n", (c + 1), promedioMateria);
        }

        System.out.println("\n--- 🎯ESTUDIANTES SIN REPROBAR NINGUNA ---");
        int contadorEstudiantesAprobadosTotal = 0;

        for (int f = 0;  f < notas.length; f++) {
            // Una bandera por fila arranca en true
            boolean aproboTodas = true;

            for (int c = 0;  c < notas[f].length; c++) {
                // Para cumpl;ir la condición, si alguna nota es menor a 6, la bandera cambiara a false
                if (notas[f][c] < 6.0) {
                    aproboTodas = false;
                    break; // Se sale del ciclo interno
                }
            }

            // Se evalua la bandera al terminar de revisar las materias del estudiante
            if (aproboTodas) {
                contadorEstudiantesAprobadosTotal++;
                System.out.println("Estudiante " + (f + 1) + " -> ¡Aprobó TODAS las materias! 🎉");
            } else {
                System.out.println("Estudiante " + (f + 1) + " -> Reprobó al menos una materia ❌");
            }
        }

        System.out.println("\n------------------------------------------------------------");
        System.out.println("✨ Total de estudiantes que aprobaron todas sus materias: " + contadorEstudiantesAprobadosTotal);
        System.out.println("------------------------------------------------------------");
    }
}
