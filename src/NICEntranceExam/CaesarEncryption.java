package NICEntranceExam;

import java.util.Scanner;

public class CaesarEncryption implements Encryption {

    //加密/解密
    public void caesarProceeding(String source, boolean isEncrypt) {
        String pro;
        if (isEncrypt)
            pro = "加密";
        else
            pro = "解密";

        System.out.println("请输入"+ pro +"位移:");
        Scanner s2 = new Scanner(System.in);
        int key = s2.nextInt();

        StringBuilder str = new StringBuilder();
        int i = 0;
        while (i < source.length()) {
            char item = source.charAt(i);
            if (item >= 'a' && item <= 'z') {

                //小写字母
                item = proceeding('a','z',26,item,key,isEncrypt);

            } else if (item >= 'A' && item <= 'Z') {

                //大写字母
                item = proceeding('A','Z',26,item,key,isEncrypt);

            } else if (item >= '0' && item <= '9') {

                //数字
                item = proceeding('0','9',10,item,key,isEncrypt);

            }
            //其他字符保持不变
            str.append(item);//将解密后的字符连成字符串
            i++;
        }
        System.out.println(pro + "后为：" + '\n' + str);
    }

    //处理系统
    public char proceeding(char left, char right, int range, char item, int key, boolean isEncrypt){
        if(isEncrypt){
            item += (key % range);
        }else{
            item -= (key % range);
        }
        if (item < left)
            item += range;//向左超界
        if (item > right)
            item -= range;//向右超界
        return item;

    }


    //解密
    public void decrypt(String source) {
        caesarProceeding(source,false);
    }

}
//求你