package ch.zhaw.example.LuksThreadPlayground;

public class Haus {


    public String getHausnummer() {
        System.out.println(Thread.currentThread().getName());
        return "Haus nummer 7";
    }

    public synchronized void einbruch()
    {
        System.out.println("Es wird eingebrochen");
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {
            System.out.println(e.toString());
        }
        System.out.println("EInbruch beendet. Es wurde gestohlen");
    }
}
