package ch.zhaw.homework.le04.v4.persistence;



import ch.zhaw.homework.le04.v4.domain.IOStrategy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class ObjectStreamStrategy implements IOStrategy {

    public void save(File file, List<String> decisions) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(decisions);
        }
    }

    public List<String> load(File file) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            List<String> decisions = (List<String>) ois.readObject();
            return decisions;
        }
    }
}
