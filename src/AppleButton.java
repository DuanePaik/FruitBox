import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;

public class AppleButton extends JButton implements ActionListener{
	
	private AppleBoard board;
	private AppleFrame frame;
	private int row;
	private int col;
	private int face;
	private ImageIcon img;
	private ImageIcon cimg;

	
	public AppleButton(AppleBoard b, AppleFrame f) {
		board = b;
		frame = f;
		
		setBorderPainted(false);
		setPreferredSize(new Dimension(50,50));
		setOpaque(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
		addActionListener(this);
	}
	
	public void setApple(int n) {
		if (n > 9)
			face = n / 10;
		else
			face = n;
		img = new ImageIcon("./src/imgPack/a" + n + ".png");
		cimg = new ImageIcon("./src/imgPack/ca" + n + ".png");
		setIcon(img);
	}
	public void setRow(int num) {
		row = num;
	}
	
	public void setCol(int num) {
		col = num;
	}
	
	public void actionPerformed(ActionEvent e) {

		if(frame.get_gameOn()) {

			if (!board.isFirst()) {
				board.targetOn();
				lightOn();
				board.setTarget(new int[]{row, col, face});
			} else if ((board.isFirst()) && (board.isTarget(new int[]{row, col, face}))) {
				board.targetOff();
				lightOff();
				board.setTarget(new int[]{-1, -1, -1});
			} else {
				if (board.check(new int[]{row, col, face})) {
					System.out.println("Success");
				} else {
					System.out.println("Fail");
				}
				System.out.println("" + board.getScore());
				board.targetOff();
				frame.update();
			}
		}
	}
	
	public void lightOn() {
		setIcon(cimg);
	}
	
	public void lightOff() {
		setIcon(img);
	}
}
