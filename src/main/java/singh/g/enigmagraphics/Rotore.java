package singh.g.enigmagraphics;

import java.util.ArrayList;

public class Rotore {
    private final ArrayList<Integer> rotore;
    int indexRotore;
    char lettereaCambio;

    public Rotore(int nRotore, int index){
        rotore = new ArrayList<>();
        codificaNRotore(nRotore);
        indexRotore = index;
    }

    public void codificaNRotore(int nRotore){
        if (nRotore < 1 || nRotore > 5){
            throw new IllegalArgumentException("Rotore non valido");
        }
        switch (nRotore) {
            case 1:
                for (char c : "EKMFLGDQVZNTOWYHXUSPAIBRCJ".toCharArray()) {
                    rotore.add(c - 'A');
                }
                lettereaCambio = 'Q';
                break;
            case 2:
                for (char c : "AJDKSIRUXBLHWTMCQGZNPYFVOE".toCharArray()) {
                    rotore.add(c - 'A');
                }
                lettereaCambio = 'E';
                break;
            case 3:
                for (char c : "BDFHJLCPRTXVZNYEIWGAKMUSQO".toCharArray()) {
                    rotore.add(c - 'A');
                }
                lettereaCambio = 'V';
                break;
            case 4:
                for (char c : "ESOVPZJAYQUIRHXLNFTGKDCMWB".toCharArray()) {
                    rotore.add(c - 'A');
                }
                lettereaCambio = 'J';
                break;
            case 5:
                for (char c : "VZBRGITYUPSDNHLXAWMJQOFECK".toCharArray()) {
                    rotore.add(c - 'A');
                }
                lettereaCambio = 'Z';
                break;
        }
    }

    public boolean cambioRotore(){
        return (char)('A' + indexRotore) == lettereaCambio;
    }

    public void giraRotore(){
        indexRotore = (indexRotore + 1) % 26;
    }

    public char lettera(char ch){
        int i = this.rotore.get((ch - 'A' + indexRotore) % 26);
        System.out.println(rotore +" "+ indexRotore);
        return (char)('A' + (i - indexRotore + 26) % 26);
    }


    public char letteraInversa(char ch) {
        int i = this.rotore.indexOf((ch - 'A' + indexRotore) % 26);
        return (char)('A' + (i - indexRotore + 26) % 26);
    }

    public int getIndexRotore(){
        return indexRotore;
    }
}