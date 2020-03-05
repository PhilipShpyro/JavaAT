package com.company;

import java.sql.SQLOutput;
import java.util.Scanner;

enum Day{
    first,
    second
}

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        byte number = input.nextByte();
        if(number < 1 || number > 12)
            throw new Exception("The number you've entered must be equal or more than 1 and less or equal 12");
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        System.out.println(monthNames[number - 1]);
    }
}
