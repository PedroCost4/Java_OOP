import java.util.Scanner;
import java.util.ArrayList;

public class atividade8 {

    public static int getSum(ArrayList<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }

    public static int getMax(ArrayList<Integer> list) {
        int max = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        return max;
    }

    public static int getMin(ArrayList<Integer> list) {
        int min = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < min) {
                min = list.get(i);
            }
        }
        return min;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (true) {
            String value = sc.nextLine();
            
            if (value.equals("-")) {
                break;
            }

            int num = Integer.parseInt(value.split(" ")[1]);

            list.add(num); 
        }

        int maximo = getMax(list);
        int minimo = getMin(list);
        int media = getSum(list) / list.size();

        int countAbove = 0;
        int countBelow = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) >= 700) {
                countAbove++;
            } else if (list.get(i) < 700) {
                countBelow++;
            }
        }

        System.out.println("maior: " + maximo);
        System.out.println("menor: " + minimo);
        System.out.println("media: " + media);
        System.out.println("acima: " + countAbove);
        System.out.println("abaixo: " + countBelow);

        sc.close();
    }
}
