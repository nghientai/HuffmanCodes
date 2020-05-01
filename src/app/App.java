package app;

import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        // System steps
        // 1. Input string = "Hello World"
        String input = "Hello World!";
        // 2. Count frequency of appearance of each character and store it in a map
        Frequency freqClass = new Frequency(input);
        Map<Character, Integer> freq = freqClass.getFreq();
        freqClass.printFreqTable();
        // 3. Store the freq into a Priority Queue

        HuffmanCodes huffmanCodes = new HuffmanCodes(freq, input);
        huffmanCodes.setToQueue();
        huffmanCodes.buildHuffmanTree();
        huffmanCodes.printHuffmanCode();
        huffmanCodes.printEncryptedString();

    }

}