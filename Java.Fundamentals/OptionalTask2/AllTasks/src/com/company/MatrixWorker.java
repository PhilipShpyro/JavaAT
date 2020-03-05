package com.company;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.util.ArrayList;
import java.util.Random;

public class MatrixWorker {
    private int [][] matrix;
    private int size;

    public MatrixWorker(int size, int interval){
        this.size = size;
        matrix = new int[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                matrix[i][j] = new Random().nextInt(interval * 2 + 1) - interval;
            }
        }
    }

    public int[][] sortAscendingByColumn(int k) {
        int[][] _matrix = copyMatrix();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (_matrix[j][k] > _matrix[j + 1][k]) {
                    int[] tempArray = _matrix[j];
                    _matrix[j] = _matrix[j + 1];
                    _matrix[j + 1] = tempArray;
                }
            }
        }
        return _matrix;
    }

    public int[] findMaxGrowingSequence(){
        ArrayList<Integer> maxSequence = new ArrayList<Integer>();
        for(int[] array : matrix){
            ArrayList<Integer> sequence = new ArrayList<Integer>();
            sequence.add(array[0]);
            for(int i = 1; i < array.length; i++){
                if(array[i] > array[i-1]){
                    sequence.add(array[i]);
                    if(sequence.size() > maxSequence.size())
                        maxSequence = new ArrayList<Integer>(sequence);
                }
                else{
                    if(sequence.size() > maxSequence.size())
                        maxSequence = new ArrayList<Integer>(sequence);
                    sequence = new ArrayList<Integer>();
                    sequence.add(array[i]);
                }
            }
        }
        int[] result = new int [maxSequence.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = maxSequence.get(i);
        }
        return result;
    }

    public Integer findSumBetweenFirstAndSecondPositiveElements(){
        //Integer sum = null;
        int sum = 0;
        for(int[] array : matrix){
            Integer index1 = null, index2 = null;
            {
                int i = 0, j = 0;
                while (i < array.length) {
                    if (array[i] > 0) {
                        index1 = i;
                        break;
                    }
                    i++;
                }
                j = i + 1;
                while (j < array.length) {
                    if (array[j] > 0) {
                        index2 = j;
                        break;
                    }
                    j++;
                }
            }
            if(index1 != null && index2 != null)
                for(int i = index1; i < index2; i++) {
                    sum += array[i];
                }
        }
        return sum;
    }

    public int[][] deleteRowsAndColumnsWithMaxElement(){
        if(matrix != null && size > 0){
            int maxElement = matrix[0][0];
            for(int[] array : matrix){
                for(int i = 0; i < array.length; i++){
                    if(array[i] > maxElement)
                        maxElement = array[i];
                }
            }

            ArrayList<Integer> rowsToDelete = new ArrayList<Integer>();
            ArrayList<Integer> columnsToDelete = new ArrayList<Integer>();
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j< matrix.length; j++){
                    if(matrix[i][j] == maxElement){
                        if(!rowsToDelete.contains(i))
                            rowsToDelete.add(i);
                        if(!columnsToDelete.contains(j))
                            columnsToDelete.add(j);
                    }
                }
            }

            int[][] matrixWithoutRows = new int[matrix.length - rowsToDelete.size()][matrix.length - columnsToDelete.size()];
            for(int i = 0, _i = 0; i < matrix.length; i++){
                if(rowsToDelete.contains(i))
                    continue;
                for(int j = 0, _j = 0; j < matrix.length; j++){
                    if(columnsToDelete.contains(j))
                        break;
                    matrixWithoutRows[_i][_j] = matrix[i][j];
                    _j++;
                }
                _i++;
            }
            return matrixWithoutRows;
        }
        return null;
    }

    private int[][] copyMatrix(){
        int[][] _matrix = new int[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                _matrix[i][j] = matrix[i][j];
            }
        }
        return _matrix;
    }

    public static String showMatrix(int matrix[][]){
        StringBuilder result = new StringBuilder();
        for(int[] array : matrix){
            for(int number : array)
                result.append(number + " ");
            result.append('\n');
        }
        return result.toString();
    }
    public String showMatrix(){
        StringBuilder result = new StringBuilder();
        for(int[] array : matrix){
            for(int number : array)
                result.append(number + " ");
            result.append('\n');
        }
        return result.toString();
    }
}
