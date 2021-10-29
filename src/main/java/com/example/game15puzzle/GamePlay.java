package com.example.game15puzzle;


import java.util.Random;

public class GamePlay {
    int[] invariants = new int[16];
    private static Random generator = new Random();
    private int[][] numbers = new int[4][4];

    public int[][] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[][] numbers) {
        this.numbers = numbers;
    }

    public int[] getInvariants() {
        return invariants;
    }

    public void setInvariants(int[] invariants) {
        this.invariants = invariants;
    }

    //Re-initialize array
    public void Init() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                numbers[i][j] = 0;
                invariants[i * 4 + j] = 0;
            }
        }
    }

    //The values of the elements in the array are random
    public void RandArr() {
        for (int i = 1; i < 16; i++) {
            int k;
            int l;
            do {
                k = generator.nextInt(100) % 4;
                l = generator.nextInt(100) % 4;
            }
            while (numbers[k][l] != 0);
            numbers[k][l] = i;
            invariants[k * 4 + l] = i;
        }
    }

    public void CheckArrValid() {
        boolean change = true;
        int counter = 1;
        while (change) {
            change = false;
            for (int i = 0; i < 16; i++) {
                if (invariants[i] != i) {
                    for (int j = 0; j < 16; j++) {
                        if (invariants[j] == i) {
                            int temp = invariants[i];
                            invariants[i] = invariants[j];
                            invariants[j] = temp;
                            change = true;
                            counter++;
                            break;
                        }
                    }
                    break;
                }
            }
        }
        System.out.println();
        System.out.println(counter);
        if (counter % 2 != 0) {
            int temp = numbers[0][0];
            numbers[0][0] = numbers[3][3];
            numbers[3][3] = temp;
        }
    }


    public boolean CheckWin() {
        boolean status = true;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == 3 && j > 2)
                    break;
                if (numbers[i][j] != i * 4 + j + 1) {
                    status = false;
                }
            }
        }
        return status;
    }

    public void PrintArr() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(numbers[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void Print() {
        for (int i = 0; i < 16; i++) {
            System.out.print(invariants[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        GamePlay gamePlay = new GamePlay();
        gamePlay.Init();
        gamePlay.Print();

        gamePlay.RandArr();
        gamePlay.Print();
        gamePlay.PrintArr();

        gamePlay.CheckArrValid();
        gamePlay.Print();
        gamePlay.PrintArr();
    }

}
