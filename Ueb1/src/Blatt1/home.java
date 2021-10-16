package Blatt1;

public class home extends Thread {
	public static int amount=0;

	public static void main(String[] args) {
		home thread=new home();
		thread.start();
		
		//wait for the thread to finish
		while(thread.isAlive()) {
			System.out.println("Waiting.....");
		
		}
	//update amount and print its values	
	System.out.println("home: " + amount);
	amount++;
	System.out.println("home: " + amount);
	
		}
	
	public void run() {
	amount++;
	}

}
