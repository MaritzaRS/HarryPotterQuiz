import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Hopefully_It_Works extends JPanel implements ActionListener, MouseListener, KeyListener {
	
	//Timer related variables
	int waveTimer = 5; //each wave of enemies is 20s
	long ellapseTime = 0;
	Font timeFont = new Font("Courier", Font.BOLD, 70);
	int level = 0;
	int score1 = 0;
	Font myFont = new Font("Courier", Font.BOLD, 40);
	
	SimpleAudioPlayer backgroundMusic = new SimpleAudioPlayer("Epic.wav", true);
	SimpleAudioPlayer SadMusic = new SimpleAudioPlayer("SadMusic2.wav", false);
	SimpleAudioPlayer winner = new SimpleAudioPlayer("scifi.wav", false);
	
	//frame width/height
	static int width = 600;
	static int height = 800;	
	

	public void paint(Graphics g) {
		super.paintComponent(g);
//		backgroundMusic.play();
//		back.paint(g);
//		maze.paint(g);
		g.setFont(myFont);
		g.setColor(Color.black);
//		g.drawString(score1+"", 500, 50);
		
	}
	
	public void reset() {
//		mouse.setVx(0);
//		mouse.x = 280;
//		mouse.y = 700;
//		
//		//loss of life
//		if (heart.size() > 0) {
//			heart.remove(0);
//		} else {
//			System.out.print(" GAME OVER ");
//			
//		}
	}
	
	public static void main(String[] arg) {
		Hopefully_It_Works f = new Hopefully_It_Works();
		
	}
	
	
	
	public Hopefully_It_Works() {
		JFrame f = new JFrame("Duck Hunt");
		f.setSize(new Dimension(width, height));
		f.setBackground(Color.white);
		f.add(this);
		f.setResizable(false);
 		f.addMouseListener(this);
		f.addKeyListener(this);
		
//		if (mouse.getX() > Frame.width) {
//			reset();
//		}
		//backgroundMusic.play();
		
		//the cursor image must be outside of the src folder
		//you will need to import a couple of classes to make it fully 
		//functional! use eclipse quick-fixes
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("torch.png").getImage(),
				new Point(0,0),"custom cursor"));	
		
		
		Timer t = new Timer(16, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent m) {
		
	
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0.getKeyCode());
		
//		if (arg0.getKeyCode() == 38) {
//			mouse.move(0);
//		} else if (arg0.getKeyCode() == 40) {
//			mouse.move(1);
//		} else if (arg0.getKeyCode() == 37) {
//			mouse.move(2);
//		} else if (arg0.getKeyCode() == 39) {
//			mouse.move(3);
//		}
//		
//		while (heart.size() == 0) {
//			if (arg0.getKeyCode() == 32) {
//				reset();
//			}
//		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
