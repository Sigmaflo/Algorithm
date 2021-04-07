import java.util.*;

public class Main {
    static Node first;
    static Node last;

    static class Node{
        int n;
        Node next;

        public Node(int n){
            this.n = n;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Node node = new Node(1);
        first = node;
        last = first;
        for(int i = 2; i <= n; i++){
            node = new Node(i);
            last.next = node;
            last = last.next;
        }
        int t = 1;
        while(first != last){
            if(t == 1){
                first = first.next;
            }else{
                node = first;
                first = first.next;
                node.next = null;
                last.next = node;
                last = last.next;
            }
            t *= -1;
        }
        System.out.println(first.n);
    }
}
