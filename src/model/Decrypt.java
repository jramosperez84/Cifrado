package model;

import aux.Constants;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Decrypt {
    public static Decrypt decrypt() {
        return new Decrypt();
    }

    public String decryptMessage(byte[] encryptedMessage, SecretKey secretKey) {
        Cipher desCipher;
        byte[] decryptedMessage = new byte[0];

        try {
            desCipher = Cipher.getInstance(Constants.ENCRYPT_SYSTEM);
            desCipher.init(Cipher.DECRYPT_MODE, secretKey);
            decryptedMessage = desCipher.doFinal(encryptedMessage);
        } catch (NoSuchAlgorithmException e) {
            System.err.println("NoSuchAlgorithmException".concat(e.getMessage()));
        } catch (NoSuchPaddingException e) {
            System.err.println("NoSuchPaddingException".concat(e.getMessage()));
        } catch (IllegalBlockSizeException e) {
            //System.err.println("IllegalBlockSizeException".concat(e.getMessage()));
        } catch (BadPaddingException e) {
            System.err.println("BadPaddingException".concat(e.getMessage()));
        } catch (InvalidKeyException e) {
            System.err.println("InvalidKeyException".concat(e.getMessage()));
        }
        return new String(decryptedMessage);
    }
}
