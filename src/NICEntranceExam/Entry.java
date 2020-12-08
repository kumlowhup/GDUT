package NICEntranceExam;

import java.util.Scanner;
//封装的实体类
class Entity {

    //选择文字处理方法，true为加密，false为解密
    private boolean encryption;
    //输入加密内容
    private String content;
    //选择加密方式,true为caesar，false为MD5
    private boolean caesar;

    //一堆setter和getter
    public boolean isEncryption() {
        return encryption;
    }
    public void setEncryption(boolean encryption) {
        this.encryption = encryption;
    }
    public void setContent(String content){
        this.content = content;
    }
    public String getContent(){
        return content;
    }
    public boolean isCaesar() {
        return caesar;
    }
    public void setCaesar(boolean caesar) {
        this.caesar = caesar;
    }
}


//main方法入口
public class Entry{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        Entity ent = new Entity();

        System.out.println("请输入单一字符以选择加密/解密");
        System.out.print("按1为加密，其他数字为解密：");
        int i = s.nextInt();
        if (i == 1){
            ent.setEncryption(true);
        }

        System.out.println("请输入单一字符以选择处理类型：");
        System.out.print("按1为凯撒密码，其他数字为MD5：");
        int j = s.nextInt();
        if(j == 1){
            ent.setCaesar(true);
        }


        System.out.println("请输入需处理的文字：");
        Scanner s2 = new Scanner(System.in);
        String source = s2.nextLine();
        ent.setContent(source);


        if (ent.isCaesar()){
            Encryption caesar = new CaesarEncryption();
            System.out.println("欢迎使用本凯撒加密/解密处理系统！");
            if(ent.isEncryption()){
                caesar.caesarProceeding(ent.getContent(),true);
            }else{
                caesar.decrypt(ent.getContent());
            }

        }else{
            System.out.println("欢迎使用MD5处理系统！");

            Encryption md5 = new Md5Encryption();

            try{
               if(ent.isEncryption()) {
                   md5.caesarProceeding(ent.getContent(),true);
                   return;
               }else{
                   md5.decrypt(ent.getContent());
               }
            } catch (UnsupportedOperationException e) {
                e.printStackTrace();
                System.out.println("注意：MD5加密后不可逆！");
            }
            System.out.println("MD5程序运行结束！");
        }
    }
}


