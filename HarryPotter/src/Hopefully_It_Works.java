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

public class Hopefully_It_Works extends JPanel implements ActionListener, MouseListener, KeyListener {
	
	//Timer related variables
	int waveTimer = 5; //each wave of enemies is 20s
	long ellapseTime = 0;
	Font timeFont = new Font("Courier", Font.BOLD, 70);
	int level = 0;
	int score1 = 0;
	Font myFont = new Font("Courier", Font.BOLD, 40);
	
	
	private static ArrayList<Question> questionList;
	private static ArrayList<String> answerList;
	private static int hScore;
	private static int gScore;
	private static int rScore;
	private static int sScore;
	
	
//	SimpleAudioPlayer backgroundMusic = new SimpleAudioPlayer("Epic.wav", true);
//	SimpleAudioPlayer SadMusic = new SimpleAudioPlayer("SadMusic2.wav", false);
//	SimpleAudioPlayer winner = new SimpleAudioPlayer("scifi.wav", false);
//	
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
		Scanner scanner = new Scanner(System.in);
		for(Question q : questionList) {
	
	        g.drawString(q.getQuestion(), 100, 50);
	        
	        
	        String answer = scanner.nextLine();
	        System.out.println("Your answer is: " + answer);
	        answerList.add(answer);
	        
		}
		
		
        scanner.close();
        
        //calculate points from answers
		for(String a : answerList) {
			
			if(a.equalsIgnoreCase("a")) {
				hScore++;
			}else if(a.equalsIgnoreCase("b")) {
				gScore++;
			}else if(a.equalsIgnoreCase("c")) {
				rScore++;
			}else{
				sScore++;
			}
	         
		}
		
		//calculate which house has the highest points
		int maxScore = Math.max(Math.max(hScore, gScore), Math.max(rScore, sScore));
		String house = "";

		if (hScore == maxScore) {
		    house = "Hufflepuff";
		} else if (gScore == maxScore) {
		    house = "Gryffindor";
		} else if (rScore == maxScore) {
		    house = "Ravenclaw";
		} else if (sScore == maxScore) {
		    house = "Slytherin";
		}
		
		System.out.println();
		System.out.println("Your house is: " + house);
		
		
		System.out.println("The percentage of each houses' ideals inside of you are: ");
		System.out.println("Hufflepuff: " + (double)(hScore * 1.0)/(gScore+rScore+sScore)*100 + "%");
		System.out.println("Gryffindor: " + (double)(gScore*1.0)/(hScore+rScore+sScore)*100 + "%");
		System.out.println("Ravenclaw: " + (double)(rScore*1.0)/(gScore+hScore+sScore)*100 + "%");
		System.out.println("Slytherin: " + (double)(sScore*1.0)/(gScore+rScore+hScore)*100 + "%");
		
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
		JFrame f = new JFrame("Harry Potter Quiz");
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
		
//		Quiz quiz = new Quiz();
//		quiz.painted();
		
		
		questionList = new ArrayList<Question>();
		answerList = new ArrayList<String>();
		
		
		//initialize questions 20, 5 points each
		questionList.add(new Question("What is the result you are hoping for?", "Hufflepuff","Gryffindor","Ravenclaw","Slytherin"));
		
		questionList.add(new Question("If a classmate cheats on a test and tells you about it, what would you do?", "Do nothing",
				"Learn how it’s done","Stop them if they try again, but don’t tell","Tell a teacher"));
		
		questionList.add(new Question("You are told a secret that could ruin an acquaintance who’s about to run against you for a position of power. "
				+ "Who do you tell?", "Nobody","Use it against them openly","Tell them you know, but it will be kept safe","Spread it as an anonymous rumor"));
		
		questionList.add(new Question("If you were approached by a hostile mountain troll, what’s the first spell you are using?", 
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
		
		//debug toString();
		//System.out.println(questionList.get(0).toString());
		
		/*
		 * I moved the display of the questions to the paint method.
		 */
		
		
		
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
