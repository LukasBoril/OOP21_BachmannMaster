package ch.zhaw.exercises.le03b.task1;

public class Catch {
    public static void main(String[] args) {
        try {
            int i = Integer.parseInt(args[0]);
            System.out.print("i= " + i);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.print("Parameter vergessen!");
        } catch (NumberFormatException e) {
            System.out.print(" kein int-Wert!");
        } finally {
            System.out.println(" finally!");
        }
    }

}
