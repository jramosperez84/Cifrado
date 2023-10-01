package controller;

import aux.Constants;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

public class GenerateSecretKey {


    public static SecretKey secretKey() {
        KeyGenerator keyGenerator = null;
        try {
            keyGenerator = KeyGenerator.getInstance(Constants.ENCRYPT_SYSTEM);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return keyGenerator.generateKey();
    }

    public static SecretKey getNewKey() {
        return secretKey();
    }
}
