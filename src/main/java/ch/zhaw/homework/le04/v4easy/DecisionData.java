package ch.zhaw.homework.le04.v4easy;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Model class for the DecisionButton application
 * provides load and save methods based on the chosen IOStragegy
 */
public class DecisionData {

    private List<String> decisions = null;
    private Random random = null;
    private IOStrategy ioStrategy;

    public DecisionData() {
        decisions = new ArrayList<>();
        random = new Random();
        ioStrategy = new ObjectStreamStrategy();
    }

    private void setDecisions(List<String> newDecisions) {
        this.decisions.clear();
        this.decisions.addAll(newDecisions);
    }

    /**
     * Saves the decisions based on the chosen strategy
     * @param fileName file name including path
     * @throws IOException in case of save errors
     */
    public void saveDecisions(String fileName) throws IOException {
        ioStrategy.save(fileName, decisions);
    }

    /**
     * Loads the decisions based on the chosen strategy
     * @param fileName file name including path
     * @throws ClassNotFoundException in case of casting problems
     * @throws IOException in case of load errors
     */
    public void loadDecisions(String fileName) throws ClassNotFoundException, IOException {
        setDecisions(ioStrategy.load(fileName));
    }

    /**
     * Set an IOStrategy, e.g. File or Stream
     * @param ioStrategy the desired strategy
     */
    public void setIOStrategy(IOStrategy ioStrategy) {
        this.ioStrategy = ioStrategy;
    }

    public IOStrategy getIOStrategy () {
        return this.ioStrategy;
    }

    /**
     * Return random values (proposals)
     *
     * @return a random proposal
     */
    public String getRandomText() {
        return decisions.get(random.nextInt(decisions.size()));
    }

    /**
     * Add a decision
     * @param decision
     */
    public void add(String decision) {
        decisions.add(decision.trim());
    }

    /**
     * Number of decision entries
     * @return number of decisions
     */
    public int getSize() {
        return decisions.size();
    }

    /**
     * Is decision data empty
     * @return true if empty
     */
    public boolean isEmpty () {
        return decisions.isEmpty();
    }

    /**
     * Does a decision exist=
     * @param decision the decision to check
     * @return true if exists
     */
    public boolean contains (String decision) {
        return decisions.contains(decision.trim());
    }

}
