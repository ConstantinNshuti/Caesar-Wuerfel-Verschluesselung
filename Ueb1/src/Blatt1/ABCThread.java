package Blatt1;


public class ABCThread extends Thread {
	
	boolean istGro�;
	
	public ABCThread(boolean isBig) {
		this.istGro� = isBig;
	}
	public void run() {
		if(istGro�) {
		for(char buschtabe = 'A'; buschtabe <= 'Z'; buschtabe++) {
			System.out.println(buschtabe);
			try {
				Thread.sleep(500);
				} catch(InterruptedException e) {
					e.printStackTrace();
					}
			}
		}
		else {
			
			for(char buschtabe = 'a'; buschtabe <= 'z'; buschtabe++) {
				System.out.println(buschtabe);
			}
			
		}
		
	}
		
public static void main(String[] args) {
	
	ABCThread gro� = new ABCThread(false);
	ABCThread klein = new ABCThread(true);
	
	gro�.start();
	
	try {
	gro�.join();
	}catch(InterruptedException e) {
		e.printStackTrace();
	}
	
	klein.start();
	
}

}