import java.io.*;
import java.util.Scanner;

public class Inversa {

    public static void main(String[] args) {
        try {
            double[][] matriz = leerMatriz("matriz.txt");
            if (matriz.length != matriz[0].length) {
                System.out.println("La matriz debe ser cuadrada.");
                return;
            }

            double[][] inversa = inversa(matriz);
            if (inversa == null) {
                System.out.println("La matriz NO tiene inversa (determinante = 0).");
                return;
            }

            guardarMatriz(inversa, "inversa.txt");
            System.out.println("Inversa generada correctamente en inversa.txt");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static double[][] leerMatriz(String nombreArchivo) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(nombreArchivo));
        int n = sc.nextInt();
        double[][] m = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = sc.nextDouble();
            }
        }
        sc.close();
        return m;
    }

    public static void guardarMatriz(double[][] m, String nombreArchivo) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter(nombreArchivo));
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                pw.print(m[i][j] + " ");
            }
            pw.println();
        }
        pw.close();
    }

    public static double[][] inversa(double[][] A) {
        int n = A.length;
        double[][] aug = new double[n][2 * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                aug[i][j] = A[i][j];
                aug[i][j + n] = (i == j) ? 1 : 0;
            }
        }

        for (int i = 0; i < n; i++) {
            if (aug[i][i] == 0) {
                boolean cambio = false;
                for (int k = i + 1; k < n; k++) {
                    if (aug[k][i] != 0) {
                        double[] temp = aug[i];
                        aug[i] = aug[k];
                        aug[k] = temp;
                        cambio = true;
                        break;
                    }
                }
                if (!cambio)
                    return null;
            }

            double pivote = aug[i][i];
            for (int j = 0; j < 2 * n; j++) {
                aug[i][j] /= pivote;
            }

            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = aug[k][i];
                    for (int j = 0; j < 2 * n; j++) {
                        aug[k][j] -= factor * aug[i][j];
                    }
                }
            }
        }

        double[][] inv = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inv[i][j] = aug[i][j + n];
            }
        }
        return inv;
    }
}