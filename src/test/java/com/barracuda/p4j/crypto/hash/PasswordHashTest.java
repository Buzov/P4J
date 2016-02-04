/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.barracuda.p4j.crypto.hash;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author artur
 */
public class PasswordHashTest {

    /**
     * Test of main method, of class PasswordHash.
     */
    /*@Test
    public void testValidatePassword() {*/
        
       /* try {
            String password = "passwod";
            Hash hash = PasswordHashWrapper.getHashWithSalt(password);
            System.out.println(hash);
            boolean failure = false;
            for (int i = 0; i < 100; i++) {
                assertTrue(PasswordHashWrapper.validatePassword(password, hash));
            }*/
            /*
            // Print out 10 hashes
            for (int i = 0; i < 10; i++) {
                System.out.println(PasswordHash.createHash("p\r\nassw0Rd!"));
            }

            // Test password validation
            boolean failure = false;
            System.out.println("Running tests...");
            for (int i = 0; i < 100; i++) {
                String password = "" + i;
                String hash = createHash(password);
                String secondHash = createHash(password);
                if (hash.equals(secondHash)) {
                    System.out.println("FAILURE: TWO HASHES ARE EQUAL!");
                    failure = true;
                }
                wrongPassword = "" + (i + 1);
                if (validatePassword(wrongPassword, hash)) {
                    System.out.println("FAILURE: WRONG PASSWORD ACCEPTED!");
                    failure = true;
                }
                if (!validatePassword(password, hash)) {
                    System.out.println("FAILURE: GOOD PASSWORD NOT ACCEPTED!");
                    failure = true;
                }
            }
            assertFalse(failure);*/
        /*} catch (UnsupportedEncodingException | NoSuchAlgorithmException | InvalidKeySpecException ex) {
            Logger.getLogger(PasswordHashTest.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    /*}*/
    
    @Test
    public void testGenerateHash() { 
        boolean failure = false;
        for (int i = 0; i < 100; i++) {
            try {
                String password = "" + i;
                Hash hash = PasswordHashWrapper.getHashWithSalt(password);
                Hash secondHash = PasswordHashWrapper.getHashWithSalt(password);
                if (hash.getHash().equals(secondHash.getHash())) {
                    System.out.println("FAILURE: TWO HASHES ARE EQUAL!");
                    failure = true;
                }
                String wrongPassword = "" + (i + 1);
                if (PasswordHashWrapper.validatePassword(wrongPassword, hash)) {
                    System.out.println("FAILURE: WRONG PASSWORD ACCEPTED!");
                    failure = true;
                }
                if (!PasswordHashWrapper.validatePassword(password, hash)) {
                    System.out.println("FAILURE: GOOD PASSWORD NOT ACCEPTED!");
                    failure = true;
                }
            } catch (NoSuchAlgorithmException | InvalidKeySpecException | UnsupportedEncodingException ex) {
                Logger.getLogger(PasswordHashTest.class.getName()).log(Level.SEVERE, null, ex);
            }
            assertFalse(failure);
        }
    }
    
}
