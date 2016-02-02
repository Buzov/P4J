package com.barracuda.p4j.crypto.hash;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 *
 * @author artur
 */
public class PasswordHashPBKDF2 extends PasswordHash{
    
    public static final String PBKDF2_ALGORITHM = "PBKDF2WithHmacSHA1";

    // The following constants may be changed without breaking existing hashes.
    public static final int SALT_BYTE_SIZE = 40;
    public static final int HASH_BYTE_SIZE = 40;
    public static final int PBKDF2_ITERATIONS = 1000;

    @Override
    public String getAlgorithm() {
        return PBKDF2_ALGORITHM;
    }

    @Override
    public int getSaltByteSize() {
        return SALT_BYTE_SIZE;
    }

    @Override
    public int getHashByteSize() {
        return HASH_BYTE_SIZE;
    }

    @Override
    public int getIterations() {
        return PBKDF2_ITERATIONS;
    }

    @Override
    protected KeySpec getKeySpec() {
        
    }
    
    private byte[] pbkdf2(char[] password, byte[] salt, int bytes) throws NoSuchAlgorithmException, InvalidKeySpecException {
        PBEKeySpec spec = new PBEKeySpec(password, salt, getIterations(), bytes * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance(getAlgorithm());
        return skf.generateSecret(spec).getEncoded();
    }
    
    
}
