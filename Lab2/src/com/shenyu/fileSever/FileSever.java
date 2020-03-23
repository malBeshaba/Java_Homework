package com.shenyu.fileSever;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;


public class FileSever {
    /**
     * 从硬盘上读取一个文本文件，并转换为字符串返回
     * @param fileName 文件名
     * @return 读到的文本文件内容(String)
     * @throws FileNotFoundException
     */
    public static String readFile(String fileName){
        String content = "00";
        File file = new File(fileName);
        try {
            if (file.exists()){
                InputStream is = new FileInputStream(file);
                byte data[] = new byte[10000000];
                int foot = 0;
                int temp = 0;
                while((temp = is.read())!=-1) {
                    data[foot++] = (byte) temp;
                }
                is.close();
                content = new String(data,0,foot);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }


    public static void main(String[] args) {
        String src = FileSever.class.getResource("/了不起的盖茨比英文.txt").getPath();
        try {
            String content = FileSever.readFile(URLDecoder.decode(src, "UTF-8"));
            StringHandle handle = new StringHandle();
            handle.handleString(content);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
