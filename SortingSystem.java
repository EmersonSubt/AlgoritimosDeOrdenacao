import java.io.*;
import java.util.*;

public class SortingSystem {

    
    public static int[] readDataFromFile(String filePath) throws IOException {
        List<Integer> dataList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] numbers = line.trim().split("\\s+");
                for (String num : numbers) {
                    dataList.add(Integer.parseInt(num));
                }
            }
        }
        return dataList.stream().mapToInt(i -> i).toArray();
    }

    a
    public static void main(String[] args) {
        String[] filePaths = {
            "conjuntosDeDados/aleatorio_100.csv", "conjuntosDeDados/aleatorio_1000.csv", "conjuntosDeDados/aleatorio_10000.csv", 
            "conjuntosDeDados/crescente_100.csv","conjuntosDeDados/crescente_1000.csv", "conjuntosDeDados/crescente_10000.csv", 
            "conjuntosDeDados/decrescente_100.csv", "conjuntosDeDados/decrescente_1000.csv", "conjuntosDeDados/decrescente_10000.csv"
        };

        for (String filePath : filePaths) {
            try {
                System.out.println("Processando arquivo: " + filePath);

                int[] data = readDataFromFile(filePath);

                int[] bubbleData = data.clone();
                long startTime = System.nanoTime();
                BubbleSort.bubbleSort(bubbleData);
                long endTime = System.nanoTime();
                System.out.println("Tempo de execução do Bubble Sort: " + (endTime - startTime) + " ns");

                int[] insertionData = data.clone();
                startTime = System.nanoTime();
                InsertionSort.insertionSort(insertionData);
                endTime = System.nanoTime();
                System.out.println("Tempo de execução do Insertion Sort: " + (endTime - startTime) + " ns");

                int[] quickData = data.clone();
                startTime = System.nanoTime();
                QuickSort.quickSort(quickData, 0, quickData.length - 1);
                endTime = System.nanoTime();
                System.out.println("Tempo de execução do Quick Sort: " + (endTime - startTime) + " ns");

                System.out.println();

            } catch (IOException e) {
                System.out.println("Erro ao ler o arquivo " + filePath + ": " + e.getMessage());
            }
        }
    }
}
