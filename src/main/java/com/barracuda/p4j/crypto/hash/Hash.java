package com.barracuda.p4j.crypto.hash;

/**
 *
 * @author artur
 */
public class Hash {
    private String salt;
    private String hash;
    
    public Hash() {}

    public Hash(String salt, String hash) {
        this.salt = salt;
        this.hash = hash;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

}
