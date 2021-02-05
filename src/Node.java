import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;

public class Node {
    public String name; // name = "a", "b" or "x"
    public char[] copy; // make a copy of inherited word
    public String characters;

    public Node(String name, char[] word, String charactersParent) {
        this.name = name;
        if (name == null && charactersParent == null) {
        } else if (charactersParent == null) {
            this.characters = name;
        } else {
            this.characters = charactersParent + name;
        }
        copy = Arrays.copyOf(word, word.length);
    }
    public void addNodes(Queue<Node> q, HashSet<String> set) {
        Node a = new Node("a", copy, this.characters);
        String s = new String(a.useMethod());
        if (set.contains(s)) {
        }
        else {
            q.add(a);
            set.add(s);
        }
        Node b = new Node("b", copy, this.characters);
        s = new String(b.useMethod());
        if (set.contains(s)) {
        }
        else {
            q.add(b);
            set.add(s);
        }
        Node x = new Node("x", copy, this.characters);
        s = new String(x.useMethod());
        if (set.contains(s)) {
        }
        else {
            q.add(x);
            set.add(s);
        }
    }
    public String toString() {return this.name;}
    public boolean inOrder() {
        for (int i = 1; i < copy.length; i++) {
            if (copy[i] < copy[i-1]) {
                return false;
            }
        }
        return true;
    }
    public char[] useMethod() {
        if (this.name != null) {
            switch (this.name) {
                case "a" -> {
                    return methodA(copy);
                }
                case "b" -> {
                    return methodB(copy);
                }
                case "x" -> {
                    return methodX(copy);
                }
            }
        }
        else {
            return copy;
        }
        return copy;
    }
    public char[] methodA(char[] c) {
        char temp = c[0];
        c[0] = c[1];
        c[1] = temp;
        return c;
    }
    public char[] methodB(char[] c) {
        char temp = c[c.length - 1];
        c[c.length - 1] = c[c.length - 2];
        c[c.length - 2] = temp;
        return c;
    }
    public char[] methodX(char[] c) {
        for (int i = c.length-2; i > 1; i--) {
            char temp = c[i-1];
            c[i-1] = c[i];
            c[i] = temp;
        }
        return c;
    }
}
