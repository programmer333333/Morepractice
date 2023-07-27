import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Stringcalculator {
    static String result;
    static Scanner sc;
    static String input;

    static String[] str;

    public static void main(String[] args) throws Exception {
        initialization();


        if (input.contains("+")) {
            addition();
        } else if (input.contains("-")) {
            subtraction();
        } else if (input.contains("*")) {
            multiplication();
        } else if (input.contains("/")) {
            division();
        } else {
            throw new Exception("Incorrect expression!!!");
        }

       if (result.toCharArray().length > 40) {
           String res = lengthString40(result);
           System.out.println("\"" + res + "..." + "\"");}
            else
            System.out.println("\"" + result + "\"");
        }



    public static void initialization() throws Exception {
        result = "";
        sc = new Scanner(System.in);
        System.out.println("Enter expression: ");
        input = sc.nextLine();
        input = input.replace("\"", "");
    }

    public static void lengthString() throws Exception {

        if (str[0].toCharArray().length > 10 || str[1].toCharArray().length > 10) {
            throw new Exception("Enter from 1 to 10 symbols");
        }

    }


    public static void addition() throws Exception {
        str = input.split("\\+");
        lengthString();
        result = str[0] + str[str.length - 1];
    }


    public static void subtraction() throws Exception {
        str = input.split("-");
        lengthString();
        int index = str[0].indexOf(str[1]);
        if (index == -1) {
            result = str[0].replace(str[0], "");
        } else {
            result = str[0].substring(0, index).trim();
        }
    }


    public static void multiplication() throws Exception {
        str = input.split("\\*");
        lengthString();
        int number = Integer.parseInt(str[str.length - 1]);
        if (number > 10) {
            throw new Exception("Enter numbers from 1 to 10 inclusive");
        }

        for (int i = 0; i < number; i++) {
            result += str[0];
        }
    }

    public static void division() throws Exception {
        str = input.split("/");
        lengthString();
        int length = str[0].toCharArray().length;
        int num = Integer.parseInt(str[str.length - 1]);
        if (num > 10) {
            throw new Exception("Enter numbers from 1 to 10 inclusive");
        }
        int res = length / num;
        if (res > 10) {
            throw new Exception("Enter numbers from 1 to 10 inclusive");
        }
        result = str[0].substring(0, length / num);
    }

    public static String lengthString40(String res) {
        if (res.toCharArray().length > 40) {
            char[] rrr = res.toCharArray();
            char[] array = new char[40];
            for (int i = 0; i < array.length; i++) {
                array[i] = rrr[i];

            }

             res = String.valueOf(array);
        }
        return res;
    }

}







