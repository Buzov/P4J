package com.barracuda.p4j.crypto.hash;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 *
 * @author artur
 */
public class PasswordHashWrapper {
    
    public static Hash getHashWithSalt(String password) throws NoSuchAlgorithmException, InvalidKeySpecException, UnsupportedEncodingException {
        String salt = PasswordHash.createSaltString();
        String hash = PasswordHash.createHash(password, salt);
        return new Hash(salt, hash);
    }
    
}
