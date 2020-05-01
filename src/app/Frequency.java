package app;

import java.util.HashMap;
import java.util.Map;

/**
 * Frequency Class
 */

public class Frequency {
    public String text;

    public Map<Character, Integer> freq = new HashMap<>();

    /**
     * Constructor
     * 
     * @param text
     */
    public Frequency(String text) {
        this.text = text;
        this.counting();
    }

    /**
     * Get
     * 
     * @return
     */
    public Map<Character, Integer> getFreq() {
        return this.freq;
    }

    /**
     * Void
     */
    public void counting() {
        for (int i = 0; i < text.length(); i++) {
            if (!freq.containsKey(text.charAt(i))) {
                freq.put(text.charAt(i), 0);
            }
            freq.put(text.charAt(i), freq.get(text.charAt(i)) + 1);
        }
    }

    /**
     * Print out Freq table
     */
    public void printFreqTable() {

        System.out.println("--- Frequency Table:");
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            // Print out the Frequency map
            System.out.println("\t" + entry.getKey() + ": " + entry.getValue().toString());
        }
    }
}