package view;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class ErrorInterface {

    public static void chooseValidOption() {
        System.err.println("Introduzca una opción correcta");
    }

    public static void fileNotFoundException(FileNotFoundException e) {
        System.err.println("FileNotFoundException ".concat(e.getMessage()));
    }

    public static void ioException(IOException e) {
        System.err.println("IOException ".concat(e.getMessage()));
    }

    public static void noSuchAlgorithmException(NoSuchAlgorithmException e) {
        System.err.println("NoSuchAlgorithmException".concat(e.getMessage()));
    }

    public static void noSuchPaddingException(NoSuchPaddingException e) {
        System.err.println("NoSuchPaddingException".concat(e.getMessage()));
    }

    public static void illegalBlockSizeException(IllegalBlockSizeException e) {
        System.err.println("IllegalBlockSizeException".concat(e.getMessage()));
    }

    public static void invalidKeyException(InvalidKeyException e) {
        System.err.println("InvalidKeyException".concat(e.getMessage()));
    }

    public static void badPaddingException(BadPaddingException e) {
        System.err.println("BadPaddingException".concat(e.getMessage()));
    }
}
