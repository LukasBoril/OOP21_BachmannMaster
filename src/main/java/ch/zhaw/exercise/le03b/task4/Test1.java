package ch.zhaw.exercise.le03b.task4;

public class Test1 {
    public static void main(String[] args) {
        int[] intarr = new int[4];
        for (int i = 0; i < 8; i++) {
            try {
                intarr[i] = i;
                System.out.println(intarr[i]);
                //throw new NullPointerException();
            } catch (Exception e) {
                System.out.println(e.getClass().getName());
                System.out.println("Index zu gross: " + e.getMessage());
            }
        }

    }
}
