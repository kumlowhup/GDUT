package NICEntranceExam;

public interface Encryption{

    //加密的抽象方法
    void caesarProceeding(String source, boolean isEncrypt);

    //解密的抽象方法
    void decrypt(String source);

}