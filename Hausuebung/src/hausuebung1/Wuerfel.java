package hausuebung1;

public class Wuerfel implements Codec {
	/**
     * String, welcher Schluessel/Losungwort bildet
     * wird durch den Uebergabeparameter der dazugehoerigen Setter-Methode initialisiert.
     */
    private String schluessel;

    /**
     * String, welcher den modifizierten Text bildet.
     *
     * @param schluessel String.
     */


    public Wuerfel(String schluessel) {

        this.schluessel = schluessel;
    }

    /**
     * Methode zum Finden Postion von jedem Buchstabe, in dem die Buchstaben eines Schluesselwort sortiert und Ihr Position finden,
     * und in einem Array permutation speichern.
     *
     * @param schluessel String, welcher je nach Postion jeder Buchstabe ein Text kodiert oder dekodiert werden muss.
     * @return String Array, der Position der Buchstaben enthält.
     */

    private int[] suchePosition(String schluessel) {
        this.schluessel = schluessel.toUpperCase();

        int[] permutation = new int[this.schluessel.length()];
        int[] position = new int[this.schluessel.length()];

        for (int i = 0; i < this.schluessel.length(); i++) {
            int count = 1;

            for (int j = 0; j < this.schluessel.length(); j++) {
                if (this.schluessel.charAt(i) > this.schluessel.charAt(j) | (this.schluessel.charAt(i) == this.schluessel.charAt(j) && i > j)) {
                    count++;
                }
            }
            position[i] = count;
        }

        for (int i = 0; i < position.length; i++) {
            permutation[position[i] - 1] = i;
        }
        return permutation;
    }

	
public String kodiere(String klartext) {
	return null;
		
		
	} 
	public String dekodiere(String geheimtext) {
		return null;
		
	}
	public String gibLosung() {
		return null;
		
	} 
	public void setzeLosung(String schluessel)throws IllegalArgumentException{
		
		
	} // bei ungeeignetem Schlüssel! }

}


