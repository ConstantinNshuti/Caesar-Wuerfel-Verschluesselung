package Blatt1;

public class ABCPrinter implements Runnable {
	
    private static boolean istKleinDran;
	boolean istGroﬂ;
 
 public ABCPrinter(boolean isBig) {
	 this.istGroﬂ = isBig;
 }
 
 public void run() {
	 if(istGroﬂ) {
		 for(char buschtabe='A';buschtabe<='Z';buschtabe++) {
			while(istKleinDran){
				Thread.yield();
				
			}
			 
			 System.out.println(buschtabe);
			 istKleinDran = true;
			 
		 }
		
			 
		 }
	 else {
		 for(char buschtabe='a';buschtabe<='z';buschtabe++) {
			 while(!istKleinDran) {
				 Thread.yield();
			 }
			 System.out.println(buschtabe);
			 istKleinDran = false;		
	 
	 }
	 }
 }
 
 public static void main(String[] args) {
		
		Thread groﬂ = new Thread(new ABCPrinter(false));
		Thread klein = new Thread(new ABCPrinter(true));
		
		groﬂ.start();
		klein.start();
		
	}

}
	 
	 
	 
	 
	 
 

