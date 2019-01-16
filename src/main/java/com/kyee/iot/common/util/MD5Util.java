package com.kyee.iot.common.util;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MS5
 */
@Slf4j
public class MD5Util {
    private static final String TAG   = MD5Util.class.getSimpleName();
    private static final int    STREAM_BUFFER_LENGTH = 1024;

    public static MessageDigest getDigest(final String algorithm) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance(algorithm);
    }

    public static byte[] md5(String txt) {
        return md5(txt.getBytes());
    }

    public static byte[] md5(byte[] bytes) {
        try {
            MessageDigest digest = getDigest("MD5");
            digest.update(bytes);
            return digest.digest();
        } catch (NoSuchAlgorithmException e) {
            log.error("error", e);
        }
        return null;
    }

    public static String md5(InputStream is) throws NoSuchAlgorithmException, IOException {
        return getHexString(updateDigest(getDigest("MD5"), is).digest());
    }
    
    public static String getHexString(byte[] b) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < b.length; i++) {
			String hex = Integer.toHexString(b[i] & 0xFF);
            if(hex.length() == 1){
                result.append("0");
            }
			result.append(hex.toLowerCase());
		}
		return result.toString();
	}

    public static MessageDigest updateDigest(final MessageDigest digest, final InputStream data) throws IOException {
        final byte[] buffer = new byte[STREAM_BUFFER_LENGTH];
        int read = data.read(buffer, 0, STREAM_BUFFER_LENGTH);

        while (read > -1) {
            digest.update(buffer, 0, read);
            read = data.read(buffer, 0, STREAM_BUFFER_LENGTH);
        }

        return digest;
    }
}
