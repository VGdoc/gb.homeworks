package HW9;

public class MyArraySizeException extends Exception{
    private int requiredSize;
    private int providedSize;

    public MyArraySizeException(int requiredSize, int providedSize) {
        super("Неправильный размер массива.");
        this.requiredSize = requiredSize;
        this.providedSize = providedSize;
    }

    public int getRequiredSize() {
        return requiredSize;
    }

    public int getProvidedSize() {
        return providedSize;
    }
}
