import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class H2P extends JButton implements ActionListener {

    private GreetingFrame frame;

    public H2P(GreetingFrame f){

        frame = f;

        ImageIcon image = new ImageIcon("./src/imgPack/H2P.png");

        setIcon(image);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new H2Pframe();
    }
}
