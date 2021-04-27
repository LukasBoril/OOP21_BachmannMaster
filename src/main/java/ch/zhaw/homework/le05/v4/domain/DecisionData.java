package ch.zhaw.homework.le05.v4.domain;



import ch.zhaw.homework.le05.v4.persistence.ObjectStreamStrategy;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DecisionData {
    private final List<String> decisions;
    private final Random random;
    private IOStrategy ioStrategy;

    public DecisionData() {
        decisions = new ArrayList<String>();
        random = new Random();
        ioStrategy = new ObjectStreamStrategy();
    }

    public AddOperationResult addDecision(String input) {
        AddOperationResult addOperationResult = new AddOperationResult();
        String text = input.trim();
        if (text.isEmpty()) {
            addOperationResult.addErrorMessage("Nichts eigegeben");
        } else if (decisions.contains(text)) {
            addOperationResult.addErrorMessage("Eintrag schon vorhanden");
        } else {
            decisions.add(text);
        }
        return addOperationResult;
    }

    public String getRandomDecision() {
        if (decisions.isEmpty()) {
            return "keine Einträge";
        }
        int randomIndex = random.nextInt(decisions.size());
        return decisions.get(randomIndex);
    }

    private void setDecisions(List<String> newDecisions) {
        this.decisions.clear();
        this.decisions.addAll(newDecisions);
    }

    public void saveDecisions(File file) throws IOException {
        ioStrategy.save(file, decisions);
    }

    public void loadDecisions(File file) throws ClassNotFoundException, IOException {
        setDecisions(ioStrategy.load(file));
    }

    public void setIOStrategy(IOStrategy ioStrategy) {
        this.ioStrategy = ioStrategy;
    }

    public IOStrategy getIOStrategy() {
        return ioStrategy;
    }

    public int getCount() {
        return this.decisions.size();
    }
}
