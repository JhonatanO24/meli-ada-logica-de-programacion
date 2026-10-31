package examenjava_jhonatan_osorio;

public class Ejercicio2Evaluador {
    enum Estado { APROBADO, RECUPERACION, REPROBADO}

    // Esta funcion calcula el promedio ponderadp recibiendo una fila de la matriz y el vector de pesos
    public static double promedioPonderado(double[] notasEst, double[] pesos) {
        double suma = 0;
        for (int i = 0; i < notasEst.length; i++) {
            suma += notasEst[i] * pesos[i];
        }
        return suma;
    }

    // Se aplica la regla de evaluacionen el orden que es y devuelve un valor del enum
    public static Estado evaluar(double promedio, double asistencia) {
        if (asistencia < 0.75) {
            return Estado.REPROBADO;
        } else if (promedio >= 3.0) {
            return Estado.APROBADO;
        } else if (promedio >= 2.5) {
            return Estado.RECUPERACION;
        } else {
            return Estado.REPROBADO;
        }
    }

    public static void main(String[] args) {
        String[] estudiantes = {"Ana", "Luis", "Sofia", "Carlos", "Valentina", "Mateo"};
        String[] evaluaciones = {"Quiz 1", "Quiz 2", "Taller", "Proyecto"};
        double[][] notas = {
                {4.5, 4.9, 3.8, 4.2}, // Ana
                {3.5, 4.0, 4.9, 4.0}, // Luis
                {2.5, 3.0, 2.8, 2.6}, // Sofia
                {3.0, 2.5, 3.2, 3.4}, // Carlos
                {5.0, 4.8, 4.6, 4.9}, // Valentina
                {2.0, 2.5, 1.8, 2.2}  // Mateo
        };
        double[] pesos = {0.20, 0.20, 0.25, 0.35}; // suman 1.0
        double[] asistencia = {0.95, 0.70, 0.88, 0.80, 1.00, 0.76};

        double[] promedios = new double[estudiantes.length];
        Estado[] estados = new Estado[estudiantes.length];

        for (int i = 0; i < estudiantes.length; i++) {
            promedios[i] = promedioPonderado(notas[i], pesos);
            estados[i] = evaluar(promedios[i], asistencia[i]);
        }

        String BLUE = "\u001B[34m";
        String RESET = "\u001B[0m";

        System.out.println(BLUE + "--- 🎓 RESULTADOS DEL CURSO ---" + RESET);
        System.out.printf("%-12s %-10s %-12s %s%n", "Estudiante", "Promedio", "Asistencia", "Estado");
        for (int i = 0; i < estudiantes.length; i++) {
            System.out.printf("%-12s %-10.2f %-11.0f%% %s%n",
                    estudiantes[i], promedios[i], (asistencia[i] * 100), estados[i]);
        }
        // Aca usamos swtch para el conteo
        int aprobados = 0;
        int recuperacion = 0;
        int reprobados = 0;

        for (int i = 0; i < estados.length; i++) {
            switch (estados[i]) {
                case APROBADO:
                    aprobados++;
                    break;
                case RECUPERACION:
                    recuperacion++;
                    break;
                case REPROBADO:
                    reprobados++;
                    break;
            }
        }
        System.out.println("Aprobados: " + aprobados + " | Recuperacion: " + recuperacion + " | Reprobados: " + reprobados);

        // Análisis por evaluación (recorriendo matriz por columnas)
        System.out.println("\n--- 📈 ANALISIS POR EVALUACION ---");
        for (int c = 0; c < evaluaciones.length; c++) {
            double sumaEval = 0;
            double mejorNota = -1.0;
            int idxMejorEstudiante = 0;

            for (int f = 0; f < estudiantes.length; f++) {
                sumaEval += notas[f][c];
                if (notas[f][c] > mejorNota) { // Uso estricto de > para conservar el primero en caso de empate si llega a suceder
                    mejorNota = notas[f][c];
                    idxMejorEstudiante = f;
                }
            }
            double promedioEval = sumaEval / estudiantes.length;
            System.out.printf("%s promedio %.2f mejor: %s (%.1f)%n",
                    evaluaciones[c], promedioEval, estudiantes[idxMejorEstudiante], mejorNota);
        }

        // Ranking utilizando el método burbuja con un vector de posiciones (orden)
        int[] orden = new int[estudiantes.length];
        for (int i = 0; i < orden.length; i++) {
            orden[i] = i;
        }

        for (int i = 0; i < orden.length - 1; i++) {
            for (int j = 0; j < orden.length - 1 - i; j++) {
                // Ordenar de mayor a menor promedio
                if (promedios[orden[j]] < promedios[orden[j + 1]]) {
                    int temp = orden[j];
                    orden[j] = orden[j + 1];
                    orden[j + 1] = temp;
                }
            }
        }

        System.out.println("\n--- 🥇 RANKING ---");
        for (int p = 0; p < orden.length; p++) {
            int idx = orden[p];
            System.out.printf("%d. %-10s %.2f%n", (p + 1), estudiantes[idx], promedios[idx]);
        }
    }
}
