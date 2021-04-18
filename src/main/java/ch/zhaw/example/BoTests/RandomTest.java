package ch.zhaw.example.BoTests;

import java.util.ArrayList;
import java.util.Random;

public class RandomTest {


    private ArrayList<String> randomText;
    private Random ran;

    public RandomTest() {
        randomText = new ArrayList<>();
        ran = new Random();
    }

    /**
     * Get an answer out of the ArrayList <randomText>
     * @return String previous entered text
     */
    public String getRandomText() {

        return randomText.get(ran.nextInt(randomText.size()));
    }

}
