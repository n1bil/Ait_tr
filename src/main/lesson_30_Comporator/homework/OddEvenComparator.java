package main.lesson_30_Comporator.homework;

import java.util.Comparator;

public class OddEvenComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        boolean number1 = o1 % 2 == 0;              // Проверяем, является ли число o1 четным
        boolean number2 = o2 % 2 == 0;              // Проверяем, является ли число o2 четным

        if (number1 && !number2) {                  // Если o1 четное, а o2 нечетное
            return -1;                              // Возвращаем -1 (Четное число должно идти перед нечетным)
        } else if (!number1 && number2) {           // Если о1 нечетное, а о2 четное
            return 1;                               // Возвращаем 1 (Нечетное число должно идти после четного)
        } else if (number1 && number2) {            // Если оба числа четные, используем естественный порядок сравнения
            return o1.compareTo(o2);                // Сортируем четные числа по возрастанию
        } else {                                    // Если оба числа нечетные, меняем порядок сравнения на обратный
            return o2.compareTo(o1);                // Сортируем нечетные числа по убыванию
        }
    }
}
