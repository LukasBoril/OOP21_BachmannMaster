package ch.zhaw.homework.le05a.task05_WiSiButton4;

import java.io.*;
import java.util.ArrayList;

public class ObjectStream implements Serializable {

    private static final long serialVersionID = 123777L;

    private String filePath;
    private String fileName;
    boolean askFroDeSer;

    public ObjectStream() {
        filePath = "/home/bonux/Documents/zhaw/testMat" +File.separator;
        fileName = "testButton4.ser";
        askFroDeSer = false;
    }

    /**
     * create a byte stream of the list received
     * and write it in a file to the given path
     * @param list
     */
    public void serialize(ArrayList<String> list) {

        if(list.isEmpty()) {
            System.out.println("the file is empty, so it will not be created/stored");
        }
        else {
            try (
                    OutputStream fos = new FileOutputStream(filePath + fileName);
                    ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(list);
                oos.close();
                fos.close();

                System.out.println("successfully wrote <text list> in to folder <ser>");
                System.out.println("-------------------------------------------------");
                System.out.println(" ");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * deserialize form a file
     * and bring it back to the button
     * @return list
     */
    public ArrayList<String> deSerialize(String file) {

        ArrayList<String> list = new ArrayList<>();

        try (InputStream fis = new FileInputStream(filePath + fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            list = (ArrayList) ois.readObject();

            ois.close();
            fis.close();

            System.out.println("successfully read list file");
            System.out.println("----------------------------------");
            System.out.println(" ");
        }
        catch( ClassNotFoundException | IOException exception) {
            System.out.println("file not found");
            exception.printStackTrace();
        }
        return list;
    }

    /**
     * handles the path to the file
     * @return filePath
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * give the file.ser given from Path
     * @return fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * have to be set to true outside this class
     * for handling the return of the
     * deserialized file return
     * @ param askFroDeSer
     */
    public void setBoolean(boolean bool) {
        this.askFroDeSer = bool;
    }
}
