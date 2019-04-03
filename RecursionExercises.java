//Taylor Palm

package lab6;

public class RecursionExercises {
	
	/**
	 * Given an integer n, find the sum of the series 1^1 + 2^2 + 3^3 + ¡­.. + n^n 
	 * using recursion.
	 * @param n 
	 * @return the sum of the series 1^1 + 2^2 + 3^3 + ¡­.. + n^n 
	 */
	public static double sum(int n)
	{
		
		// TO DO: add you code here ..

		
		if (n==1) return 1;
		
		else return  Math.pow(n, n) + sum(n-1); 
		
	}
	
	
	/**
	 * Climbing stairs Problem: @restriction: Each time can climb 1, 2 or 3 steps.
	 * @param n - total number of steps
	 * @return the number of distinct ways from bottom to top
	 */
	public static long climbStairs(int n)
	{
		// TO DO: add you code here ..
		
		if(n==0||n==1) return 1;
		if(n==2) return 2;
				
		else return  climbStairs(n-3) + climbStairs(n-2) +  climbStairs(n-1);			
		
	}
	
	
	/**
	 * Find the index of the given target in sorted array (assume no duplicated elements)
	 * Example: (arr = [1 2 4 7 9], target = 7)  return 3
	 * @param target
	 * @return the index of the given target in sorted array or -1 if not found
	 */
	public static int binSearchTarget(int[] arr, int target)
	{
		// TO DO: add you code here ..
		return binarySearch(arr, target, 0, arr.length-1);
		
	}
	
	public static int binarySearch(int[] arr, int target, int start, int end) {
		
		if(start>end) { return -1;}
		
		int middle= (start+end)/2;
		
		if (arr[middle]==target) {return middle; }
		
		else if(arr[middle]>target) {
			return binarySearch(arr, target, start, middle-1);}
	
		else 
			return binarySearch(arr, target, middle+1, end);
	}

		
//	==============================  10%  Extra Credit ==================================
	/**
	 * Find the index of first occurrence of given target in sorted array (allow duplicated elements)
	 * Example: (arr = [1 1 1 2 4], target = 1)  return 0
	 * @param target
	 * @return the index of first occurrence of the given target in sorted array or -1 if not found
	 */
    // Please also add at least two Junit test cases in the test file.
	public static int  binSearchTargetDup(int[] arr, int target)
	{
		// TO DO: add you code here ..
		return dupBinarySearch(arr, target, 0, arr.length-1);
					
	}
	
	public static int dupBinarySearch(int[] arr, int target, int start, int end) {
		
		if(start>end) {return -1;}
		
		int middle= (start+end)/2;
		
		if (arr[middle]==target && arr[middle-1]<arr[middle]) {return middle;}
		
		else if(arr[middle]<target) {
			return binarySearch(arr, target, middle+1, end);}
	
		else 
			return binarySearch(arr, target, start, middle-1);

	}
	
	
	
	
	
	
//	==============================  10%  Extra Credit ==================================
	/*
	  Print all possible paths from top left to bottom right of a mXn matrix
	  The problem is to print all the possible paths from top left to bottom right of 
	  a mXn matrix with the constraints that from each cell you can           
	  either move only to right or down.
	  Examples :

		Input : 1 2 3
        		4 5 6
		Output : 1 4 5 6
         		 1 2 5 6
         		 1 2 3 6

		Input : 1 2 
        		3 4
		Output : 1 2 4
         		 1 3 4
	 */
	
	public static void allPaths(int[][] arr)
	{
		System.out.println(paths(arr, 0, 0, ""));
	
	}
	
	public static String paths(int [][] array, int m, int n, String print) {
		
		print+= array[m][n] + " ";
		
		if(m==(array.length-1) && n==(array[array.length-1].length-1)) {
				print=print.substring(0, print.length()-1);	
				return print;}
		
		
		else if (m==(array.length-1) && n<(array[array.length-1].length-1)) {
				
					return paths(array, m, n+1, print);}
		
		
		else if(n==(array[array.length-1].length-1) && m<(array.length-1)) {
			
			return paths(array, m+1, n, print);}
		
		
		else
		 return paths(array, m+1, n, print) + "\n" +
				paths(array, m, n+1, print);}
		
	public static void main(String[]args) {
		
		int arr[][]= {{1,2,3}, {4,5,6}, {7,8,9}};
		
		allPaths(arr);
	}
		
	}
