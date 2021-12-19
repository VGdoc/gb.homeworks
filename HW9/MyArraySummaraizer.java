package HW9;

public class MyArraySummaraizer {

    private final int ARRAY_SIZE = 4;

    private String[][] stringArr = new String[ARRAY_SIZE][ARRAY_SIZE];


    /**
     * констуктор перезаписывает входящий массив в поле класса, но проверяет его предварительно на
     * соответствие требуемым размерам. Бросает ошибку в случае несоответствия
     * @param arr строковый массив
     * @throws MyArraySizeException
     */
    MyArraySummaraizer(String[][] arr) throws MyArraySizeException {

        if (arr.length != ARRAY_SIZE) { ///////////////////////////////////////// 2 блока if чтобы точно знать где ошибка и сказать об этом
            throw new MyArraySizeException(ARRAY_SIZE, arr.length);
        }
        else if (arr[0].length != ARRAY_SIZE){
            throw new MyArraySizeException(ARRAY_SIZE, arr[0].length);
        } else {
            for (int i = 0; i < ARRAY_SIZE; i++) {
                for (int j = 0; j < ARRAY_SIZE; j++) {
                    stringArr[i][j] = arr[i][j];
                }
            }
        }
    }

    public int summarize() throws MyArrayDataException {
        int result = 0;
        for (String[] a : stringArr) {
            for (String b : a) {
                try {
                    result += Integer.parseInt(b);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException();
                }

            }

        }
        return result;
    }
}
