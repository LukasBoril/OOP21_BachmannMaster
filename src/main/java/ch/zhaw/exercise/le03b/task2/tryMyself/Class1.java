package ch.zhaw.exercise.le03b.task2.tryMyself;

public class Class1 {

    public static void main(String[] args) {
        int[] arr = new int[] {0,1,2};

        try {
            Class2 a = new Class2(arr);
        }
        catch (Exception e) {
            //e.printStackTrace();
        }
        finally {
            System.out.println("finally");
        }
    }
}
