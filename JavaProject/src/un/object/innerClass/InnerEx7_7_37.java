package un.object.innerClass;

import java.awt.*;
import java.awt.event.*;

public class InnerEx7_7_37
{
	public static void main(String[] args)
	{
		Button b = new Button("Start");
		b.addActionListener(new EventHandler());
	}
}

class EventHandler implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("ActionEvent occurred!!!");
	}
}
