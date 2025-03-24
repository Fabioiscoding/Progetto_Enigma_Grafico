package singh.g.enigmagraphics;
import java.util.ArrayList;

public class Reflector {
    private final ArrayList<Integer> reflector;

    public Reflector(int nReflector){
        reflector = new ArrayList<>();
        codificaNRotore(nReflector);
    }

    public void codificaNRotore(int nReflector){
        if (nReflector < 0 || nReflector > 2){
            throw new IllegalArgumentException("Rotore non valido");
        }
        switch (nReflector) {
            case 0:
                for (char c : "EJMZALYXVBWFCRQUONTSPIKHGD".toCharArray()) {
                    reflector.add(c - 'A');
                }
                break;
            case 1:
                for (char c : "YRUHQSLDPXNGOKMIEBFZCWVJAT".toCharArray()) {
                    reflector.add(c - 'A');
                }
                break;
            case 2:
                for (char c : "FVPJIAOYEDRZXWGCTKUQSBNMHL".toCharArray()) {
                    reflector.add(c - 'A');
                }
                break;
        }
    }

    public char lettera(char ch){
        int pos = reflector.get(ch - 'A');
        return (char)('A' + pos);
    }
}

