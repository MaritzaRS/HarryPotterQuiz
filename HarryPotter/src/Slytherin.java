import java.awt.Color;

public class Slytherin extends House{
	
	private static String co;
	private static Color s;
	private static Color second;
	
	public Slytherin() {
		super();
		co = "Ambitious";
		s = Color.GREEN;
		second = Color.LIGHT_GRAY;
	}

	public static Color getSecond() {
		return second;
	}

	public static void setSecond(Color second) {
		Slytherin.second = second;
	}

	public String getCo() {
		return co;
	}

	public static void setCo(String c) {
		c = co;
	}

	public Color getS() {
		return s;
	}

	public static void setS(Color sl) {
		sl = s;
	}
	
	
}
