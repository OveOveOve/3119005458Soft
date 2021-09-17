package libgem.utils;

import org.junit.Test;

public class TestForSimHash {

    @Test
    public void TestForGetHash(){
        String[] strings = {"广东", "工业" , "大学", "计算机学院", "信息", "安全"};
        for(String string : strings){
            String hash_String = SimHash.getHash_for_String(string);
            System.out.println(hash_String.length());
            System.out.println(hash_String);
        }
    }

    @Test
    public void TestForSimHash(){
        String str0 = Txt_TO_String.getStringForTxt("E:/3119005458/test/orig.txt");
        String str1 = Txt_TO_String.getStringForTxt("E:/3119005458/test/orig_0.8_add.txt");
        System.out.println(SimHash.getSimHash(str0));
        System.out.println(SimHash.getSimHash(str1));
    }
}
