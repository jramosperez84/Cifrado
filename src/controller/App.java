package controller;

import aux.Constants;
import model.Decrypt;
import model.Encrypt;
import view.UserInterface;

import javax.crypto.SecretKey;
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
                System.out.print("Introduzca el nombre del documento: ");
                filePath = dataEntry.nextLine();
                System.out.print("Introduzca el texto a codificar: ");
                messageText = dataEntry.nextLine();
                encryptMessage(filePath,messageText);
                applicationMenu();
            }
            case Constants.DECRYPT -> {
                System.out.print("Introduzca el nombre del documento: ");
                filePath = dataEntry.nextLine();
                outputMessage = decryptMessage(filePath);
                System.out.println(outputMessage);
                applicationMenu();
            }
            case Constants.EXIT -> System.exit(0);
            default -> System.out.println("Introduzca una opción correcta");

        }
    }

    private void encryptMessage(String filePath, String messageText) {
        Encrypt encrypt = Encrypt.encrypt();
        fileManagement = FileManagement.fileManagement();
        byte[] encryptedMessage = encrypt.encryptMessage(messageText, secretKey);
        fileManagement.writeFile(filePath, encryptedMessage);
    }

    private String decryptMessage(String filePath) {
        Decrypt decrypt = Decrypt.decrypt();
        byte[] decryptedMessage = fileManagement.readFile(filePath);
        return decrypt.decryptMessage(decryptedMessage, secretKey);
    }
}


