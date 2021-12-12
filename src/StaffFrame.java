import javax.swing.*;
import java.awt.*;
import java.net.URISyntaxException;

public class StaffFrame extends JFrame{

    private Image stf_contents = new ImageIcon("./src/imgPack/STAFF.png").getImage();

    public StaffFrame() throws URISyntaxException {

        JPanel background = new JPanel() {
            { setOpaque(false); }
            public void paintComponent(Graphics g)
            {
                g.drawImage(stf_contents, 0, 0, this);
                super.paintComponent(g);
            }
        };
        this.setContentPane(background);
        background.setLayout(null);

        GithubButton ghbtn = new GithubButton(this);
        ghbtn.setBounds(225, 405, 87, 87);
        background.add(ghbtn);

        setTitle("Fruit Box");
        setSize(392,578);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}
