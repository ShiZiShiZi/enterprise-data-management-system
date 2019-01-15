package org.hfut.tool.global;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * PasswordEncryption
 *
 * @author Weixin
 * @date 2018/12/21
 * @describe Get encrypted password
 **/
public class PasswordEncryption {

    public static String getPasswordEncryptionWithUserName(String phoneNumber, String email,
                                                           String password) throws NoSuchAlgorithmException {
        String preEncryptionPassword = password + email + phoneNumber;
        BigInteger encryptedPassword;

        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(preEncryptionPassword.getBytes());
        encryptedPassword = new BigInteger(messageDigest.digest());
        return encryptedPassword.toString();
    }
}
