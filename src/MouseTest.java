import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseTest extends JFrame implements MouseMotionListener,MouseListener{


	private JButton t ;
	private int cx;
	private int cy;
	private int nx;
	private int ny;
	private int[] lt = new int[2];
	private int tlx, tly;
	private boolean press = false;
	
	public MouseTest() {
		
		JPanel canvas = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				{setOpaque(false);}
				super.paintComponents(g);
				
				if (press) {
				g.setColor(Color.black);
				//g.drawRect(150, 150, -50, -50);
				if(nx >= cx && ny >= cy)
					g.drawRect(cx, cy, nx - cx, ny - cy);
				else if(nx >= cx && ny < cy) {
					g.drawRect(cx, ny, nx - cx, cy - ny);
				}
				else if(nx < cx && ny >= cy) {
					g.drawRect(nx, cy, cx - nx, ny - cy);
				}
				else if(nx < cx && ny < cy) {
					g.drawRect(nx, ny, cx - nx, cy - ny);
				}
				}
			}
		};
		
		this.setContentPane(canvas);
		ImageIcon img = new ImageIcon("./src/imgPack/a1.png");
		ImageIcon cimg = new ImageIcon("./src/imgPack/ca1.png");
		t = new JButton() {
			public void paintComponent(Graphics g) {
				super.paintComponents(g);
				//g.drawLine(0,0,100,50);
				g.drawImage(img.getImage(), 0, 0, this);
				/*
				if (press) {
				g.setColor(Color.black);
				//g.drawRect(150, 150, -50, -50);
				if(nx >= cx && ny >= cy)
					g.drawRect(cx, cy, nx - cx, ny - cy);
				else if(nx >= cx && ny < cy) {
					g.drawRect(cx, ny, nx - cx, cy - ny);
				}
				else if(nx < cx && ny >= cy) {
					g.drawRect(nx, cy, cx - nx, ny - cy);
				}
				else if(nx < cx && ny < cy) {
					g.drawRect(nx, ny, cx - nx, cy - ny);
				}
				}*/
				
				
			}
		};
		t.setOpaque(false);
		t.setText("TEST");
		
		canvas.add(t);
		
	
		int trx = t.getBounds().height;
		int try2 = t.getBounds().width;
		getcoord();
		
		System.out.println("" + tlx + " " + tly + " " +trx + " "+try2);
		
		t.setPreferredSize(new Dimension(250, 50));
		setTitle("Mousetest");
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	public boolean inBox(int[] point) {
		if(nx >= cx && ny >= cy) 
			return ((point[0] >= cx && point[0] <nx)&&(point[1] >= cy && point[1] <ny));
		else if(nx >= cx && ny < cy) 
			return ((point[0] >= cx && point[0] <nx)&&(point[1] < cy && point[1] >= ny));
		else if(nx < cx && ny >= cy) 
			return ((point[0] < cx && point[0] >= nx)&&(point[1] >= cy && point[1] <ny));
		else if(nx < cx && ny < cy) 
			return ((point[0] < cx && point[0] >= nx)&&(point[1] < cy && point[1] >= ny));
		else
			return false;
	}

	public void getcoord() {
		tlx = t.getBounds().x;
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		tlx = t.getBounds().x;
		tly = t.getBounds().y;
		lt[0] = tlx;
		lt[1] = tly;
		nx = e.getX() - 8;
		ny = e.getY() - 31;
		if(inBox(lt)) {System.out.println("in!");}
		t.setText("X : "+nx + " Y : "+ny);
		repaint();
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		press = true;
		cx = e.getX() - 8;
		cy = e.getY() - 31;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		press = false;
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		new MouseTest();
	}
}
