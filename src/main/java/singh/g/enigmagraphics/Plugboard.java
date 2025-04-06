package singh.g.enigmagraphics;

import java.util.HashMap;

public class Plugboard {
    private final HashMap<Character, Character> scambi = new HashMap<>();

    public void aggiungiScambio(char a, char b) {
        if (a != b && Character.isLetter(a) && Character.isLetter(b)) {
            a = Character.toUpperCase(a);
            b = Character.toUpperCase(b);
            rimuoviLettera(a);
            rimuoviLettera(b);
            scambi.put(a, b);
            scambi.put(b, a);
        }
    }

    public char swap(char input) {
        return scambi.getOrDefault(Character.toUpperCase(input), input);
    }

    public void reset() {
        scambi.clear();
    }

    private void rimuoviLettera(char c) {
        if (scambi.containsKey(c)) {
            char paired = scambi.get(c);
            scambi.remove(paired);
            scambi.remove(c);
        }
    }
}
