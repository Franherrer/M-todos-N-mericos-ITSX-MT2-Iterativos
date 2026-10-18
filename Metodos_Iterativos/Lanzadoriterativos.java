package Metodos_Iterativos;

    /**
      Ejecución (clase principal).
     * Ejecuta de forma secuencial el método de Jacobi y el de Gauss-Seidel
     * con el mismo sistema, aproximación inicial y tolerancia.
     */
    public class Lanzadoriterativos {

        public static void main(String[] args) {
            // 1. Obtener los datos del sistema desde el módulo 1
            double[][] A = DefSistema.matrizA();
            double[] b = DefSistema.vectorB();
            double[] x0 = DefSistema.vectorInicial();
            double tol = DefSistema.TOLERANCIA;
            int maxIter = DefSistema.MAX_ITERACIONES;

            // 2. Resolver con cada método (módulo 2)
            Metodositerativos.Resultado jacobi = Metodositerativos.jacobi(A, b, x0, tol, maxIter);
            Metodositerativos.Resultado seidel = Metodositerativos.gaussSeidel(A, b, x0, tol, maxIter);

            // 3. Presentar resultados
            System.out.println("Tolerancia: " + tol);
            imprimir("METODO DE JACOBI", jacobi);
            imprimir("METODO DE GAUSS-SEIDEL", seidel);

            // 4. Comparación final
            System.out.println();
            System.out.println("COMPARACION");
            System.out.println("Jacobi:       " + jacobi.iteraciones + " iteraciones");
            System.out.println("Gauss-Seidel: " + seidel.iteraciones + " iteraciones");
        }

        /** Imprime la tabla de iteraciones y la solución de un método. */
        private static void imprimir(String titulo, Metodositerativos.Resultado r) {
            System.out.println();
            System.out.println("=== " + titulo + " ===");
            for (int k = 0; k < r.historial.size(); k++) {
                double[] x = r.historial.get(k);
                System.out.printf("Iteracion %2d: x = %.6f  y = %.6f  z = %.6f%n", k + 1, x[0], x[1], x[2]);
            }
            System.out.println("Convergio: " + (r.convergio ? "si" : "no")
                    + " | Iteraciones: " + r.iteraciones
                    + " | Error final: " + String.format("%.6f", r.error));
            System.out.printf("Solucion: x = %.6f  y = %.6f  z = %.6f%n", r.solucion[0], r.solucion[1], r.solucion[2]);
        }
    }

