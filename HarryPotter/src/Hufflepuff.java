import java.awt.Color;

public class Hufflepuff extends House{
	
	private static String co;
	private static Color h;
	private static Color second;
	
	public Hufflepuff() {
		super();
		co = "Loyal";
		h = Color.YELLOW;
		second = Color.BLACK;
	}

	public String getCo() {
		return co;
	}

	public static void setCo(String c) {
		c = co;
	}

	public static Color getH() {
		return h;
	}

	public static void setH(Color hu) {
		hu = h;
	}
	
	public Color getSecond() {
		return second;
	}
	
	public static void setSecond(Color sec) {
		second = sec;
	}
	
}
