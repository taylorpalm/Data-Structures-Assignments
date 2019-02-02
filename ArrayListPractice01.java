package prog1;
import java.io.*;
import java.util.*;

/**
 * 
 * @author taylorpalm
 *
 */

public class ArrayListPractice01 {

	public static void main(String[]args) {
	
	Scanner keyboard=new Scanner (System.in);
	
	System.out.println("Enter a filename: ");
	
	String fname= keyboard.nextLine();
	
	try {
		Scanner inFile=new Scanner(new File(fname));
		
		ArrayList<Double> purchases = new ArrayList<Double>();
		
		while(inFile.hasNext())
			
		{	double purch = inFile.nextDouble();
			purchases.add(purch);}
		
		inFile.close();
		
		System.out.println(purchases.toString());
		
		//Display average
		
		System.out.println("The average purchase value was "  
					       + computeAverage(purchases) + ".");
		
		//Display max purchase
		
		System.out.println("The maximum purchase value was " + purchases.get(findMax(purchases))  
			       + " located at position " + findMax(purchases) + ".");

		//Display min purchase
		System.out.println("The minimum purchase value was " + purchases.get(findMin(purchases))  
	       + " located at position " + findMin(purchases) + ".");
		
	}
	
		catch(IOException e)
	{
			System.out.println("Error reading file: " + fname);
	}
		
}
	

	/*Add all elements in the array list and divide by the size to 
	 * find the average of the elements in the arrayList
	 * @param arrlist - The array list to be searched
	 * @return the average*/
	
public static double computeAverage(ArrayList<Double> arrlist)
{int sum=0;

	for(int i=0; i<arrlist.size(); i++)
		{sum+=arrlist.get(i);}
	
	

return sum/arrlist.size();}


/*Find the max value in the arrayList
 * @param arrlist - The array list to be searched
 * @return maxIndex- the position of the max value in the array list
 */

public static int findMax(ArrayList<Double> arrlist)
{double max=arrlist.get(0);
 int maxIndex=0;

	for(int i=1; i<arrlist.size();i++)
	{
		if(max<arrlist.get(i))
			{max=arrlist.get(i);
		     maxIndex=i;}
		
	}
	
return maxIndex;}

/*Find the minimum value in the arrayList
 * @param arrlist - The array list to be searched
 * @return minIndex- the position of the min value in the array list
 */

public static int findMin(ArrayList<Double> arrlist)
{double min=arrlist.get(0);
 int minIndex=0;

	for(int i=1; i<arrlist.size();i++)
	{
		if(min>arrlist.get(i))
			{min=arrlist.get(i);
		     minIndex=i;}
		
	}
	
return minIndex;}


}
