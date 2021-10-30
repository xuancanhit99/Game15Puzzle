package com.example.game15puzzle;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GamePlay {

    JButton jButtonPlayRTP, jButtonStartRTP, jButtonPlay15P, jButton15PMixNum, jButton1, jButton2, jButton3, jButton4, jButton5, jButton6, jButton7, jButton8, jButton9;
    JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6;
    JScrollPane jScrollPaneRTP, jScrollPane15P, jScrollPaneTable;
    JTextArea jTextAreaRTP, jTextArea15P;
    JTable jTableRTP;
    JTabbedPane jTabbedPaneGameMain;
    JPanel jPanelRTP, jPanel15P, jPanel15pBottom;

    JFrame jFrameRuleRTP, jFrameRule15P, jFrameGameMain;

    GroupLayout jFrameRTPLayout, jFrame15PLayout;

    JMenu jMenuMainGame, jMenuGame;
    JMenuBar jMenuBarMain;
    JMenuItem jMenuItemGameRTP, jMenuItemGame15P, jMenuItemExit;


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


    public GamePlay() {
        initComponents();
    }

    // Game Rearrange The Pieces: RTP - Игра "переставь фигуры"
    // Game 15 puzzle: 15P - Игра "Пятнашки"

    private void initComponents() {
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jButton4 = new JButton();
        jButton5 = new JButton();
        jButton6 = new JButton();
        jButton7 = new JButton();
        jButton8 = new JButton();
        jButton9 = new JButton();
        jButtonStartRTP = new JButton();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();

        jPanelRTP = new JPanel();
        jPanel15P = new JPanel();
        jPanel15pBottom = new JPanel();


        jFrameRuleRTP = new JFrame();
        jButtonPlayRTP = new JButton();
        jTextAreaRTP = new JTextArea();
        jFrameRule15P = new JFrame();
        jTextArea15P = new JTextArea();

        jButton15PMixNum = new JButton();
        //---Game RTP---
        jFrameRuleRTP.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jFrameRuleRTP.setTitle("Правила игры переставь фигуры");
        jFrameRuleRTP.setBounds(new Rectangle(0, 0, 500, 500));
        jFrameRuleRTP.setLocationRelativeTo(null);


        jButtonPlayRTP.setText("Перейти к игре");
        jButtonPlayRTP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButtonPlayRTPActionPerformed(e);
            }
        });


        jTextAreaRTP.setColumns(20);
        jTextAreaRTP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        jTextAreaRTP.setRows(5);
        jTextAreaRTP.setText("                                           Добро пожаловать!\n\n" +
                "   При нажатии кнопки \"Перейти к игре\" перед вами появится \n игровое поле 3х3 с стоящими на нем фигурами. Ваша задача\n заключается в том, чтобы перенести верхние фигуры вниз, а\n верхние вверх, игра считается оконченной если переставлены\n все фигуры.Так же, в таблице сбоку будут показываться ваши\n ходы. Желаю удачи!");
        jTextAreaRTP.setEditable(false);

        jScrollPaneRTP = new JScrollPane();
        jScrollPaneRTP.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        jScrollPaneRTP.setViewportView(jTextAreaRTP);

        jFrameRTPLayout = new GroupLayout(jFrameRuleRTP.getContentPane());
        jFrameRuleRTP.getContentPane().setLayout(jFrameRTPLayout);
        jFrameRTPLayout.setHorizontalGroup(
                jFrameRTPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jFrameRTPLayout.createSequentialGroup()
                                .addGap(180, 180, 180)
                                .addComponent(jButtonPlayRTP)
                                .addContainerGap(200, Short.MAX_VALUE)
                        )
                        .addComponent(jScrollPaneRTP)
        );

        jFrameRTPLayout.setVerticalGroup(
                jFrameRTPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jFrameRTPLayout.createSequentialGroup()
                                .addComponent(jScrollPaneRTP, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                                .addComponent(jButtonPlayRTP)
                                .addGap(30, 30, 30))
        );

        //---Game 15P---
        jFrameRule15P.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jFrameRule15P.setTitle("Правила игры пятнашки");
        jFrameRule15P.setBounds(new Rectangle(0, 0, 500, 500));
        jFrameRule15P.setLocationRelativeTo(null);

        jButtonPlay15P = new JButton();
        jButtonPlay15P.setText("Перейти к игре");
        jButtonPlay15P.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButtonPlay15PActionPerformed(e);
            }
        });


        jTextArea15P.setColumns(20);
        jTextArea15P.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        jTextArea15P.setRows(5);
        jTextArea15P.setText("                                           Добро пожаловать!\n\n" +
                "   При нажатии кнопки \"Перейти к игре\" перед вами появится \n игровое поле 4х4 со стоящими на нем числами от 1 до 15\n(в случайном порядке). Ваша задача восстановить порядок чисел.\n Желаю удачи!");
        jTextArea15P.setEditable(false);

        jScrollPane15P = new JScrollPane();
        jScrollPane15P.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        jScrollPane15P.setViewportView(jTextArea15P);

        jFrame15PLayout = new GroupLayout(jFrameRule15P.getContentPane());
        jFrameRule15P.getContentPane().setLayout(jFrame15PLayout);
        jFrame15PLayout.setHorizontalGroup(
                jFrame15PLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jFrame15PLayout.createSequentialGroup()
                                .addGap(180, 180, 180)
                                .addComponent(jButtonPlay15P)
                                .addContainerGap(200, Short.MAX_VALUE)
                        )
                        .addComponent(jScrollPane15P)
        );

        jFrame15PLayout.setVerticalGroup(
                jFrame15PLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jFrame15PLayout.createSequentialGroup()
                                .addComponent(jScrollPane15P, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                                .addComponent(jButtonPlay15P)
                                .addGap(30, 30, 30))
        );

        //Game Main Windows: RTP, 15P
        jFrameGameMain = new JFrame();
        jFrameGameMain.setTitle("Игра");
        jFrameGameMain.setBounds(new Rectangle(0, 0, 750, 520));
        jFrameGameMain.setLocationRelativeTo(null);

        //Table Game RTP
        jTableRTP = new JTable();
        jTableRTP.setShowGrid(true);
        jTableRTP.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
        jTableRTP.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Фигура", "Клетка n-1", "Клетка n"
                }
        ));
        jScrollPaneTable = new JScrollPane();
        jScrollPaneTable.setViewportView(jTableRTP);

        //Tab in Main Game
        jTabbedPaneGameMain = new JTabbedPane();
        jTabbedPaneGameMain.addTab("Переставь фигуры", jPanelRTP);
        jTabbedPaneGameMain.addTab("Пятнашки", jPanel15P);


        //Tab 15P
        GridLayout jPanel15PLayout = new GridLayout(5, 4, 2, 2);
        jPanel15P.setLayout(jPanel15PLayout);
        init();
        jPanel15P.setDoubleBuffered(true);
        repaintField();

        jButton15PMixNum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init();
                repaintField();
            }
        });

        //Tab RTP
        GroupLayout jPanelRTPLayout = new GroupLayout(jPanelRTP);
        jPanelRTP.setLayout(jPanelRTPLayout);
        jPanelRTPLayout.setHorizontalGroup(
                jPanelRTPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelRTPLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(jPanelRTPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelRTPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton7, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelRTPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanelRTPLayout.createSequentialGroup()
                                                .addGroup(jPanelRTPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton8, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanelRTPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton6, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton9, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanelRTPLayout.createSequentialGroup()
                                                .addComponent(jLabel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
                                .addGap(20, 20, 20)
                                .addGroup(jPanelRTPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jButtonStartRTP)
                                        .addComponent(jScrollPaneTable, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelRTPLayout.setVerticalGroup(
                jPanelRTPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelRTPLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanelRTPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelRTPLayout.createSequentialGroup()
                                                .addGroup(jPanelRTPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel6))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanelRTPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanelRTPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton6, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanelRTPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(jPanelRTPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jButton7, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jButton8, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton9, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanelRTPLayout.createSequentialGroup()
                                                .addComponent(jScrollPaneTable, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButtonStartRTP)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout jFrameGameMainLayout = new GroupLayout(jFrameGameMain.getContentPane());
        jFrameGameMain.getContentPane().setLayout(jFrameGameMainLayout);
        jFrameGameMainLayout.setHorizontalGroup(
                jFrameGameMainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPaneGameMain, GroupLayout.Alignment.TRAILING)
        );
        jFrameGameMainLayout.setVerticalGroup(
                jFrameGameMainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPaneGameMain)
        );

        //Game Main
        jButton1.setEnabled(false);
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton1ActionPerformed(e);
            }
        });

        jButton2.setEnabled(false);
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton2ActionPerformed(e);
            }
        });

        jButton3.setEnabled(false);
        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton3ActionPerformed(e);
            }
        });

        jButton4.setEnabled(false);
        jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton4ActionPerformed(e);
            }
        });

        jButton5.setEnabled(false);
        jButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton5ActionPerformed(e);
            }

        });

        jButton6.setEnabled(false);
        jButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton6ActionPerformed(e);
            }
        });

        jButton7.setEnabled(false);
        jButton7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton7ActionPerformed(e);
            }
        });

        jButton8.setEnabled(false);
        jButton8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton8ActionPerformed(e);
            }
        });

        jButton9.setEnabled(false);
        jButton9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton9ActionPerformed(e);
            }
        });

        jLabel1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        jLabel1.setText("1");

        jLabel2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        jLabel2.setText("2");

        jLabel3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        jLabel3.setText("3");

        jLabel4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel4.setText("A");
        jLabel4.setHorizontalTextPosition(SwingConstants.RIGHT);

        jLabel5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel5.setText("B");

        jLabel6.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        jLabel6.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel6.setText("C");

        jButtonStartRTP.setText("Начать игру");
        jButtonStartRTP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButtonStartRTPActionPerformed(e);
            }
        });

        //Menu
        jMenuMainGame = new JMenu();
        jMenuGame = new JMenu();
        jMenuItemGameRTP = new JMenuItem();
        jMenuItemGame15P = new JMenuItem();
        jMenuItemExit = new JMenuItem();
        jMenuBarMain = new JMenuBar();

        jMenuMainGame.setText("Игры");
        jMenuGame.setText("Об игре");
        jMenuItemGameRTP.setText("Переставь фигуры");
        jMenuItemGameRTP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jMenuItemRTPActionPerformed(e);
            }
        });
        jMenuGame.add(jMenuItemGameRTP);

        jMenuItemGame15P.setText("Пятнашки");
        jMenuItemGame15P.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jMenuItem15PActionPerformed(e);
            }
        });
        jMenuGame.add(jMenuItemGame15P);

        jMenuMainGame.add(jMenuGame);

        jMenuItemExit.setText("Выход");
        jMenuItemExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jMenuItemExitActionPerformed(e);
            }
        });
        jMenuMainGame.add(jMenuItemExit);

        jMenuBarMain.add(jMenuMainGame);

        setJMenuBar(jMenuBarMain);


        //Size
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mini Chess & 15 Puzzle");
        setLocationRelativeTo(null);

    }

    private void init() {
        int[] invariants = new int[16];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                numbers[i][j] = 0;
                invariants[i * 4 + j] = 0;
            }
        }

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

        if (counter % 2 != 0) {
            int temp = numbers[0][0];
            numbers[0][0] = numbers[3][3];
            numbers[3][3] = temp;
        }
    }

    public void repaintField() {
        jPanel15P.removeAll();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                JButton button = new JButton(Integer.toString(numbers[i][j]));
                button.setFocusable(false);
                jPanel15P.add(button);
                if (numbers[i][j] == 0) {
                    button.setVisible(false);
                } else
                    button.addActionListener(new ClickListener());
            }
        }
        jPanel15P.add(jPanel15pBottom);
        jButton15PMixNum.setText("Перемешать");
        jPanel15pBottom.add(jButton15PMixNum);
        jPanel15P.validate();
    }

    private class ClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            button.setVisible(false);
            String name = button.getText();
            change(Integer.parseInt(name));
        }
    }

    public void change(int num) {
        int i = 0, j = 0;
        for (int k = 0; k < 4; k++) {
            for (int l = 0; l < 4; l++) {
                if (numbers[k][l] == num) {
                    i = k;
                    j = l;
                }
            }
        }
        if (i > 0) {
            if (numbers[i - 1][j] == 0) {
                numbers[i - 1][j] = num;
                numbers[i][j] = 0;
            }
        }
        if (i < 3) {
            if (numbers[i + 1][j] == 0) {
                numbers[i + 1][j] = num;
                numbers[i][j] = 0;
            }
        }
        if (j > 0) {
            if (numbers[i][j - 1] == 0) {
                numbers[i][j - 1] = num;
                numbers[i][j] = 0;
            }
        }
        if (j < 3) {
            if (numbers[i][j + 1] == 0) {
                numbers[i][j + 1] = num;
                numbers[i][j] = 0;
            }
        }
        repaintField();
        if (checkWin()) {
            JOptionPane.showMessageDialog(null, "Игра закончена!", "Вы выиграли!", 1);
            init();
            repaintField();
            setVisible(false);
            setVisible(true);
        }
    }

    private void jButton1ActionPerformed(ActionEvent e) {
        func(0, 0);
    }

    private void jButton2ActionPerformed(ActionEvent e) {
        func(0, 1);
    }

    private void jButton3ActionPerformed(ActionEvent e) {
        func(0, 2);
    }

    private void jButton4ActionPerformed(ActionEvent e) {
        func(1, 0);
    }

    private void jButton5ActionPerformed(ActionEvent e) {
        func(1, 1);
    }

    private void jButton6ActionPerformed(ActionEvent e) {
        func(1, 2);
    }

    private void jButton7ActionPerformed(ActionEvent e) {
        func(2, 0);
    }

    private void jButton8ActionPerformed(ActionEvent e) {
        func(2, 1);
    }

    private void jButton9ActionPerformed(ActionEvent e) {
        func(2, 2);
    }

    private void jButtonPlay15PActionPerformed(ActionEvent e) {
        jFrameGameMain.setVisible(true);
        jFrameRule15P.dispose();
        jTabbedPaneGameMain.setSelectedIndex(1);
    }

    private void jButtonStartRTPActionPerformed(ActionEvent e) {
        DefaultTableModel model = (DefaultTableModel) jTableRTP.getModel();
        model.setRowCount(0);
        jButton1.setEnabled(true);
        jButton2.setEnabled(true);
        jButton3.setEnabled(true);
        jButton4.setEnabled(true);
        jButton5.setEnabled(true);
        jButton6.setEnabled(true);
        jButton7.setEnabled(true);
        jButton8.setEnabled(true);
        jButton9.setEnabled(true);

        jButton1.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 50));
        jButton2.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 50));
        jButton3.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 50));
        jButton4.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 50));
        jButton5.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 50));
        jButton6.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 50));
        jButton7.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 50));
        jButton8.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 50));
        jButton9.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 50));

        jButton1.setText("♘");
        jButton2.setText("♘");
        jButton3.setText("♘");
        jButton4.setText(" ");
        jButton5.setText(" ");
        jButton6.setText(" ");
        jButton7.setText("♞");
        jButton8.setText("♞");
        jButton9.setText("♞");
        mass[0][0] = 1; // 1 - верхнии клетки
        mass[0][1] = 1;
        mass[0][2] = 1;
        mass[1][0] = 0; // 0 - пустая клетка
        mass[1][1] = 0;
        mass[1][2] = 0;
        mass[2][0] = 2; // 2 - нижнии клетки
        mass[2][1] = 2;
        mass[2][2] = 2;
    }

    private void jMenuItemExitActionPerformed(ActionEvent e) {
        System.exit(0);
    }

    private void jMenuItem15PActionPerformed(ActionEvent e) {
        jFrameRule15P.setVisible(true);
    }

    private void jMenuItemRTPActionPerformed(ActionEvent e) {
        jFrameRuleRTP.setVisible(true);
    }


    public boolean checkWin() {
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
