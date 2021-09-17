package libgem.utils;

import org.junit.Test;

public class TestForHamming {

    @Test
    public void testHammingDistance(){
        String str0 =  Txt_TO_String.getStringForTxt("E:/3119005458/test/orig.txt");
        String str1 = Txt_TO_String.getStringForTxt("E:/3119005458/test/orig_0.8_add.txt");
        int distance = Utils_Hamming.hammingDistance(SimHash.getSimHash(str0), SimHash.getSimHash(str1));
        System.out.println("海明距离：" + distance);
        System.out.println("相似度" + (100 - distance * 100 / 128) + "%");
    }

    @Test
    public void hammingDistanceException(){
        // 如果出现两个获取的字符串长度不一样的情况
        String str0 = "10101010";
        String str1 = "1010101";
        System.out.println(Utils_Hamming.hammingDistance(str0, str1));
    }

    @Test
    public void SimilarityTest(){
        String str0 = Txt_TO_String.getStringForTxt("E:/3119005458/test/orig.txt");
        String str1 = Txt_TO_String.getStringForTxt("E:/3119005458/test/orig_0.8_add.txt");
        int hammingDistance = Utils_Hamming.hammingDistance(SimHash.getSimHash(str0), SimHash.getSimHash(str1));
        double similarity = Utils_Hamming.similarity(SimHash.getSimHash(str0), SimHash.getSimHash(str1));
        System.out.println("str0和str1之间的海明距离为：" + hammingDistance);
        System.out.println("str0和str1的相似度为：" + similarity);
    }

}
