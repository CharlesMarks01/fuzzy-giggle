

import javax.swing.*;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;

@SuppressWarnings("serial")
public class ClickerFace extends JFrame implements ActionListener
{
    private static int count = 0;
    private JButton btn1;
    private JLabel gif;
    private static JLabel lbTemp;
    private JLabel lb1 = lbTemp;
    private Container c;
    private static int level = 1;
    private boolean hasHappened = false;
    private static int mult = 1;
    
    
    public ClickerFace()
    {
    		c = getContentPane();
    		
    		c.setLayout(new FlowLayout(FlowLayout.LEADING, 10 ,20));
    	
    		c.setBackground(Color.GRAY);
         
    	
         	btn1 = new JButton();
         	lb1 = new JLabel();
         	JLabel dummy = new JLabel("                                          ");
         	JLabel dummy2 = new JLabel("                                                                                  ");
         	JLabel dummy3 = new JLabel("                                                                                                                                              ");     
         	JLabel dummy4 = new JLabel("                                                                                                        ");     
         	
         	
         
         
         	btn1.addActionListener(this);
        
        
         
         	ImageIcon test = new ImageIcon("test.png");
         	
         	
         	
			btn1.setIcon(test);
			btn1.setText("");
			gif = new JLabel();
			gif.setText("            ");
			
			btn1.setPreferredSize(new Dimension(340,340));
			
			gif.setPreferredSize(new Dimension(150,150));
			
			
			lb1.setFont(new Font("Comic Sans MS", Font.BOLD, 60));
			lb1.setText("$0");
			
			c.add(gif);
			c.add(btn1);
			c.add(dummy);
			c.add(lb1);
		    c.add(dummy2);
		    c.add(dummy3);
		    
		    c.add(dummy4);
		   
		    
			
		    
    }


	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals(""))
		{
			count += (level*mult);
			lb1.setText("$"+count);
			
			
			Upgrades.setThisCount(count);
			if(count == 20 && hasHappened == false)
			{
				Upgrades btn = new Upgrades("HANDS",20,c,count, lb1,gif,btn1);
				hasHappened = true;
				gif.setIcon( new ImageIcon("hand.gif"));
			}
		}
	}
	
	
	public static void subFromCount(int num)
	{
		count -= num;
	}
	public static void addLevel()
	{
		level++;
	}
	public static int getLevel()
	{
		return level;
	}
	public static void setMult(int num)
	{
		mult = num;
	}
	
	
			
	
	
	public static void main(String[] args)
	{
		ClickerFace test = new ClickerFace();
		test.setSize(1000, 700);
		test.show();
	}
}
