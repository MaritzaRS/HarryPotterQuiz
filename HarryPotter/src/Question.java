
public class Question {
	private String question;
	private String huffAnswer;
	private String ravenAnswer;
	private String gryffAnswer;
	private String slythAnswer;
	
//	private boolean addHuff;		//returns true if certain answer is selected
//	private boolean addGryff;
//	private boolean addRaven;
//	private boolean addSlyth;
	
	public Question(String text, String h, String g, String r, String s) {
		question = text;
		huffAnswer = h;
		ravenAnswer = r;
		gryffAnswer = g;
		slythAnswer = s;
		
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getHuffAnswer() {
		return huffAnswer;
	}

	public void setHuffAnswer(String huffAnswer) {
		this.huffAnswer = huffAnswer;
	}

	public String getRavenAnswer() {
		return ravenAnswer;
	}

	public void setRavenAnswer(String ravenAnswer) {
		this.ravenAnswer = ravenAnswer;
	}

	public String getGryffAnswer() {
		return gryffAnswer;
	}

	public void setGryffAnswer(String gryffAnswer) {
		this.gryffAnswer = gryffAnswer;
	}

	public String getSlythAnswer() {
		return slythAnswer;
	}

	public void setSlythAnswer(String slythAnswer) {
		this.slythAnswer = slythAnswer;
	}
	
	@Override
	public String toString() {
	    return "Question: " + question + "\n"
	         + "A: " + huffAnswer + "\n"
	         + "B: " + gryffAnswer + "\n"
	         + "C: " + ravenAnswer + "\n"
	         + "D: " + slythAnswer;
	}

	
}
