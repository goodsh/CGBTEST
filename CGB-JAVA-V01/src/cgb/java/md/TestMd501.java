package cgb.java.md;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TestMd501 {
    public static void main(String[] args) throws Exception {
        String s1 = "123456" + "tmooc";
        String pwd = doMD5(s1.getBytes());
        System.out.println(pwd);

        //2.对文件内容进行消息摘要获取,例如file
        InputStream in = new FileInputStream("data.dat");
        //ByteArrayOutputStream是读数据
        ByteArrayOutputStream out =
                new ByteArrayOutputStream();//内置一个数组(可以自动扩容)
        byte[] buf = new byte[256];
        int len = -1;
        while ((len = in.read(buf)) != -1) {
            out.write(buf, 0, len);
        }
        byte[] array = out.toByteArray();
              String fileMd=doMD5(array);
        System.out.println(fileMd);
        in.close();
        out.close();
    }


    public static String doMD5(byte[] arraye) throws NoSuchAlgorithmException {
        //2.对s1进行加密
        //2.1获取消息摘要对象
        MessageDigest md = MessageDigest.getInstance("MD5");
        //2.2对密码进行加密
        byte[] pwdArray = md.digest(arraye);
        System.out.println(pwdArray.length);//16byte=128bit
        //2.3将每个字节转换一个一个16进制数
        StringBuilder sd = new StringBuilder();
        for (int i = 0; i < pwdArray.length; i++) {
            String hexString = Integer.toHexString(0xFF & pwdArray[i]);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            sd.append(hexString);
        }
        return sd.toString();
    }
}
