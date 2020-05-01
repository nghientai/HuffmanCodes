package app;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.HashMap;

/**
 * HuffmanCodes class
 */
public class HuffmanCodes {
    String input;
    Map<Character, String> huffmanCode = new HashMap<>();
    Map<Character, Integer> freq;
    PriorityQueue<Node> pq = new PriorityQueue<>((l, r) -> l.freq - r.freq);

    public HuffmanCodes(Map<Character, Integer> freq, String input) {
        this.freq = freq;
        this.input = input;
    }

    /**
     * Set to Priority Queue
     */
    public void setToQueue() {
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            this.pq.add(new Node(entry.getKey(), entry.getValue()));
        }
        while (this.pq.size() != 1) {
            Node left = this.pq.poll();
            Node right = this.pq.poll();
            int sum = left.freq + right.freq;
            this.pq.add(new Node('\0', sum, left, right));
        }
    }

    /**
     * Build the tree
     */
    public void buildHuffmanTree() {
        Node root = this.pq.peek();
        // Traverse the Huffman tree and store code in a map
        encode(root, "", huffmanCode);
    }

    /**
     * Printing Huffman Code
     */
    public void printHuffmanCode() {
        System.out.println("--- Huffman codes are: ");
        for (Map.Entry<Character, String> entry : huffmanCode.entrySet()) {
            System.out.println("\t" + entry.getKey() + " " + entry.getValue());
        }
    }

    /** */
    public void printEncryptedString() {
        String encryptedString = "";
        for (int i = 0; i < input.length(); i++) {
            encryptedString += huffmanCode.get(input.charAt(i));
        }
        System.out.println("--- Encrypted string is: \n" + "\t" + encryptedString);
    }

    /**
     * 
     * @param root
     * @param str
     * @param huffmanCode
     */
    public static void encode(Node root, String str, Map<Character, String> huffmanCode) {
        if (root == null)
            return;
        // found a leaf Node
        if (root.left == null && root.right == null) {
            huffmanCode.put(root.ch, str);
        }

        // recursive the tree
        encode(root.left, str + "0", huffmanCode);
        encode(root.right, str + "1", huffmanCode);
    }

}