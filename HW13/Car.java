package HW13;


public class Car implements Runnable {
    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = Main.RESET + "\033[0;3" + CARS_COUNT%8 + "m" + //ставим цвет по кругу, стираем старую разметку и красим всю строку
                "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            Main.waitAllOthers();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
            if ( i + 1 == race.getStages().size()){ ///// если последний трек в заезде
                if (!race.getStages().get(i).isHasWinner()){ // если этот трек не имеет победителя
                    race.getStages().get(i).setHasWinner(true); //изменяем значение
                    System.out.printf("\033[0;93m" + "\nПОЗДРАВЛЯЕМ ПОБЕДИТЕЛЯ!\n***%s " + "\033[0;93m" + "пришёл первым!***\n\n" + Main.RESET,getName());
                }
                Main.waitAllOthers();
            }
        }
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }
}
