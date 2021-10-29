package com.example.game15puzzle;


import java.util.Random;

public class GamePlay {
    private static Random generator = new Random();
    private int[][] numbers = new int[4][4];

    public int[][] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[][] numbers) {
        this.numbers = numbers;
    }


    //Re-initialize array
    public void Init() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                numbers[i][j] = 0;
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
        }
    }

    public void PrintArr() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(numbers[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GamePlay gamePlay = new GamePlay();
        gamePlay.PrintArr();
    }

}
