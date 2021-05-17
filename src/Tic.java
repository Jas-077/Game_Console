import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Tic implements ActionListener{
	Random ran=new Random();
	JFrame frame= new JFrame();
	JPanel title=new JPanel();
	JPanel board=new JPanel();
	JPanel foot=new JPanel();
	
	JLabel textfield=new JLabel();
	JLabel textfield2=new JLabel();
	JLabel textfield3=new JLabel();
	
	JButton buttons[]=new JButton[9];
	
	boolean player1;
	
	JButton retry=new JButton();
	JButton back= new JButton();
	
	public void firstTurn() 
	{
		int r=ran.nextInt(2);
		if(r==0)
		{
			player1=true;
			//textfield3.setForeground(new Color(173, 196, 182));
			textfield3.setForeground(Color.black);
		}
		else
		{
			player1=false;
			//textfield2.setForeground(new Color(173, 196, 182));
			textfield2.setForeground(Color.black);
		}
	}
	
	public void draw()
	{
		for(int i=0;i<9;i++)
		{
			buttons[i].setBackground(Color.green);
		}
		textfield.setText("Draw!");
		textfield2.setText(null);
		textfield3.setText(null);
		for(int i=0;i<9;i++)
		{
			buttons[i].setBorder(BorderFactory.createLineBorder(Color.red,2));
		}
	}
	
	public int checkDraw()
	{
		int f=1;
		for(int i=0;i<9;i++)
		{
			if(buttons[i].getText()!="")
				f=1;
			else
			{
				f=0;
				break;
			}
		}
		return f;
	}
	
	public void XWins(int a, int b, int c)
	{
		buttons[a].setBackground(Color.green);
		buttons[c].setBackground(Color.green);
		buttons[b].setBackground(Color.green);
		
		buttons[a].setForeground(Color.black);
		buttons[b].setForeground(Color.black);
		buttons[c].setForeground(Color.black);
		
		for(int i=0;i<9;i++)
		{
			buttons[i].setEnabled(false);
		}
		textfield.setText("X Wins!");
		textfield2.setText(null);
		textfield3.setText(null);
	}
	public void OWins(int a, int b, int c)
	{
		buttons[a].setBackground(Color.green);
		buttons[c].setBackground(Color.green);
		buttons[b].setBackground(Color.green);
		
		buttons[a].setForeground(Color.black);
		buttons[b].setForeground(Color.black);
		buttons[c].setForeground(Color.black);
		
		for(int i=0;i<9;i++)
		{
			buttons[i].setEnabled(false);
		}
		textfield.setText("O Wins!");
		textfield2.setText(null);
		textfield3.setText(null);
	}
	public int check()
	{
		if(buttons[0].getText()=="X"
				&& buttons[1].getText()=="X"
				&& buttons[2].getText()=="X")
		{
			XWins(0,1,2);
			return 1;
		}
		if(buttons[3].getText()=="X"
				&& buttons[4].getText()=="X"
				&& buttons[5].getText()=="X")
		{
			XWins(3,4,5);
			return 1;
		}
		if(buttons[6].getText()=="X"
				&& buttons[7].getText()=="X"
				&& buttons[8].getText()=="X")
		{
			XWins(6,7,8);
			return 1;
		}
		if(buttons[0].getText()=="X"
				&& buttons[3].getText()=="X"
				&& buttons[6].getText()=="X")
		{
			XWins(0,3,6);
			return 1;
		}
		if(buttons[1].getText()=="X"
				&& buttons[4].getText()=="X"
				&& buttons[7].getText()=="X")
		{
			XWins(1,4,7);
			return 1;
		}
		if(buttons[2].getText()=="X"
				&& buttons[5].getText()=="X"
				&& buttons[8].getText()=="X")
		{
			XWins(2,5,8);
			return 1;
		}
		if(buttons[0].getText()=="X"
				&& buttons[4].getText()=="X"
				&& buttons[8].getText()=="X")
		{
			XWins(0,4,8);
			return 1;
		}
		if(buttons[2].getText()=="X"
				&& buttons[4].getText()=="X"
				&& buttons[6].getText()=="X")
		{
			XWins(2,4,6);
			return 1;
		}
		
		
		
		
		if(buttons[0].getText()=="O"
				&& buttons[1].getText()=="O"
				&& buttons[2].getText()=="O")
		{
			OWins(0,1,2);
			return 1;
		}
		if(buttons[3].getText()=="O"
				&& buttons[4].getText()=="O"
				&& buttons[5].getText()=="O")
		{
			OWins(3,4,5);
			return 1;
		}
		if(buttons[6].getText()=="O"
				&& buttons[7].getText()=="O"
				&& buttons[8].getText()=="O")
		{
			OWins(6,7,8);
			return 1;
		}
		if(buttons[0].getText()=="O"
				&& buttons[3].getText()=="O"
				&& buttons[6].getText()=="O")
		{
			OWins(0,3,6);
			return 1;
		}
		if(buttons[1].getText()=="O"
				&& buttons[4].getText()=="O"
				&& buttons[7].getText()=="O")
		{
			OWins(1,4,7);
			return 1;
		}
		if(buttons[2].getText()=="O"
				&& buttons[5].getText()=="O"
				&& buttons[8].getText()=="O")
		{
			OWins(2,5,8);
			return 1;
		}
		if(buttons[0].getText()=="O"
				&& buttons[4].getText()=="O"
				&& buttons[8].getText()=="O")
		{
			OWins(0,4,8);
			return 1;
		}
		if(buttons[2].getText()=="O"
				&& buttons[4].getText()=="O"
				&& buttons[6].getText()=="O")
		{
			OWins(2,4,6);
			return 1;
		}
		return 0;
	}
	public Tic()
	{
		frame.setSize(800,800);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon img = new ImageIcon(".//Images//tic_logo.png");
		frame.setIconImage(img.getImage());
		
		textfield.setPreferredSize(new Dimension(400,100));
		textfield.setOpaque(true);
		textfield.setText("Tic-Tac-Toe");
		textfield.setFocusable(false);
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setForeground(Color.green);
		textfield.setFont(new Font("MV Boli",Font.PLAIN,70));
		textfield.setBackground(Color.black);
		
		textfield2.setPreferredSize(new Dimension(186,100));
		textfield2.setOpaque(true);
		textfield2.setText("X");
		textfield2.setFocusable(false);
		textfield2.setHorizontalAlignment(JLabel.CENTER);
		textfield2.setForeground(Color.green);
		textfield2.setFont(new Font("MV Boli",Font.PLAIN,70));
		textfield2.setBackground(Color.black);
		
		textfield3.setPreferredSize(new Dimension(200,100));
		textfield3.setOpaque(true);
		textfield3.setText("O");
		textfield3.setFocusable(false);
		textfield3.setHorizontalAlignment(JLabel.CENTER);
		textfield3.setForeground(Color.green);
		textfield3.setFont(new Font("MV Boli",Font.PLAIN,70));
		textfield3.setBackground(Color.black);
		
		title.setBackground(Color.green);
		title.setPreferredSize(new Dimension(100,100));
		title.setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
		
		title.add(textfield3);
		title.add(textfield);
		title.add(textfield2);
		
		
		
		board.setBackground(Color.red);
		board.setPreferredSize(new Dimension(100,600));
		board.setLayout(new GridLayout(3,3));
		
		for(int i=0;i<9;i++)
		{
			buttons[i]=new JButton();
			buttons[i].setFocusable(false);
			buttons[i].setText("");
			//buttons[i].setForeground(Color.black);
			buttons[i].setBackground(Color.black);
			buttons[i].setBorder(BorderFactory.createLineBorder(Color.green,2));
			buttons[i].setFont(new Font("MV Boli",Font.ITALIC,130));
			buttons[i].addActionListener(this);
			board.add(buttons[i]);
		}
		
		retry.setPreferredSize(new Dimension(300,100));
		retry.setText("Retry");
		retry.setFocusable(false);
		retry.setFont(new Font("Comic Sans MS",Font.PLAIN,40));
		retry.addActionListener(this);
		retry.setForeground(new Color(250, 35, 211));
		retry.setBackground(Color.black);
		retry.setBorder(BorderFactory.createEmptyBorder());
		
		back.setPreferredSize(new Dimension(300,100));
		back.setText("Menu");
		back.setFocusable(false);
		back.setFont(new Font("Comic Sans MS",Font.PLAIN,40));
		back.addActionListener(this);
		back.setForeground(new Color(250, 35, 211));
		back.setBackground(Color.black);
		back.setBorder(BorderFactory.createEmptyBorder());
		
		foot.setBackground(Color.black);
		foot.setPreferredSize(new Dimension(100,100));
		foot.add(retry);
		foot.add(back);
		
		frame.add(title,BorderLayout.NORTH);
		frame.add(board,BorderLayout.CENTER);
		frame.add(foot,BorderLayout.SOUTH);
		
		
		frame.setVisible(true);
		
		firstTurn();
	}
	
	@Override
    public void actionPerformed(ActionEvent e)
    {
		
		int x=-1,y=-1;
		for(int i=0;i<9;i++)
		{
			if(e.getSource()==buttons[i])
			{
				if(player1)
				{
					if(buttons[i].getText()=="")
					{
						buttons[i].setText("X");
						player1=false;
						buttons[i].setForeground(Color.red);
						//textfield2.setForeground(new Color(173, 196, 182));
						textfield2.setForeground(Color.black);
						textfield3.setForeground(Color.green);
						x=check();
						y=checkDraw();
						if(x==0)
						{
						if(y==1)
						{
							draw();
						}
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Cell Already Filled", "Warning", JOptionPane.WARNING_MESSAGE);
					}
				}
				else
				{
					if(buttons[i].getText()=="")
					{
						buttons[i].setText("O");
						player1=true;
						buttons[i].setForeground(Color.blue);
						//textfield3.setForeground(new Color(173, 196, 182));
						textfield3.setForeground(Color.black);
						textfield2.setForeground(Color.green);
						x=check();
						y=checkDraw();
						if(x==0)
						{
						if(y==1)
						{
							draw();
						}
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Cell Already Filled","Warning", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		}
		if(e.getSource()==back)
		{
			frame.dispose();
			
			Main test=new Main();
		}
		else if(e.getSource()==retry)
		{
			frame.dispose();
			Tic test2=new Tic();
		}
    }
}
