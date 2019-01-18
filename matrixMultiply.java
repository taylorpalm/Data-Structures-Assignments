
public class matrixMultiply {
	
	public static void main (String []args) {
	
	int[][] arr= {{1, 2, 0},{0,3,4}};
	int[][] arr2= {{0,1},{2,3},{0,0}};
	int[][] multiplied = new int[arr.length][arr2[0].length];
	
	//Multiply Matrices and create new matrix: Multiplied
	
	for(int i=0; i<arr.length;i++)
		{for(int j=0; j<arr2[i].length;j++)
			{multiplied[i][j]=((arr[i][0]*arr2[0][j])+(arr[i][1])*(arr2[1][j]));}
		}
	
	//Print New matrix arr x arr2
	
	for (int i=0;i<multiplied.length;i++)
	{for(int j=0; j<multiplied[0].length;j++)
		{System.out.println(multiplied[i][j] + " ");}}
}}

