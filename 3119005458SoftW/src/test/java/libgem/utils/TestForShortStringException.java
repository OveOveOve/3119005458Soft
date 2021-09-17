package libgem.utils;

import org.junit.Test;

public class TestForShortStringException {

    @Test
    public void test_for_shortString(){
        // 测试hanlp包在str.length() < 200  的情况
        System.out.println(SimHash.getSimHash("广东工业大学"));
    }
}
