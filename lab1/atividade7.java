import java.util.Scanner;
import java.util.ArrayList;

public class atividade7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            String names = sc.nextLine();
            String[] nameArray = names.split(" ");

            if (nameArray[0].equals("wally")) {
                break;
            }

            ArrayList<String> nameList = new ArrayList<String>();
            for (int i = 0; i < nameArray.length; i++) {
                if (nameArray[i].length() == 5) {
                    nameList.add(nameArray[i]);
                }
            }

            if (nameList.size() == 0){
                System.out.println("?");
            }else{
                System.out.println(nameList.get(nameList.size() - 1));
            }

        }
        sc.close();
    }
}
