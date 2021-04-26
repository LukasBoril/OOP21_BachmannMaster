package ch.zhaw.homework.le04bo;

import java.util.ArrayList;
import java.util.Random;

public class Randomizer {
    private Random ran;
    private ArrayList<String> list;

    public Randomizer() {
        this.ran = new Random();
        this.list = new ArrayList<>();
    }

    /**
     * give your input in to the ArrayList
     * @param text
     */
    public void addText(String text) {
        list.add(text);
    }
    /**
     * Get an answer out of the ArrayList <randomText>
     * @return String previous entered text
     */
    public String getRandomText() {
        return list.get(ran.nextInt(list.size()));
    }

    public int sizeOfList() {
        return list.size();
    }

    public ArrayList<String> getList() {
        return this.list;
    }
}