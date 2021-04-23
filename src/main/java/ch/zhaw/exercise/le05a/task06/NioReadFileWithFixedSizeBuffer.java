package ch.zhaw.exercise.le05a.task06;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class NioReadFileWithFixedSizeBuffer
{
    public static void main(String[] args) throws IOException  {
        String pathToPackage = "src/main/java/ch/zhaw/exercise/le05a/";
        try (RandomAccessFile reader = new RandomAccessFile(pathToPackage + "personen-crlf-utf8.txt", "r");
             FileChannel channel = reader.getChannel();
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {

            int bufferSize = 1024;
            if (bufferSize > channel.size()) {
                bufferSize = (int) channel.size();
            }
            ByteBuffer buff = ByteBuffer.allocate(bufferSize);

            while (channel.read(buff) > 0) {
                out.write(buff.array(), 0, buff.position());
                buff.clear();
            }

            String fileContent = new String(out.toByteArray(), StandardCharsets.UTF_8);
            System.out.println(fileContent);

        }
    }
}
