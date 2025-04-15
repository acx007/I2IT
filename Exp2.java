import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Exp2 extends Frame implements MouseListener {
    Label l;
    Exp2() {
        super("Lab2");
        l = new Label();
        l.setBounds(25, 60, 280, 30);
        l.setAlignment(Label.CENTER);
        this.add(l);
        this.setSize(300, 300);
        this.setLayout(null);
        this.setVisible(true);
        this.addMouseListener(this);
        this.addWindowFocusListener(new WindowAdapter(){
            public void windowClose(WindowEvent e) {
                dispose();
            }
        });
    }

    public static void main(String args[]) {
        new Exp2();
    }

    @Override
    public void mouseClicked(MouseEvent var1) {
        l.setText("Mouse Clicked");
    }

    @Override
    public void mouseEntered(MouseEvent var1) {
        l.setText("Mouse Entered");
    }

    @Override
    public void mouseExited(MouseEvent var1) {
        l.setText("Mouse Exited");
    }

    @Override
    public void mousePressed(MouseEvent var1) {
    }

    @Override
    public void mouseReleased(MouseEvent var1) {
    }
}