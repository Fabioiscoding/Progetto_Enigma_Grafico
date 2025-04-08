package singh.g.enigmagraphics;

import java.util.ArrayList;

public class Criptografia {
    private final Rotore r1, r2, r3;
    private final Reflector rf;
    private final Plugboard plugboard;
    char[] fraseDivisa;
    StringBuilder codice;

    Criptografia(int r1, int index1, int r2, int index2, int r3, int index3, int rf) {
        this.r1 = new Rotore(r1, index1);
        this.r2 = new Rotore(r2, index2);
        this.r3 = new Rotore(r3, index3);
        this.rf = new Reflector(rf);
        this.plugboard = new Plugboard();
        codice = new StringBuilder();
    }

    public void setPlugboardConnections(char letter1, char letter2) {
        plugboard.aggiungiScambio(letter1, letter2);
    }

    public void resetPlugboard() {
        plugboard.reset();
    }

    public void giraRotori() {
        r1.giraRotore();
        if (r1.cambioRotore()) {
            r2.giraRotore();
            if (r2.cambioRotore()) {
                r3.giraRotore();
            }
        }
    }

    public ArrayList<Integer> indexRotori() {
        ArrayList<Integer> i = new ArrayList<>();
        i.add(r1.indexRotore);
        i.add(r2.indexRotore);
        i.add(r3.indexRotore);
        return i;
    }

    public char codificaLettera(char ch) {
        giraRotori();
        ch = plugboard.swap(ch);
        ch = r1.letteraInversa(r2.letteraInversa(r3.letteraInversa(rf.lettera(r3.lettera(r2.lettera(r1.lettera(ch)))))));
        return plugboard.swap(ch);
    }

    public StringBuilder codificaFrase(String frase) {
        fraseDivisa = (frase.toUpperCase()).toCharArray();
        codice = new StringBuilder();
        for (char ch : fraseDivisa) {
            System.out.println(ch);
            if ((codice.length() + 1) % 6 == 0)
                codice.append(" ");
            if (ch <= 'Z' && ch >= 'A')
                codice.append(codificaLettera(ch));
        }
        return codice;
    }

}