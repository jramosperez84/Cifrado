package model;

import aux.Constants;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Encrypt {
    public static Encrypt encrypt() {
        return new Encrypt();
    }

    public byte[] encryptMessage(String message, SecretKey secretKey) {
        byte[] encryptedMessage = null;

        try {
            Cipher desCipher = Cipher.getInstance(Constants.ENCRYPT_SYSTEM);
            desCipher.init(Cipher.ENCRYPT_MODE, secretKey);

            encryptedMessage = desCipher.doFinal(message.getBytes());
            return encryptedMessage;
        } catch (NoSuchPaddingException e) {
            System.err.println("NoSuchPaddingException".concat(e.getMessage()));
        } catch (IllegalBlockSizeException e) {
            System.err.println("IllegalBlockSizeException".concat(e.getMessage()));
        } catch (NoSuchAlgorithmException e) {
            System.err.println("NoSuchAlgorithmException".concat(e.getMessage()));
        } catch (BadPaddingException e) {
            System.err.println("BadPaddingExceptio".concat(e.getMessage()));
        } catch (InvalidKeyException e) {
            System.err.println("InvalidKeyException".concat(e.getMessage()));
        }
        return encryptedMessage;
    }
}
