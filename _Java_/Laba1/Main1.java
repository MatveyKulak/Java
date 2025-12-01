package Laba1;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input number: ");
        int num = scan.nextInt();
        scan.close();

        if ( num==0 ){
            num+=1;
            System.out.printf("Your number is 0,then: %d", num);
        }
        else {
            System.out.printf("Your number isn't 0,then: %d", num);
        }
    }
}