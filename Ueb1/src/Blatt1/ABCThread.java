package Blatt1;


public class ABCThread extends Thread {
	
	boolean istGroﬂ;
	
	public ABCThread(boolean isBig) {
		this.istGroﬂ = isBig;
	}
	public void run() {
		if(istGroﬂ) {
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
	
	ABCThread groﬂ = new ABCThread(false);
	ABCThread klein = new ABCThread(true);
	
	groﬂ.start();
	
	try {
	groﬂ.join();
	}catch(InterruptedException e) {
		e.printStackTrace();
	}
	
	klein.start();
	
}

}