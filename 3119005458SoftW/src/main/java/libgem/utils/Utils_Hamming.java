package libgem.utils;

// 计算海明距离模块类
public class Utils_Hamming {
    /*
    传入两个Hash的值并且计算他们的海明距离
     */
    public static int hammingDistance(String hash1, String hash2){
        int distance = 0;  // 定义并初始化海明距离
        if(hash1.length() != hash2.length()){     // Hash长度匹配
            distance = -1;  // 错误的时候返回-1
        } else{
            for (int i = 0; i < hash1.length(); i++) {
                // 对两个Hash值进行逐位的比较
                if (hash1.charAt(i) != hash2.charAt(i)) {
                    distance++; // 距离＋1
                }
            }
        }
        return distance;
    }

    /*
    通过计算出的海明距离再计算出两个Hash值的相似度
     */
    public static double similarity(String hash1, String hash2){
        int distance = hammingDistance(hash1, hash2);
        double similarity = 0.01 * (100 - distance * 100 / 128);
        return similarity;
    }
}
