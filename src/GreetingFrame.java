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

		H2P h2pbtn = new H2P(this);
		h2pbtn.setBounds(100, 600, 332, 55);
		background.add(h2pbtn);

		StaffButton stfbtn = new StaffButton(this);
		stfbtn.setBounds(535, 600, 160, 52);
		background.add(stfbtn);

		setTitle("Fruit Box");
		setSize(855,759);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
}
