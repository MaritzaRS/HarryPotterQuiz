import java.awt.Color;

public class House {
	private String trait;
	private Color color;
	private Color secondary;
	
	public House() {
		trait = "";
		color = Color.BLACK;
		secondary = Color.BLACK;
	}
	
	public Color getSecondary() {
		return secondary;
	}

	public void setSecondary(Color secondary) {
		this.secondary = secondary;
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
