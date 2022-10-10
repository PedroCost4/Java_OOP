import java.util.ArrayList;
import java.util.Scanner;

public class atividade6 {

    public static int getSum(ArrayList<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String na = sc.nextLine();
        sc.close();
        String[] n = na.split(" ");
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n.length; i++) {
            list.add(Integer.parseInt(n[i]));
        }

        float media = getSum(list) / list.size();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > media) {
                System.out.print(list.get(i) + " ");
            }
        }
        

        



    }
}
