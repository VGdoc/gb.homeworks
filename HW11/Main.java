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

        Box<Fruit> box1 = new Box<>();
        Box<Fruit> box2 = new Box<>();
        Box<Fruit> box3 = new Box<>();
        Orange[] bulkOranges = new Orange[6]; //массив с апельсинами
        for (int i = 0; i < bulkOranges.length; i++){
            bulkOranges[i] = new Orange();
        }
        Apple[] bulkApples = new Apple[11]; //массив с яблоками
        for (int i = 0; i < bulkApples.length; i++){
            bulkApples[i] = new Apple();
        }


        box1.putFruits(new Orange()); // добавляем 1 апельсин в пустую коробку
        box2.putFruits(bulkOranges);  // добавляем 5 апельсинов в пустую коробку
        box3.putFruits(new Apple());  // добавляем яблоко в пустую коробку
        System.out.println("***");


        box1.putFruits(new Apple());  // пытаемся добавить яблоко в коробку с папельсином
        System.out.println("-");
        box1.putFruits(new Orange()); // добавляем еще 1 апельсин
        System.out.println("-");
        box1.putFruits(box3); // пытаемся пересыпать яблоко в коробку с апельсином
        System.out.println("-");
        box1.putFruits(box2); // пересыпаем апельсины со второй коробки в первую
        System.out.println("***");
        System.out.println("Коробка 1 - " + box1);
        System.out.println("Коробка 2 - " + box2);
        System.out.println("Коробка 3 - " + box3);


        System.out.println("\n*** Сравнение веса коробок ***");
        box3.putFruits(bulkApples); // добавляем 11 яблок в корбку, чтобы получить одинаковый вес
        System.out.println("Коробка 1 - " + box1);
        System.out.println("Коробка 2 - " + box2);
        System.out.println("Коробка 3 - " + box3);
        System.out.println("Сравниваем вес box1 и box2: " + box1.compare(box2));
        System.out.println("Сравниваем вес box1 и box3: " + box1.compare(box3));


        System.out.println("\n*** Высыпаем ИЗ коробки в другую ***");
        box1.unloadTo(box3); // пытаемся высыпать к яблокам
        box1.unloadTo(box2); // пересыпаем в пустую коробку
        System.out.println("Коробка 1 - " + box1);
        System.out.println("Коробка 2 - " + box2);
        System.out.println("Коробка 3 - " + box3);

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
