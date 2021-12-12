import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class GithubButton extends JButton implements ActionListener {

    private StaffFrame frame;
    final private URI url;

    public GithubButton(StaffFrame f) throws URISyntaxException {

        frame = f;

        ImageIcon image = new ImageIcon("./src/imgPack/gh.png");
        url = new URI("https://github.com/DuanePaik/FruitBox");
        setIcon(image);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Desktop.getDesktop().browse(url);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
