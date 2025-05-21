import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Scanner;

public class Quiz {
	
  //JFrame frame;
	private static ArrayList<Question> questionList;
	private static ArrayList<String> answerList;
	private static int hScore;
	private static int gScore;
	private static int rScore;
	private static int sScore;

	
	public Quiz() {
		questionList = new ArrayList<Question>();
		answerList = new ArrayList<String>();
		setup();
		
		//initialize questions
		questionList.add(new Question("What is the result you are hoping for?", "Hufflepuff","Gryffindor","Ravenclaw","Slytherin"));
		
		questionList.add(new Question("If a classmate cheats on a test and tells you about it, what would you do?", "Do nothing","Learn how it’s done","Stop them if they try again, but don’t tell","Tell a teacher"));
		
		questionList.add(new Question("You are told a secret that could ruin an acquaintance who’s about to run against you for a position of power. Who do you tell?", "Nobody","Use it against them openly","Tell them you know, but it will be kept safe","Spread it as an anonymous rumor"));
		
		questionList.add(new Question("If you were approached by a hostile mountain troll, what’s the first spell you are using?", "Spell? I’m running away","Wingardium Leviosa","Disillusionment Charm","Avada Kedavra"));
		
		questionList.add(new Question("Someone accuses you of a crime against the Student Code, but the punishment is only a couple of detentions and the actual culprit is your friend. How do you react?", "Defend yourself by turning the arguments back to the accuser","Firmly oppose the accusation, but not giving up your friend","Accept the detentions and move on","Accept the accusation in return for having a favor from the culprit"));
		
		questionList.add(new Question("What position do you play on the Quidditch Team?", "Chaser","Seeker","I’m not on the Quidditch Team","Beater"));
		
		questionList.add(new Question("A Dark Wizard targets your family in your home. You know who they are, but the Ministry doesn’t believe you. What’s your next course of action?", "Revenge campaign to destroy their reputation","Hunt them down yourself","Ward your home with everything you know","Revenge campaign to destroy their reputation"));
		
		//debug toString();
		//System.out.println(questionList.get(0).toString());
		
		
		//show questions
		Scanner scanner = new Scanner(System.in);
		for(Question q : questionList) {
	
	        System.out.println(q.toString());
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
		
		
		System.out.println("Your house is: " + house);
		
	}
	
	public void setup() {
//		frame.setBounds(100, 100, 100, 100);
//		frame.addMouseListener(null);
		//setupBoard();
	}
	
//	public void setupBoard() {
//		JPanel jp = new JPanel();
//
//		GridLayout g = new GridLayout(8,8);
//		jp.setLayout(g);	
//
//
////		Tile[][] board = chessLogic.getBoard();
////		for(int i =0; i < question.size();i++) {
////			for(int j = 0; j < question.size();j++) {
////				jp.add(question.get(i));
////				question.get(i).addMouseListener(this);
////			}
////		}
//		
//		frame.add(jp);
//		
//		
//		
//	}
	/*
	 * hopefully graphically placing the quiz on a screen
	 */
	public void paint() {
		
	}

	public static void main(String[] args) {
		
		new Quiz();
		
	}
	
	

}
