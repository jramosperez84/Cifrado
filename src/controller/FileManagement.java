package controller;

import view.ErrorInterface;

import java.io.*;

public class FileManagement {

    public static FileManagement fileManagement() {
        return new FileManagement();
    }

    public void writeFile(String filePath, byte[] encryptedMessage) {
        saveData(filePath, encryptedMessage);
    }

    public void writeSecretKey(String filePath, byte[] secretKey) {
        saveData(filePath, secretKey);
    }

    private void saveData(String filePath, byte[] dataArray) {
        File file = new File(filePath);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            OutputStream outputStream = new FileOutputStream(file);
            byteArrayOutputStream.write(dataArray);
            byteArrayOutputStream.writeTo(outputStream);

        } catch (FileNotFoundException e) {
            ErrorInterface.fileNotFoundException(e);
        } catch (IOException e) {
            ErrorInterface.ioException(e);
        }
    }

    public byte[] readFile(String filePath) {
        File file = new File(filePath);
        byte[] contentFile = new byte[0];
        try(FileInputStream fileInputStream = new FileInputStream(file)) {

            contentFile = fileInputStream.readNBytes((int)file.length());

        } catch (FileNotFoundException e) {
            ErrorInterface.fileNotFoundException(e);
        } catch (IOException e) {
            ErrorInterface.ioException(e);
        }
        return contentFile;
    }
}
