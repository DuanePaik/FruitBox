import javax.swing.*;
import java.awt.*;

public class H2Pframe extends JFrame{

    private Image stf_contents = new ImageIcon("./src/imgPack/how_to_play.png").getImage();

    public H2Pframe(){

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

        setTitle("Fruit Box");
        setSize(803,748);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

}
