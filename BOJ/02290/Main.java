import java.util.Scanner;

public class Main {
    static int s;
    static String n;
    static StringBuilder[] sb;

    static void input() {
        Scanner scan = new Scanner(System.in);
        s = scan.nextInt();
        n = scan.nextLine();
    }

    static void top(int t) {
        if (t == 0) {
            for (int i = 0; i < s + 3; i++) sb[0].append(" ");
        } else if (t == 1){
            sb[0].append(" ");
            for (int i = 0; i < s; i++) sb[0].append("-");
            sb[0].append("  ");
        }
    }

    static void topDown(int t) {
        if (t == 1) {
            for (int i = 1; i <= s; i++){
                sb[i].append("|");
                for (int j = 0; j < s + 2; j++) sb[i].append(" ");
            }
        } else if (t == 2) {
            for (int i = 1; i <= s; i++){
                sb[i].append("|");
                for (int j = 0; j < s; j++) sb[i].append(" ");
                sb[i].append("| ");
            }
        } else if (t == 3) {
            for (int i = 1; i <= s; i++){
                for (int j = 0; j < s + 1; j++) sb[i].append(" ");
                sb[i].append("| ");
            }
        }
    }

    static void middle(int t) {
        if (t == 0) {
            for (int i = 0; i < s + 3; i++) sb[s + 1].append(" ");
        } else if (t == 1){
            sb[s + 1].append(" ");
            for (int i = 0; i < s; i++) sb[s + 1].append("-");
            sb[s + 1].append("  ");
        }
    }

    static void bottomUp(int t) {
        if (t == 1) {
            for (int i = s + 2; i < s + 2 + s; i++){
                sb[i].append("|");
                for (int j = 0; j < s + 2; j++) sb[i].append(" ");
            }
        } else if (t == 2) {
            for (int i = s + 2; i < s + 2 + s; i++){
                sb[i].append("|");
                for (int j = 0; j < s; j++) sb[i].append(" ");
                sb[i].append("| ");
            }
        } else if (t == 3) {
            for (int i = s + 2; i < s + 2 + s; i++){
                for (int j = 0; j < s + 1; j++) sb[i].append(" ");
                sb[i].append("| ");
            }
        }
    }

    static void bottom(int t) {
        if (t == 0) {
            for (int i = 0; i < s + 3; i++) sb[sb.length-1].append(" ");
        } else if (t == 1){
            sb[sb.length-1].append(" ");
            for (int i = 0; i < s; i++) sb[sb.length-1].append("-");
            sb[sb.length-1].append("  ");
        }
    }

    static void pro() {
        sb = new StringBuilder[s * 2 + 3];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuilder();
        for (int i = 0; i < n.length(); i++) {
            char c = n.charAt(i);
            switch (c) {
                case '0':
                    top(1);
                    topDown(2);
                    middle(0);
                    bottomUp(2);
                    bottom(1);
                    break;
                case '1':
                    top(0);
                    topDown(3);
                    middle(0);
                    bottomUp(3);
                    bottom(0);
                    break;
                case '2':
                    top(1);
                    topDown(3);
                    middle(1);
                    bottomUp(1);
                    bottom(1);
                    break;
                case '3':
                    top(1);
                    topDown(3);
                    middle(1);
                    bottomUp(3);
                    bottom(1);
                    break;
                case '4':
                    top(0);
                    topDown(2);
                    middle(1);
                    bottomUp(3);
                    bottom(0);
                    break;
                case '5':
                    top(1);
                    topDown(1);
                    middle(1);
                    bottomUp(3);
                    bottom(1);
                    break;
                case '6':
                    top(1);
                    topDown(1);
                    middle(1);
                    bottomUp(2);
                    bottom(1);
                    break;
                case '7':
                    top(1);
                    topDown(3);
                    middle(0);
                    bottomUp(3);
                    bottom(0);
                    break;
                case '8':
                    top(1);
                    topDown(2);
                    middle(1);
                    bottomUp(2);
                    bottom(1);
                    break;
                case '9':
                    top(1);
                    topDown(2);
                    middle(1);
                    bottomUp(3);
                    bottom(1);
                    break;
            }
        }
        for (int i =0 ; i < sb.length; i++){
            System.out.println(sb[i].toString());
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}