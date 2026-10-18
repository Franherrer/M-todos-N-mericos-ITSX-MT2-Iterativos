package Metodos_Iterativos;

/**
 Definición del sistema.
 * Almacena la matriz de coeficientes A, el vector independiente b,
 * el vector de aproximación inicial X(0) y la tolerancia de error.
 */
public class DefSistema {

    // Tolerancia de error establecida: ε = 0.0001
    public static final double TOLERANCIA = 0.0001;

    // Límite de seguridad para evitar ciclos infinitos si el método no converge
    public static final int MAX_ITERACIONES = 100;

    /** Matriz de coeficientes A del sistema. */
    public static double[][] matrizA() {
        return new double[][] {
                { 5.0, 1.0, 1.0 },
                { 1.0, 4.0, 1.0 },
                { 1.0, 2.0, 5.0 }
        };
    }

    /** Vector de términos independientes b. */
    public static double[] vectorB() {
        return new double[] { 7.0, 6.0, 8.0 };
    }

    /** Vector de aproximación inicial X(0) = [0, 0, 0]. */
    public static double[] vectorInicial() {
        return new double[] { 0.0, 0.0, 0.0 };
    }
}