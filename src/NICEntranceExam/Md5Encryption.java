package NICEntranceExam;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//实现Encryption接口
public class Md5Encryption implements Encryption{
    public void caesarProceeding(String source, boolean isEncrypt){

        try {
            // 加密对象，指定加密方式
            MessageDigest md5 = MessageDigest.getInstance("md5");
            // 准备要加密的数据
            byte[] b = source.getBytes();
            // 加密
            byte[] digest = md5.digest(b);
            // 十六进制的字符
            char[] chars = new char[] { '0', '1', '2', '3', '4', '5', '6', '7' , '8', '9', 'A', 'B', 'C', 'D', 'E','F' };
            StringBuffer sb = new StringBuffer();
            // 处理成十六进制的字符串(通常)
            for (byte bb : digest) {
                sb.append(chars[(bb >> 4) & 15]);
                sb.append(chars[bb & 15]);
            }
            // 打印加密后的字符串
            System.out.println("以16进制进行MD5加密的结果如下：");
            System.out.println(sb);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }


    }


    public void decrypt(String source){
        throw new UnsupportedOperationException("MD5加密后无法解密");
    }


}
