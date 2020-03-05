package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MatrixWorker worker = new MatrixWorker(10, 99);
        System.out.println(worker.showMatrix());

        System.out.println(MatrixWorker.showMatrix((worker.sortAscendingByColumn(0)))); //First task

        for(int i : worker.findMaxGrowingSequence()) //Second task
            System.out.print(i + " ");

        System.out.println(worker.findSumBetweenFirstAndSecondPositiveElements()); //Third task

        System.out.println(MatrixWorker.showMatrix((worker.deleteRowsAndColumnsWithMaxElement())));  //Fourth task

    }
}
