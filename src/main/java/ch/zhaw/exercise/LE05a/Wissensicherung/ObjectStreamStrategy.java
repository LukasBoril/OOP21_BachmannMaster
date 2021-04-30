package ch.zhaw.exercise.LE05a.Wissensicherung;

import java.io.*;

public class ObjectStreamStrategy implements IOStrategy {

    public ObjectStreamStrategy(Object o){
        try {
            OutputStream fos = new FileOutputStream("src/main/java/ch/zhaw/exercise/LE05a/Wissensicherung/data.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(o);

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
