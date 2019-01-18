
public class twoDArraySpiral {

	public static void main(String[] args) {
		
		int [][] array= {{1,2,3,4},{5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
		
		int rEnd=array.length;
		int cEnd=array[0].length;

	for(int start=0; start<=array.length/2; start++)	{
		
		//Print top row left to right
		
		for(int col=start; col<cEnd; col++)
			{System.out.print(array[start][col] + " ");}
		
		//Print right column top to bottom
		
		for(int row=(start+1); row<rEnd; row++)
			{System.out.print(array[row][cEnd-1] + " ");}
		
		//Print bottom row right to left
		
		for(int col=(cEnd-2); col>=start; col--)
			{System.out.print(array[rEnd-1][col] + " ");}
		
		//Print left column bottom to top
		
		for(int row=(rEnd-2); row>start; row--)
			{System.out.print(array[row][start] + " ");}
		
		//Shrink to print next layer
		rEnd--;
		cEnd--;
	}

		
		
	}

}
