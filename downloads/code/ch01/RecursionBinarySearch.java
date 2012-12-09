public class RecursionBinarySearch(){
	public static int rank(int key, in[] a){
		int lo = 0;
		int hi = a.length - 1;
		
		while(lo <= hi){
			int mid = (hi - lo) / 2;
			
			if(key < a[mid]){
				hi = mid - 1;
			} else if(key > a[mid]){
				lo = mid + 1;
			} else{
				return mid;
			}
		}

		return -1;
	}
}