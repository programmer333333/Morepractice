import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Stringcalculator {
    public static void main(String[] args) throws Exception {
        String result = "";

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter expression: ");
        String input = sc.nextLine();
        input = input.replace("\"", "");


        if (result.toCharArray().length > 40) {
            System.out.println("\"" + result + "..." + "\"");
        }


        String[] str = input.split("[+ \\- * /]");


        for (int i = 0; i < str.length; i++) {
            if (str[i].toCharArray().length > 10) {
                throw new Exception("Enter from 1 to 10 symbols");
            }
        }


        if (input.contains("+")) {
            result = str[0] + str[str.length - 1];
            System.out.println("\"" + result + "\"");
        }


        else if (input.contains("-")) {
            List<String> strArr = new ArrayList<>(List.of(str));
            while (strArr.remove(str[str.length - 1])) ;
            result = String.join(" ", strArr);
            System.out.println("\"" + result + "\"");
        }


        else  if (input.contains("*")) {
            int number = Integer.parseInt(str[str.length - 1]);

            if (number > 10) {
                throw new Exception("Enter numbers from 1 to 10 inclusive");
            }

            for (int i = 0; i < number; i++) {
                result += str[0];
            }

            if (result.toCharArray().length > 40) {
                System.out.println("\"" + result + "..." + "\"");
            } else {
                System.out.print("\"" + result + "\"");
            }
        }

            else if (input.contains("/")) {
                int length = str[0].toCharArray().length;
                int num = Integer.parseInt(str[str.length - 1]);
                int res = length / num;
                if (res > 10) {
                    throw new Exception("Enter numbers from 1 to 10 inclusive");
                }

                result = str[0].substring(0, length / num);
                System.out.println("\"" + result + "\"");
            }

            else {throw new Exception("Incorrect expression!!!");}
        }

    }






