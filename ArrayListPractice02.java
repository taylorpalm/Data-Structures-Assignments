package prog1;
import java.io.*;
import java.util.*;

	/**
	 * 
	 * @author taylorpalm
	 *
	 */

	public class ArrayListPractice02 {

		public static void main(String[]args) {
			
			boolean done=false;
			String input="";
			
			ArrayList<String> myStrings = new ArrayList<>();
		
		Scanner keyboard=new Scanner (System.in);
		
		System.out.println("We will create a list of strings. When you are done, enter 'XXX'.");
		
		
		//User input to create array list, stop when "XXX" is entered
		
		while(done==false)
		{
			System.out.print("Enter a string: ");
			input=keyboard.nextLine();
			
			if(input.matches("XXX"))
			{done=true;}
			
			else
			{myStrings.add(input);}
			
		}
		
		
			//Display array list
		
			System.out.println(myStrings.toString());
			
			//Display average
			
			System.out.println("The average string length is "  
						       + computeAverage(myStrings) + " characters.");
			
			//Display max length
			
			System.out.println("The longest string is '" + myStrings.get(findMax(myStrings)) + "' with "+  
					myStrings.get(findMax(myStrings)).length()  + " character(s) located at position " 
					+ findMax(myStrings) + ".");

			//Display min length
			System.out.println("The shortest string is '" + myStrings.get(findMin(myStrings)) + "' with "  
					+ myStrings.get(findMin(myStrings)).length() + " character(s) located at position " 
					+ findMin(myStrings) + ".");
			
			//Display combined string
			
			System.out.println("The combined string is '" + makeString(myStrings) + "'.");
			
	}
	
		/*Add all the characters in all of the strings in the array list 
		 * and divide by the size to find the average characters per string in the arrayList
		 * @param arrlist - The array list to be searched
		 * @return the average*/		

	public static double computeAverage(ArrayList<String> arrlist)
	{int sum=0;
	 String str;

		for(int i=0; i<arrlist.size(); i++)
			{sum+= (arrlist.get(i).length());}
		

	return sum/arrlist.size();}


	/*Find the maximum(longest) string in the arrayList
	 * @param arrlist - The array list to be searched
	 * @return maxIndex- the position of the longest string in the array list
	 */

	public static int findMax(ArrayList<String> arrlist)
	{double max=arrlist.get(0).length();
	 int maxIndex=0;

		for(int i=1; i<arrlist.size();i++)
		{
			if(max<arrlist.get(i).length())
				{max=arrlist.get(i).length();
			     maxIndex=i;}
			
		}
		
	return maxIndex;}

	/*Find the minimum(shortest) string in the arrayList
	 * @param arrlist - The array list to be searched
	 * @return minIndex- the position of the shortest string in the array list
	 */

	public static int findMin(ArrayList<String> arrlist)
	{double min=arrlist.get(0).length();
	 int minIndex=0;

		for(int i=1; i<arrlist.size();i++)
		{
			if(min>arrlist.get(i).length())
				{min=arrlist.get(i).length();
			     minIndex=i;}
			
		}
		
	return minIndex;}
	
	
	/*Make a combined string with all of the string in the array list
	 * @param arrlist - The array list to be searched
	 * @return str- a string of string elements seperated by commas
	 */
	
	public static String makeString(ArrayList<String> arrlist)
	{String str="";

		for(int i=0; i<arrlist.size();i++)
		{str+=arrlist.get(i);
		
		if(i!=(arrlist.size()-1))
			{str+= ", ";}
		}
		
	return str;}

	
	}