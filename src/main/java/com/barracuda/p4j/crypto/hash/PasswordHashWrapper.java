package com.barracuda.p4j.crypto.hash;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public static boolean validatePassword(String password, Hash hash) {
        try {
            return PasswordHash.validatePassword(password, hash.getSalt(), hash.getHash());
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            Logger.getLogger(PasswordHashWrapper.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
