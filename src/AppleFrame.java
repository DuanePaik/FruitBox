import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;
import javax.swing.*;

public class AppleFrame extends JFrame{

	private AppleBoard board;
	private AppleButton[][] button_board;
	private int[] button_count = {0,0,0,0,0,0,0,0,0};
	private int gold_count = 0;
	private Image bg = new ImageIcon("./src/imgPack/gboard.png").getImage();
	private boolean press = false;
	
	public AppleFrame (AppleBoard b) {
		
		board = b;
		button_board = new AppleButton[12][15];
		Random rd = new Random();
		
		JPanel background = new JPanel() {
		      { setOpaque(false); }
		      public void paintComponent(Graphics g) 
		      {
		        g.drawImage(bg, 0, 0, this);
		        super.paintComponent(g);
		      }
		};
		this.setContentPane(background);
		
		background.setLayout(new BorderLayout());

		JPanel p1 = new JPanel() {
			{setOpaque(false);}
			{setLayout(new FlowLayout());}
		};
		JLabel blank = new JLabel(" ");
		p1.add(blank);
		p1.setPreferredSize(new Dimension(800,30));
		
		JPanel p2 = new JPanel(){
			{setOpaque(false);}
			{setLayout(new GridLayout(12,15));}
		};
		
		for (int row = 0; row < 12; row++)
			for (int col = 0; col < 15; col++) {
				button_board[row][col] = new AppleButton(b, this);
				button_board[row][col].setRow(row);
				button_board[row][col].setCol(col);
				p2.add(button_board[row][col]);
			}
			
		JPanel p3 = new JPanel(){
			{setOpaque(false);}
			{setLayout(new GridBagLayout());}
		};
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		p3.setPreferredSize(new Dimension(800,70));
		JLabel score = new JLabel("   Score : ");
		score.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		JLabel time = new JLabel("Timeleft :           ");
		time.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		ResetButton reset = new ResetButton(b, this);
		reset.setPreferredSize(new Dimension(30,30));
		
		JLabel blank2 = new JLabel(" ");
		JLabel blank3 = new JLabel("      ");

		setGrid(blank3, 0.05, 1, 0, 0, gbc, p3);
		setGrid(reset, 0.04, 0.4, 1, 0, gbc, p3);
		setGrid(score, 0.48, 1, 2, 0, gbc, p3);
		setGrid(time, 0.48, 1, 3, 0, gbc, p3);
		setGrid(blank2, 0.04, 0.6, 1, 1, gbc, p3);
		
		JPanel p4 = new JPanel() {
			{setOpaque(false);}
			{setLayout(new FlowLayout());}
		};
		p4.setPreferredSize(new Dimension(40,2));
		p4.add(blank);
		
		JPanel p5 = new JPanel() {
			{setOpaque(false);}
			{setLayout(new FlowLayout());}
		};
		p5.setPreferredSize(new Dimension(34,2));
		p5.add(blank);
		
		background.add(p1, BorderLayout.NORTH);
		background.add(p2, BorderLayout.CENTER);
		background.add(p3, BorderLayout.SOUTH);
		background.add(p4, BorderLayout.WEST);
		background.add(p5, BorderLayout.EAST);
		update();
		setTitle("Fruit Box");
		setSize(855,759);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);		
	}
	
	private void setGrid(JComponent obj,double wx, double wy, int x, int y, GridBagConstraints gbc, JPanel panel) {
		gbc.weightx = wx;
		gbc.weighty = wy;
		gbc.gridx = x;
		gbc.gridy = y;
		
		panel.add(obj,gbc);
	}
	
	public void update() {
		
		int[][] fruit_board = board.getGameBoard();
		for (int row = 0; row < 12; row++)
			for (int col = 0; col < 15; col++) 
				button_board[row][col].setApple(fruit_board[row][col]);
	}
}
