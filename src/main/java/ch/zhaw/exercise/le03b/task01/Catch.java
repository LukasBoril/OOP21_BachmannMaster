package ch.zhaw.exercise.le03b.task01;

public class Catch {

    public static void main(String[] args) {
        try {
            int i = Integer.parseInt(args[0]);
            System.out.println("i= " + i);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Parameter vergessen!");
        } catch (NumberFormatException e){
            System.out.println(" kein int-Wert!");
        } finally {
            System.out.println(" finally!");
        }
    }
}
