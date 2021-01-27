package opencv;

import java.io.IOException;

import dataReceiver.DataReceiver;

public class MoveDetector{
	public static Process process;
	
	private DataReceiver dataReceiver;
	public MoveDetector(DataReceiver dataReceiver) {
		this.dataReceiver = dataReceiver;
	}
	public void detect() {
		System.out.println("Start up MoveDetector");
		
		String pythonPath="C:/Users/USER/Desktop/Python-Opencv/env/Scripts/python ";
        String filePath="C:/Users/USER/Desktop/Python-Opencv/move_detect.py ";
        
      // �I�spython���O�X�öǻ�list
        try {
            process = Runtime.getRuntime().exec(
                    pythonPath + filePath);
            dataReceiver.receive();
            int re=process.waitFor();
            System.out.println(re==1?"----���A�X1----���楢��":"----���A�X0----���榨�\");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }        
	}
}

