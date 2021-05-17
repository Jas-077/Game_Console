import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetPanel {
    public JPanel Main = new JPanel();
    private JButton reset = new JButton("Reset");
    private JButton quit = new JButton("Quit");

    public ResetPanel() {
        reset.setBackground(Color.BLACK);
        reset.setOpaque(true);
        reset.setBorderPainted(false);
        reset.setForeground(Color.WHITE);
        reset.setFocusable(false);
        quit.setBackground(Color.BLACK);
        quit.setOpaque(true);
        quit.setBorderPainted(false);
        quit.setForeground(Color.WHITE);
        quit.setFocusable(false);
        Main.setBackground(Color.lightGray);
        Main.add(reset);
        Main.add(quit);
    }

    public void listen_for_action(C4 g) {
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g.reset();
            }
        });
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	g.dispose();
    			
    			Main test=new Main();
            }
        });

    }
}