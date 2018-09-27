import java.util.*;
import java.awt.*;
import java.awt.event.*;
class dinkar extends WindowAdapter
{
	public void windowClosing(WindowEvent we)
	{
		System.exit(0);
	}
}

class hotel extends Frame implements ItemListener,MouseListener
{
	Label l1,l3;
	Choice c;
	Choice c2=new Choice();
	Button b1,b2,b3;
	TextField f6;
	Label l11;
	Checkbox cb1;
	hotel()
	{
		setResizable (false);
		addWindowListener(new dinkar());
		setLayout(null);
		setSize(1366,768);
		setVisible(true);
		Font ft1=new Font("ARIAL BLACK",Font.BOLD,60);
		l1 = new Label("Green Park Hotel");
		l1.setBounds(300,100,500,45);
		l1.setForeground(Color.green);
		Font ft=new Font("ARIAL BLACK",Font.BOLD,40);
		Font ft2=new Font("ARIAL BLACK",Font.BOLD,25);
		l1.setFont(ft1);
		add(l1);
		Label l2=new Label("Select Type:");
		l2.setBounds(120,200,270,40);
		l2.setFont(ft);
		add(l2);
		c=new Choice();
		c.setBounds(400,200,400,40);
		c.setFont(ft2);
		add(c);
		c.add("--select type--");
		c.add("Deluxe Room");
		c.add("Non-Deluxe Room");
		l3=new Label("Select room");
		l3.setBounds(870,200,210,40);
		l3.setFont(ft2);
		c.addItemListener(this);
		b1 = new Button("Book Room");
		b2 = new Button("Reset Booking");
		b1.setBounds(500,300,200,30);
		b1.setForeground(Color.blue);
		b2.setBounds(750,300,200,30);
		b2.setForeground(Color.blue);
		Font ft4=new Font("ARIAL BLACK",Font.BOLD,15);
		b1.setFont(ft4);
		b2.setFont(ft4);
		b1.addMouseListener(this);
		b2.addMouseListener(this);
		b3 = new Button("Confirm Booking");
		b3.setBounds(600,600,150,30);
		b3.setForeground(Color.blue);
		b3.setFont(ft4);
		b3.addMouseListener(this);
		l11 = new Label();
		l11.setBounds(1000,600,200,30);	
		add(l11);
		cb1 = new Checkbox("Cash paid");
		cb1.setBounds(200,600,200,30);
		cb1.setForeground(Color.blue);
		cb1.addItemListener(this);
		
	}
	public void itemStateChanged(ItemEvent ie)
	{
		if(c.getSelectedItem().equals("Deluxe Room"))
		{
			Font ft2=new Font("ARIAL BLACK",Font.BOLD,25);
			add(l3);
			try
			{
				c2.remove("--select room--");
			}
			catch(Exception ex)
			{
			}
		        c2.setBounds(1100,200,250,30);
			c2.add("--select room--");
			c2.add("101");
			c2.add("102");
			c2.add("103");
			c2.add("104");
			c2.add("105");
			c2.setFont(ft2);
			add(c2);
			try
			{
				c2.remove("201");
				c2.remove("202");
				c2.remove("203");
				c2.remove("204");
				c2.remove("205");
			}
			catch(Exception ex)
			{
			}
		}	
		if(c.getSelectedItem().equals("Non-Deluxe Room"))
		{
			add(l3);
			Font ft2=new Font("ARIAL BLACK",Font.BOLD,25);
			try
			{
				c2.remove("--select room--");
			}
			catch(Exception ex)
			{
			}
		        c2.setBounds(1100,200,250,30);
			c2.add("--select room--");
			c2.add("201");
			c2.add("202");
			c2.add("203");
			c2.add("204");
			c2.add("205");
			c2.setFont(ft2);
			add(c2);
			try
			{
				c2.remove("101");
				c2.remove("102");
				c2.remove("103");
				c2.remove("104");
				c2.remove("105");
			}
			catch(Exception ex)
			{
			}
		}
		if(!(c.getSelectedItem().equals("")))
		{
			add(b1);
			add(b2);
		}
		//if((Checkbox)ie.getSource() == cb1)
			//{
				if(cb1.getState() == true)
					add(b3);
			//}
	}
	public void mouseEntered(MouseEvent me)
	{
	}
	public void mouseExited(MouseEvent me)
	{
	}
	public void mouseClicked(MouseEvent me)
	{
		if((Button)me.getSource()==b1)
		{
			Font ft2=new Font("ARIAL BLACK",Font.BOLD,25);
			Label l4,l5,l6,l7,l8,l9,l10;
			TextField f1,f2,f3,f4,f5;
			
			l4 = new Label("Enter Name");
			l4.setBounds(100,350,150,30);
			l5 = new Label("Address");
			l5.setBounds(100,400,150,30);
			l6 = new Label("District");
			l6.setBounds(100,500,150,30);
			l7 = new Label("Fathers name");
			l7.setBounds(800,350,200,30);
			l8 = new Label("City");
			l8.setBounds(800,400,200,30);
			l9 = new Label("Pincode");
			l9.setBounds(800,500,200,30);
			l10 = new Label("credit");
			l10.setBounds(100,550,200,30);			
			add(l4);
			add(l5);
			add(l6);
			add(l7);
			add(l8);
			add(l9);
			add(l10);
			
			l4.setFont(ft2);
			l5.setFont(ft2);
			l6.setFont(ft2);
			l7.setFont(ft2);
			l8.setFont(ft2);
			l9.setFont(ft2);
			l10.setFont(ft2);
			f1 = new TextField();
			f1.setBounds(300,350,300,50);
			f2 = new TextField();
			f2.setBounds(300,400,300,100);
			f3 = new TextField();
			f3.setBounds(300,500,300,50);
			f4 = new TextField();
			f4.setBounds(1000,350,200,50);
			f5 = new TextField();
			f5.setBounds(1000,400,200,50);
			f6 = new TextField();
			f6.setBounds(1000,500,200,50);
			add(f1);
			add(f2);
			add(f3);
			add(f4);
			add(f5);
			add(f6);
			add(cb1);
			f1.setFont(ft2);
			f2.setFont(ft2);
			f3.setFont(ft2);
			f4.setFont(ft2);
			f5.setFont(ft2);
			f6.setFont(ft2);
		}
		if((Button)me.getSource()==b2)
		{
			this.dispose();
			Frame f1=new hotel(); 
		}
		if((Button)me.getSource()==b3)
		{
			String str = f6.getText();
			try
			{
				int m = Integer.parseInt(str);
				l11.setText("valid pincode");
				l11.setForeground(Color.green);
			}
			catch(Exception ex)
			{
				f6.setText("");
				l11.setText("Invalid pincode");
				l11.setForeground(Color.red);
			} 
			if(!(str.length()==6))
			{
				
				f6.setText("");
				l11.setText("Invalid code");
				l11.setForeground(Color.red);
			}
		}
	}
	public void mouseReleased(MouseEvent me)
	{
	}
	public void mousePressed(MouseEvent me)
	{
	}
	public static void main(String []s)
	{
		Frame f=new hotel(); 
	}
		
}
		
