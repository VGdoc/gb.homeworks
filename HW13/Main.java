package HW13;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Main {

    //region цвета текста
    public static final String RESET = "\033[0m";  // Text Reset
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
    //endregion

    public static final int CARS_COUNT = 4;
    static CyclicBarrier cb = new CyclicBarrier(CARS_COUNT + 1); // машины + main

    public static void main(String[] args) {

        System.out.println(CYAN_BOLD_BRIGHT + "\nВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!" + RESET);
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }

        waitAllOthers();

        System.out.println(CYAN_BOLD_BRIGHT + "\nВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!" + RESET);

        waitAllOthers();

        System.out.println(CYAN_BOLD_BRIGHT + "\nВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!" + RESET);

    }

    public static void waitAllOthers(){
        try {
            cb.await();
        }
        catch (BrokenBarrierException | InterruptedException e){
            e.printStackTrace();
        }
    }
}

