package com.example.game15puzzle;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class Game15PuzzleApplicationTests {

    @Test
    public void GamePlayInitTestCase1() {
        GamePlay gamePlay = new GamePlay();
        int[][] arrTest = new int[4][4];
        arrTest[0][0] = 1;
        arrTest[0][1] = 2;
        arrTest[0][2] = 13;
        arrTest[0][3] = 14;
        arrTest[1][0] = 15;
        arrTest[1][1] = 6;
        arrTest[1][2] = 7;
        arrTest[1][3] = 8;
        arrTest[2][0] = 9;
        arrTest[2][1] = 10;
        arrTest[2][2] = 11;
        arrTest[2][3] = 12;
        arrTest[3][0] = 3;
        arrTest[3][1] = 4;
        arrTest[3][2] = 5;
        gamePlay.setNumbers(arrTest);
        gamePlay.Init();
        // Desired result of array
        int[][] arrResult = new int[4][4]; //(All values in array = 0)
        assertThat(gamePlay.getNumbers()).isEqualTo(arrResult);
    }

    @Test
    public void GamePlayRandArrTestCase2() {
        GamePlay gamePlay = new GamePlay();
        int[][] arrTest = new int[4][4]; //(All values in array = 0)
        gamePlay.setNumbers(arrTest);
        gamePlay.RandArr();
        int[][] arrResult = new int[4][4]; //(All values in array = 0)
        assertThat(gamePlay.getNumbers()).isNotEqualTo(arrResult);
    }

    @Test
    public void GamePlayCheckArrValidTestCase3() {
        GamePlay gamePlay = new GamePlay();
        gamePlay.Init();
        gamePlay.RandArr();
        int num00 = gamePlay.getNumbers()[0][0];
        gamePlay.CheckArrValid();
        int numResult00 = gamePlay.getNumbers()[0][0];
        assertThat(num00).isNotEqualTo(numResult00);
    }

    @Test
    public void Puzzle15CheckWinTestCase4() {
        GamePlay gamePlay = new GamePlay();
        int[][] arrTest = new int[4][4];
        arrTest[0][0] = 1;
        arrTest[0][1] = 2;
        arrTest[0][2] = 3;
        arrTest[0][3] = 4;
        arrTest[1][0] = 5;
        arrTest[1][1] = 6;
        arrTest[1][2] = 7;
        arrTest[1][3] = 8;
        arrTest[2][0] = 9;
        arrTest[2][1] = 10;
        arrTest[2][2] = 11;
        arrTest[2][3] = 12;
        arrTest[3][0] = 13;
        arrTest[3][1] = 14;
        arrTest[3][2] = 15;
        gamePlay.setNumbers(arrTest);
        Boolean output = gamePlay.CheckWin();
        assertThat(output).isEqualTo(true);
    }

    @Test
    public void Puzzle15CheckWinTestCase5() {
        GamePlay gamePlay = new GamePlay();
        int[][] arrTest = new int[4][4];
        arrTest[0][0] = 1;
        arrTest[0][1] = 2;
        arrTest[0][2] = 13;
        arrTest[0][3] = 14;
        arrTest[1][0] = 15;
        arrTest[1][1] = 6;
        arrTest[1][2] = 7;
        arrTest[1][3] = 8;
        arrTest[2][0] = 9;
        arrTest[2][1] = 10;
        arrTest[2][2] = 11;
        arrTest[2][3] = 12;
        arrTest[3][0] = 3;
        arrTest[3][1] = 4;
        arrTest[3][2] = 5;
        gamePlay.setNumbers(arrTest);
        Boolean output = gamePlay.CheckWin();
        assertThat(output).isEqualTo(false);
    }

    @Test
    public void Puzzle15CheckWinTestCase6() {
        GamePlay gamePlay = new GamePlay();
        int[][] arrTest = new int[4][4];
        arrTest[0][0] = 1;
        arrTest[0][1] = 3;
        arrTest[0][2] = 5;
        arrTest[0][3] = 7;
        arrTest[1][0] = 9;
        arrTest[1][1] = 11;
        arrTest[1][2] = 13;
        arrTest[1][3] = 15;
        arrTest[2][0] = 14;
        arrTest[2][1] = 12;
        arrTest[2][2] = 10;
        arrTest[2][3] = 8;
        arrTest[3][0] = 6;
        arrTest[3][1] = 4;
        arrTest[3][2] = 2;
        gamePlay.setNumbers(arrTest);
        Boolean output = gamePlay.CheckWin();
        assertThat(output).isEqualTo(false);
    }

}
