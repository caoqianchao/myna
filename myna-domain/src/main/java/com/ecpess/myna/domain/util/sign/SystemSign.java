package com.ecpess.myna.domain.util.sign;

import com.ecpess.myna.domain.util.RsaUtils;

public class SystemSign {

    private static String RSASign(String src, String pubkey) {
        RsaUtils rsa = RsaUtils.getInstance();
        return rsa.encryptData(src, pubkey);
    }

    private static boolean rsaVerify(String plain, String encrypt, String pubkey) {
        RsaUtils rsa = RsaUtils.getInstance();
        return rsa.verifySignature(encrypt, plain, pubkey);
    }

    public static String sign(String src, String pubkey) {
        return RSASign(src, pubkey);
    }

    public static boolean verify(String plain, String encrypt, String pubkey) {
        return rsaVerify(plain, encrypt, pubkey);
    }

}
