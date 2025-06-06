// importing necessary classes for graphics, events, timing, etc
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

// main class that runs the quiz game
// it extends JPanel for drawing and implements listeners for mouse, keyboard, and timer events
public class DriverRUNTHIS extends JPanel implements ActionListener, MouseListener, KeyListener {
	
	// fonts used to draw text on screen
	Font timeFont = new Font("Courier", Font.BOLD, 70);
	Font myFont = new Font("Courier", Font.BOLD, 40);
	
	// keeps track of which question is being shown
	int currentQuestionIndex = 0;
	
	// stores the answers the user selects
	ArrayList<String> chosenAnswers = new ArrayList<>();

	// global variables for tracking scores and state
	private static ArrayList<Question> questionList; // stores all quiz questions
	private static int hScore; // hufflepuff score
	private static int gScore; // gryffindor score
	private static int rScore; // ravenclaw score
	private static int sScore; // slytherin score
	private boolean showHitboxes = false; // toggle to show or hide hitboxes

	// screen size constants
	static int width = 1200;
	static int height = 800;	
	

	// paint method draws the entire game screen
	public void paint(Graphics g) {
	    super.paintComponent(g); // clears the screen
	    
	    // if there are still questions to display
	    if (currentQuestionIndex < questionList.size()) {
	        Question q = questionList.get(currentQuestionIndex); // get current question
	        
	        // draw question number
	        g.setFont(new Font("Cambria", Font.BOLD, 20));
	        g.drawString("Question " + (currentQuestionIndex + 1) + " of " + questionList.size(), 100, 70);
	        
	        g.setFont(new Font("Cambria", Font.PLAIN, 24));
	        
	        // break long questions into two lines if needed
	        if (q.getQuestion().length() < 85) {
		        g.drawString(q.getQuestion(), 100, 120);
	        } else {
	        	if (q.getQuestion().substring(85, 86).equals(" ")) {
		        	g.drawString(q.getQuestion().substring(0, 85), 100, 120);
		        	g.drawString(q.getQuestion().substring(86, q.getQuestion().length()), 100, 150);
	        	} else {
	        		for (int i = 85; i < q.getQuestion().length(); i++) {
	        			if (q.getQuestion().substring(i, i+1).equals(" ")) {
	        				g.drawString(q.getQuestion().substring(0, i), 100, 120);
	        				g.drawString(q.getQuestion().substring(i+1, q.getQuestion().length()), 100, 150);
	        				break;
	        			}
	        		}
	        	}
	        }
	        
	        // draw the answer boxes and answer text
	        g.drawRect(100, 170, 800, 50);
	        g.drawString(q.getHuffAnswer(), 110, 205);
	        
	        g.drawRect(100, 240, 800, 50);
	        g.drawString(q.getGryffAnswer(), 110, 275);

	        g.drawRect(100, 310, 800, 50);
	        g.drawString(q.getRavenAnswer(), 110, 345);

	        g.drawRect(100, 380, 800, 50);
	        g.drawString(q.getSlythAnswer(), 110, 415);
	        
	    } else {
	    	// once all questions are done, display result
	        g.setFont(new Font("Cursive", Font.BOLD, 30));
	        g.setColor(Color.black);
	        g.drawString("Quiz Complete!", 100, 100);
	        
	        int total = hScore + gScore + rScore + sScore; // calculate total score
	        
	        // calculate percentage of each house and display result
	        if (total > 0) {
	        	int H = hScore * 100 / total;
	        	int G = gScore * 100 / total;
	        	int R = rScore * 100 / total;
	        	int S = sScore * 100 / total;
	        	
	        	// determine top house and draw result text with house color
	        	if (H < G && H > R && H > G) {
	        		Hufflepuff hu = new Hufflepuff();
	        		g.setColor(hu.getSecondary());
	        		g.drawString("HUFFLEPUFF!!!", 100, 400);
	        	} else if (G > H && G > R && G > S) {
	        		Gryffindor gr = new Gryffindor();
	        		g.setColor(gr.getG());
	        		g.drawString("GRYFFINDOR!!!", 100, 400);
	        	} else if (R > G && R > S && R > H) {
	        		Ravenclaw ra = new Ravenclaw();
	        		g.setColor(ra.getR());
	        		g.drawString("RAVENCLAW!!!", 100, 400);
	        	} else if (S > G && S > H && S > R) {
	        		Slytherin sl = new Slytherin();
	        		g.setColor(sl.getS());
	        		g.drawString("Slytherin!!!", 100, 400);
	        	}
	        	
	        	// draw all house percentages
	            g.drawString("Hufflepuff: " + H + "%", 100, 150);
	            g.drawString("Gryffindor: " + G + "%", 100, 200);
	            g.drawString("Ravenclaw: " + R + "%", 100, 250);
	            g.drawString("Slytherin: " + S + "%", 100, 300);
	        }
	    }
	}

