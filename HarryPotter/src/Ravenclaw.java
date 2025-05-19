import java.awt.Color;

public class Ravenclaw extends House{
	
	private static String co;
	private static  Color r;
	
	public Ravenclaw() {
		super();
		co = "Wise";
		r = Color.BLUE;
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
	
	
	
}
