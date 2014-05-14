import java.awt.Color;

/**
 * class for sorting rectangles and highlighting nodes
 * @author kovaka
 *
 */
public class SelectionSort {
	
	/**
	 * wrapper method that sorts Rectangle data
	 * @param data
	 */
	public static void sort(RectangleList rects){
		sort(rects, 0, rects.length()-1);
	}
	
	/**
	 * recursively sorts data between lo and hi
	 * @param data
	 * @param lo
	 * @param hi
	 */
	private static void sort(RectangleList rects, int lo, int hi){
		if(lo == hi){ 
			rects.paint(lo, Color.white);
			return;
		}
		swap(rects, lo, findMax(rects, lo, hi));
		rects.paint(lo, Color.white);
		sort(rects, lo+1, hi);
	}
	
	/**
	 * swap the Rectangles at i and j
	 * @param data
	 * @param i
	 * @param j
	 */
	private static void swap(RectangleList rects, int i, int j){
		Rectangle[] data = rects.getData();
		Rectangle temp = data[i].clone();
		data[i] = data[j];
		data[j] = temp;
		rects.paint();
	}
	
	/**
	 * finds index of rectangle with smallest value
	 * @param data
	 * @param lo
	 * @param hi
	 * @return
	 */
	private static int findMax(RectangleList rects, int lo, int hi){
		int best = lo;
		Rectangle[] data = rects.getData();
		rects.paint(lo, Color.red);
		for(int i = lo; i <= hi; i++){
			rects.paint(i, Color.yellow);//highlight suspect yellow
			if(data[best].getValue() < data[i].getValue()){//if it replaces best
				rects.paint(i, Color.red);//change new best to red
				rects.paint(best, Color.white);
				best = i;}
			else{//if it doesn't replace best
				rects.paint(i, Color.white);
			}
		}
		return best;
	}
}
