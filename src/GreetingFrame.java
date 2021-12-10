import java.awt.*;
import javax.swing.*;

public class GreetingFrame extends JFrame{
	
	private Image bg = new ImageIcon("./src/imgPack/greet.png").getImage();
	
	public GreetingFrame() {

		JPanel background = new JPanel() {
		      { setOpaque(false); }
		      public void paintComponent(Graphics g) 
		      {
		        g.drawImage(bg, 0, 0, this);
		        super.paintComponent(g);
		      }
		};
		this.setContentPane(background);
		background.setLayout(null);
		StartButton play = new StartButton(this);
		play.setBounds(125, 290, 200, 237);
		background.add(play);
		
		setTitle("Fruit Box");
		setSize(855,759);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);	
	}
}
