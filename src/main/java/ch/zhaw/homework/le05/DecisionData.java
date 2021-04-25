package ch.zhaw.homework.le05;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DecisionData {

    private List<String> decisions = null;
    private Random random = null;
    private IOStrategy strategy;

    public DecisionData(){
        decisions = new ArrayList<>();
        random = new Random();
        strategy = new ObjectIOStrategy();
        this.initValues();
    }

    public boolean isInList(String text){
        return decisions.contains(text);
    }

    public void addText(String text){
        decisions.add(text);
    }

    public String getRandomText(){
        return decisions.get(random.nextInt(decisions.size()));
    }

    public void setIOStategy(ObjectIOStrategy strategy){
        this.strategy = strategy;
    }

    public void setFileStrategy(FileIOStrategy strategy){
        this.strategy = strategy;
    }

    public void saveDecision(){
        strategy.serialize(decisions);
    }

    public void loadDecision(){
        decisions = strategy.deserialize();
    }

    private void initValues(){
        decisions.add("Kino");
        decisions.add("Essen gehen");
        decisions.add("Konzert");
    }

}
