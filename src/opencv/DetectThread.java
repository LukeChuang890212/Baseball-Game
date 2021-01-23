package opencv;

public class DetectThread extends Thread{
    public void run(){
    	MoveDetector moveDetector = new MoveDetector();
		moveDetector.detect();
		System.out.println("again");
    }
}
