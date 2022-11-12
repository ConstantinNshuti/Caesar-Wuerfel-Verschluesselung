package hue1;
/**
 * Eine Klasse die das Inteface Codec implementiert und alle darin erhaltenen Methoden bereitstellt.
 * Klasseninvariante : Die Variablen "schluessel".
 * A. Der Schluessel soll niemals leer sein
 * B. Der Schluessel soll kein Sonderzeichen enthalten
 * C. Der Schluessel muss nur  Buchstaben enthalten
 * Die Variable "schluessel" ist auf einer Seite Verschluesselung eines klartextes bzw. eines verschluesselten Textes,
 * und auf anderen Seite zur Entschluesselung verschluesselter Text.
 *
 *
 * @author Constantin Nshuti
 */


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

    /**
     * Methode zum Verschluesseln eines Klartextes.
     * Die Position jeweiliger Buchstabe von klartext gemaeß die Postion von Buchstaben des schluesselwortes ordnen,
     * in dem die Buchstaben mit gleichen Position zusammengesetzt sein muessen, da wird das Position des gefundenene Buchstabe
     * mit der Laenge des schluesselwortes addiert und weiter so.
     *
     * @param klartext String, der Text der spaeter kodiert sein wird.
     */
    public String kodiere(String klartext) {

        int[] permutation = suchePosition(this.schluessel);

        StringBuilder geheimtext = new StringBuilder();

        for (int i = 0; i < permutation.length; i++) {
            for (int j = 0; j < klartext.length(); j++) {

                if (j == permutation[i]) {
                    while (j < klartext.length()) {
                        geheimtext.append(klartext.charAt(j));
                        j = j + schluessel.length();
                    }
                }

            }

        }

        return geheimtext.toString();
    }


    /**
     * Methode zum Entschluesseln eines Geheimtextes
     * Die Position jeweiliger Buchstabe von geheimtext gemäß die Postion von Buchstaben des schluesselwortes ordnen,
     * in dem die Buchstaben mit gleichen Position zusammengesetzt sein müssen, da wird der gefundenene
     * Buchstabe in StringBuilder neu_text rein gesetzt und der nachfolge geloescht.
     *
     * @param geheimtext String, der den Ausgangstext zurueck nach dem Entschuesseln
     */
    public String dekodiere(String geheimtext) {

        int[] permutation = suchePosition(this.schluessel);

        StringBuilder neu_text = new StringBuilder(geheimtext);
        int position = 0;

        for (int i = 0; i < permutation.length; i++) {
            for (int j = 0; j < geheimtext.length(); j++) {
                if (permutation[i] == j % permutation.length) {
                    neu_text.insert(j, geheimtext.charAt(position));
                    neu_text.deleteCharAt(j + 1);
                    position++;

                }
            }

        }

        return neu_text.toString();
    }

    /**
     * den Schluessel liefern, welcher vorher definiert wurde.
     * sollte diese nicht vorher definiert worden sein, so wird ein standardmaeßiger Schluessel "ABC" gesetzt.
     *
     * @return String schluessel.
     */
    public String gibLosung() {

        return this.schluessel;
    }

    /**
     * Den Schluessel aus Uebergabeparameter setzen.
     * Die beide Schluessel ist bei Wuerfel Verschluesselung sehr wichtig und vorrausgesetzt, da der Klartext zweimal verschluesselt sein muss.
     * Was ausgegeben werden, erklärt alles
     *
     * @param schluessel String.
     */
    public void setzeLosung(String schluessel) throws IllegalArgumentException {


        if (schluessel.length() == 0) {
            throw new IllegalArgumentException(" Das Schluesselwort soll niemals leer sein  ");
        }
        if (schluessel.matches(".*\\d.*") == true) {
            throw new IllegalArgumentException("Das Schluesselwort muss nur  Buchstaben enthalten");
        }
        if (schluessel.matches(".*[!@#$%&()_+=|<>?{}\\[\\]~-].*") == true) {
            throw new IllegalArgumentException("Das Schluesselwort soll kein Sonderzeichen enthalten");

        }
        this.schluessel = schluessel;
    }
}
