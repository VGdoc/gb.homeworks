package HW9;

import java.util.Random;

public class Main {


    public static void main(String[] args) {

        String[][] strArr = new String[4][4]; // поменять индексы для тестов исключений
        arrayFiller(strArr, false); ////// true - создаст массив только с числами, false - добавит 1 НЕ числовой элемент



        try {
            MyArraySummaraizer arraySummaraizer = new MyArraySummaraizer(strArr);
            System.out.println("Сумма элементов массива: " + arraySummaraizer.summarize());
        }
        catch (MyArraySizeException e){
            System.out.println(e.getMessage());
            System.out.printf("Вы прислали массив с размером: %d. Требуемый размер: %d.\n\n", e.getProvidedSize(), e.getRequiredSize());
        }
        catch (MyArrayDataException e){
            System.out.println(e.getMessage());
            System.out.printf("Несоответствующее значение: \"%s\" лежит по координатам: [%d][%d]\n\n", e.getElementData(),e.getyCoord(),e.getxCoord());
        }

        printArray(strArr);
        System.out.println();

    }

    /**
     * Заполняет массив случайными строками с числами. Или добавляет в случайный элемент строку "not_int" для тестов
     *
     * @param isOnlyNumbers если true то будут только числа, если false то гдето будет "not_int"
     */
    static void arrayFiller(String[][] arr, boolean isOnlyNumbers) {
        if (arr.length < 1 || arr[0].length < 1) { ///////////////  небольшая проверка для умников, которые создают массивы с 0 элементов, а потом пытаются их нициализировать
            System.out.println("Массив с 0 элементов. Переделать!");
            return;
        }

        Random random = new Random();

        for (int i = 0; i < arr.length; i++) { ////////////////////////// заполняем случайными значениями
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = String.valueOf(random.nextInt(10));
            }
        }
        if (!isOnlyNumbers) {
            arr[random.nextInt(arr.length - 1)][random.nextInt(arr[0].length - 1)] = "not_int"; // в случайном месте поместим строку not_int
        }
    }


    /**
     * просто красиво рисует двумерный массив в консоли
     * @param arr двумерный массив
     */
    static void printArray(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "  "); // тут знак табуляции
            }
            System.out.println();
        }
    }

}
