package ch.zhaw.homework.le05;

import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectIOStrategy implements IOStrategy{

    Stage stage = new Stage();

    @Override
    public void serialize(List<String> data) {
        try {
            OutputStream fos = new FileOutputStream(new FileSelector().saveFile(stage));
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(data);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> deserialize() {

        try {
            InputStream fis = new FileInputStream(new FileSelector().loadFile(stage));
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<String> list = (ArrayList<String>) ois.readObject();
            ois.close();

            return list;

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
