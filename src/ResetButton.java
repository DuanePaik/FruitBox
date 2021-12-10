import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.*;


public class ResetButton extends JButton implements ActionListener{
	
	private AppleBoard board;
	private AppleFrame frame;
	private ImageIcon[] button_img = new ImageIcon[8];

	
	public ResetButton(AppleBoard b, AppleFrame f) {
		
		board = b;
		frame = f;

		for(int i = 0; i < button_img.length ; i++) {
			button_img[i] = new ImageIcon("./src/imgPack/b" + i + ".png");
		}
		
		Image image = Toolkit.getDefaultToolkit().createImage("./src/imgPack/spinning.gif");
        ImageIcon spinIcon = new ImageIcon(image);
		
		setIcon(new ImageIcon("./src/imgPack/b1.png"));
		setRolloverIcon(spinIcon);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
		addActionListener(this);
	}
	

	public void actionPerformed(ActionEvent e) {
		board.createNewBoard();
		frame.update();
	}
}
