import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;

public class Main implements ActionListener {
	JFrame frame=new JFrame("Menu");
	JButton button1=new JButton();
	JButton button2=new JButton();
	
	public Main()
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(350,500);
		frame.setLayout(null);
		frame.setResizable(false);
		
		JPanel title=new JPanel();
		title.setBounds(0,0,350,50);
		title.setBackground(Color.black);
		title.setLayout(new FlowLayout(FlowLayout.CENTER,0,-5));
		
		
		JLabel label=new JLabel();
		label.setText("Choose One");
		label.setForeground(Color.green);
		label.setFont(new Font("MV Boli",Font.PLAIN,40));
		//label.setBounds(100, 50, 100, 40);
		
		title.add(label,BorderLayout.CENTER);
		frame.add(title);
		
		JPanel menu=new JPanel();
		menu.setBounds(0, 50, 350, 450);
		menu.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		
		
		button1.setText("Tic-Tac-Toe");
		button1.setForeground(Color.red);
		button1.setFont(new Font("MV Boli",Font.PLAIN,40));
		button1.setPreferredSize(new Dimension(350,225));
		button1.setFocusable(false);
		button1.setBackground(Color.yellow);
		button1.setBorder(BorderFactory.createEmptyBorder());
		//button1.setMargin(new Insets(50, 50, 50, 50));
		
		button2.setText("Connect 4");
		button2.setForeground(new Color(0, 0, 204));
		button2.setFont(new Font("MV Boli",Font.PLAIN,40));
		button2.setPreferredSize(new Dimension(350,215));
		button2.setFocusable(false);
		button2.setBackground(Color.red);
		button2.setBorder(BorderFactory.createEmptyBorder());
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		
		menu.add(button1);
		menu.add(button2);
		
		frame.add(menu);
		
		frame.setVisible(true);
		
	}

	public static void main(String[] args) {
		Main menu=new Main();
	}
	
	@Override
    public void actionPerformed(ActionEvent e)
    {
		if(e.getSource()==button1)
		{
			frame.dispose();
			Tic test=new Tic();
		}
		else if(e.getSource()==button2)
		{
			frame.dispose();
			new C4().listenForDrops();

		}
        
    }

}
