package com.shenyu.fileSever;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class StringHandle {
    /**
     * 将读取的文本内容处理后，存入 HashMap，
     * 再讲 Map 进行排序，排序后将数据写入 output.tet 文件
     * @param content 传入的文本内容
     */
    public void handleString(String content) {
        Map<String, Integer> map = new HashMap<>();
        StringBuffer sBuffer = new StringBuffer();
        char[] temp = content.toCharArray();
        for(char i: temp) {
            if((i >= 33 && i <= 44) || (i >= 46 && i <= 47)) {
                sBuffer.append(" ");
            }
            if(i == ' ' || (i >= 'a' && i <= 'z') || (i >= 'A' && i <= 'Z')) {
                sBuffer.append(i);
            }
        }
        content = sBuffer.toString();
        content = content.toLowerCase();

        System.out.println(content);
        String[] contents = content.split(" ");
        for(int i = 0; i<contents.length; i++) {
            if(map.containsKey(contents[i])) {
                int newVal = map.get(contents[i]) + 1;
                map.put(contents[i], newVal);
            }else {
                map.put(contents[i], 1);
            }
        }
        map = StringHandle.sortMapByValue(map);
        String outputFileName = StringHandle.class.getResource("").getPath();
        try {
            outputFileName = URLDecoder.decode(outputFileName, "UTF-8"); // 将中文路径转为 UTF—8
            outputFileName = outputFileName + "data/output.txt";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            String word = entry.getKey();
            int num = entry.getValue();
            String toWrite = word + " " + num + "\n";
            try {
                StringHandle.writeFile(outputFileName, toWrite);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 将数据写入指定路径文件
     * @param fileName   要写入的相对文件路径
     * @param content    要写入文件的数据
     * @throws Exception 文件传入失败，抛出异常
     */
    public static void writeFile(String fileName, String content) throws Exception {
        File outFile = new File(fileName);
        if(!outFile.getParentFile().exists()) {
            outFile.getParentFile().mkdirs();
        }
        FileOutputStream write = new FileOutputStream(outFile, true);
        byte[] data = content.getBytes();

        write.write(data);
        write.close();
    }
    /**
     * 通过 Value 值将 map 降序排序
     * @param oriMap 要排序的map
     * @return 返回排完序的map
     */
    public static Map<String, Integer> sortMapByValue(Map<String, Integer> oriMap) {
        if (oriMap == null || oriMap.isEmpty()) {
            return null;
        }
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        List<Map.Entry<String, Integer>> entryList = new ArrayList<Map.Entry<String, Integer>>(
                oriMap.entrySet());
        Collections.sort(entryList, new MapValueComparator());

        Iterator<Map.Entry<String, Integer>> iter = entryList.iterator();
        Map.Entry<String, Integer> tmpEntry = null;
        int flag = 0;
        while (iter.hasNext()) {
            if(flag == 0) {
                flag = 1;
                tmpEntry = iter.next();
            }else {
                tmpEntry = iter.next();
                sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
            }

        }
        return sortedMap;
    }
}

class MapValueComparator implements Comparator<Map.Entry<String, Integer>> {

    @Override
    public int compare(Entry<String, Integer> me1, Entry<String, Integer> me2) {

        return me2.getValue().compareTo(me1.getValue());
    }
}
