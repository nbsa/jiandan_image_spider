

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class Utils {
	public static void writeToFile(InputStream in, String path){
		 File file = new File(path);
		 System.out.println("是否为文件："+file.isFile());
		 try {
			 FileOutputStream out = new FileOutputStream(file);
	         byte[] buffer = new byte[1024];
	         int len;
	         while((len=in.read(buffer))>0){
	         	out.write(buffer, 0, len);
	         }
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("================文件写入失败==================");
		}        
	}
	/*
	 * 
	 */
	public static String convertStreamToString(InputStream in) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "/n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();

	}
}
