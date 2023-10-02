package model;

import aux.Constants;
import view.ErrorInterface;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Encrypt {
    public static Encrypt encrypt() {
        return new Encrypt();
    }

    public byte[] encryptMessage(String message, SecretKey secretKey) {
        byte[] encryptedMessage = new byte[0];

        try {
            Cipher desCipher = Cipher.getInstance(Constants.ENCRYPT_SYSTEM);
            desCipher.init(Cipher.ENCRYPT_MODE, secretKey);

            encryptedMessage = desCipher.doFinal(message.getBytes());
            return encryptedMessage;
        } catch (NoSuchPaddingException e) {
            ErrorInterface.noSuchPaddingException(e);
        } catch (IllegalBlockSizeException e) {
            ErrorInterface.illegalBlockSizeException(e);
        } catch (NoSuchAlgorithmException e) {
            ErrorInterface.noSuchAlgorithmException(e);
        } catch (BadPaddingException e) {
            ErrorInterface.badPaddingException(e);
        } catch (InvalidKeyException e) {
            ErrorInterface.invalidKeyException(e);
        }
        return encryptedMessage;
    }
}
