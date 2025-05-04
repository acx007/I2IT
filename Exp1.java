import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListenerEg extends Frame implements KeyListener 
{
    Label l;
    TextArea area;

    KeyListenerEg()
    {
        // Label Creation
        l = new Label();
        l.setBounds(20, 50, 100, 20);
        
        // Text area creation
        area = new TextArea();
        area.setBounds(20, 80, 300, 300);
        area.addKeyListener(this);

        add(l);
        add(area);

        setSize(400, 400);
        setLayout(null);
        setVisible(true);

        // Add window listener to close the window
        addWindowListener(new java.awt.event.WindowAdapter() 
        {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) 
            {
                System.exit(0);
            }
        });
    }

    @Override
    public void keyTyped(KeyEvent e) 
    {
        l.setText("Key typed");
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        l.setText("Key Pressed");
    }

    @Override
    public void keyReleased(KeyEvent e) 
    {
        l.setText("Key Released");
    }

    public static void main(String[] args) 
    {
        new KeyListenerEg();
    }
    
}
