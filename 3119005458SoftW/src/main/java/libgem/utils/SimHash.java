package libgem.utils;
import com.hankcs.hanlp.HanLP;
import javax.crypto.ShortBufferException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class SimHash {
    /*
        首先将传入的String值计算成Hash值，并以String的形式输出
     */
    public static String getHash_for_String(String str){
        try{
            // 利用MD5的值计算出Hash
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            return new BigInteger(1, messageDigest.digest(str.getBytes("UTF-8"))).toString(2);
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    /*
        计算传入的String的simHash值，并以String的形式输出
     */
    public static String getSimHash(String str){
        // 处理HanLp无法处理太短的文本的异常
        try{
            if(str.length() < 200) throw new ShortStringException("文本太短！");
        } catch (ShortStringException e) {
            e.printStackTrace();
            return null;
        }

        // 定义数组, 共128位，从0，1，2开始从高到低
        int[] arr = new int[128];
        List<String> keywords_List = HanLP.extractKeyword(str, str.length()); // 取出所有的关键词放在列表中
        int list_Size = keywords_List.size();
        int i = 0;
        // 外层循环
        for (String keywords : keywords_List){

            // 获取Hash值
            String keywords_Hash = getHash_for_String(keywords);
            if (keywords_Hash.length() < 128){ // 可能或出现Hash值不满128位的问题，在低位用0补齐
                int difference = 128 - keywords_Hash.length();
                for (int j = 0; j < difference; j++) {
                    keywords_Hash += "0";
                }
            }

            // 加权、合并
            for (int j = 0; j < arr.length; j++) {
                if (keywords_Hash.charAt(j) == '1'){
                    arr[j] += (10 - (i / (list_Size / 10)));
                } else {
                    arr[j] -= (10 - (i / (list_Size / 10)));
                }
            }
            i++;
        }
            // 降维
        String simHash = ""; // 用来存储返回的simHash值
        for (int j = 0; j < arr.length; j++) {
            if(arr[j] <= 0){
                simHash += "0";
            } else{
                simHash += "1";
            }
        }
        return simHash;
    }
}
