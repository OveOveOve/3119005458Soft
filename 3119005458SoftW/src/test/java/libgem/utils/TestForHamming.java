package libgem.utils;

import org.junit.Test;

public class TestForHamming {

    @Test
    public void testHammingDistance(){
        String str0 =  Txt_TO_String.getStringForTxt("E:/3119005458/test/orig.txt");
        String str1 = Txt_TO_String.getStringForTxt("E:/3119005458/test/orig_0.8_add.txt");
        int distance = Utils_Hamming.hammingDistance(SimHash.getSimHash(str0), SimHash.getSimHash(str1));
        System.out.println("海明距离：" + (100 - distance * 100 / 128) + "%");
    }


    
}
