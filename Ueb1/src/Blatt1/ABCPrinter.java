package Blatt1;

public class ABCPrinter implements Runnable {
	
    private static boolean istKleinDran;
	boolean istGro�;
 
 public ABCPrinter(boolean isBig) {
	 this.istGro� = isBig;
 }
 
 public void run() {
	 if(istGro�) {
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
		
		Thread gro� = new Thread(new ABCPrinter(false));
		Thread klein = new Thread(new ABCPrinter(true));
		
		gro�.start();
		klein.start();
		
	}

}
	 
	 
	 
	 
	 
 

