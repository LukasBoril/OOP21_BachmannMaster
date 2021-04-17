package ch.zhaw.homework.le04.v4.persistence;



import ch.zhaw.homework.le04.v4.domain.IOStrategy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileIOStrategy implements IOStrategy {

    @Override
    public List<String> load(File file) throws IOException,
            ClassNotFoundException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            List<String> decisions = new ArrayList<String>();

            String decision = reader.readLine();
            while (decision != null) {
                decisions.add(decision);
                decision = reader.readLine();
            }
            return decisions;
        }
    }

    @Override
    public void save(File file, List<String> decisions) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {

            for (String string : decisions) {
                writer.write(string);
                writer.newLine();
            }
        }
    }

}
