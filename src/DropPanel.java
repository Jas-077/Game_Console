import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Dimension;

public class DropPanel {

    public JButton[] drops = new JButton[7];
    public JPanel dropPanel = new JPanel();

    public DropPanel() {
        dropPanel.setBackground(Color.BLUE);

        for (int i = 0; i < 7; i++) {
            JButton dropBtn = new JButton(" ");

            dropBtn.setOpaque(false);
            dropBtn.setContentAreaFilled(false);
            dropBtn.setBorderPainted(false);
            dropBtn.setBackground(Color.WHITE);
            dropBtn.setFocusable(false);

            dropBtn.setPreferredSize(new Dimension(85, 24));
            dropPanel.add(dropBtn);

            drops[i] = dropBtn;

        }

    }

}
