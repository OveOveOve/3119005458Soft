package libgem.mainclass;

import libgem.utils.SimHash;
import libgem.utils.Txt_TO_String;
import libgem.utils.Utils_Hamming;
import org.junit.Test;

public class TestMainClass {
    @Test
    // 测试原文本和其他所有抄袭文本的查重
    public void TestforAllTxt(){
        String[] strings = new String[6];
        strings[0] = Txt_TO_String.getStringForTxt("E:/3119005458SoftW/test/orig.txt");
        strings[1] = Txt_TO_String.getStringForTxt("E:/3119005458SoftW/test/orig_0.8_add.txt");
        strings[2] = Txt_TO_String.getStringForTxt("E:/3119005458SoftW/test/orig_0.8_del.txt");
        strings[3] = Txt_TO_String.getStringForTxt("E:/3119005458SoftW/test/orig_0.8_dis_1.txt");
        strings[4] = Txt_TO_String.getStringForTxt("E:/3119005458SoftW/test/orig_0.8_dis_10.txt");
        strings[5] = Txt_TO_String.getStringForTxt("E:/3119005458SoftW/test/orig_0.8_dis_15.txt");
    }

    @Test
    // 测试原文本和原文本比较的查重率
    public void origEqualTest(){
        String str0 = Txt_TO_String.getStringForTxt("E:/3119005458SoftW/test/orig.txt");
        String str1 = Txt_TO_String.getStringForTxt("E:/3119005458SoftW/test/orig.txt");
        String compTxt = "E:/3119005458SoftW/test/equTxt.txt";
        double equal = Utils_Hamming.similarity(SimHash.getSimHash(str0), SimHash.getSimHash(str1));
        Txt_TO_String.txt_write_String(equal, compTxt);
    }

    @Test
    // 测试orig和orig_0.8_add查重率
    public void origAddTest(){
        String str0 = Txt_TO_String.getStringForTxt("E:/3119005458SoftW/test/orig.txt");
        String str1 = Txt_TO_String.getStringForTxt("E:/3119005458SoftW/test/orig_0.8_add.txt");
        String compTxt = "E:/3119005458SoftW/test/addTxt.txt";
        double compAdd = Utils_Hamming.similarity(SimHash.getSimHash(str0), SimHash.getSimHash(str1));
        Txt_TO_String.txt_write_String(compAdd, compTxt);
    }

    @Test
    // 测试orig和orig_0.8_del查重率
    public void origDelTest(){
        String str0 = Txt_TO_String.getStringForTxt("E:/3119005458SoftW/test/orig.txt");
        String str1 = Txt_TO_String.getStringForTxt("E:/3119005458SoftW/test/orig_0.8_del.txt");
        String compTxt = "E:/3119005458SoftW/test/delTxt.txt";
        double compDel = Utils_Hamming.similarity(SimHash.getSimHash(str0), SimHash.getSimHash(str1));
        Txt_TO_String.txt_write_String(compDel, compTxt);
    }

    @Test
    // 测试orig和orig_0.8_dis_1查重率
    public void origDis1Test(){
        String str0 = Txt_TO_String.getStringForTxt("E:/3119005458SoftW/test/orig.txt");
        String str1 = Txt_TO_String.getStringForTxt("E:/3119005458SoftW/test/orig_0.8_dis_1.txt");
        String compTxt = "E:/3119005458SoftW/test/dis1Txt.txt";
        double compDis1 = Utils_Hamming.similarity(SimHash.getSimHash(str0), SimHash.getSimHash(str1));
        Txt_TO_String.txt_write_String(compDis1, compTxt);
    }

    @Test
    // 测试orig和orig_0.8_dis_10查重率
    public void origDis10Test(){
        String str0 = Txt_TO_String.getStringForTxt("E:/3119005458SoftW/test/orig.txt");
        String str1 = Txt_TO_String.getStringForTxt("E:/3119005458SoftW/test/orig_0.8_dis_10.txt");
        String compTxt = "E:/3119005458SoftW/test/dis10Txt.txt";
        double compDis10 = Utils_Hamming.similarity(SimHash.getSimHash(str0), SimHash.getSimHash(str1));
        Txt_TO_String.txt_write_String(compDis10, compTxt);
    }

    @Test
    // 测试orig和orig_0.8_dis_15查重率
    public void origDis15Test(){
        String str0 = Txt_TO_String.getStringForTxt("E:/3119005458SoftW/test/orig.txt");
        String str1 = Txt_TO_String.getStringForTxt("E:/3119005458SoftW/test/orig_0.8_dis_15.txt");
        String compTxt = "E:/3119005458SoftW/test/dis15Txt.txt";
        double compDis15 = Utils_Hamming.similarity(SimHash.getSimHash(str0), SimHash.getSimHash(str1));
        Txt_TO_String.txt_write_String(compDis15, compTxt);
    }

}
