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

    public void applicationMenu() { // Función con el menú de la aplicación.
        Scanner dataEntry = new Scanner(System.in);
        String filePath, messageText, outputMessage;
        int menuOption;
        UserInterface.mainMenu(); // Imprime el menú de usuario en pantalla
        menuOption = Integer.parseInt(dataEntry.nextLine());

        switch (menuOption) {
            case Constants.ENCRYPT -> {
                UserInterface.getDocumentName(); // Imprime petición de documento
                filePath = dataEntry.nextLine();
                UserInterface.getStrText(); // Imprime petición de texto a cifrar.
                messageText = dataEntry.nextLine();
                encryptMessage(filePath, messageText); // Llamada a la función que encripta el texto.
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
        Encrypt encrypt = Encrypt.encrypt(); // Named Constructor de la clase Encrypt
        fileManagement = FileManagement.fileManagement(); // Named Constructor de la clase FileManagement
        byte[] desKey = secretKey.getEncoded(); // Guardamos la SecretKey en un byte[] para almacenarla en un documento.
        byte[] encryptedMessage = encrypt.encryptMessage(messageText, secretKey); // Mensaje encriptado, mediante llamada a la función encryptMesaje de la clase Encrypt
        fileManagement.writeFile(filePath, encryptedMessage); // Se cuarda el mensaje en el documento con la funcion writeFile
        fileManagement.writeSecretKey(Constants.PREFIX.concat(filePath), desKey); // Guarda la clave en un documento con el mismo nombre de documento mas el prefijo key.
    }

    private String decryptMessage(String filePath) {
        Decrypt decrypt = Decrypt.decrypt(); // Named Constructor de la clase Decrypt
        byte[] SecretKey = fileManagement.readFile(Constants.PREFIX.concat(filePath)); // Recuperamos la clave mediante readFile
        byte[] encryptedMessage = fileManagement.readFile(filePath); // Recuperamos la clave mediante readFile
        SecretKey originalKey = new SecretKeySpec(SecretKey, Constants.ENCRYPT_SYSTEM); // Guardamos el array de byte recuperado del fichero key.documento.dat en una nueva instancia de SecretKey
        return decrypt.decryptMessage(encryptedMessage, originalKey); // Devolvemos el mensaje desencriptado.
    }
}


