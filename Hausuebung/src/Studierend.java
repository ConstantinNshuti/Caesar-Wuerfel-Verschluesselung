
/*Dieses Programm gibt Student Informationen  aus.
 * @author: 5267505_Nshuti.
 * @version: 1.0
 */

import java.util.List;

import java.util.*;

import java.util.ArrayList;

public class Studierend {

	//Deklaration der Variable

	private int iMatrNr;
	private String strName;
	private String strVorname;
	
	private ArrayList<PrLeistung> prueleistung= new ArrayList<PrLeistung>();
	
	//Konstruktor der Attributen
	
	public Studierend (int matrNr, String name,String vorname) {
		this.iMatrNr=matrNr;
		this.strName=name;
		this.strVorname=vorname;
		
		
	}
	
	// Set und Get Methode, da Variable Private sind
	
	public int getImtr() {
		return this.iMatrNr;
	}
	
	public String getName() {
		return this.strName;
	}
	
	public String getVorname() {
		return this.strVorname;
	}
	
	
	// Methode Leistung um zu den PrLeistung Konstruktor zu greifen 
	
  public void Leistungen(Module module,String pruefer,double ergebnis) {
	  
	  prueleistung.add(new PrLeistung(module,pruefer,ergebnis));
	
	  
	}

	// Studierend Infos aufzunehmen zu können
	
	
		public static void main(String[]arg) {
	
			// Liste aller Studierenden zu erstellen
			
			 ArrayList	<Studierend> IstStudierend = new ArrayList<Studierend>();
			
			// 
			 
		  Module module1,module2,module3,module4;
		  
		  // Jeden Studierend eine Leistung geben,mit 4 Module und 4 Pruefer sowie 4 verschiedene Punkte
		  
		    module1=new Module("OOP","Hans",6,4);
			module2=new Module("Math","Chris",4,5);
			module3=new Module("Physic","Irene",2,3);
			module4=new Module("Chemie","Verantwortlicher",0,5);
			 
			IstStudierend.add( new Studierend(1234,"Cos","Ema"));
		    IstStudierend.get(0).Leistungen(module1,"pruefer1", 34);
		    IstStudierend.get(0).Leistungen(module2,"pruefer2", 35);
		    IstStudierend.get(0).Leistungen(module2,"pruefer3", 36);
		    IstStudierend.get(0).Leistungen(module2,"pruefer4", 37);
			   
			
			IstStudierend.add(new Studierend(2345,"Aman","Anam"));
			IstStudierend.get(1).Leistungen(module1, "pruefer1", 45);
			IstStudierend.get(1).Leistungen(module2, "pruefer2", 46);
			IstStudierend.get(1).Leistungen(module3, "pruefer3", 47);
			IstStudierend.get(1).Leistungen(module4, "pruefer4", 48);
			
			IstStudierend.add(new Studierend(3456,"Passi","Sippa"));
			IstStudierend.get(2).Leistungen(module1," pruefer1", 55);
			IstStudierend.get(2).Leistungen(module2," pruefer2", 56);
			IstStudierend.get(2).Leistungen(module3," pruefer3", 56);
			IstStudierend.get(2).Leistungen(module4," pruefer4", 57);
			
			IstStudierend.add(new Studierend(4567,"Hamed","Medih"));
			IstStudierend.get(3).Leistungen(module1, "pruefer1",65);
			IstStudierend.get(3).Leistungen(module2, "pruefer2",64);
			IstStudierend.get(3).Leistungen(module3, "pruefer3",66);
			IstStudierend.get(3).Leistungen(module4, "pruefer4",61);
			
			IstStudierend.add(new Studierend(5678,"Gatanu","Tanu"));
			IstStudierend.get(4).Leistungen(module1, "pruefer1", 75);
			IstStudierend.get(4).Leistungen(module2, "pruefer2", 71);
			IstStudierend.get(4).Leistungen(module3, "pruefer3", 72);
			IstStudierend.get(4).Leistungen(module4, "pruefer4", 73);
			
			IstStudierend.add(new Studierend(5678,"Ga","Fifi"));
			IstStudierend.get(5).Leistungen(module1, "pruefer1", 56);
			IstStudierend.get(5).Leistungen(module2, "pruefer2", 87);
			IstStudierend.get(5).Leistungen(module3, "pruefer3", 86);
			IstStudierend.get(5).Leistungen(module4, "pruefer4", 90);
			
			// auf der konsole auszugeben
			
			System.out.println("1: Liste aller Studierenden");
			System.out.println("2: Liste aller Leistungen eines Studierenden");
			System.out.println("3: Tabellariche Leistungsübersicht pro Studierend"+"\n" );
			
			
				
				
				int dekanat=0;
				
				Scanner sc=new Scanner(System.in);
				
				dekanat =sc.nextInt();
				
			
				while(dekanat!=5) {
				
				switch(dekanat){
				
				
					
					case 1:
						
						
						for(int i = 0; i < IstStudierend.size(); i++) 
						{
						
						System.out.println("ImNummer: " + IstStudierend.get(i).iMatrNr);
						System.out.println("Nachname: "+ IstStudierend.get(i).strName);
						System.out.println("Vorname: "+ IstStudierend.get(i).strVorname );
						
						System.out.println();
						
					
						}
						break;
					case 2:
						
						
						
						for(int i = 0; i < IstStudierend.size(); i++) 
						{
						
							
						System.out.println("Leistung von Herren/Frau "+ IstStudierend.get(i).strVorname +  "!!!!!!!!:"+"\n");
						
						for (int j = 0;j<IstStudierend.get(i).prueleistung.size();j++) {
						
							
							
							
						System.out.println("Ergebnis: "+ IstStudierend.get(i).prueleistung.get(j).getErgebnis()+ "%");
						System.out.println("Puefername: "+ IstStudierend.get(i).prueleistung.get(j).getPruefer());
						
					    System.out.println("\t");
						
						System.out.println("Modulename : "+ IstStudierend.get(i).prueleistung.get(j).getModule().getModule());
						System.out.println("Verantwortlicher : "+ IstStudierend.get(i).prueleistung.get(j).getModule().getVerantwortlicher());
						System.out.println("SwS : "+ IstStudierend.get(i).prueleistung.get(j).getModule().getSwa());
						System.out.println("Credit : "+ IstStudierend.get(i).prueleistung.get(j).getModule().getCredit());
						
						
						}
						}
					break;
					
					case 3:
						for(int i = 0; i < IstStudierend.size(); i++) 
						{
							
						
						System.out.println("Leistung von Herren/Frau "+ IstStudierend.get(i).strVorname +  "!!!!!!!!!:"+"\n");
						
						System.out.println("ImNummer: " + IstStudierend.get(2).iMatrNr);
						System.out.println("Nachname: "+ IstStudierend.get(i).strName);
						System.out.println("Vorname: "+ IstStudierend.get(i).strVorname );
                        
						
						
						
						
						for (int j = 0;j<IstStudierend.get(i).prueleistung.size();j++) {
							
							System.out.println();
							
							
						System.out.println("Ergebnis: "+ IstStudierend.get(i).prueleistung.get(j).getErgebnis()+ "%");
						System.out.println("Puefername: "+ IstStudierend.get(i).prueleistung.get(j).getPruefer());
						
					    System.out.println("\t");
						
						System.out.println("Modulename : "+ IstStudierend.get(i).prueleistung.get(j).getModule().getModule());
						System.out.println("Verantwortlicher : "+ IstStudierend.get(i).prueleistung.get(j).getModule().getVerantwortlicher());
						System.out.println("SwS : "+ IstStudierend.get(i).prueleistung.get(j).getModule().getSwa());
						System.out.println("Credit : "+ IstStudierend.get(i).prueleistung.get(j).getModule().getCredit());
						
						}
						}
						break;
						
					case 4:
						
						
						
						
						default:
					
						
						
				}
				dekanat =sc.nextInt();
				
				}
				
				
				
				
				System.out.println();
				
				
			
			}
		
		
		
		
		
			
			
			
			
		
		}
	
	
	

	


	// Klasse für Leistung eines Studierend, diese Klasse enthält eine Klasse Module
    // Diese Klasse wird von Klasse Studierend als Attribute benutzt
	
	
 class PrLeistung {
	private Module strModul;
	private String strPruefer;
	private double dErgebnis=0;
	
	// Konstruktor der Klasse PrLei stung
	
	public PrLeistung(Module module,String pruefer,double ergebnis) {
		
		this.strModul=module;
		this.strPruefer=pruefer;
		this.dErgebnis=ergebnis;
	}
	
	public Module getModule(){
		return this.strModul;
	}
	
	public String getPruefer() {
		return this.strPruefer;
		
	}
	public double getErgebnis() {
		return this.dErgebnis;
	}
   public String toString() {
	   return this.strModul+""+this.strPruefer+""+this.dErgebnis;
   }
	
}
	// Klasse Module und ihre Konstruktor, diese Klasse wird von PrLeistung Klasse als Attribute benutzt
	
 class Module {
	
	private String strModule;
	private String strVerantwortlicher;
	private int iSws;
	private int iCredit;
	
	public Module(String module,String verantwortlicher,int sws,int credit) {
		
		this.strModule=module;
		this.strVerantwortlicher=verantwortlicher;
		this.iSws=sws;
		this.iCredit=credit;
		
		
	}
	
	public String getModule() {
		return this.strModule;
	
}
	public String getVerantwortlicher() {
		return this.strVerantwortlicher;
 }
	public int getSwa() {
		return this.iSws;
}
	public int getCredit() {
		return this.iCredit;
 }
	public String toString() {
		return this.strModule +""+this.strVerantwortlicher+""+this.iSws+""+this.iCredit;
	}
 }
 
 
 