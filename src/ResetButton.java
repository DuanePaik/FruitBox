import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.*;


public class ResetButton extends JButton implements ActionListener{
	
	private AppleBoard board;
	private AppleFrame frame;

	
	public ResetButton(AppleBoard b, AppleFrame f) {
		
		board = b;
		frame = f;
		
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
		if(frame.get_gameOn()) {
			board.createNewBoard();
			frame.update();
		}
	}
}
