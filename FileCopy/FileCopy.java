import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopy{
	
	private String src;//源文件路径
	private String des;//目标目录路径
	
	public FileCopy(String from, String to) {
		this.src = from;
		this.des = to;
		copyFile(from, to);
	} 
	/*
	 * 实现文件的拷贝
	 * @param srcPathStr
	 *          源文件的地址信息
	 * @param desPathStr
	 *          目标文件的地址信息 
	 */
	private static void copyFile(String srcPathStr, String desPathStr) {
		String newFileName = srcPathStr.substring(srcPathStr.lastIndexOf('/') + 1); //目标文件地址
		System.out.println(newFileName);
		desPathStr = desPathStr + File.separator + newFileName; //源文件地址
		System.out.println(desPathStr);
			try{
			FileInputStream fis = new FileInputStream(srcPathStr);
			FileOutputStream fos = new FileOutputStream(desPathStr);                
			byte datas[] = new byte[1024*8];
			int len = 0;
			while((len = fis.read(datas))!=-1){
				fos.write(datas,0,len);
			}
			fis.close();
			fis.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}