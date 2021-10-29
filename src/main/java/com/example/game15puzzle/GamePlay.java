package com.example.game15puzzle;


public class GamePlay {
    private int[][] numbers = new int[4][4];

    public int[][] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[][] numbers) {
        this.numbers = numbers;
    }


    //Re-initialize array
    public void Init() {

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
