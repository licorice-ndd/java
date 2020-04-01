/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package changebasenumber;

/**
 *
 * @author LICORICE
 */

public class Lab11ChangeBaseMain {

    public static void main(String[] args) {
        InputAndMethod iam = new InputAndMethod();
        //program run until user doesn't want to continue using this program 
        do {
            iam.DisplayMenuOption();
            String input;
            int fromBase = iam.inputChoice(" Choose the base number input : ");
            int toBase = iam.inputChoice(" Choose the base number output : ");
            switch (toBase) {
                case 2:
                    input = iam.inputValue(fromBase);
                    if (fromBase == toBase) {
                        System.out.println("Result : " + input);
                        break;
                    } else {
                        int binHex = iam.toDec(input, fromBase);
                        String binNum = iam.decToBin(binHex);
                        System.out.println("Result : " + binNum);
                        break;
                    }
                case 10:
                    input = iam.inputValue(fromBase);
                    if (fromBase == toBase) {
                        System.out.println("Result : " + input);
                        break;
                    } else {
                        int decNum = iam.toDec(input, fromBase);
                        System.out.println("Result : " + decNum);
                        break;
                    }
                case 16:
                    input = iam.inputValue(fromBase);
                    if (fromBase == toBase) {
                        System.out.println("Result : " + input);
                        break;
                    } else {
                        int hexDec = iam.toDec(input, fromBase);
                        String hexNum = iam.decToHex(hexDec);
                        System.out.println("Result : " + hexNum);
                        break;
                    }
//                case 24:
//                    input = iam.inputValue(fromBase);
//                    if(fromBase==toBase){
//                        System.out.println("");
//                    }                             
            }
        } while (iam.isContinue());
    }
}
