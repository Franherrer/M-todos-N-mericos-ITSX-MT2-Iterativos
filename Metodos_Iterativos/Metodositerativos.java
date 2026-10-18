package Metodos_Iterativos;

import java.util.ArrayList;
import java.util.List;

/**
  Métodos iterativos.
 * Contiene la lógica del método de Jacobi y del método de Gauss-Seidel.
 */
public class Metodositerativos {

    /** Resultado de un método iterativo: solución, iteraciones y trazas. */
    public static class Resultado {
        public double[] solucion;          // aproximación final
        public int iteraciones;            // número de iteraciones realizadas
        public double error;               // error máximo de la última iteración
        public boolean convergio;          // true si se alcanzó la tolerancia
        public List<double[]> historial = new ArrayList<>(); // X(k) de cada iteración
    }

    /**
     * Método de Jacobi.
     * Usa un vector AUXILIAR para guardar los valores nuevos: todos los
     * cálculos de la iteración k+1 usan únicamente valores de la iteración k.
     */
    public static Resultado jacobi(double[][] A, double[] b, double[] x0, double tol, int maxIter) {
        int n = b.length;
        Resultado res = new Resultado();
        double[] x = x0.clone();            // copia: no se modifica el vector inicial original

        for (int k = 1; k <= maxIter; k++) {
            double[] xNuevo = new double[n];   // vector auxiliar para los valores nuevos

            for (int i = 0; i < n; i++) {
                double suma = 0.0;
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        suma += A[i][j] * x[j];   // se usa SIEMPRE el valor anterior
                    }
                }
                xNuevo[i] = (b[i] - suma) / A[i][i];
            }

            double error = errorMaximo(xNuevo, x);
            x = xNuevo;                         // el auxiliar pasa a ser el vector actual

            res.historial.add(x.clone());
            res.iteraciones = k;
            res.error = error;
            if (error < tol) {
                res.convergio = true;
                break;
            }
        }
        res.solucion = x;
        return res;
    }

    /**
     * Método de Gauss-Seidel.
     * Actualiza cada variable de INMEDIATO: en cuanto se calcula x[i] nuevo,
     * se usa en el cálculo de las variables siguientes de la misma iteración.
     */
    public static Resultado gaussSeidel(double[][] A, double[] b, double[] x0, double tol, int maxIter) {
        int n = b.length;
        Resultado res = new Resultado();
        double[] x = x0.clone();

        for (int k = 1; k <= maxIter; k++) {
            double error = 0.0;

            for (int i = 0; i < n; i++) {
                double suma = 0.0;
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        suma += A[i][j] * x[j];   // x[j] ya puede ser un valor nuevo (j < i)
                    }
                }
                double nuevo = (b[i] - suma) / A[i][i];
                error = Math.max(error, Math.abs(nuevo - x[i]));
                x[i] = nuevo;                      // actualización inmediata
            }

            res.historial.add(x.clone());
            res.iteraciones = k;
            res.error = error;
            if (error < tol) {
                res.convergio = true;
                break;
            }
        }
        res.solucion = x;
        return res;
    }

    /** Error = máxima diferencia absoluta entre dos aproximaciones consecutivas. */
    private static double errorMaximo(double[] nuevo, double[] anterior) {
        double max = 0.0;
        for (int i = 0; i < nuevo.length; i++) {
            max = Math.max(max, Math.abs(nuevo[i] - anterior[i]));
        }
        return max;
    }
}