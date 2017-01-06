package com.archfiery.andriod.commonhash;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 */
public class MyCommonHash {

    private final String UTF8 = "UTF-8";

    private String hashTextHelper(String s, String algo) {
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance(algo);
            md.update(s.getBytes(UTF8));
            byte[] digest = md.digest();
            for (int i = 0; i < digest.length; i++)
                sb.append(String.format("%02x", digest[i] & 0xFF));
        } catch (UnsupportedEncodingException uee) {
            uee.printStackTrace();
        } catch (NoSuchAlgorithmException nae) {
            nae.printStackTrace();
        }
        return sb.toString();
    }

    public String hashText(String s, String alg) {
        return hashTextHelper(s, alg);
    }
}
