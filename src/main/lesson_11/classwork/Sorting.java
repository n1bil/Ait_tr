package main.lesson_11.classwork;

import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        System.out.println("Array sorting");
        // Задан массив целых чисел: 46, 13, 1, 10, 67, -4, 20, 56, 11, 35. Выполнить
        // массива от меньшого к большему

        // Способов сортировки всего 2 - первый математики по числам, второй по алфавиту
        // Есть еще один способ - по времени, если есть метка времени

        // Алгоритм:
        // "bubble sort" - меньший элемент "всплывает" в начало (левый конец) массива
        // наименьший элемент должен получить индекс = 0 и т.д.
        // цикл по элементам массива от начала до конца, наименьший элемент ставим на место 1-го
        // сдвигаемся ко 2-му элементу массива и делаем тоже самое
        // цикл в цикле - первый цикл проходит по массиву, второй (внутренний) ищет минимальный из оставшихся

        int min, indexOfMin;
        int[] numbers = {46, 13, 1, 10, 67, -4, 20, 56, 11, 35};

        System.out.println(Arrays.toString(numbers)); // print array

        for (int i = 0; i < numbers.length; i++) {
            min = numbers[i]; // присваиваем минимальное
            indexOfMin = i;   // присваиваем индекс
            // обойти все елементы правее от текущего
            for (int j = i; j < numbers.length; j++) {
                // find new min
                if (numbers[j] < min) {
                    min = numbers[j]; // new min
                    indexOfMin = j;   // index of new min
                }
            } // end of for "j"
            // switch elements
            int temp = numbers[i];
            numbers[i] = numbers[indexOfMin]; // element with min index
            numbers[indexOfMin] = temp;

            System.out.println(Arrays.toString(numbers)); // test printing
        }
    }
}













