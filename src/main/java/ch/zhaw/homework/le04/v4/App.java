package ch.zhaw.homework.le04.v4;


import ch.zhaw.homework.le04.v4.domain.DecisionData;
import ch.zhaw.homework.le04.v4.presentation.DecisionButtonPresentation;

public class App {

    private static DecisionData decisionData;

    public static DecisionData getDecisionData() {
        return decisionData;
    }

    public static void main(String[] args) {
        System.setProperty("prism.lcdtext", "false");
        new App().run(args);

    }

    public void run(String[] args) {
        decisionData = new DecisionData();
        DecisionButtonPresentation.main(args);
    }

}
