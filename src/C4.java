
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.WindowConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.Image;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Dimension;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class C4 extends JFrame {

    // serialization
    private static final long serialVersionUID = 1L;

    // data members
    JButton[][] board = new JButton[6][7];
    int[][] iboard = new int[6][7];
    JButton[] drops = new JButton[7];
    boolean playerRed;
    Cursor mouse;
    int redMoves;
    int yellowMoves;

    public C4() {

        playerRed = true;

        ImageIcon logo = new ImageIcon("images/logo.png");
        this.setIconImage(logo.getImage());

        this.setTitle("Connect 4");

        this.setSize(655, 589);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);

        DropPanel dp = new DropPanel();
        this.add(dp.dropPanel, BorderLayout.NORTH);
        drops = dp.drops;

        BoardPanel bp = new BoardPanel();
        this.getContentPane().add(bp.boardPanel);
        this.getContentPane().add(bp.boardPanel);
        board = bp.gboard;

        ResetPanel resetPanel = new ResetPanel();
        this.add(resetPanel.Main, BorderLayout.SOUTH);
        resetPanel.listen_for_action(this);

        activateCursor();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        this.setVisible(true);

    }

    public void reset() {
        this.dispose();
        new C4().listenForDrops();
    }

    public void setMoveAndChangeCursor(int current, int next, int row, int col) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        ImageIcon current_chip = new ImageIcon(getImagePath(current));
        Image scaled_img = current_chip.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        current_chip = new ImageIcon(scaled_img);
        Image next_chip = new ImageIcon(getImagePath(next)).getImage();

        board[row][col].setIcon(current_chip);
        mouse = tk.createCustomCursor(next_chip, new Point(30, 30), "chip");
        this.setCursor(mouse);

    }

    public void listenForDrops() {

        for (int i = 0; i < drops.length; i++) {

            final int col = i;
            drops[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (checkColumnSpace(iboard, col) < 0) {
                        JOptionPane.showMessageDialog(null, "This column is full, try another");
                    } else {
                        int row = checkColumnSpace(iboard, col);

                        makeSound();

                        /*
                         * 1:Red, 2:Yellow, -1: None
                         */

                        if (playerRed) {

                            setMoveAndChangeCursor(1, 2, row, col);
                            iboard[row][col] = 1;
                            playerRed = false;
                            redMoves++;
                            // displayArray(iboard);

                        } else {

                            setMoveAndChangeCursor(2, 1, row, col);
                            iboard[row][col] = 2;
                            playerRed = true;
                            yellowMoves++;
                            // displayArray(iboard);
                        }

                        if ((redMoves + yellowMoves) > 6) {

                            GameLogic gl = new GameLogic(iboard, row, col);

                            int winner = gl.findGameWinner();

                            if (winner > 0 || chechDrawState())
                                displayMessage(winner);

                        }

                    }
                }
            });

        }

    }

    public void makeSound() {
        // sound
        try {

            String soundfile = "audio/coin_drop_sound.wav";
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File(soundfile).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(ais);
            clip.start();

        } catch (IOException e1) {
            System.out.println("IOEXCEPTION sound ln:105");
        } catch (UnsupportedAudioFileException e2) {
            System.out.println("UnsupportedAudioFileException sound file ln:105");
        } catch (LineUnavailableException e3) {
            System.out.println("LineUnavailableException sound file ln:105");
        }
    }

    public void displayMessage(int winner) {

        if (winner == 1) {
            // red wins
            System.out.println("Red wins!");
            System.out.println("Took moves:" + redMoves);
            JOptionPane.showMessageDialog(null, "Red wins!\nTotal Moves taken: " + redMoves);

        } else if (winner == 2) {
            // yellow wins
            System.out.println("Yellow wins!");
            System.out.println("Took moves:" + yellowMoves);
            JOptionPane.showMessageDialog(null, "Yellow wins!\nTotal Moves taken: " + yellowMoves);
        } else if (winner == -1) { // tie condition
            System.out.println("Tie!");
            JOptionPane.showMessageDialog(null, "It's a tie!");

        }
        displayArray(iboard);
        reset();

    }

    public boolean chechDrawState() {
        return (redMoves + yellowMoves) == 42;
    }

    public void displayArray(int[][] a) {
        for (int[] row : a) {
            for (int x : row) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        System.out.println();

    }

    public String getImagePath(int i) {
        if (i == 1)
            return "images/red-chip.png";
        else if (i == 2)
            return "images/yellow-chip.png";
        return "NULL";
    }

    public int checkColumnSpace(int[][] board, int col) {

        int row = -1;

        for (int i = 0; i < board.length; i++) {

            if (board[i][col] != 0) {
                break;
            }

            row = i;
        }

        return row;

    }

    public void activateCursor() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        Image img;

        if (playerRed) {
            img = new ImageIcon("..//Images//red-chip.png").getImage();
        } else {
            img = new ImageIcon("..//Images//yellow-chip.png").getImage();
        }

        mouse = toolkit.createCustomCursor(img, new Point(32, 32), "coin");
        // System.out.println(toolkit.getBestCursorSize(50, 50));
        this.setCursor(mouse);

    }

    public static void main(String[] args) {

        new C4().listenForDrops();
    }
}
