package ch.zhaw.homework.le01.Wissenssicherung;

import java.util.ArrayList;
import java.util.Random;

public class Answer {

    private Random random;
    private ArrayList<String> answer;

    public Answer() {

        answer = new ArrayList<>();
        random = new Random();
        setAnswer();

    }
    public void setAnswer() {
        answer.add("Kino");
        answer.add("Essen");
        answer.add("Tanzen");
        answer.add("Chillen");
    }
    public String getAnswer() {
        return answer.get(random.nextInt(answer.size()));
    }
}
