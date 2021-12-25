package HW11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        /////////////////////   Задание 1 тесты   /////////////////////////////
        System.out.println("\n********** Задание 1 тесты *************");
        int index1 = 0;
        int index2 = 3;
        Integer[] testArray = {1, 2, 3, 4, 5, 6};

        System.out.println("Наш массив:");
        printTestArray(testArray);
        System.out.printf("Меняем элемент номер %d и номер %d местами. Результат:\n", index1,index2);

        elementChanger(testArray, index1, index2);
        printTestArray(testArray);

        //////////////////////   Задание 2 тесты   ///////////////////////////
        System.out.println("\n********** Задание 2 тесты *************");
        ArrayList<Integer> lst = arrayToArrayListTransformer(testArray);

        System.out.println("Массив в виде ArrayList:");
        System.out.println(lst);

        //////////////////////   Задание 3 тесты   ///////////////////////////
        System.out.println("\n********** Задание 3 тесты *************");
    }

    //region Метод для задания 1

    /**
     * Метод меняет местами 2 элемента маасива
     *
     * @param arr                массив
     * @param firstElementIndex  индекс первого элемента
     * @param secondElementIndex индекс второго элемента
     * @param <C>                Универсальный тип данных массива
     */
    public static <C> void elementChanger(C[] arr, int firstElementIndex, int secondElementIndex) {

        if (arr.length != 0 &&///////////////////////////////////////////////////// проверяем индекс на выход за границы
                firstElementIndex >= 0 && firstElementIndex < arr.length &&
                secondElementIndex >= 0 && secondElementIndex < arr.length) {
            if (firstElementIndex == secondElementIndex) { //////////////////////  если индекс совпадает
                return;
            } else {///////////////////////////////////меняем элементы местами
                C temp = arr[firstElementIndex];
                arr[firstElementIndex] = arr[secondElementIndex];
                arr[secondElementIndex] = temp;
            }
        } else {
            System.out.println("Индексы за пределами массива, выполнение невозможно!");
        }
    }
    //endregion

    //region метод для задания 2

    /**
     * Метод трансформирует массив с ArrayList
     *
     * @param arr массив
     * @param <E> обобщенный тип
     * @return новый ArrayList который содержит все элементы массива
     */
    public static <E> ArrayList<E> arrayToArrayListTransformer(E[] arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }

    //endregion

    //region Вспомагательные методы
    public static  <E> void printTestArray(E[] arr) {
        for (E a : arr) {
            System.out.print(a);
        }
        System.out.println();
    }


//endregion

}
