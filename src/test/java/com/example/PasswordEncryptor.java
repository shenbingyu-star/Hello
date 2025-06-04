package com.example;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class PasswordEncryptor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入密码
        System.out.print("请输入密码：");
        String password = scanner.nextLine();

        // 加密密码
        String encryptedPassword = encryptPassword(password);

        // 输出加密后的密码
        System.out.println("加密后的密码：" + encryptedPassword);
    }

    // 加密方法
    public static String encryptPassword(String password) {
        try {
            // 获取SHA-256的MessageDigest对象
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            // 将密码转换为字节数组
            byte[] encodedHash = digest.digest(password.getBytes());
            // 将字节数组转换为十六进制字符串
            StringBuilder hexString = new StringBuilder(2 * encodedHash.length);
            for (int i = 0; i < encodedHash.length; i++) {
                String hex = Integer.toHexString(0xff & encodedHash[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256算法未找到", e);
        }
    }
}