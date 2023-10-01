package controller;

import java.io.*;

public class FileManagement {
    public static FileManagement fileManagement() {
        return new FileManagement();
    }

    public void writeFile(String filePath, byte[] encryptedMessage) {
        File file = new File(filePath);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {

            OutputStream outputStream = new FileOutputStream(file);
            byteArrayOutputStream.write(encryptedMessage);
            byteArrayOutputStream.writeTo(outputStream);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println(" ");
        }
    }

    public byte[] readFile(String filePath) {
        File file = new File(filePath);
        byte[] contentFile = new byte[0];
        try(FileInputStream fileInputStream = new FileInputStream(file)) {

            contentFile = fileInputStream.readNBytes((int)file.length());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("ss");
        }
        return contentFile;
    }
}
