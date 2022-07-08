import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<Character, Integer> ht = new HashMap<>();
        for(int i = 0; i < input.length(); i++){
            if(ht.containsKey(input.charAt(i))){
                ht.put(input.charAt(i), ht.get(input.charAt(i)) + 1);
            }else{
                ht.put(input.charAt(i), 1);
            }
        }
        int max = -1;
        int twin = 0;
        for(Character key : ht.keySet()){
            if(key != '6' && key != '9'){
                if(max < ht.get(key)){
                    max = ht.get(key);
                }
            }else{
                twin += ht.get(key);
            }
        }
        if(max < twin / 2 + twin % 2){
            max = twin / 2 + twin % 2;
        }
        System.out.println(max);
    }
}
