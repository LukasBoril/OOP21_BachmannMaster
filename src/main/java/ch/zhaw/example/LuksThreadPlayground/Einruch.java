package ch.zhaw.example.LuksThreadPlayground;

public class Einruch {

    private Haus haus = new Haus();
    private TheJob job = new TheJob(haus);

    public static void main(String[] args) {
        Einruch einbruch = new Einruch();
        einbruch.los();
    }

    public void los() {
        Thread tobi = new Thread(job);
        Thread abdul = new Thread(job);
        tobi.setName("Tobi");
        abdul.setName("Abdul");
        tobi.start();
        abdul.start();

    }

}
