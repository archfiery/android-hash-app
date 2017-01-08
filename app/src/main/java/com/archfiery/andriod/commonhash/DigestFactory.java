package com.archfiery.andriod.commonhash;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD2Digest;
import org.bouncycastle.crypto.digests.MD4Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.digests.RIPEMD128Digest;
import org.bouncycastle.crypto.digests.RIPEMD160Digest;
import org.bouncycastle.crypto.digests.RIPEMD256Digest;
import org.bouncycastle.crypto.digests.RIPEMD320Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA224Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.digests.SHA384Digest;
import org.bouncycastle.crypto.digests.SHA3Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.crypto.digests.TigerDigest;
import org.bouncycastle.crypto.digests.WhirlpoolDigest;

public class DigestFactory {

    public Digest createDigest(String algorithm) {
        switch (algorithm) {
            case "MD2":
                return new MD2Digest();
            case "MD4":
                return new MD4Digest();
            case "MD5":
                return new MD5Digest();
            case "RIPEMD-128":
                return new RIPEMD128Digest();
            case "RIPEMD-160":
                return new RIPEMD160Digest();
            case "RIPEMD-256":
                return new RIPEMD256Digest();
            case "RIPEMD-320":
                return new RIPEMD320Digest();
            case "SHA-1":
                return new SHA1Digest();
            case "SHA-224":
                return new SHA224Digest();
            case "SHA-256":
                return new SHA256Digest();
            case "SHA-384":
                return new SHA384Digest();
            case "SHA-512":
                return new SHA512Digest();
            case "SHA-3":
                return new SHA3Digest();
            case "Tiger":
                return new TigerDigest();
            case "Whirlpool":
                return new WhirlpoolDigest();
            default:
                return null;
        }
    }
}
