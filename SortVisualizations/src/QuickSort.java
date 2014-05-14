import java.awt.Color;


public class QuickSort {
	
	public static void sort(RectangleList blocks){
		if(blocks.getData().length == 0) return;
		sort(blocks, 0, blocks.length()-1);
	}
	
	
	/**
	 * sort blocks between lo and hi
	 * 
	 * @param blocks
	 * @param lo
	 * @param hi
	 */
	private static void sort(RectangleList blocks, int lo, int hi){
		if(lo >= hi) return;
	
		int pivotIndex = pickPivot(lo, hi);
		blocks.paint(pivotIndex, Color.red);
		int pivot = blocks.getValue(pivotIndex);
		blocks.swap(lo, pivotIndex);//move pivot to lo
		pivotIndex = partition(blocks, pivot, lo+1, hi);
		blocks.swap(lo, pivotIndex);//move pivot between partitions
		blocks.paint(pivotIndex, Color.white);
		sort(blocks, lo, pivotIndex-1);
		sort(blocks, pivotIndex + 1, hi);
	}
	
	/**
	 * picks a pivot between lo and hi
	 * 
	 * @param lo
	 * @param hi
	 * @return
	 */
	private static int pickPivot(int lo, int hi){
		return (int)(Math.random()*(hi - lo) + lo);
	}

	/**
	 * partition blocks around pivot between lo and hi
	 * 
	 * @param blocks
	 * @param pivot
	 * @param lo
	 * @param hi
	 * @return
	 */
	private static int partition(RectangleList blocks, int pivot, int lo, int hi){
		blocks.paint(lo, Color.blue);
		blocks.paint(hi, Color.blue);
		while(lo < hi){
			if(blocks.getValue(lo) <= pivot){
				blocks.paint(lo, Color.white);
				lo++;
				blocks.paint(lo, Color.blue);
			}
			else{
				blocks.swap(lo, hi);
				blocks.paint(hi, Color.white);
				hi--;
				blocks.paint(hi, Color.blue);
			}
		}
		blocks.paint(lo, Color.white);
		blocks.paint(hi, Color.white);
		if(blocks.getValue(lo) <= pivot){//make sure pivot goes into right spot
			return lo;
		}
		else{
			return lo - 1;
		}
	}
}
