import java.awt.Color;

public class Gryffindor extends House{
	
	private String co;
	private Color g;
	
	public Gryffindor() {
		super();
		co = "Brave";
		g = Color.RED;
	}

	public String getCo() {
		return co;
	}

	public void setCo(String co) {
		this.co = co;
	}

	public Color getG() {
		return g;
	}

	public void setG(Color g) {
		this.g = g;
	}
	
	
	
}
