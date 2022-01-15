package HW14;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
    }

    /**
     * Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов, идущих после последней четверки.
     * @param arr целочисленный массив
     * @return целочисленный массив со значениями, идущими после последней 4ки входящего массива
     * @throws RuntimeException в случае отсутствия 4рок во входящем массиве
     */
    public static int[] arrayCutterAfterLastNumberFour(int[] arr) throws RuntimeException {
        if (!arrHasNumberFour(arr)) {
            throw new RuntimeException();
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 4) {
                int[] result = new int[arr.length - i - 1];
                System.arraycopy(arr, i + 1, result, 0, arr.length - i-1);
                return result;
            }
        }

        return arr;
    }

    /**
     * Метод проверяет, что в массиве есть и 1 и 4, но при этом нету других чисел
     * @param arr целочисленный массив
     * @return true если массив состоит только из 1 и 4, при этом и те другие присутствуют
     *         false в противном случае
     */
    public static boolean arrHasNumbersFourAndOne(int[] arr) {
        boolean hasOne = false,
                hasFour = false,
                hasOther = false;

        for (int a : arr){
            if (a == 1){
                hasOne = true;
            }
            else if (a == 4){
                hasFour = true;
            }
            else hasOther = true;
        }

        if (hasOne && hasFour && !hasOther){
            return true;
        }
        return false;
    }


    /**
     * Метод проверяет есть ли в целочисленном массиве хоть одна 4ка
     * @param arr целочисленный массив
     * @return true если есть, false если нет
     */
    public static boolean arrHasNumberFour(int[] arr) {
        for (int a : arr) {
            if (a == 4) {
                return true;
            }
        }
        return false;
    }
}
