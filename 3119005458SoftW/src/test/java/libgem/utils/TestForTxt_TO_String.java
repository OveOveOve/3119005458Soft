package libgem.utils;

import org.junit.Test;
import org.junit.validator.PublicClassValidator;

public class TestForTxt_TO_String {

    @Test
    public void TestFor_getTxt(){
        //  如果文件路径存在的话，则正常读取文件
        String str = Txt_TO_String.getStringForTxt("E:/3119005458/test/orig.txt");
        String[] strings = str.split(" "); // 切割文本
        for (String string : strings){
            System.out.println(string);
        }
    }

    @Test
    public void TestFor_getTxt_Fail(){
        // 如果读取文件的路径不存在的话，则读取失败
        String str = Txt_TO_String.getStringForTxt("E:/3119005458SoftW/test/fail.txt");
    }

    @Test
    public void write_Txt_Test(){
        // 当路径存在时，测试查重率的写入是否正常
        double[] rate_rechecking = {0.10, 0.99, 0.24, 0.34, 0.67};
        for (int i = 0; i < rate_rechecking.length; i++) {
            Txt_TO_String.txt_write_String(rate_rechecking[i], "E:/3119005458SoftW/test/result.txt");
        }
    }

    @Test
    public void write_txt_test_fail(){
        // 路径不存在时，对数据写入错误的测试
        double[] rate_recheck = {0.10, 0.26, 0.45, 0.25, 0.57};
        for (int i = 0; i < rate_recheck.length; i++) {
            Txt_TO_String.txt_write_String(rate_recheck[i], "E:/3119005458SoftW/test/fail.txt");
        }
    }
}
