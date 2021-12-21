import java.applet.*;
import java.awt.*;
import java.awt.event.*;
/* <applet code = "ishan.class" width = 1000 height = 1000> </applet> */
public class ishan  extends Applet implements ActionListener,Runnable
{
	boolean flag = true;
	int x = 500;
	int y = 500;
	Thread t = null;

	public void start()
	{
		t = new Thread(this);
		flag = false;
		t.start();
	}

	public void run()
	{
		for(;;)
		{
			try
			{
				repaint();
				Thread.sleep(100);
				if(flag)
					break;
			}

			catch(InterruptedException e)
			{
				System.out.println("Exception :- " + e);
			}
		}
	}

	public void stop()
	{
		flag = true;
		t = null;
	}

	Button b1 = new Button("UP");
	Button b2 = new Button("DOWN");
	Button b3 = new Button("LEFT");
	Button b4 = new Button("RIGHT");

	public void init()
	{
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			y = y - 5;

		}

		if(ae.getSource()==b2)
		{
			y = y + 5;

		}

		if(ae.getSource()==b3)
		{
			x = x - 5;
		}

		if(ae.getSource()==b4)
		{
			x = x + 5;
		}
	}

    public void paint(Graphics g)
    {
	setBackground(Color.BLACK);
	g.setColor(Color.YELLOW);
        g.fillOval(x, y, 120, 120);//150, 150, 120, 120
        g.setColor(Color.BLACK);
        g.fillOval(x+30,y+50,10,15);//180, 200, 10, 15
        g.fillOval(x+80, y+50,10,15);//230, 200, 10, 15
        
        g.drawArc(x+35, y+50, 50, 50, 240, 80);//int x, int y, int width, int height, int startAngle, int arcAngle
    }
}