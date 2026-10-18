# M-todos-N-mericos-ITSX-MT2-Iterativos
Repositorio de proyectos para la materia de metodos numericos 
# Práctica: Métodos Iterativos (Jacobi y Gauss-Seidel)

**Materia:**  Métodos Numéricos — Unidad 3
**Instituto:** Instituto Tecnológico Superior de Xalapa, Ing. en Sistemas Computacionales

Programa en **Java** que resuelve un sistema de ecuaciones lineales con los métodos
iterativos de **Jacobi** y **Gauss-Seidel**, y compara cuántas iteraciones necesita
cada uno para converger con la misma tolerancia.

## Sistema resuelto

```
5x +  y +  z = 7
 x + 4y +  z = 6
 x + 2y + 5z = 8
```

- Aproximación inicial: X(0) = [0, 0, 0]
- Tolerancia: ε = 0.0001
- Criterio de paro: máxima diferencia absoluta entre dos iteraciones consecutivas.
- Límite de seguridad: 100 iteraciones.

## Estructura modular

Todas las clases pertenecen al paquete `Metodos_Iterativos`.

| Módulo | Archivo | Responsabilidad |
|---|---|---|
| 1. Definición del sistema | `DefSistema.java` | Almacena la matriz A, el vector b, el vector inicial X(0) y la tolerancia. |
| 2. Métodos iterativos | `Metodositerativos.java` | Lógica de `jacobi(...)` (con vector auxiliar) y `gaussSeidel(...)` (actualización inmediata). |
| 3. Ejecución | `Lanzadoriterativos.java` | Clase principal: ejecuta ambos métodos, imprime las iteraciones y compara. |

## Lenguaje

Java (JDK 11 o superior).

## Compilar y ejecutar

Desde la carpeta que **contiene** a `Metodos_Iterativos/`:

```bash
# Compilar
javac Metodos_Iterativos/*.java

# Ejecutar
java Metodos_Iterativos.Lanzadoriterativos
```

También se puede abrir en un IDE (IntelliJ, NetBeans, Eclipse) y ejecutar la clase
`Lanzadoriterativos`.

## Ejecución

Tolerancia: 1.0E-4

=== METODO DE JACOBI ===
Iteracion  1: x = 1.400000  y = 1.500000  z = 1.600000
Iteracion  2: x = 0.780000  y = 0.750000  z = 0.720000
Iteracion  3: x = 1.106000  y = 1.125000  z = 1.144000
Iteracion  4: x = 0.946200  y = 0.937500  z = 0.928800
Iteracion  5: x = 1.026740  y = 1.031250  z = 1.035760
Iteracion  6: x = 0.986598  y = 0.984375  z = 0.982152
Iteracion  7: x = 1.006695  y = 1.007813  z = 1.008930
Iteracion  8: x = 0.996651  y = 0.996094  z = 0.995536
Iteracion  9: x = 1.001674  y = 1.001953  z = 1.002232
Iteracion 10: x = 0.999163  y = 0.999023  z = 0.998884
Iteracion 11: x = 1.000419  y = 1.000488  z = 1.000558
Iteracion 12: x = 0.999791  y = 0.999756  z = 0.999721
Iteracion 13: x = 1.000105  y = 1.000122  z = 1.000140
Iteracion 14: x = 0.999948  y = 0.999939  z = 0.999930
Iteracion 15: x = 1.000026  y = 1.000031  z = 1.000035
Iteracion 16: x = 0.999987  y = 0.999985  z = 0.999983
Convergio: si | Iteraciones: 16 | Error final: 0.000052
Solucion: x = 0.999987  y = 0.999985  z = 0.999983

=== METODO DE GAUSS-SEIDEL ===
Iteracion  1: x = 1.400000  y = 1.150000  z = 0.860000
Iteracion  2: x = 0.998000  y = 1.035500  z = 0.986200
Iteracion  3: x = 0.995660  y = 1.004535  z = 0.999054
Iteracion  4: x = 0.999282  y = 1.000416  z = 0.999977
Iteracion  5: x = 0.999921  y = 1.000025  z = 1.000006
Iteracion  6: x = 0.999994  y = 1.000000  z = 1.000001
Convergio: si | Iteraciones: 6 | Error final: 0.000072
Solucion: x = 0.999994  y = 1.000000  z = 1.000001

COMPARACION
Jacobi:       16 iteraciones
Gauss-Seidel: 6 iteraciones

Process finished with exit code 0

## Conclusión

La solución exacta del sistema es x = y = z = 1. Con la misma tolerancia
(ε = 0.0001), **Jacobi requirió 16 iteraciones y Gauss-Seidel solo 6**. Gauss-Seidel
converge más rápido porque usa los valores recién calculados dentro de la misma
iteración, mientras que Jacobi solo usa los de la iteración anterior. En ambos casos
la convergencia está garantizada porque la matriz es diagonalmente dominante.
