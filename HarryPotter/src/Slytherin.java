import java.awt.Color;

public class Slytherin extends House{
	
	private static String co;
	private static Color s;
	
	public Slytherin() {
		super();
		co = "AmbitiousS";
		s = Color.GREEN;
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
