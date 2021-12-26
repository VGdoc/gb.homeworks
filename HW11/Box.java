package HW11;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<F extends Fruit> {

    private ArrayList<F> boxContent = new ArrayList<>();
    private final float EMPTY_BOX_WEIGHT = 2.0f;

    /**
     * Рассчитывает общий вес коробки
     *
     * @return общий вес коробки
     */
    public float getWeight() {
        if (boxContent.isEmpty()) {
            return EMPTY_BOX_WEIGHT;
        } else {
            return EMPTY_BOX_WEIGHT + boxContent.size() * boxContent.get(0).getWeight();
        }
    }


    /**
     * Заполняет коробку из массива фруктов
     *
     * @param fruits
     */
    public void putFruits(F[] fruits) {

        if (fruits.length > 0) {
            if (checkFruitArray(fruits)) { // проверяем на однотипность фруктов
                if (boxContent.isEmpty() || boxContent.get(0).equals(fruits[0])) {
                    System.out.println("Успешно положили " + fruits.length + " шт. " + fruits[0].getName());
                    boxContent.addAll(Arrays.stream(fruits).toList());
                } else {
                    System.out.printf("Не могу добавить %dшт. %s\n", fruits.length, fruits[0].getName());
                    System.out.println("Коробка занята другими фруктами. Она содержит " + fruits[0].getName() + " в количестве " + boxContent.size() + "шт.");
                }
            }
        }
    }

    /**
     * добавляет фрукт в коробку если возможно
     * @param fruit
     */
    public void putFruits(F fruit) {
        if (boxContent.isEmpty() || boxContent.get(0).equals(fruit)) {
            boxContent.add(fruit);
            System.out.println("Успешно положили " + 1 + " шт. " + boxContent.get(0).getName());
        } else {
            System.out.printf("Не могу добавить %dшт. %s\n", 1, fruit.getName());
            System.out.println("Коробка занята другими фруктами. Она содержит " + boxContent.get(0).getName() + " в количестве " + boxContent.size() + "шт.");
        }
    }

    /**
     * пересыпает фрукты из другой коробки если возможно
     * @param anotherFruitBox коробка
     */
    public void putFruits(Box<F> anotherFruitBox) {
        if (!anotherFruitBox.boxContent.isEmpty()) {
            if (boxContent.isEmpty() || boxContent.get(0).equals(anotherFruitBox.getBoxContent().get(0))) {
                boxContent.addAll(anotherFruitBox.getBoxContent());
                System.out.println("Успешно положили " + anotherFruitBox.getBoxContent().size() + " шт. " + anotherFruitBox.getBoxContent().get(0).getName());
                anotherFruitBox.getBoxContent().clear();
            } else {
                System.out.printf("Не могу добавить %dшт. %s\n", anotherFruitBox.getBoxContent().size(), anotherFruitBox.getBoxContent().get(0).getName());
                System.out.println("Коробка занята другими фруктами. Она содержит " + boxContent.get(0).getName() + " в количестве " + boxContent.size() + "шт.");
            }
        }
    }

    /**
     * пересыпает фрукты в лругую коробку если возможно
     * @param anotherBox
     */
    public void unloadTo(Box<F> anotherBox) {
        anotherBox.putFruits(this);
    }


    @Override
    public String toString() {
        if (boxContent.isEmpty()) {
            return "Пустая коробка весом " + EMPTY_BOX_WEIGHT + "кг.";
        } else {
            return "Коробка с фруктами. " + "Она содержит " + boxContent.get(0).getName() + " в количестве " + boxContent.size() + "шт. Общий вес: " + getWeight() + "кг.";
        }

    }

    /**
     * проверяет массив с фруктами на однотипность
     * @param fruits массив с фруктами
     * @return тру - если массив однотипный
     */
    protected boolean checkFruitArray(F[] fruits) {
        if (fruits.length != 1) {
        for (int i = 0; i < fruits.length - 1; i++) {
                if (!fruits[i].equals(fruits[i + 1])) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * сравнивает вес 2х коробок
     * @param anotherBox 2я коробка
     * @return тру если вес одинаковый
     */
    public boolean compare(Box<F> anotherBox) {
        return getWeight() == anotherBox.getWeight();
    }

    public ArrayList<F> getBoxContent() {
        return boxContent;
    }


}
