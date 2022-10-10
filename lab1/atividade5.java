import java.util.Scanner;
import java.text.MessageFormat;

public class atividade5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String operator = input.next();
        float a = input.nextFloat();
        float b = input.nextFloat();
        input.close();
        switch (operator) {
            case "+":
                System.out.println(MessageFormat.format("RESULTADO: {0}", a + b));
                break;
            case "-":
                System.out.println(MessageFormat.format("RESULTADO: {0}", a - b));
                break;
            case "*":
                System.out.println(MessageFormat.format("RESULTADO: {0}", a * b));
                break;
            case "/":
                if (b == 0.0f) {
                    System.out.println("ERRO");
                } else {
                    System.out.println(MessageFormat.format("RESULTADO: {0}", a / b));
                }
                break;
            default:
                System.out.println("ENTRADA INVALIDA");
                return;
        }
    }
}