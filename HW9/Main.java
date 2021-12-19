package HW9;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        String[][] strArr = new String[4][4];
        arrayFiller(strArr, false);
        printArray(strArr);
        System.out.println();

        try {
            MyArraySummaraizer arraySummaraizer = new MyArraySummaraizer(strArr);
            System.out.println("Сумма элементов массива: " + arraySummaraizer.summarize());
        }
        catch (MyArraySizeException e){
            System.out.println("Массив не 4х4. Программа не будет работать.");
        }
        catch (MyArrayDataException e){
            System.out.println("В массиве содержатся не числовые значения. Программа не будет работать.");
        }
        catch (Exception e){
            System.out.println("Ooops! Something wrong!");
        }



    }

    /**
     * Заполняет массив случайными строками с числами или добавляет в случайный элемент строку "not_int" для тестов
     *
     * @param isOnlyNumbers если true то будут только числа, если false то гдето будет "not_int"
     */
    static void arrayFiller(String[][] arr, boolean isOnlyNumbers) {
        if (arr.length < 1 || arr[0].length < 1) {
            System.out.println("Массив с 0 элементов. Переделать!");
            return;
        }

        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = String.valueOf(random.nextInt(10));
            }
        }
        if (!isOnlyNumbers) {
            arr[random.nextInt(arr.length - 1)][random.nextInt(arr[0].length - 1)] = "not_int";
        }
    }

    static void printArray(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
    }

}
