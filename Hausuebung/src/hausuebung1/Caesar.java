package hue1;

/**
 * Eine Klasse die das Interface Codec implementiert und alle darin erhaltenen Methoden bereitstellt.
 * Klasseninvariante : Die Variablen "schluessel".
 *  * A. Der Schluessel soll nicht leer sein.
 *  * B. Der Schluessel soll kein Sonderzeichen enthalten
 *  * C. Der Schluessel muss mindestens ein Buchstabe enthalten
 * @author Constantin Nshuti
 */

public class Caesar implements Codec {

    /**
     * String, welcher schluessel bildet.
     * Sein Initialisierung ist durch den Uebergabeparameter des setzeLosung Methodes.
     */
    private String schluessel;

    /**
     * Den Klartext kodieren, in dem jeder Buchstabe innerhalb des Strings geschoben wird.
     * Jeder Buchstabe muss zuerst zu ASCII Wert umgewandelt, und dann muss ueberpruft werden, ob eine Buchstabe große oder klein ist.
     * Fuer wie viele Schritte ein Buchstabe geschoben wird, muss die Laenge des Schluessel das bestimmen,
     *                        in dem ACII Wert eines Buchstabes mit der laenge des Schluessel addiriet wird.
     *                        und dann den gefunden Wert wieder zu einem Charakter umwandeln.
     * Im Fall eine Verschiebung eines Buchstabes den letzten Buchstabe(Z) ueberschreitet,
     * 			 muss zurueck zum ersten Buchstabe(A) wieder angefangen werden.
     * Das gleich wieder umgekehrt auch.
     * @param klartext ein String in jeder Form.
     * @return String, ein Geheimtext, welcher sich aus den kodierten Zeichen zusammensetzt, die an der gleichen Stelle wie zuvor stehen und nur als Einzelnes kodiert wurde.
     */

    public String kodiere(String klartext) {

        char c = 0;

        char offset []  = schluessel.toCharArray();
        StringBuilder unknown_text = new StringBuilder();

        for(int i = 0; i < klartext.length(); i++) {
            c = klartext.charAt(i);

            if((int)c >= 65 && (int)c <= 90) { //

                if(((int)c + offset.length > 90) ) {
                    c = (char)((int)c + offset.length - 26);
                }
                else {

                    c = (char)((int)c + offset.length);
                }

                unknown_text.append(c);
            }

            else if((int)c >= 97 && (int)c <= 122){
                if(((int)c + offset.length > 122) ) {
                    c = (char)((int)c + offset.length - 26);
                }
                else {
                    c = (char)((int)c + offset.length);
                }
                unknown_text.append(c);
            } else {
                unknown_text.append(c);
            }

        }

        return unknown_text.toString();
    }

    /**
     * Den Geheimtext dekodieren, in dem jeder Buchstabe innerhalb des Strings zurueckgeschoben wird.
     * Jeder Buchstabe muss zuerst zu ASCII Wert umgewandelt, und dann muss ueberpruft werden, ob eine Buchstabe große oder klein ist.
     * Fuer wie viele Schritte ein Buchstabe zurueckgeschoben wird, muss die Laenge des Schluessel das bestimmen,
     *                        in dem ACII Wert eines Buchstabes mit der laenge des Schluessel addiriet wird,
     *                         und dann den gefunden Wert wieder zu einem Charakter umwandeln.
     * Im Fall eine Verschiebung eines Buchstabes den letzten Buchstabe(in diesem Fall ist A) ueberschreitet,
     * 			 muss sie zurueck zum ersten Buchstabe(Z) wieder anfangen.
     * Das gleich wieder umgekehrt auch.
     * @param geheimtext ein String in jeder Form.
     * @return String, ein Klartext, welcher sich aus den dekodierten Zeichen zusammensetzt, die an der gleichen Stelle wie zuvor stehen und nur als Einzelnes dekodiert wurden.
     */

    public String dekodiere(String geheimtext) {

        char c = 0;
        char offset []  = schluessel.toCharArray();
        StringBuilder known_text = new StringBuilder();

        for(int i = 0; i < geheimtext.length(); i++) {
            c = geheimtext.charAt(i);


            if((int)c >= 65 && (int)c <= 90) {
                if((int)c - offset.length < 65) {
                    c = (char)((int)c - offset.length + 26);

                }

                else if((int)c - offset.length >= 65 ){
                    c = (char)((int)c - offset.length);
                }

                known_text.append(c);
            }

            else if ((int)c >= 97 && (int)c <= 122){
                if((int)c - offset.length < 97) {
                    c = (char)((int)c - offset.length + 26);

                }

                else if(((int)c - offset.length >= 97) ) {
                    c = (char)((int)c - offset.length);
                }

                known_text.append(c);
            } else {
                known_text.append(c);
            }

        }
        return known_text.toString();
    }

     /**
      * Den Schluessel liefern, welcher vorher definiert wurde.
      * sollte diese nicht vorher definiert worden sein, so wird ein standardmaeßiger Schluessel "ABC" gesetzt.
      * @return String schluessel.
      */
    public String gibLosung() {
       /** if(schluessel == null){
            setzeLosung("ABC");
        }*/

        return this.schluessel;
    }

     /**
      * Den Schluessel aus Uebergabeparameter setzen.
      * Die laenge des Schluessel ist bei Caesar Verschluesselung sehr wichtig, deswegen ist es vorrausgesetzt ein valider Schluessel zu verwenden.
      * Die Laenge des Schluessel  wird ermittelt und in der Variable offset gespeichert und dann beim Kodieren und Dekodieren benoetigt.
      * @param schluessel String.
      */
    public void setzeLosung(String schluessel) throws IllegalArgumentException {

        if (schluessel.length() == 0) {
            throw new IllegalArgumentException("Der Schluessel soll niemalS leer sein!!  ");
        }
        if (schluessel.matches(".*\\d.*") == true) {
            throw new IllegalArgumentException("Der Schluessel muss nur Buchstabe enthalten");
        }
        if (schluessel.matches(".*[!@#$%&()_+=|<>?{}\\[\\]~-].*") == true) {
            throw new IllegalArgumentException("Der Schluessel soll kein Sonderzeichen enthalten");

        }
        this.schluessel = schluessel;

    }
}
