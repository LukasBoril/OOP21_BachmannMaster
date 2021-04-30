package ch.zhaw.example.LuksThreadPlayground;

public class TheJob implements Runnable {

    Haus haus1;

    public TheJob(Haus haus)
    {

        this.haus1 = haus;
    }
    public void run()
    {
        haus1.einbruch();
    }
}
