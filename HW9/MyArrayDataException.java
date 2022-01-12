package HW9;

public class MyArrayDataException extends Exception{
    private int xCoord, yCoord;
    String elementData;

    public MyArrayDataException(int xCoord, int yCoord, String elementData) {
        super("В массиве содержатся не числовые значения.");
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.elementData = elementData;
    }

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public String getElementData() {
        return elementData;
    }
}
