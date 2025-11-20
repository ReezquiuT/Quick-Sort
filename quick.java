import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class quick {
    public static void quicksort(int[] arr, int inicio, int fin) {
        if (inicio < fin) {
            int pivoteIndex = particion(arr, inicio, fin);
            quicksort(arr, inicio, pivoteIndex - 1);
            quicksort(arr, pivoteIndex + 1, fin);
        }
    }

    private static int particion(int[] arr, int inicio, int fin) {
        int pivote = arr[fin];
        int i = inicio - 1;
        for (int j = inicio; j < fin; j++) {
            if (arr[j] <= pivote) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[fin];
        arr[fin] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Escribe el nombre del archivo (ej. datos.txt):");
            String nombreArchivo = entrada.readLine();

            // Ruta fija
            String ruta = "C:\\Archivos\\" + nombreArchivo;

            BufferedReader br = new BufferedReader(new FileReader(ruta));
            String linea = br.readLine();
            br.close();

            String[] partes = linea.trim().split("\\s+");
            int[] numeros = new int[partes.length];
            for (int i = 0; i < partes.length; i++) {
                numeros[i] = Integer.parseInt(partes[i]);
            }

            quicksort(numeros, 0, numeros.length - 1);

            System.out.println("\nNúmeros ordenados:");
            for (int n : numeros) {
                System.out.print(n + " ");
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}