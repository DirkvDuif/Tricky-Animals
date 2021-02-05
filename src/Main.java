import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void printer(Node node) {
        System.out.println(node.characters);
    }
    public static void run(String s) throws IOException, InterruptedException {
        Queue<Node> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        Node head = new Node(null, s.toCharArray(), null);
        q.add(head);
        set.add(new String(head.copy));
        int maxSize = 0;
        for (int i = 0; i < q.size(); i++) {
            if (q.size() > maxSize) {
                maxSize = q.size();
            }

            Node node = q.poll();
            node.addNodes(q, set);
            if (node.inOrder()) {
                System.out.println(node.copy);
                System.out.println(maxSize);
                printer(node);
                break;
            }
            i--;

        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        Date currentTime = new Date();
        run(s);
        Date newTime = new Date();
        double sDelay = (newTime.getTime() - currentTime.getTime()) / (double) 1000;
        System.out.println(sDelay);

    }
}