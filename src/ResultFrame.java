import javax.swing.*;
import java.awt.*;


public class ResultFrame extends JFrame{

    private Image rty_bg = new ImageIcon("./src/imgPack/result.png").getImage();

    public ResultFrame(){

        JPanel background = new JPanel() {
            { setOpaque(false); }
            public void paintComponent(Graphics g)
            {
                g.drawImage(rty_bg, 0, 0, this);
                super.paintComponent(g);
            }
        };
        this.setContentPane(background);
        background.setLayout(null);

        JLabel score = new JLabel(){ {setOpaque(false);}};
        Image bigsc = new ImageIcon("./src/imgPack/merged_score.png").getImage();
        score.setIcon(new ImageIcon("./src/imgPack/merged_score.png"));
        score.setBounds(401 - (bigsc.getWidth(null) / 2),250 - (bigsc.getHeight(null) / 2),bigsc.getWidth(null),bigsc.getHeight(null));
        RetryButton rtybtn = new RetryButton(this);
        rtybtn.setBounds(550, 310, 169, 59);
        background.add(score);
        background.add(rtybtn);

        setTitle("Fruit Box");
        setSize(803,448);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}
