import java.awt.Color;


public class MergeSort {
	public static void sort(RectangleList blocks){
		if(blocks.length() == 0) return;
		sort(blocks, 0, blocks.length()-1);
	}
	
	public static void sort(RectangleList blocks, int lo, int hi){
		if(lo == hi) return;
		int midpt = (lo + hi)/2;
		
		sort(blocks, lo, midpt);
		sort(blocks, midpt+1, hi);
		
		merge(blocks, lo, midpt, midpt+1, hi);
	}
	
	public static void merge(RectangleList blocks, int lo, int a, int b, int hi){
		RectangleList tmp = blocks.clone();
		int i = lo;
		while(lo <= a && b <= hi){//copy smaller value into tmp
			if(blocks.getValue(lo) < blocks.getValue(b)){
				tmp.getData()[i] = blocks.getData()[lo].clone();
				lo++;
			}
			else{
				tmp.getData()[i] = blocks.getData()[b].clone();
				b++;
			}
			tmp.paint(i, Color.blue);
			i++;
		}
		
		//one list is extinguished and one loop won't run
		while(lo <= a){
			tmp.getData()[i] = blocks.getData()[lo].clone();
			tmp.paint(i, Color.blue);
			i++;
			lo++;
		}
		while(b <= hi){
			tmp.getData()[i] = blocks.getData()[b].clone();
			tmp.paint(i, Color.blue);
			b++;
			i++;
		}
		blocks.copyRectangeList(tmp);
		blocks.paint(Color.white);
	}
	
}
