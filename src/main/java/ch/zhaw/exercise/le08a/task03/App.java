package ch.zhaw.exercise.le08a.task03;

public class App {

    public static void main(String[] args) {
        Tea t = new Tea("Darjeeling");

        Sirup s = new Sirup("Himbeer");

        System.out.println(t.getFlavour());
        System.out.println(s.getFlavour());
    }
}
