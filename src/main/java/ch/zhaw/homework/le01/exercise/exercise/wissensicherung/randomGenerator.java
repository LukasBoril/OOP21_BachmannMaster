package ch.zhaw.homework.le01.exercise.exercise.wissensicherung;

import java.util.Random;

public class randomGenerator {

    protected static Random random;

    public randomGenerator()
    {
       random = new Random();
    }

    public int getNextInt(int upperLimit)
    {

        return random.nextInt(upperLimit);

    }

}
