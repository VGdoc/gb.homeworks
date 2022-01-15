package HW10;

import java.util.ArrayList;
import java.util.HashMap;

public class TelephoneBook {

    private HashMap<String, ArrayList<Long>> tBook = new HashMap<>();

    TelephoneBook() {
    }


    /**
     * добавляет абонента в справочник, или новый номер к существующему контакту
     * @param surname фамилия
     * @param number номер телефона
     */
    public void add(String surname, long number){

        if (tBook.containsKey(surname)){
            tBook.get(surname).add(number);
        }
        else {
            ArrayList<Long> lst = new ArrayList<>();
            lst.add(number);
            tBook.put(surname, lst);
        }
    }


    /**
     * возвращает массив номеров телефонов. Принципиально, чтобы усложнить задачу
     * @param surname фамилия
     * @return возвращает массив номеров телефонов либо null если фамилии нет в списке
     */
    public long[] get(String surname){

        if (tBook.containsKey(surname)){
            //https://stackoverflow.com/questions/718554/how-to-convert-an-arraylist-containing-integers-to-primitive-int-array
            return (tBook.get(surname).stream().filter(i -> i != null).mapToLong(i -> i).toArray());
        }
        else {
            return null;
        }

    }

}
