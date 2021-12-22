package HW10;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FirstTaskStaticClass {

    /**
     * Копирует массив строк в HashSet, чтобы удалить дубликаты и вы водит список в консоль
     * @param arr массив строк
     */
    public static void showUniqueWords(String[] arr){
        Set<String> set = new HashSet<>(Arrays.stream(arr).toList());
        System.out.println(set);
    }

    /**
     * Копирует массив строк в HashSet, чтобы убрать дубли. Сравнивает значения из HashSet со значениями из массива, если есть совпадения - инкрементирует счетчик.
     * Выводит сообщение в консоль о том, сколько раз встречается слово в массиве
     * @param arr массив строк
     */
    public static void showNameStatistics(String[] arr){
        int count = 0;
        Set<String> set = new HashSet<>(Arrays.stream(arr).toList());
        for (String s: set) {
            for(String a: arr){
                if (s == a){
                    count++;
                }
            }
            System.out.printf("Слово %s встречается %d раз.\n",s,count);
            count = 0;
        }
    }
}
