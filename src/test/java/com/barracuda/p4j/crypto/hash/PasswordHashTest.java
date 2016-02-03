/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.barracuda.p4j.crypto.hash;
import com.barracuda.p4j.crypto.hash.PasswordHash;
import static com.barracuda.p4j.crypto.hash.PasswordHash.createHash;
import static com.barracuda.p4j.crypto.hash.PasswordHash.validatePassword;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
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
    @Test
    public void testMain() {
        /*try {
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
            assertFalse(failure);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            System.out.println("ERROR: " + ex);
        }*/
    }
    
}
