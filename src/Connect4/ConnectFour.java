package Connect4;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class ConnectFour extends JFrame implements ActionListener {

    int x = 0;
    int y = 0;
    JButton[] buttons;
    JPanel mainPanel, gamePanel, buttonPanel;

    JPanel boardLayout;
    JPanel[][] circles;
    ConnectFour() {
        // SETUP
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setSize(525, 525);
            this.setResizable(false);
            this.setLayout(new BorderLayout());

            // Design
                    buttons = new JButton[7];
                    for(int i = 0; i < buttons.length; i++) {
                        buttons[i] = new JButton(String.valueOf(i+1));
                        buttons[i].setFocusable(false);
                        buttons[i].setPreferredSize(new Dimension(40, 25));
                        buttons[i].addActionListener(this);
                    }

                    // Panel
                    mainPanel = new JPanel();
                    gamePanel = new JPanel();
                    buttonPanel = new JPanel();

                    mainPanel.setLayout(new BorderLayout());
                    mainPanel.setPreferredSize(null);
                    mainPanel.setBackground(Color.BLUE);

                    gamePanel.setLayout(null);
                        boardLayout = new JPanel();
                        boardLayout.setLayout(new GridLayout(6,7));
                        circles = new JPanel[6][7];
                        for (int i = 0; i < circles.length; i++) {
                            x=0;
                            for (int j = 0; j < circles[i].length; j++) {
                                circles[i][j] = new JPanel() {
                                    @Override
                                    protected void paintComponent(Graphics g) {
                                        super.paintComponent(g);
                                        drawCircle(g);
                                    }
                                };
                                circles[i][j].setOpaque(false);
                                circles[i][j].setBounds(x, y, 50,50);
                                boardLayout.add(circles[i][j]);

                                x+=75;
                            }
                            y+=75;
                        }

                    buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 31,5));
                    buttonPanel.setPreferredSize(new Dimension(100,50));
                    buttonPanel.setBorder(new LineBorder(Color.BLACK, 5));

        //Adding
            // 1 Button
                for(int i = 0; i < buttons.length; i++) {
                    buttonPanel.add(buttons[i]);
                }
                    // buttonPanel to mainPanel
            mainPanel.add(buttonPanel, BorderLayout.SOUTH);
                mainPanel.add(gamePanel, BorderLayout.NORTH);
            for (int i = 0; i < circles.length; i++) {
                for (int j = 0; j < circles[i].length; j++) {
                    this.add(circles[i][j]);
                }
            }
            // 2 mainPanel adding to Frame
            this.add(mainPanel, BorderLayout.CENTER);

        // Exit
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    int[] currentColumn = {6,6,6,6,6,6,6};
    int[][] colorSpectrum = new int[6][7];
    int turn = 1;
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(circles[0].length);
        int currentButton = 0;
        for (int i = 0; i < buttons.length; i++) {
            if(currentColumn[i] == 0) {
                System.out.println("MAX");
                System.out.println(Arrays.toString(currentColumn));
                currentButton = i;
            }
            else if(e.getSource()==buttons[i]) {
                if(turn % 2 == 0) {
                    circles[currentColumn[i]-1][i].setBackground(Color.YELLOW);
                    circleColor = Color.YELLOW;
                    System.out.println(circles[currentColumn[i]-1][i].getBackground().getGreen());
                    colorSpectrum[currentColumn[i]-1][i] = circles[currentColumn[i]-1][i].getBackground().getGreen();
                } else if((turn % 2) != 0) {
                    circles[currentColumn[i]-1][i].setBackground(new Color(255, 1, 0));
                    circleColor = new Color(255, 1, 0);
                    System.out.println(circles[currentColumn[i]-1][i].getBackground().getGreen());
                    colorSpectrum[currentColumn[i]-1][i] = circles[currentColumn[i]-1][i].getBackground().getGreen();
                }
                System.out.println("Hello" + i);
                currentButton = i;
            }
        }
        currentColumn[currentButton]--;
        turn++;
        printArray(colorSpectrum);
        if(this.winOrLose()) {
            System.exit(0);
        }

    }

    boolean winOrLose() {
        // give each: horizontal, vetical, diagonals, in TEST class.
        String[][] movesList = convertArray(colorSpectrum);
            System.out.println("I want you to believe it" + Arrays.deepToString(movesList));
        // Horizontal
        String[] horizontal = {"", "", "", "", "", ""};
        for(int i = 0; i < movesList.length; i++) {
            horizontal[i] = "";
            for (int j = 0; j < movesList[i].length; j++) {
                horizontal[i] += movesList[i][j];
            }
        }
        System.out.println(Arrays.toString(horizontal));
        System.out.println(Arrays.deepToString(movesList));
        for (int i = 0; i < horizontal.length; i++) {
            if(horizontal[i].contains("rrrr")) {
                JOptionPane.showMessageDialog(null, "Red Wins! ", "Wins! ", JOptionPane.PLAIN_MESSAGE);
                return true;
            } else if(horizontal[i].contains("yyyy")) {
                JOptionPane.showMessageDialog(null, "Yellow Wins! ", "Wins! ", JOptionPane.PLAIN_MESSAGE);
                return true;
            }
        }

        System.out.println("Vertical");
        // Vertical
        String[] vertical = {"","","","","","", ""};
        for(int i = 0; i < 7; i++) {
            vertical[i] = "";
            for (int j = 0; j < 6; j++) {
                vertical[i] += movesList[j][i];
            }
        }
        System.out.println(Arrays.toString(vertical));
        System.out.println(Arrays.deepToString(movesList));
        for (int i = 0; i < vertical.length; i++) {
            if(vertical[i].contains("rrrr")) {
                JOptionPane.showMessageDialog(null, "Red Wins! ", "Wins! ", JOptionPane.PLAIN_MESSAGE);
                return true;
            } else if(vertical[i].contains("yyyy")) {
                JOptionPane.showMessageDialog(null, "Yellow Wins! ", "Wins! ", JOptionPane.PLAIN_MESSAGE);
                return true;
            }
        }
            //* Whats left? -> Diagonals. Good Luck 😭😭
        // Right justified diagonals
        String[] firstDiagonal = {"", "", "", "", "", ""};
        for (int i = 0; i < firstDiagonal.length; i++) {
            switch(i) {
                case 0:
                    for (int j = 3, k = 0; j >= 0 && k <= 3; j--, k++) {
                        firstDiagonal[i] += movesList[j][k];
                    }
                    break;
                case 1:
                    for (int j = 4, k = 0; j >= 0 && k <= 4; j--, k++) {
                        firstDiagonal[i] += movesList[j][k];
                    }
                    break;
                case 2:
                    for (int j = 5, k = 0; j >= 0 && k <= 5; j--, k++) {
                        firstDiagonal[i] += movesList[j][k];
                    }
                    break;
                case 3:
                    for (int j = 5, k = 1; j >= 0 && k <= 6; j--, k++) {
                        firstDiagonal[i] += movesList[j][k];
                    }
                    break;
                case 4:
                    for (int j = 5, k = 2; j >= 1 && k <= 6; j--, k++) {
                        firstDiagonal[i] += movesList[j][k];
                    }
                    break;
                case 5:
                    for (int j = 5, k = 3; j >= 2 && k <= 6; j--, k++) {
                        firstDiagonal[i] += movesList[j][k];
                    }
                    break;
            }
        }
        for (int i = 0; i < firstDiagonal.length; i++) {
            if(firstDiagonal[i].contains("rrrr")) {
                JOptionPane.showMessageDialog(null, "Red Wins! ", "Wins! ", JOptionPane.PLAIN_MESSAGE);
                return true;
            } else if(firstDiagonal[i].contains("yyyy")) {
                JOptionPane.showMessageDialog(null, "Yellow Wins! ", "Wins! ", JOptionPane.PLAIN_MESSAGE);
                return true;
            }

        }
        System.out.println(Arrays.deepToString(firstDiagonal));

        // next
        String[] secondDiagonal = {"","","","","",""};
        for (int i = 0; i < secondDiagonal.length; i++) {
            switch(i) {
                case 0:
                    for (int j = 2, k = 0; j <= 5 && k <= 3; j++, k++) {
                        secondDiagonal[i] += movesList[j][k];
                    }
                    break;
                case 1:
                    for (int j = 1, k = 0; j <= 5 && k <= 4; j++, k++) {
                        secondDiagonal[i] += movesList[j][k];
                    }
                    break;
                case 2:
                    for (int j = 0, k = 0; j <= 5 && k <= 5; j++, k++) {
                        secondDiagonal[i] += movesList[j][k];
                    }
                    break;
                case 3:
                    for (int j = 0, k = 1; j <= 5 && k <= 6; j++, k++) {
                        secondDiagonal[i] += movesList[j][k];
                    }
                    break;
                case 4:
                    for (int j = 0, k = 2; j <= 4 && k <= 6; j++, k++) {
                        secondDiagonal[i] += movesList[j][k];
                    }
                    break;
                case 5:
                    for (int j = 0, k = 3; j <= 3 && k <= 6; j++, k++) {
                        secondDiagonal[i] += movesList[j][k];
                    }
                    break;
            }
        }
        for (int i = 0; i < secondDiagonal.length; i++) {
            if(secondDiagonal[i].contains("rrrr")) {
                JOptionPane.showMessageDialog(null, "Red Wins! ", "Wins! ", JOptionPane.PLAIN_MESSAGE);
                return true;
            } else if(secondDiagonal[i].contains("yyyy")) {
                JOptionPane.showMessageDialog(null, "Yellow Wins! ", "Wins! ", JOptionPane.PLAIN_MESSAGE);
                return true;
            }
        }

        // win = true, continue = false
        return false;
    }
    static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + ", ");
            }
            System.out.println();
        }
    }
    static String[][] convertArray(int[][] array) {
        String[][] moves = {
                {" ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " "}
        };
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(array[i][j] == 255) {
                    moves[i][j] = "y";
                } else if(array[i][j] == 1) {
                    moves[i][j] = "r";
                }
            }
        }

        return moves;
    }
    Color circleColor = Color.WHITE;
    private void drawCircle(Graphics g) {
        g.setColor(circleColor);
        g.fillOval(0, 0, 50, 50);
    }
}
