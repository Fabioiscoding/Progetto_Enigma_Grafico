package singh.g.enigmagraphics;

import java.util.HashMap;

public class Plugboard {
    private HashMap<Character, Character> connections = new HashMap<>();
    public void connect(char letter1, char letter2) {
        if (letter1 == letter2) return;
        disconnect(letter1);
        disconnect(letter2);
        connections.put(letter1, letter2);
        connections.put(letter2, letter1);
    }

    public void disconnect(char letter) {
        if (connections.containsKey(letter)) {
            char pairedLetter = connections.get(letter);
            connections.remove(letter);
            connections.remove(pairedLetter);
        }
    }

    public char swap(char input) {
        return connections.getOrDefault(input, input);
    }

    public void reset() {
        connections.clear();
    }
    public String getConnections() {
        return connections.toString();
    }
}