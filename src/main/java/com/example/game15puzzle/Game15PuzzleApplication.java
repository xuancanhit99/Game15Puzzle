package com.example.game15puzzle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
public class Game15PuzzleApplication {

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            Logger.getLogger(GamePlay.class.getName()).log(Level.SEVERE, null, e);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GamePlay().setVisible(true);
            }
        });
        SpringApplication.run(Game15PuzzleApplication.class, args);
    }

}
