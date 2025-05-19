import java.awt.Color;

public class Gryffindor extends House{
	
	private static String co;
	private static Color g;
	
	public Gryffindor() {
		super();
		co = "Brave";
		g = Color.RED;
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
	
	
	
}
