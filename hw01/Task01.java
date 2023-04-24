package hw01;

public class Task01 {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {10, 9, 8, 7, 6};
        int[] arr3 = {0, 1, 2, 3, 4, 5};
        int[] arr4 = {10, 9, 8, 7, 6};
        try {
            PrintArr(SubArray(arr1, arr2));
            PrintArr(SubArray(arr3, arr4));
        } catch (DifferentLengthException e) {
            System.out.println(e);
        }
    }

    public static int[] SubArray(int[] arr1, int[] arr2) throws DifferentLengthException{
        if (arr1.length != arr2.length ) {
            throw new DifferentLengthException();
        }
        if (arr1.length == 0) {
            return arr1;
        }

        int[] result = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            result[i] = arr1[i] - arr2[i];
        }
        return result;
    }

    public static void PrintArr(int[] arr) {
        System.out.print("[ ");
        for (int i : arr) {
            System.out.printf("%s ", i);
        }
        System.out.println("]");
    }
}
