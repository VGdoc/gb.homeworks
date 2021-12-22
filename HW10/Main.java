package HW10;

public class Main {

    public static void main(String[] args) {

        ///////////////// Task 1 ////////////////////////
        String[] words = new String[] {"Вова", "Петя","Маша","Миша","Коля","Петя","Вова","Герасим","Степан","Юрий","Афанасий","Глеб","Герасим"};

        FirstTaskStaticClass.showUniqueWords(words);
        System.out.println("*********************");
        FirstTaskStaticClass.showNameStatistics(words);

    }


}
