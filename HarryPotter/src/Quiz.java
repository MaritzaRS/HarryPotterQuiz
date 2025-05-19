import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Quiz {
	
//	JFrame frame;
	private static ArrayList<Question> questionList;
	
	public Quiz() {
		questionList = new ArrayList<Question>();
		
		setup();
		
		
		questionList.add(new Question("What is the result you are hoping for?", "Hufflepuff","Gryffindor","Ravenclaw","Slytherin"));
		
		
		//debug
		System.out.println(questionList.get(0).toString());
		
		
		
		
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
