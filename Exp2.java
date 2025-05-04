import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class Lab2 extends Frame implements MouseListener 
{
	Label l;
	Lab2()
	{
		super("Lab2");
		l = new Label();
		l.setBounds(25, 60, 280, 30);
		l.setAlignment(Label.CENTER);
		this.add(l);
		this.setSize(300, 300);
		this.setLayout(null);
		this.setVisible(true);
		
		//adding action
		this.addMouseListener(this);
		
		addWindowListener(new java.awt.event.WindowAdapter() 
        {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) 
            {
                System.exit(0);
            }
        });
		
	}
	public static void main(String args[])
	{
		new Lab2();
	}
	@Override
	public void mouseClicked(MouseEvent var1) 
	{
		l.setText("Mouse Clicked");
	}
	@Override
	public void mouseEntered(MouseEvent var1) 
	{
		l.setText("Mouse Entered");
	}
	@Override
	public void mouseExited(MouseEvent var1) 
	{
		l.setText("Mouse Exited");
	}
	@Override
	public void mousePressed(MouseEvent var1) 
	{
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseReleased(MouseEvent var1) 
	{
		// TODO Auto-generated method stub
	}
}
