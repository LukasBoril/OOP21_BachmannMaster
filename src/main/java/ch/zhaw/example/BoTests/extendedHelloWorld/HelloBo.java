package ch.zhaw.example.BoTests.extendedHelloWorld;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HelloBo {

    private String string;
    final DateTimeFormatter dtf;
    final LocalDateTime now;

    public HelloBo(String string) {
        dtf = DateTimeFormatter.ofPattern("h:mm:ss a 'on' MMMM d, yyyy'.'");
        now = LocalDateTime.now();
        setString(string);
        //printOut();
    }

    public String getString() {
        return string;
    }

    private void setString(String string) {
        this.string = string;
    }

    public DateTimeFormatter getTime() {
        return dtf;
    }

    public LocalDateTime getDate() {
        return now;
    }

    public void printOut() {
        System.out.println(string +"\n" +
                            "The current time is:\n" + dtf.format(now)+ "\n" +
                "------*eof_println*------");
    }
}

