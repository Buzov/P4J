package com.barracuda.p4j.crypto.hash;

import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.SecretKeyFactory;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public abstract class PasswordHash {
    
    public static final String PBKDF2_ALGORITHM = "PBKDF2WithHmacSHA1";

    // The following constants may be changed without breaking existing hashes.
    public static final int SALT_BYTE_SIZE = 40;
    public static final int HASH_BYTE_SIZE = 40;
    public static final int PBKDF2_ITERATIONS = 1000;
    
    private static final SecureRandom random = new SecureRandom();

    public static byte[] createSalt() {
        byte[] salt = new byte[SALT_BYTE_SIZE];
        random.nextBytes(salt);
        return salt; 
    }
    
    public static String createSaltString() {
        return toHex(createSalt()); 
    }
    
    public static String createHash(String password, String salt) throws NoSuchAlgorithmException, InvalidKeySpecException, UnsupportedEncodingException {
        return createHash(password.toCharArray(), salt.getBytes(), PBKDF2_ITERATIONS, HASH_BYTE_SIZE);
    }

    public static String createHash(char[] password, byte[] salt, int iterations, int hashByteSize) throws NoSuchAlgorithmException, InvalidKeySpecException, UnsupportedEncodingException {
        // Hash the password
        byte[] hash = pbkdf2(password, salt, iterations, hashByteSize);
        //return new String(hash, "UTF8");
        return toHex(hash);
    }
    
    public static boolean validatePassword(String password, String salt, String hash) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return validatePassword(password.toCharArray(), fromHex(salt), fromHex(hash), PBKDF2_ITERATIONS);
    }

    public static boolean validatePassword(String password, String salt, String hash, int iterations) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return validatePassword(password.toCharArray(), fromHex(salt), fromHex(hash), iterations);
    }
    
    public static boolean validatePassword(char[] password, byte[] salt, byte[] hash, int iterations) throws NoSuchAlgorithmException, InvalidKeySpecException {
        // Compute the hash of the provided password, using the same salt, 
        // iteration count, and hash length
        byte[] testHash = pbkdf2(password, salt, hash.length);
        // Compare the hashes in constant time. The password is correct if
        // both hashes match.
        return slowEquals(hash, testHash);
    }

    private static boolean slowEquals(byte[] a, byte[] b) {
        int diff = a.length ^ b.length;
        for (int i = 0; i < a.length && i < b.length; i++) {
            diff |= a[i] ^ b[i];
        }
        return diff == 0;
    }

    private static byte[] pbkdf2(char[] password, byte[] salt, int bytes) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return pbkdf2(password, salt, PBKDF2_ITERATIONS, bytes * 8);
    }
    
    private static byte[] pbkdf2(char[] password, byte[] salt, int iterations, int bytes) throws NoSuchAlgorithmException, InvalidKeySpecException {
        PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, bytes * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance(PBKDF2_ALGORITHM);
        return skf.generateSecret(spec).getEncoded();
    }   
        
    private static byte[] fromHex(String hex) {
        byte[] binary = new byte[hex.length() / 2];
        for (int i = 0; i < binary.length; i++) {
            binary[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return binary;
    }

    private static String toHex(byte[] array) {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if (paddingLength > 0) {
            return String.format("%0" + paddingLength + "d", 0) + hex;
        } else {
            return hex;
        }
    }

    public static void main(String[] args) {
        
    }

}
