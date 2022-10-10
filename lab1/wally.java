import java.util.Scanner;
public class wally { 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nomes;
        String[] listaNomes;
        int i;

        while(true){
            boolean igual = false;
            nomes = sc.nextLine();
            if(nomes.equals("wally")){
                break;
            }
            listaNomes = nomes.split(" ");
            for(i = listaNomes.length-1; i >= 0; i--){
                if(listaNomes[i].length() == 5){
                    System.out.println(listaNomes[i]);
                    igual = true;
                    break;
                }
            }
            if(igual == false){
                System.out.println("?");
            }
        }
        sc.close();
    }
}
