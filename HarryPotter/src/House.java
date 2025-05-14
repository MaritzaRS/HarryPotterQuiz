import java.awt.Color;

public class House {
	private String trait;
	private Color color;
	
	public House() {
		trait = "";
		color = Color.BLACK;
	}

	public String getTrait() {
		return trait;
	}

	public void setTrait(String trait) {
		this.trait = trait;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	
}
