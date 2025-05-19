import java.awt.Color;

public class Hufflepuff extends House{
	
	private String co;
	private Color h;
	
	public Hufflepuff() {
		super();
		co = "Loyal";
		h = Color.YELLOW;
	}

	public String getCo() {
		return co;
	}

	public void setCo(String co) {
		this.co = co;
	}

	public Color getH() {
		return h;
	}

	public void setH(Color h) {
		this.h = h;
	}
	
}
