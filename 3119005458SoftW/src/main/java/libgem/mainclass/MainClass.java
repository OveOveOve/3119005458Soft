package libgem.mainclass;

import libgem.utils.SimHash;
import libgem.utils.Txt_TO_String;
import libgem.utils.Utils_Hamming;

public class MainClass {
    public static void main(String[] args) {

        /*
            从命令行输入路径，并且读取相对应的文件，将读取到的文件内容转化成字符串
         */
        String str0 = Txt_TO_String.getStringForTxt(args[0]);
        String str1 = Txt_TO_String.getStringForTxt(args[1]);
        String result_txt = args[2];

        /*
            计算字符串的simHash值
         */
        String simHash1 = SimHash.getSimHash(str0);
        String simHash2 = SimHash.getSimHash(str1);

        /*
            计算相似度
         */
        double similarity = Utils_Hamming.similarity(simHash1, simHash2);

        /*
            将计算的相似度结果输出到txt文件中
         */
        Txt_TO_String.txt_write_String(similarity, result_txt);

        /*
            结束
         */
        System.exit(0);
    }
}
