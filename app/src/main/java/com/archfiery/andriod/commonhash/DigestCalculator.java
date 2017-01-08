package com.archfiery.andriod.commonhash;


import org.bouncycastle.crypto.Digest;

public class DigestCalculator {

    private DigestFactory factory;

    public DigestCalculator() {
        factory = new DigestFactory();
    }

    public String getDigestString(String str, String algorithm) {
        Digest digest = factory.createDigest(algorithm);
        if (digest == null) return "";

        byte[] rawBytes = str.getBytes();
        digest.update(rawBytes, 0, rawBytes.length);
        byte[] encoded = new byte[digest.getDigestSize()];
        digest.doFinal(encoded, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < encoded.length; i++) {
            sb.append(String.format("%02x", encoded[i] ));
        }
        return sb.toString();
    }

}
