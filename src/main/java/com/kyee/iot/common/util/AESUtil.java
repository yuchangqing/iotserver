package com.kyee.iot.common.util;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class AESUtil {

    // base64 zhouliang
    public static final String defaultKey = "emhvdWxpYW5nCg==";

    private static SecretKeySpec generateMySQLAESKey(final String key, final String encoding) {
        try {
            final byte[] finalKey = new byte[16];
            int i = 0;
            for(byte b : key.getBytes(encoding))
                finalKey[i++%16] ^= b;
            return new SecretKeySpec(finalKey, "AES");
        } catch(UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] encryptUsingSHA1PRNG(String content, String password) throws AESException {
        try {
            byte[] enCodeFormat = getEnCode(password);
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            byte[] byteContent = content.getBytes("utf-8");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] result = cipher.doFinal(byteContent);
            return result;
        } catch (NoSuchAlgorithmException e) {
            throw new AESException(e);
        } catch (InvalidKeyException e) {
            throw new AESException(e);
        } catch (NoSuchPaddingException e) {
            throw new AESException(e);
        } catch (BadPaddingException e) {
            throw new AESException(e);
        } catch (UnsupportedEncodingException e) {
            throw new AESException(e);
        } catch (IllegalBlockSizeException e) {
            throw new AESException(e);
        }
    }

    private static byte[] decryptUsingSHA1PRNG(byte[] content, String password) throws AESException {
        try {
            byte[] enCodeFormat = getEnCode(password);
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] result = cipher.doFinal(content);
            return result;
        } catch (NoSuchAlgorithmException e) {
            throw new AESException(e);
        } catch (NoSuchPaddingException e) {
            throw new AESException(e);
        } catch (InvalidKeyException e) {
            throw new AESException(e);
        } catch (IllegalBlockSizeException e) {
            throw new AESException(e);
        } catch (BadPaddingException e) {
            throw new AESException(e);
        }
    }

    public static byte[] getEnCode(String password) throws NoSuchAlgorithmException {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        //防止linux下 随机生成key
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        secureRandom.setSeed(password.getBytes());
        kgen.init(128, secureRandom);
        SecretKey secretKey = kgen.generateKey();
        return secretKey.getEncoded();
    }

    private static byte[] encryptUsingMysql(String content, String password) throws AESException {
        try {
            final Cipher encryptCipher = Cipher.getInstance("AES");
            encryptCipher.init(Cipher.ENCRYPT_MODE, generateMySQLAESKey(password, "UTF-8"));
            return encryptCipher.doFinal(content.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            throw new AESException(e);
        } catch (InvalidKeyException e) {
            throw new AESException(e);
        } catch (NoSuchPaddingException e) {
            throw new AESException(e);
        } catch (BadPaddingException e) {
            throw new AESException(e);
        } catch (UnsupportedEncodingException e) {
            throw new AESException(e);
        } catch (IllegalBlockSizeException e) {
            throw new AESException(e);
        }
    }

    private static byte[] decryptUsingMysql(byte[] content, String password) throws AESException {
        try {
            final Cipher decryptCipher = Cipher.getInstance("AES");
            decryptCipher.init(Cipher.DECRYPT_MODE, generateMySQLAESKey(password, "UTF-8"));
            return  decryptCipher.doFinal(content);
        } catch (NoSuchAlgorithmException e) {
            throw new AESException(e);
        } catch (InvalidKeyException e) {
            throw new AESException(e);
        } catch (NoSuchPaddingException e) {
            throw new AESException(e);
        } catch (BadPaddingException e) {
            throw new AESException(e);
        } catch (IllegalBlockSizeException e) {
            throw new AESException(e);
        }
    }

    public static byte[] encrypt(String content, String password) throws AESException {
        return  encryptUsingMysql(content,password);
    }

    public static byte[] decrypt(byte[] content, String password) throws AESException {
        return  decryptUsingMysql(content,password);
    }

    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length()/2];
        for (int i = 0;i< hexStr.length()/2; i++) {
            int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);
            int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    public static class AESException extends Exception{

        public AESException() {
        }

        public AESException(String message) {
            super(message);
        }

        public AESException(String message, Throwable cause) {
            super(message, cause);
        }

        public AESException(Throwable cause) {
            super(cause);
        }

        public AESException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    }
}
