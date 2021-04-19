package ch.zhaw.exercise.le03b.task3;

public class NotValidPhoneNumber extends Exception{
    public NotValidPhoneNumber() {
        System.out.println("Error: No valid Phone number!");
    }
}
