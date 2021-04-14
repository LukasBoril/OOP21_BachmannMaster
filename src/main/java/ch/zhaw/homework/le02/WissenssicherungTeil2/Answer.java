package ch.zhaw.homework.le02.WissenssicherungTeil2;


import java.util.ArrayList;
import java.util.Random;

public class Answer {

    private Random random;
    private ArrayList<String> answer;

    public Answer() {

        answer = new ArrayList<>();
        random = new Random();
        fillAnswer();

    }
    public void fillAnswer() {
        answer.add("Kino");
        answer.add("Essen");
        answer.add("Tanzen");
        answer.add("Chillen");
    }

    public void setAnswer(String text) {
        String leerString = "";
        if (!answer.contains(text) && !(text.equals(leerString))) {
            answer.add(text);
        }
    }

    public String getAnswer() {
        return answer.get(random.nextInt(answer.size()));
    }
}
