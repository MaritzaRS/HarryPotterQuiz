import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Carriage{
	
	private Image forward;
	
	private AffineTransform tx;
	
	
	//attribute of a mousy object
	//int dir = 0; 					//0-forward, 1-backward, 2-left, 3-right
	
	int width, height;		//<-- used for the hitbox aka for the collision detection code
	int x, y;						//position of the object
	int vx, vy;						//movement variables
	double scaleWidth = 0.85;		//change to scale image
	double scaleHeight = 0.85; 		//change to scale image

	
	
	//constructor (default)
	public Carriage() {
		forward 	= getImage("/imgs/"+"ActCarriage.gif"); //load the image for Tree

		//alter these
		width = 15;		//this is for the hit box
		height = 10;
		
//		//top left location of image
//		x = Frame.width/2 - width/2;
//		y = Frame.height - height*1;
		
		
		vx = -5;
		vy = 0;
		
		tx = AffineTransform.getTranslateInstance(0, 0);
		
		init(x, y); 				//initialize the location of the image
									//use your variables
		
	}
	
	/*
	 * Collision with MC
	 */
//	public boolean collided(Mousy1 mainChar){
//		
//		//represent each object as a rectangle for better detection
//		Rectangle rectMain = new Rectangle(
//				mainChar.getX(),
//				mainChar.getY(),
//				mainChar.getWidth(),
//				mainChar.getHeight()
//				
//				);
//				
//				//represent the obj we're querying for info
//		Rectangle thisObj = new Rectangle(
//				this.x,
//				this.y,
//				this.width,
//				this.height
//				);
//		
//		return rectMain.intersects(thisObj);
//		
//	}
	
	//Overload the constructor aka add another constructor
	public Carriage(int x, int y) {
		
		//sometimes the work is done by another constructor, call it
		this();		//this invoke the default constructor
					//so you don't copy and paste code
		//set this object;s attributes
		//this.x is attribute of the entire class, not the parameter
		
		this.x = x; 
		this.y = y;
		
		
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	} 
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public void setVx(int velocity) {
		vx = velocity;
	}
	public int getVx() {
		return vx;
	}
	public void setVy(int velocity) {
		vy = velocity;
	}
	public int getVy() {
		return vy;
	}

	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		
		x		+= vx;
		y		+= vy;	
		
		//if the object leaves the right side
		
		//if (x > Frame.width) {
			//x = - width;
		//}
		
		init(x,y);
		
		g2.drawImage(forward, tx, null);

	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(scaleWidth, scaleHeight);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Carriage.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

}
