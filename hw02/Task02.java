package hw02;

public class Task02 {
    public static void main(String[] args) {
        int[] intArray = new int[10];
        try {
            int d = 0;
            int catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
         } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
         }         
    }
}
