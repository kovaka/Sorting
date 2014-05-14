import java.awt.Color;


public class Rectangle {
	private int value;
	private Color color;
	
	
	/**
	 * special constructor
	 * @param _value
	 * @param _color
	 */
	public Rectangle(int _value, Color _color){
		value = _value;
		color = _color;
	}
	
	/**
	 * default constructor
	 * @param _value
	 */
	public Rectangle(int _value){
		value = _value;
		color = Color.WHITE;
	}
	
	/**
	 * change color;
	 * @param _color
	 */
	public void highlight(Color _color){
		color = _color;
	}
	
	/**
	 * returns the Color of the object
	 * @return
	 */
	public Color getColor(){
		return color;
	}
	
	/**
	 * returns the integer value of the object
	 * @return
	 */
	public int getValue(){
		return value;
	}
	
	public Rectangle clone(){
		return new Rectangle(value, color);
	}
}
