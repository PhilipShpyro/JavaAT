package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int randomNumbersAmount = input.nextInt();
        int[] randomInts = new int[randomNumbersAmount];
        for(int i = 0; i < randomInts.length; i++){
            randomInts[i] = new Random().nextInt(101);
            System.out.println(randomInts[i]);
        }
        for(int randomNumber : randomInts)
            System.out.print(randomNumber + " ");
    }
}
