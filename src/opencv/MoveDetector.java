package opencv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MoveDetector extends Thread{
	public static Process process;
	
	public void run() {
		detect();
	}
	public void detect() {
		String pythonPath="C:/Users/USER/Desktop/Python-Opencv/env/Scripts/python ";
        String filePath="C:/Users/USER/Desktop/Python-Opencv/move_detect.py ";
        
      // 呼叫python指令碼並傳遞list
        try {
            process = Runtime.getRuntime().exec(
                    pythonPath + filePath);
            BufferedReader in=new BufferedReader(new InputStreamReader(process.getInputStream()));
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

