package examenjava_jhonatan_osorio;

public class Ejercicio1Ventas {
    public static final double META_SEMANAL = 10000.0;

    // Se crea la funcion que sumara los valores del vector en el for.
    public static double calcularTotal(double[] v) {
        double suma = 0;
        for (int i = 0; i < v.length; i++) {
            suma += v[i];
        }
        return suma;
    }

    // Aqui se divide el total entre e; v.lenght reutilizando calcularTotal
    public static double calcularPromedio(double[] v) {
        return calcularTotal(v) / v.length;
    }

    // Se devuelve el valor mas alto
    public static int indiceMayor(double[] v) {
        int idx = 0;
        for (int i = 0; i < v.length; i++) {
            if (v[i] > v[idx]) {
                idx = i;
            }
        }
        return idx;
    }

    // Se devuelve el valor mas bajo
    public static int indiceMenor(double[] v) {
        int idx = 0;
        for (int i = 0; i < v.length; i++) {
            if (v[i] < v[idx]) {
                idx = i;
            }
        }
        return idx;
    }

    // Se clasifica la venta
    public static String clasificar(double venta, double promedio) {
        if (venta >= promedio * 1.2) {
            return "ALTA";
        }  else if (venta <= promedio * 0.8) {
            return "BAJA";
        }  else {
            return "NORMAL";
        }
    }

    public static void main(String[] args) {
        String[] dias = {"LUNES", "MARTES", "MIERCOLES", "JUEVES", "VIERNES", "SABADO", "DOMINGO"};
        double[] ventas = {1250.5, 980.0, 1430.75, 760.25, 2100.0, 2650.5, 1890.0};

        double total = calcularTotal(ventas);
        double promedio = calcularPromedio(ventas);

        // Y un toque con el codigo ansi para una estetica :)
        String PURPLE = "\u001B[35m";
        String RESET = "\u001B[0m";

        System.out.println(PURPLE + "--- 📊 REPORTE DE VENTAS SEMANAL ---" + RESET);
        System.out.printf("%-10s %12s %s%n", "Dia", "Venta", "Nivel");

        int diasEncimaPromedio = 0;
        for (int i = 0; i < dias.length; i++) {
            String nivel = clasificar(ventas[i], promedio);
            System.out.printf("%-10s %12.2f %s%n", dias[i], ventas[i], nivel);
            if (ventas[i] > promedio) {
                diasEncimaPromedio++;
            }
        }
        System.out.printf("Total semanal: %.2f%n", total);
        System.out.printf("Promedio diario: %.2f%n", promedio);

        int idxMayor = indiceMayor(ventas);
        int idxMenor = indiceMenor(ventas);
        System.out.println("Mejor dia: " + dias[idxMayor] + " (" + ventas[idxMayor] + ")");
        System.out.println("Peor dia: " + dias[idxMenor] + " (" + ventas[idxMenor] + ")");
        System.out.println("Dias por encima del promedio: " + diasEncimaPromedio);

        if (total >= META_SEMANAL) {
            System.out.printf("✨ Meta cumplida. Superaste la meta por %.2f%n", (total - META_SEMANAL));
        } else {
            System.out.printf("⚠️ Meta no cumplida. Faltó %.2f%n", (META_SEMANAL - total));
        }
    }
}

