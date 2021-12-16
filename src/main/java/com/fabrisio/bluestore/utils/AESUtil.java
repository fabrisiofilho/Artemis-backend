package com.fabrisio.bluestore.utils;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

@Component
public class AESUtil {

    private static String iv = "0102030405060708";
    private static String key = "czabcd1234czabcd";

    public static String Encrypt(String sSrc) throws Exception {
        if (key == null) {
            System.out.print("Key está null");
            return null;
        }
        if (key.length() != 16) {
            System.out.print("Key não contém 16 caracteres");
            return null;
        }
        byte[] raw = key.getBytes("UTF-8");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/Iso10126Padding");
        IvParameterSpec ivps = new IvParameterSpec(iv.getBytes("UTF-8"));
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivps);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes("UTF-8"));

        return new String(Base64.encodeBase64(encrypted),"UTF-8");
    }

    public static String Decrypt(String sSrc) throws Exception {
        try {
            if (key == null) {
                System.out.print("Key está null");
                return null;
            }
            if (key.length() != 16) {
                System.out.print("Key não contém 16 caracteres");
                return null;
            }
            byte[] raw = key.getBytes("UTF-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/Iso10126Padding");
            IvParameterSpec ivps = new IvParameterSpec(iv.getBytes("UTF-8"));
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivps);
            byte[] encrypted1 = Base64.decodeBase64(sSrc.getBytes("UTF-8"));//先用bAES64解密
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original,"UTF-8");
                return originalString;
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }

}
