package model;

import aux.Constants;
import view.ErrorInterface;

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
            ErrorInterface.noSuchAlgorithmException(e);
        } catch (NoSuchPaddingException e) {
            ErrorInterface.noSuchPaddingException(e);
        } catch (IllegalBlockSizeException e) {
            ErrorInterface.illegalBlockSizeException(e);
        } catch (InvalidKeyException e) {
            ErrorInterface.invalidKeyException(e);
        } catch (BadPaddingException e) {
            ErrorInterface.badPaddingException(e);
        }
        return new String(decryptedMessage);
    }
}