	// helper method that checks if a point is inside a rectangle
	private boolean isInBox(int mx, int my, int x, int y, int w, int h) {
	    return mx >= x && mx <= x + w && my >= y && my <= y + h;
	}
	
	// main method starts the program
	public static void main(String[] arg) {
		DriverRUNTHIS f = new DriverRUNTHIS();
	}
	
	// constructor sets up the frame and initializes everything
	public DriverRUNTHIS() {
		JFrame f = new JFrame("Harry Potter Quiz"); // create frame
		f.setSize(new Dimension(width, height)); // set frame size
		f.setBackground(Color.white); // background color
		f.add(this); // add this panel to the frame
		f.setResizable(false); // disable resizing
 		f.addMouseListener(this); // enable mouse input
		f.addKeyListener(this); // enable keyboard input
		
		// initialize the question list
		questionList = new ArrayList<Question>();
		
		// add all quiz questions to the list
		// each question takes four answers in hufflepuff, gryffindor, ravenclaw, slytherin order
		questionList.add(new Question("What is the result you are hoping for?", "Hufflepuff","Gryffindor","Ravenclaw","Slytherin"));
		
		questionList.add(new Question("If a classmate cheats on a test and tells you about it, what would you do?", "Do nothing",
				"Learn how it’s done","Stop them if they try again, but don’t tell","Tell a teacher"));
		
		questionList.add(new Question("You are told a secret that could ruin an acquaintance who’s about to run against you for a position of power. "
				+ "Who do you tell?", "Nobody","Use it against them openly","Tell them you know, but it will be kept safe","Spread it as an anonymous rumor"));
		
		questionList.add(new Question("If you were approached by a hostile mountain troll, what’s the first spell you are using?   ", 
				"Spell? I’m running away","Wingardium Leviosa","Disillusionment Charm","Avada Kedavra"));
		
		questionList.add(new Question("Someone accuses you of a crime against the Student Code, but the punishment is only a couple of detentions and the actual culprit is your friend. "
				+ "How do you react?", "Firmly oppose the accusation, but not giving up your friend","Defend yourself by turning the arguments back to the accuser",
				"Accept the detentions and move on","Accept the accusation in return for having a favor from the culprit"));
		
		questionList.add(new Question("What position do you play on the Quidditch Team?", 
				"Chaser","Seeker","I’m not on the Quidditch Team","Beater"));
		
		questionList.add(new Question("A Dark Wizard targets your family in your home. You know who they are, but the Ministry doesn’t believe you. "
				+ "What’s your next course of action?", "Secure undeniable evidence of their guilt and take it to the Ministry","Hunt them down yourself",
				"Ward your home with everything you know","Revenge campaign to destroy their reputation"));
		
		questionList.add(new Question("Which of these magical events would you most want to go to?", "Christmas at Hogwarts","Quidditch World Cup",
				"Yule Ball","Triwizard Tournament"));
		
		questionList.add(new Question("Which word would hurt you the most should you be insulted?", "Useless","Weak","Stupid","Ungrateful"));
		
		questionList.add(new Question("How easily do you hate people who have wronged you slightly? (like a unknowing push, a microaggression, an eye roll)", 
				"I’m a bit hurt. I’m sure its accidental, but I don’t want to confront them still","I don’t like them at all, and I ask why they did it",
				"I don’t care, I have more important things to focus on","I hate them a bit, and turn a couple of people against them"));
		
		questionList.add(new Question("What did your parents/guardian/mentor say to make you do or be better? (or as close as they would say)", 
				"“Family and friends will guide you on your path”","“Failure is just another way to learn”","“Nobody can take what’s in your brain”",
				"“The only thing you can control is yourself”"));
		
		questionList.add(new Question("What’s the most unforgivable thing a person can do?", "Betray someone’s trust (romantic or otherwise)","Murder",
				"Erase information that could have helped everyone","Destroy everything you’ve worked for"));
		
		questionList.add(new Question("Why did you have to push them away?", "They only vented to me and never listened back","They started getting involved with a bad group",
				"They got angry that I couldn’t make time for them","They started trying to control me"));
		
		questionList.add(new Question("If someone walked up and booped your nose in the middle of your melodramatic speech, what’s your immediate reaction?", 
				"Stare in confusion, because why?","Start laughing","They would not get close enough to do that","Curse them into oblivion"));
		
		questionList.add(new Question("If society was under control of a powerful person you disagree with, which action are you taking?", 
				"Work with organizations to help the victims","Amass a force to overthrow the power, then establish a better one",
				"Research facts to create arguments against the power’s supporters","Infiltrate the existing power and change from the inside"));
		
		questionList.add(new Question("What’s the superior shape (close to or adjacent to the shapes below)?", "Triangle","Square","Hexagon","Circle"));
		
		questionList.add(new Question("When do you do your homework (on the condition you actually do it)?", "The night before it’s due","In the morning before class",
				"In the class day it was assigned","In order of priority to other assignments, no matter the time"));
		
		questionList.add(new Question("A friend calls you because they killed a person and need your car to transport the body away from they city. Do you do it?", 
				"Yes, I’m out the door, no questions asked","I’m going to ask a few questions, morally contemplate it, but yes","No, I either contact the police or take the secret to the grave",
				"No, but I call up someone who will and keep it secret until I need to tell"));
		
		questionList.add(new Question("Which position of power would you most rather have?", "A homemaker, religious leader, a manager, guiding the community",
				"A spy, militant, activist, taking action","A head researcher, librarian, teacher, dealing with knowledge","A ruler, president, lawyer, top of the food chain"));
		
		questionList.add(new Question("If you could master one magical subject, which would it be?", "Transfiguration", "Duelling", "Ancient Runes", "Potions"));
		

		// start game loop using timer that updates screen every ~16 ms
		Timer t = new Timer(16, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close on exit
		f.setVisible(true); // show the frame
	}
	
	
	// not used
	@Override
	public void mouseClicked(MouseEvent arg0) {}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	// handles clicking on an answer
	@Override
	public void mousePressed(MouseEvent m) {
	    int mx = m.getX(); // x coordinate of click
	    int my = m.getY(); // y coordinate of click

	    if (currentQuestionIndex >= questionList.size()) return; // do nothing if quiz is done

	    Question q = questionList.get(currentQuestionIndex);
	    String selected = "";

	    // check which box was clicked and update score
	    if (isInBox(mx, my, 100, 170, 800, 75)) {
	        hScore++;
	        selected = "Hufflepuff";
	    } else if (isInBox(mx, my, 100, 240, 800, 75)) {
	        gScore++;
	        selected = "Gryffindor";
	    } else if (isInBox(mx, my, 100, 310, 800, 75)) {
	        rScore++;
	        selected = "Ravenclaw";
	    } else if (isInBox(mx, my, 100, 380, 800, 75)) {
	        sScore++;
	        selected = "Slytherin";
	    }

	    // if a valid answer was clicked, save it and go to next question
	    if (!selected.equals("")) {
	        chosenAnswers.add(selected);
	        currentQuestionIndex++;
	        repaint();
	    }
	}

	// not used
	@Override
	public void mouseReleased(MouseEvent arg0) {}

	// called automatically by timer every 16 ms to repaint the screen
	@Override
	public void actionPerformed(ActionEvent arg0) {
		repaint();
	}

	// toggles hitbox visibility when f1 key is pressed
	@Override
	public void keyPressed(KeyEvent e) {
	    if (e.getKeyCode() == KeyEvent.VK_F1) {
	        showHitboxes = !showHitboxes;
	        repaint();
	    }
	}

	@Override
	public void keyReleased(KeyEvent arg0) {}

	@Override
	public void keyTyped(KeyEvent arg0) {}

}
