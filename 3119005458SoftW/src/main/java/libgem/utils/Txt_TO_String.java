package libgem.utils;

/*
    txt文件读写类
 */
import java.io.*;
import java.nio.Buffer;

public class Txt_TO_String {
    public static String getStringForTxt(String txt_file_path){
        /*
            通过传入文件的绝对路径来将txt的文件内容以String的形式输出
         */
        String str = "";
        String strline;
        // 使用file类将txt文件内容按照行读进str中
        File file = new File(txt_file_path);
        FileInputStream fileInputStream = null;
        try{
            fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReade = new InputStreamReader(fileInputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReade);

            // 对每次获取的String进行拼接
            while ((strline = bufferedReader.readLine()) != null){
                str += strline;
            }

            //关闭所有资源
            inputStreamReade.close();
            bufferedReader.close();
            fileInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return str; // 返回最终的字符串
    }

    /*
        将String写入txt文件
     */
    public static void txt_write_String(double txtCont, String txt_file_path){
        String str = Double.toString(txtCont);
        File file = new File(txt_file_path);
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter(file, true);
            fileWriter.write(str, 0, (str.length() > 3 ? 4 : str.length()));
            fileWriter.write("\r\n");

            // 关闭资源
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
