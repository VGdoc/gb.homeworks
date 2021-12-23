package HW10;

import java.util.Arrays;
import java.util.Random;

public class Main {
static Random random = new Random();
    public static void main(String[] args) {

        ///////////////// Task 1 /////////////////////////////////////////////////////////////////////////
        String[] words = new String[] {"Вова", "Петя","Маша","Миша","Коля","Петя","Вова","Герасим","Степан","Юрий","Афанасий","Глеб","Герасим"};

        FirstTaskStaticClass.showUniqueWords(words);
        System.out.println("*********************");
        FirstTaskStaticClass.showNameStatistics(words);


        //////////////// Task 2 //////////////////////////////////////////////////////////////////////////
        System.out.println("*********************");

        TelephoneBook tBook = new TelephoneBook();

        tBook.add("Григорьев",3801276580L); // Есть повторения
        tBook.add("Фокин",3801487112L);
        tBook.add("Шестаков",3801857237L);
        tBook.add("Хохлов",3801199951L);
        tBook.add("Шубин",3801924219L);
        tBook.add("Бирюков",3801494097L);
        tBook.add("Копылов",3801909335L);
        tBook.add("Горбунов",3801374212L);
        tBook.add("Лыткин",3801745861L);
        tBook.add("Лыткин",3801471772L);
        tBook.add("Григорьев",3801689150L);
        tBook.add("Фокин",3801357644L);
        tBook.add("Шестаков",3801629773L);
        tBook.add("Хохлов",3801766417L);
        tBook.add("Шубин",3801028364L);
        tBook.add("Григорьев",3801003244L);
        tBook.add("Лыткин",3801523102L);
        tBook.add("Горбунов",3801687757L);
        tBook.add("Лыткин",3801550459L);
        tBook.add("Соколов",3801617238L);


        /////////////////// для тестов
        String testSurname = "Лыткин";
        System.out.printf("Номера контакта \"%s\": ",testSurname);
        System.out.println(Arrays.toString(tBook.get(testSurname)));
        //_________________
        System.out.println();
        testSurname = "Григорьев";
        System.out.printf("Номера контакта \"%s\": ",testSurname);
        System.out.println(Arrays.toString(tBook.get(testSurname)));
        //_________________
        System.out.println();
        testSurname = "Соколов";
        System.out.printf("Номера контакта \"%s\": ",testSurname);
        System.out.println(Arrays.toString(tBook.get(testSurname)));
        //_________________
        System.out.println();
        testSurname = "qwerty";
        System.out.printf("Номера контакта \"%s\": ",testSurname);
        System.out.println(Arrays.toString(tBook.get(testSurname)));

    }


}
