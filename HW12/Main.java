package HW12;


public class Main extends Thread {

    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;
    static float[] arr1 = new float[SIZE];
    static float[] arr2 = new float[SIZE];


    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < SIZE; i++) { // заполняем единицами
            arr1[i] = 1;
            arr2[i] = 1;
        }


        method1();
        System.out.println("***********");
        method2();


    }

    /**
     * //простой метод по заданию
     */
    static void method1() {

        long a = System.currentTimeMillis();

        arrFormula(arr1);

        System.out.printf("Время выполнения метода 1: %d милисекунд.\n", System.currentTimeMillis() - a);
        System.out.println("Сумма элементов: " + arrSum(arr1));
    }

    /**
     * метод с 2мя потоками по заданию
     * @throws InterruptedException чтобы не писать try/catch везде
     */
    static void method2() throws InterruptedException {
        float[] a1 = new float[HALF]; // половины массива временные
        float[] a2 = new float[HALF];

        Runnable runnable1 = () -> { /////////////////// переменные интерфейса? оО с реализацией метода run()
            arrFormula(a1);
            System.out.println("Первая половина посчитана");
        };

        Runnable runnable2 = () -> {
            arrFormula(a2);
            System.out.println("Вторая половина посчитана");
        };

        long a = System.currentTimeMillis(); // засекаем время


        System.arraycopy(arr2, 0, a1, 0, HALF);
        System.arraycopy(arr2, HALF, a2, 0, HALF);

        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable2);

        t1.start();
        t2.start();
        t1.join(); // ждем, пока потоки всё посчитают
        t2.join();


        System.arraycopy(a1, 0, arr2, 0, HALF); // собираем массив обратно
        System.arraycopy(a2, 0, arr2, HALF, HALF);


        System.out.printf("Время выполнения метода 2: %d милисекунд.\n", System.currentTimeMillis() - a);
        System.out.println("Сумма элементов: " + arrSum(arr2)); // для теста


    }

    ////////////////////////////////// вспомогательные методы



    public static void arrFormula(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    static float arrSum(float[] arr) {
        float result = 0;
        for (float v : arr) {
            result += v;
        }
        return result;
    }
}
