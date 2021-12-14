import javax.swing.*;
import java.awt.*;


public class ResultFrame extends JFrame{

    private Image rty_bg = new ImageIcon("./src/imgPack/result.png").getImage();
    private AppleBoard board;

    public ResultFrame(AppleBoard b){

        board = b;

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

        ScoreLabel score = new ScoreLabel(board);
        RetryButton rtybtn = new RetryButton(this);
        rtybtn.setBounds(550, 310, 169, 59);
        background.add(score);
        background.add(rtybtn);

        setTitle("Fruit Box");
        setSize(803,448);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
