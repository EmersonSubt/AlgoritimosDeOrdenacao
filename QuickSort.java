public class QuickSort {
    public static void quickSort(int[] array, int inicio, int fim) {
        if (inicio < fim) {
            int pi = parti(array, inicio, fim);

            
            quickSort(array, inicio, pi - 1);
            quickSort(array, pi + 1, fim);
        }
    }

    private static int parti(int[] array, int inicio, int fim) {
        int pivot = array[fim];
        int i = (inicio - 1);

        for (int j = inicio; j < fim; j++) {
            if (array[j] <= pivot) {
                i++;

                
                int dadoTemporario = array[i];
                array[i] = array[j];
                array[j] = dadoTemporario;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[fim];
        array[fim] = temp;

        return i + 1;
    }
}