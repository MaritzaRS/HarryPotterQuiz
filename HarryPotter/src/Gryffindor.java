import java.awt.Color;

public class Gryffindor extends House{
	
	private static String co;
	private static Color g;
	private static Color second;
	
	public Gryffindor() {
		super();
		co = "Brave";
		g = Color.RED;
		second = Color.YELLOW;
	}

	public String getCo() {
		return co;
	}

	public static void setCo(String c) {
		c = co;
	}

	public Color getG() {
		return g;
	}

	public static void setG(Color gr) {
		gr = g;
	}
	
	public Color getSecond() {
		return second;
	}
	
	public static void setSecond(Color s) {
		second = s;
	}
	
}
