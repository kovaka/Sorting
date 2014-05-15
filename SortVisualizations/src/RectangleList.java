import java.awt.Color;


public class RectangleList {
	private int numberRectangles = 0;
	private Rectangle[] data = new Rectangle[1];

	/**
	 * construct RectangleList numRects long with random values 10 through 110 
	 * @param numRects
	 */
	public RectangleList(int numRects, Color color){
		numberRectangles = numRects;
		data = new Rectangle[numberRectangles];
		for(int i = 0; i < numberRectangles; i++){
			data[i] = new Rectangle((int)(Math.random()*(Zen.getZenHeight()*0.7))+100, color);
		}
	}
	
	/**
	 * copy constructor
	 * @param other
	 */
	public RectangleList(RectangleList other, boolean deep){
		numberRectangles = other.numberRectangles;
		if(!deep){
			data = other.data;
		}
		else{//make deep copy of data
			Rectangle[] tmp = new Rectangle[other.data.length];
			for(int i = 0; i < numberRectangles; i++){
				tmp[i] = other.data[i].clone();
			}
			data = tmp;
		}
	}
	
	/**
	 * adds an additional rectangle into data;
	 * @param rect
	 */
	public void append(Rectangle rect){
		if(numberRectangles == data.length){//copy new array
			Rectangle[] temp = new Rectangle[data.length*2];
			for(int i = 0; i < numberRectangles; i++){
				temp[i] = data[i];
			}
			data = temp;
		}
		data[numberRectangles] = rect; //add rect into data
		numberRectangles++;
	}
	
	
	/**
	 * paints the entire list of rectangles to Zen window
	 */
	public void paint(){
		double rectWidth = (Zen.getZenWidth() / numberRectangles);
	
		for(int i = 0; i < numberRectangles; i++){
			Zen.setColor(data[i].getColor());
			Zen.fillRect((int)(i*rectWidth), Zen.getZenHeight()-data[i].getValue(), (int) rectWidth, data[i].getValue());
			//Zen.fillRect((int)(i*rectWidth), 0, (int)rectWidth, data[i].getValue());
		}
	}
	
	
	public void paint(Color color){
		for(int i = 0; i < numberRectangles; i++){
			data[i].highlight(color);
		}
		this.paint();
	}
	
	/**
	 * paints one rectangle to the screen
	 * 
	 * in a sense,
	 * actually it changes the color of one rectangle
	 * then it paints all the rectangles
	 * 
	 * @param i
	 * @param _color
	 */
	public void paint(int i, Color _color){
		data[i].highlight(_color);
		this.paint();
		Zen.flipBuffer();
	}
	
	/**
	 * returns data
	 * DOES NOT RETURN A COPY
	 * 
	 * @return
	 */
	public Rectangle[] getData(){
		return data;
	}
	
	/**
	 * return the number of rectangles in the array
	 * 
	 * @return
	 */
	public int length(){
		return numberRectangles;
	}
	
	/**
	 * return the value in one rectangle
	 * 
	 * @param i
	 * @return
	 */
	public int getValue(int i){
		return data[i].getValue();
	}
	
	/**
	 * swap two rectangle in the RetangleList
	 * 
	 * @param i
	 * @param j
	 */
	public void swap(int i, int j){
		Rectangle tmp = data[i].clone();
		data[i] = data[j];
		data[j] = tmp;
		paint();
	}
	
	/**
	 * clone that list!
	 */
	public RectangleList clone(){
		return new RectangleList(this, true);
	}
	
	/**
	 * do funny things with the data to make mergeSort work
	 * uggggghhh
	 * programming right?
	 * 
	 * @param other
	 */
	public void copyRectangeList(RectangleList other){
		numberRectangles = other.numberRectangles;
		data = other.data;
	}
}
