package ch.zhaw.exercise.le08a.task3;

public class Start {

  public static void main(String[] args) {

    Tea t = new Tea("Darjeeling");

    Sirup s = new Sirup("Holunderblueten");

    Cup<Tea> cupOfTea = new Cup<>(t);

    System.out.println(cupOfTea);

    Cup<Sirup> cupOfSirup = new Cup<>(s);

    System.out.println(cupOfSirup);

  }

}
