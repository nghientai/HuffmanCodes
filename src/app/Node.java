package app;

public class Node {
    public char ch;
    public int freq;
    public Node left = null;
    public Node right = null;

    public Node(char ch, int data) {
        this.freq = data;
        this.ch = ch;
    }

    public Node(char ch, int freq, Node left, Node right) {
        this.ch = ch;
        this.freq = freq;
        this.left = left;
        this.right = right;
    }

    public String toString() {
        return String.format("%d\n", this.freq);
    }

}