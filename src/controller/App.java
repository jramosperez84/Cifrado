package controller;

import aux.Constants;
import model.Decrypt;
import model.Encrypt;
import view.ErrorInterface;
import view.UserInterface;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Scanner;

public class App {
    private final SecretKey secretKey = GenerateSecretKey.getNewKey();
    private FileManagement fileManagement;

    public App() {
        fileManagement = FileManagement.fileManagement();
    }

    public static App app() {
        return new App();
    }

    public void applicationMenu() {
        Scanner dataEntry = new Scanner(System.in);
        String filePath, messageText, outputMessage;
        int menuOption;
        UserInterface.mainMenu();
        menuOption = Integer.parseInt(dataEntry.nextLine());

        switch (menuOption) {
            case Constants.ENCRYPT -> {
                UserInterface.getDocumentName();
                filePath = dataEntry.nextLine();
                UserInterface.getStrText();
                messageText = dataEntry.nextLine();
                encryptMessage(filePath, messageText);
                applicationMenu();
            }
            case Constants.DECRYPT -> {
                UserInterface.getDocumentName();
                filePath = dataEntry.nextLine();
                outputMessage = decryptMessage(filePath);
                System.out.println(outputMessage);
                applicationMenu();
            }
            case Constants.EXIT -> System.exit(0);
            default -> ErrorInterface.chooseValidOption();
        }
    }

    private void encryptMessage(String filePath, String messageText) {
        Encrypt encrypt = Encrypt.encrypt();
        fileManagement = FileManagement.fileManagement();
        byte[] desKey = secretKey.getEncoded();
        byte[] encryptedMessage = encrypt.encryptMessage(messageText, secretKey);
        fileManagement.writeFile(filePath, encryptedMessage);
        fileManagement.writeSecretKey(Constants.PREFIX.concat(filePath), desKey);
    }

    private String decryptMessage(String filePath) {
        Decrypt decrypt = Decrypt.decrypt();
        byte[] SecretKey = fileManagement.readFile(Constants.PREFIX.concat(filePath));
        byte[] encryptedMessage = fileManagement.readFile(filePath);
        SecretKey originalKey = new SecretKeySpec(SecretKey, Constants.ENCRYPT_SYSTEM);
        return decrypt.decryptMessage(encryptedMessage, originalKey);
    }
}


