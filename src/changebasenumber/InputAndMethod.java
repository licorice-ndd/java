/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//decimal sang binary 77777777777777777777
package changebasenumber;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author LICORICE
 */
public class InputAndMethod {

    Scanner scanner = new Scanner(System.in);

    void DisplayMenuOption() {
        System.out.println(" Change Base Program ");
        System.out.println(" 1 : Binary.");
        System.out.println(" 2 : Decimal.");
        System.out.println(" 3 : Hexadecimal.");
    }

    public boolean isContinue() {
        String isCont;
        while (true) {
            System.out.println("You need to input y to continue or n to return : ");
            isCont = scanner.nextLine();
            if (isCont.equalsIgnoreCase("Y")) {
                return true;
            } else if (isCont.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.out.print("You need to input Y or N : ");
            }
        }
    }

    public int inputChoice(String display) {
        int choice;
        //let user input your choice 
        System.out.print(display);
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                //notify to user when they input wrong and let them re-input
                if (choice < 1 || choice > 3) {
//                    System.out.print("Your input must be in range 1 to 3! Re-input: ");
//                    choice = Integer.parseInt(scan.nextLine());
                    throw new Exception();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.print("You must input digit! Re-input : ");
            } catch (Exception ex) {
                System.out.println("Your input must be in range 1 to 3! Re-input : ");
            }
        }
        switch (choice) {
            case 1:
                return 2;
            case 2:
                return 10;
            case 3:
                return 16;
            case 4:
                return 24;
            default:
                return 0;
        }
    }

    public boolean isValid(String input, int fromBase) {
        input = input.toLowerCase();
        //get all character of string input
        for (int i = 0; i < input.length(); i++) {
            //check if you input is binary or not
            if (fromBase == 2 && input.charAt(i) != '0' && input.charAt(i) != '1') {
                return false;
            }
            //check if you input is decimal or not
            if (fromBase == 10 && !Character.isDigit(input.charAt(i))) {
                return false;
            }
            //check if you input is hexadecimal or not
            if (fromBase == 16 && !Character.isDigit(input.charAt(i))) {
                if (input.charAt(i) < 'a' || input.charAt(i) > 'f') {
                    return false;
                }
            }
        }
        return true;
    }

    public String inputValue(int fromBase) {
        String input;
        System.out.print("Enter the input value : ");
        //let user input value until it valid
        while (true) {
            try {
                input = scanner.nextLine();
                //notify user and let user re-input
                if (!isValid(input, fromBase)) {
                    throw new Exception();
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.print("Wrong format number! Re-enter : ");
            }
        }
        return input;
    }

    public int toDec(String input, int fromBase) {
        input = input.toLowerCase();
        int decNum = 0;
        int length = input.length();
        int i = 0, exp = length - 1;
        //convert your input from base you choose to decimal
        while (i < length) {
            //calculate decimal number
            //char of a to int is 97, 9 is 57, 0 is 48
            if (input.charAt(i) >= 48 && input.charAt(i) <= 57) {
                decNum += (int) (input.charAt(i) - 48) * Math.pow(fromBase, exp);
            } else {
                decNum += (int) (input.charAt(i) - 87) * Math.pow(fromBase, exp);
            }
            i++;
            exp--;
        }
        return decNum;
    }

    public void decToBin(int decNum) {
        int[] binaryNum = new int[32];
        int i = 0;
        while (decNum != 0) {
            binaryNum[i] = decNum %= 2;
            decNum = decNum / 2;
            i++;
        }
        for (int j = i - 1; j >= 0; j--) {
            System.out.print(binaryNum[j]);
        }
//        return binaryNum;
    }

    public String decToHex(int decNum) {
        String temp = "";
        //change decimal to hexadecimal but it is reversed
        while (decNum != 0) {
            if (decNum % 16 < 9) {
                temp += (char) (decNum % 16 + 48);
            } else {
                temp += (char) (decNum % 16 + 87);
            }
            decNum /= 16;
        }
        String hexNum = new StringBuffer(temp).reverse().toString();
        return hexNum;
    }

}
