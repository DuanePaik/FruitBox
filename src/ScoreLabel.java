
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ScoreLabel extends JLabel {

    private AppleBoard board;
    private int score ;
    private Image[] numbers = new Image[10];
    private Image[] scoreimg;
    private BufferedImage merged;

    public ScoreLabel(AppleBoard b){

        board = b;
        score = b.getScore();

        for (int i = 0; i < 10; i++)
            numbers[i] = new ImageIcon("./src/imgPack/"+ i +".png").getImage();
        setOpaque(false);
        makeScore();
        merged = mergeScore();
        ImageIcon icon = new ImageIcon(merged);
        setIcon(icon);
        setBounds(401 - (icon.getImage().getWidth(null) / 2),250 - (icon.getImage().getHeight(null) / 2)
                ,icon.getImage().getWidth(null),icon.getImage().getHeight(null));

    }

    public void makeScore(){
        char[] st_score = Integer.toString(score).toCharArray();
        scoreimg = new Image[st_score.length];

        for (int i = 0 ; i < st_score.length ; i++)
            scoreimg[i] = numbers[Character.getNumericValue(st_score[i])];
    }

   public BufferedImage mergeScore() {

            int width = 0;
            int height = 96;

            for (int i = 0 ; i < scoreimg.length ; i++)
                width += scoreimg[i].getWidth(null);

            BufferedImage mergedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D graphics = (Graphics2D) mergedImage.getGraphics();

            graphics.setBackground(new Color(255, 0, 0, 0));
            graphics.drawImage(scoreimg[0], 0, 0, new Color(255,0,0,0), null);

            for (int i = 1 ; i < scoreimg.length ; i++)
                graphics.drawImage(scoreimg[i], scoreimg[i-1].getWidth(null),0,null);

           // ImageIO.write(mergedImage, "png", new File("./src/imgPack/merged_score.png"));
            return mergedImage;
    }
}
