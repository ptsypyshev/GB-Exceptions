package hw01;

public class Task02 {
    public static void main(String[] args) {
        Integer[] arr1 = {1, 2, 3, 4, 5};
        Integer[] arr2 = {0, 9, 8, 7, 6};
        Integer[] arr3 = {0, 1, 2, 3, 4, 5};
        Integer[] arr4 = {10, 9, 8, 7, 6};
        try {
            PrintArr(DivArray(arr1, arr2));
            PrintArr(DivArray(arr3, arr4));
        } catch (DifferentLengthException e) {
            System.out.println(e);
        } catch (ArithmeticException e) {
            System.out.println("Division by zero exception");
        }

        try {
            PrintArr(DivArrayInt(arr1, arr2));
        } catch (DifferentLengthException e) {
            System.out.println(e);
        } catch (ArithmeticException e) {
            System.out.println("Division by zero exception");
        }
    }

    public static Double[] DivArray(Integer[] arr1, Integer[] arr2) throws DifferentLengthException {
        if (arr1.length != arr2.length) {
            throw new DifferentLengthException();
        }
        if (arr1.length == 0) {
            return new Double[0];
        }

        Double[] result = new Double[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            result[i] = arr1[i] / (double) arr2[i];
        }
        return result;
    }

    public static Integer[] DivArrayInt(Integer[] arr1, Integer[] arr2) throws DifferentLengthException, ArithmeticException {
        if (arr1.length != arr2.length) {
            throw new DifferentLengthException();
        }
        if (arr1.length == 0) {
            return arr1;
        }

        Integer[] result = new Integer[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            result[i] = arr1[i] / arr2[i];
        }
        return result;
    }

    public static <T> void PrintArr(T[] arr) {
        System.out.print("[ ");
        for (T i : arr) {
            System.out.printf("%s ", i);
        }
        System.out.println("]");
    }
}
