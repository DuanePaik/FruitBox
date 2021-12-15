import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URISyntaxException;

public class StaffButton extends JButton implements ActionListener {

    public StaffButton(){

        ImageIcon image = new ImageIcon("./src/imgPack/STF.png");

        setIcon(image);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            new StaffFrame();
        } catch (URISyntaxException uriSyntaxException) {
            uriSyntaxException.printStackTrace();
        }
    }
}
