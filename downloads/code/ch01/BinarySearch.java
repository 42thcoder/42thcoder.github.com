public class BinarySearch{
	public static int rank(int key, int[] a){
		return ranke(key, a, 0, a.length - 1);
	}

	public int void rank(int key, int[] a, int lo, int hi){
		if(lo > hi){
			return -1;
		}

		int mid = (hi - lo) / 2;
		if(key < a[mid]){
			hi = mid - 1;
			rank(key, a, lo, hi);
		} else if(key > a[mid]){
			lo =  mid + 1;
			rank(key, a, lo, hi);
		} else{
			return mid;
		}
	}
}
