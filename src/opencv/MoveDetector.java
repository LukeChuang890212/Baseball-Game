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
        
      // �I�spython���O�X�öǻ�list
        try {
            process = Runtime.getRuntime().exec(
                    pythonPath + filePath);
            BufferedReader in=new BufferedReader(new InputStreamReader(process.getInputStream()));
            in.close();
            int re=process.waitFor();
            System.out.println(re==1?"----���A�X1----���楢��":"----���A�X0----���榨�\");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
}

