package com.github.martinfrank.super_wasching_machine;

import java.util.*;

/**
 * https://leetcode.com/problems/super-washing-machines/
 *
 * Input: machines = [1,0,5]
 * Output: 3
 * Explanation:
 * 1st move:    1     0 <-- 5    =>    1     1     4
 * 2nd move:    1 <-- 1 <-- 4    =>    2     1     3
 * 3rd move:    2     1 <-- 3    =>    2     2     2
 *
 */
public class Solution {

    public static void main(String[] args) {
        final int[] input = {1,0,5};
        Solution solution = new Solution();
        System.out.println("output : "+solution.findMinMoves(input));
    }

    public int findMinMoves(int[] machines) {
        final int totalAmountOfCloths = Arrays.stream(machines).sum();
        final int amountMachines = machines.length;
        final int targetValue =  totalAmountOfCloths / amountMachines;

        if (isImpossibleToSolve(totalAmountOfCloths, amountMachines)){
            return -1;
        }
        return calculateMoves(machines, amountMachines, targetValue, totalAmountOfCloths);
    }



    private int calculateMoves(int[] machines, int amountMachines, int targetValue, int totalAmountOfCloths) {
        int amountSteps = 0;
        while(!isSolved(machines, targetValue)) {
            distributeCloths(machines, amountMachines, targetValue, totalAmountOfCloths);
            amountSteps = amountSteps + 1;
            System.out.println("----next iter---");
        }
        return amountSteps;
    }

    private void distributeCloths(int[] machines, int amountMachines, int targetValue, int totalAmountOfCloths) {
        int amountClothsLeft = 0;
        int amountClothsRight = totalAmountOfCloths;
        for (int machineIndex = 0; machineIndex < amountMachines; machineIndex++) {
            amountClothsRight = amountClothsRight - machines[machineIndex];
            if(machineIndex > 0){
                amountClothsLeft = amountClothsLeft+machines[machineIndex-1];
            }

            boolean alreadyMoved = false;
            double leftAverage = amountClothsLeft / (machineIndex+1d);
            System.out.println("index:"+machineIndex+"  amountLeft:"+amountClothsLeft+"  leftAverage:"+leftAverage+" "+Arrays.toString(machines));

            double rightAverage = (double)amountClothsRight / (amountMachines - machineIndex);
            System.out.println("index:"+machineIndex+" amountRight:"+amountClothsRight+" rightAverage:"+rightAverage+" "+Arrays.toString(machines));


            if(leftAverage < targetValue && machineIndex > 0){
                pushLeft(machines, machineIndex);
                alreadyMoved = true;
            }

            if(rightAverage < targetValue && machineIndex < amountMachines+1 && !alreadyMoved){
                pushRight(machines, machineIndex);
            }
        }
    }

    private void pushRight(int[] machines, int machineIndex) {
        System.out.println("push right");
        push(machines, machineIndex, machineIndex+1);
    }

    private void pushLeft(int[] machines, int machineIndex) {
        System.out.println("push left");
        push(machines, machineIndex, machineIndex-1);
    }
    private void push(int[] machines, int machineIndex, int targetIndex) {
        System.out.println("before push:"+Arrays.toString(machines));
        machines[targetIndex] = machines[targetIndex]+1;
        machines[machineIndex] = machines[machineIndex]-1;
        System.out.println("after  push:"+Arrays.toString(machines));
    }

    private boolean isImpossibleToSolve(int amountOfCloths, int amountMachines) {
        return amountOfCloths % amountMachines != 0;
    }

    private boolean isSolved(int[] machines, int targetValue) {
        return ! Arrays.stream(machines).filter(m -> m!=targetValue).findAny().isPresent();
    }

}
