import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;

public class StartButton extends JButton implements ActionListener{
	
	private GreetingFrame frame;
	private ImageIcon pl = new ImageIcon("./src/imgPack/play.png");
	private ImageIcon go = new ImageIcon("./src/imgPack/go.png");
	
	public StartButton(GreetingFrame f) {
		
		frame = f;
		
		setIcon(pl);
		setRolloverIcon(go);
		
		setBorderPainted(false);
		setPreferredSize(new Dimension(200,237));
		setOpaque(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		new AppleFrame(new AppleBoard());
		frame.dispose();
	}
}