package aplicacao;

import java.util.Scanner;

public class ProgramaPrincipal {
    // Contadores de comparações e trocas para Selection Sort
    private static int selectionSortComparacoes = 0;
    private static int selectionSortTrocas = 0;

    // Contadores de comparações para Merge Sort
    private static int mergeSortComparacoes = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[10];

        System.out.println("Digite 10 valores inteiros:");
        for (int i = 0; i < 10; i++) {
            array[i] = sc.nextInt();
        }

        // Usar um array clone
        int[] arrayClone = array.clone();

        selectionSort(array);
        mergeSort(arrayClone, new int[arrayClone.length], 0, arrayClone.length - 1);

        System.out.println("Resultado do Selection Sort:");
        printArray(array);
        System.out.println("Comparações: " + selectionSortComparacoes);
        System.out.println("Trocas: " + selectionSortTrocas);

        System.out.println("Resultado do Merge Sort:");
        printArray(arrayClone);
        System.out.println("Comparações: " + mergeSortComparacoes);
    }

    // Implementação do Selection Sort
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int indiceMenor = i;
            for (int j = i + 1; j < array.length; j++) {
                selectionSortComparacoes++;
                if (array[j] < array[indiceMenor]) {
                    indiceMenor = j;
                }
            }
            if (indiceMenor != i) {
                trocar(array, i, indiceMenor);
                selectionSortTrocas++;
            }
        }
    }

    // Implementação do Merge Sort
    public static void mergeSort(int[] array, int[] temp, int inicio, int fim) {
        if (inicio >= fim) {
            return;
        }
        int meio = (inicio + fim) / 2;
        mergeSort(array, temp, inicio, meio);
        mergeSort(array, temp, meio + 1, fim);
        mergeMetades(array, temp, inicio, fim);
    }

    public static void mergeMetades(int[] array, int[] temp, int inicio, int fim) {
        int meio = (inicio + fim) / 2;
        int esquerda = inicio;
        int direita = meio + 1;
        int indice = inicio;

        while (esquerda <= meio && direita <= fim) {
            mergeSortComparacoes++;
            if (array[esquerda] <= array[direita]) {
                temp[indice] = array[esquerda];
                esquerda++;
            } else {
                temp[indice] = array[direita];
                direita++;
            }
            indice++;
        }

        System.arraycopy(array, esquerda, temp, indice, meio - esquerda + 1);
        System.arraycopy(array, direita, temp, indice, fim - direita + 1);
        System.arraycopy(temp, inicio, array, inicio, fim - inicio + 1);
    }

    // Função de troca genérica
    public static void trocar(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Função para imprimir o array
    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}