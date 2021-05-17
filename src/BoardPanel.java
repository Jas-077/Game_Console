import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.GridLayout;

public class BoardPanel {

    public ImagePanel boardPanel;
    public JButton[][] gboard = new JButton[6][7];

    public BoardPanel() {

        ImageIcon boardImage = new ImageIcon("images/connect-4-board.png");

        boardPanel = new ImagePanel(boardImage.getImage());

        boardPanel.setLayout(new GridLayout(6, 7));
        boardPanel.setOpaque(false);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                JButton temp = new JButton(i + " " + j);
                temp.setFocusable(false);
                temp.setOpaque(false);
                temp.setHorizontalTextPosition(JButton.CENTER);
                temp.setContentAreaFilled(false);
                temp.setBorderPainted(true);
                boardPanel.add(temp);
                gboard[i][j] = temp;
            }
        }

    }

}
