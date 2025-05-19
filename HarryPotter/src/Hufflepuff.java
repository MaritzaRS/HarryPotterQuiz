import java.awt.Color;

public class Hufflepuff extends House{
	
	private static String co;
	private static Color h;
	
	public Hufflepuff() {
		super();
		co = "Loyal";
		h = Color.YELLOW;
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
	
}
