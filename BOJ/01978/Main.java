import java.util.*;

public class Main {
    static List<Integer> decimal_list;

    private static void set_decimal(){
        for(int i = 2; i <= 1000; i++) {
            decimal_list.add(i);
        }
        for(int i = 0; i < decimal_list.size(); i++){
            int prime_number = decimal_list.get(i);
            if(prime_number*prime_number <= 1000){
                for(int j = i+1; j < decimal_list.size(); j++){
                    if(decimal_list.get(j) % prime_number == 0){
                        decimal_list.remove(j);
                        j--;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        decimal_list  = new LinkedList<>();
        int n = scan.nextInt();
        scan.nextLine();
        StringTokenizer st = new StringTokenizer(scan.nextLine());
        set_decimal();
        int count = 0;
        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            if(decimal_list.contains(num)){
                count++;
            }
        }
        System.out.println(count);
    }
}
