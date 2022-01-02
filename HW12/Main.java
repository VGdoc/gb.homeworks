package HW12;


import java.util.Arrays;

public class Main extends Thread {

    static final int SIZE = 10000000;
    static float[] arr1 = new float[SIZE];
    static float[] arr2 = new float[SIZE];
    static int optimalFinderThreadCounter; // упрощает работу метода optimalFinder, запоминает оптимальное кол-во потоков


    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < SIZE; i++) { // заполняем единицами
            arr1[i] = 1;
            arr2[i] = 1;
        }


        method1();
        System.out.println("***********");
        method2(6); ////////////////// можно указать колличество потоков

        // мой лучший результат 62 потока (105 милисек)
        //System.out.println("Лучшее время выполнения метода method2(): " + optimalFinder(100) + "милисек. достигнуто при использовании " + optimalFinderThreadCounter + " потоков!");
    }

    /**
     * //простой метод по заданию
     */
    static void method1() {

        long a = System.currentTimeMillis();

        arrFormula(arr1);

        System.out.printf("Время выполнения метода 1: %d милисекунд.\n", System.currentTimeMillis() - a);
    }

    /**
     * 2й метод для задания, дробит подсчёт на потоки
     *
     * @param threadCounts кол-во потоков
     * @throws InterruptedException чтобы не писать везде трай кеч
     */
    static void method2(int threadCounts) throws InterruptedException {

        ///////////// создаём временные массивы для подсчёты в разных потоках
        float[][] arrayPart = new float[threadCounts][];
        for (int i = 0; i < threadCounts; i++) {
            if (SIZE % threadCounts != 0 && i + 1 == threadCounts) {
                //добавляем остаточные элементы к последнему массиву если, при делении массива есть остаток
                //это работает неоптимально (напр. Массив - 10 эл, 6 потоков. Будет обработано(эл) 1 + 1 + 1 + 1 + 1 + 5),
                //но работает. С миллионными массивами незаметно
                arrayPart[i] = new float[SIZE / threadCounts + SIZE % threadCounts];
            } else {
                arrayPart[i] = new float[SIZE / threadCounts];
            }

        }


        //////////////  создаём массив... методов... с разными частями массива для подсчёта в потоках. Как-то так
        Runnable[] runnables = new Runnable[threadCounts];
        for (int i = 0; i < threadCounts; i++) {
            int finalI = i;
            runnables[i] = () -> {
                arrFormula(arrayPart[finalI]);
                System.out.printf("Поток %d завершил подсчёт\n\n", finalI + 1);
            };
        }


        long a = System.currentTimeMillis(); // засекаем время


        ///////// копируем части нашего массива в массивы поменьше для потоков
        for (int i = 0; i < threadCounts; i++) {
            System.arraycopy(arr2, SIZE / threadCounts * i, arrayPart[i], 0, arrayPart[i].length);
        }


        /////////////// создаём потоки и запускаем
        Thread[] threads = new Thread[threadCounts];
        for (int i = 0; i < threadCounts; i++) {
            threads[i] = new Thread(runnables[i]);
            threads[i].start();
        }


        //////////////// ждём завершения всех потоков
        for (int i = 0; i < threadCounts; i++) {
            threads[i].join();
        }


        //////////////// собираем наш массив обратно
        for (int i = 0; i < threadCounts; i++) {
            System.arraycopy(arrayPart[i], 0, arr2, SIZE / threadCounts * i, arrayPart[i].length);
        }


        System.out.printf("Время выполнения метода 2: %d милисекунд.\n", System.currentTimeMillis() - a);


    }


    /**
     * массив для вычислений в массиве по заданию
     *
     * @param arr массив
     */
    public static void arrFormula(float[] arr) {
        int testCounter = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            testCounter++;
        }
        System.out.printf("Было обработано %d элементов массива\n", testCounter); // для тестов
    }


    /**
     * Метод помогает найти лучшее время по использованию разного колл-ва потоков
     * @param threadsCount кол-во потоков для тестов
     * @return лучшее время
     * @throws InterruptedException чтобы не писать трай кеч
     */
    public static long optimalFinder(int threadsCount) throws InterruptedException {
        long[] results = new long[threadsCount];


        for (int i = 1; i <= threadsCount; i++) {
            long a = System.currentTimeMillis(); // засекаем время
            method2(i);
            results[i-1] = System.currentTimeMillis() - a; // записываем минимальное время в массив
        }
        long bestResult = results[0];
        // находим лучшее время
        for (int i = 0; i < threadsCount; i++) {
            if (results[i] < bestResult) {
                bestResult = results[i];
                optimalFinderThreadCounter = i;
            }
        }
        return bestResult;


    }
}
