
import java.util.*;
public class SumAutoboxing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        System.out.print("How many integers? ");
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.print("Enter integer #"+(i+1)+": ");
            int v=sc.nextInt();
            list.add(v);
        }
        int sum=0;
        for(Integer x:list) sum+=x;
        System.out.println("You entered: "+list);
        System.out.println("Sum: "+sum);
    }
}