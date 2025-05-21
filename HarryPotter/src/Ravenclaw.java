import java.awt.Color;

public class Ravenclaw extends House{
	
	private static String co;
	private static  Color r;
	private static Color second;
	
	public Ravenclaw() {
		super();
		co = "Wise";
		r = Color.BLUE;
		second = Color.GRAY;
	}

	public String getCo() {
		return co;
	}

	public static void setCo(String c) {
		c = co;
	}

	public Color getR() {
		return r;
	}

	public static void setR(Color ra) {
		ra = r;
	}

	public static Color getSecond() {
		return second;
	}

	public static void setSecond(Color second) {
		Ravenclaw.second = second;
	}
	
}
