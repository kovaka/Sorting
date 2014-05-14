import java.awt.Color;


public class Window {
	public static void SelectionSort(){
		int width = 1200;
		int height = 600;
		Zen.create(width, height, null);
		
		RectangleList myList = new RectangleList(200, Color.white);
		myList.paint();
		
		Zen.flipBuffer();
		
		SelectionSort.sort(myList);
		
	}
	
	public static void QuickSort(){
		int width = 1600;
		int height = 900;
		Zen.create(width, height, null);
		
		RectangleList myList = new RectangleList(1600, Color.white);
		
		QuickSort.sort(myList);
	}
	
	public static void MergeSort(){
		int width = 1600;
		int height = 800;
		Zen.create(width, height, null);
		
		RectangleList myList = new RectangleList(1600, Color.white);
		
		MergeSort.sort(myList);
		
		myList.paint();
		Zen.flipBuffer();
	}
	
	public static void main(String[] args){
		MergeSort();
	}
	
	
}
