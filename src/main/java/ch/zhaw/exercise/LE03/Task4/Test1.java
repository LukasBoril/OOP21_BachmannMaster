package ch.zhaw.exercise.LE03.Task4;

public class Test1 {
    public static void main(String[] args) {
        int[] intarr = new int[4];
        for (int i = 0; i < 8; i++) {
            try {
                intarr[i] = i; System.out.println(intarr[i]);

                //throw new NullPointerException();
            } catch (Exception e) {
                System.out.println(e.getClass().getName());
            System.out.println("Index zu gross: " + e.getMessage());
            }
        }
    }
}
