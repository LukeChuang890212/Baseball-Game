package opencv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MoveDetector {
	public static Process process;
	public static int[] intArray = new int[4];
	
	public void detect() {
		String pythonPath="C:/Users/USER/Desktop/Python-Opencv/env/Scripts/python ";
        String filePath="C:/Users/USER/Desktop/Python-Opencv/move_detect.py ";
        
      // 呼叫python指令碼並傳遞list
        try {
            process = Runtime.getRuntime().exec(
                    pythonPath + filePath);
            BufferedReader in=new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line=in.readLine())!=null){
            	line = line.substring(1,line.length()-1);
            	System.out.println(line);
            	intArray = Arrays.stream(line.split(", ")).mapToInt(Integer::parseInt).toArray(); 
            }
            in.close();
            int re=process.waitFor();
            System.out.println(re==1?"----狀態碼1----執行失敗":"----狀態碼0----執行成功");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
}

