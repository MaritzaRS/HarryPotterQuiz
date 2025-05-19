import java.awt.Color;

public class Slytherin extends House{
	
	private String co;
	private Color s;
	
	public Slytherin() {
		super();
		co = "AmbitiousS";
		s = Color.GREEN;
	}

	public String getCo() {
		return co;
	}

	public void setCo(String co) {
		this.co = co;
	}

	public Color getS() {
		return s;
	}

	public void setS(Color s) {
		this.s = s;
	}
	
	
	
}
