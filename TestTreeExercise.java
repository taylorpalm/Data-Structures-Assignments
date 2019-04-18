package lab7;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.*;

public class TestTreeExercise {
	
	private Node<Integer> root1;
	private Node<Integer> root2;
	private Node<Integer> root3;
	
	
	@Before
	  public void setUp()
	  {
		int[] arr1 = {20, 10, 5, 1, 7, 15, 30, 25, 35, 32, 40};
		int[] arr2 = {10, 5, 2, 7, 40, 50};
		int[] arr3 = {2,1,3};
		root1 = TreeExercise.consBSTfromPreOrder(arr1, 0, arr1.length-1);
		root2 = TreeExercise.consBSTfromPreOrder(arr2, 0, arr2.length-1);
		root3 = TreeExercise.consBSTfromPreOrder(arr3, 0, arr3.length-1);
	  }
	
	
	@Test(timeout = 100)
	public void testinOrder()
	{
		ArrayList<Integer> ret = new ArrayList<Integer>();
		
		List<Integer> expected1 = Arrays.asList(1,5,7,10,15,20,25,30,32,35,40);		
		List<Integer> expected2 = Arrays.asList(2,5,7,10,40,50);		
		List<Integer> expected3 = Arrays.asList(1,2,3);	
		
		assertEquals("inOrder function failed",expected1, TreeExercise.inOrder(root1, ret));
		ret.clear();
		assertEquals("inOrder function failed", expected2, TreeExercise.inOrder(root2, ret));
		ret.clear();
		assertEquals("inOrder function failed", expected3, TreeExercise.inOrder(root3, ret));
	}
	
	@Test(timeout = 100)
	public void testmaxBST()
	{
		assertEquals("maxBST function failed",40, TreeExercise.maxBST(root1));
		assertEquals("maxBST function failed", 50, TreeExercise.maxBST(root2));
		assertEquals("maxBST function failed", 3, TreeExercise.maxBST(root3));
	}
	
	@Test(timeout = 100)
	public void testminBST()
	{
		assertEquals("minBST function failed",1, TreeExercise.minBST(root1));
		assertEquals("minBST function failed", 2, TreeExercise.minBST(root2));
		assertEquals("minBST function failed", 1, TreeExercise.minBST(root3));
	}
	
	@Test(timeout = 100)
	public void testisBST()
	{
		assertEquals("isBST function failed", true, TreeExercise.isBST(root1));
		assertEquals("isBST function failed", true, TreeExercise.isBST(root2));
		assertEquals("isBST function failed", true, TreeExercise.isBST(root3));
		changeNode(root1, 19);
		assertEquals("isBST function failed", false, TreeExercise.isBST(root1));
		changeNode(root2, 8);
		assertEquals("isBST function failed", false, TreeExercise.isBST(root2));
		
	}
	
	public void changeNode(Node<Integer> root, int val)
	{
		if (root == null) return;
		
		Node<Integer> temp = root;
		while(temp.left != null)
		{
			temp = temp.left;
		}
		
		temp.data = val;
	}
	
	
	@Test(timeout = 100)
	public void levelOrderBST() {
	
	//Root 1 expected result set-up
	ArrayList<ArrayList<Integer>> expected1 = new  ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> addFirst1= new ArrayList<Integer>();
	ArrayList<Integer> addSecond1= new ArrayList<Integer>();
	ArrayList<Integer> addThird1= new ArrayList<Integer>();
	ArrayList<Integer> addFourth1= new ArrayList<Integer>();
	addFirst1.add(20); 
	addSecond1.add(10);
	addSecond1.add(30);
	addThird1.add(5);
	addThird1.add(15);
	addThird1.add(25);
	addThird1.add(35);
	addFourth1.add(1);
	addFourth1.add(7);
	addFourth1.add(32);
	addFourth1.add(40);
	expected1.add(addFirst1);
	expected1.add(addSecond1);
	expected1.add(addThird1);
	expected1.add(addFourth1);

	assertEquals("levelOrderBST function failed", expected1, TreeExercise.levelOrderBST(root1));
		
	
	//Root 2 expected result set-up
	ArrayList<ArrayList<Integer>> expected2 = new  ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> addFirst2= new ArrayList<Integer>();
	ArrayList<Integer> addSecond2= new ArrayList<Integer>();
	ArrayList<Integer> addThird2= new ArrayList<Integer>();
	addFirst2.add(10);
	addSecond2.add(5);
	addSecond2.add(40);
	addThird2.add(2);
	addThird2.add(7);
	addThird2.add(50);

	expected2.add(addFirst2);
	expected2.add(addSecond2);
	expected2.add(addThird2);

	assertEquals("levelOrderBST function failed", expected2, TreeExercise.levelOrderBST(root2));
	
	
	//Root 3 expected result set-up
	ArrayList<ArrayList<Integer>> expected3 = new  ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> addFirst3= new ArrayList<Integer>();
	ArrayList<Integer> addSecond3= new ArrayList<Integer>();
	addFirst3.add(2);
	addSecond3.add(1);
	addSecond3.add(3);
	expected3.add(addFirst3);
	expected3.add(addSecond3);
	
	assertEquals("levelOrderBST function failed", expected3, TreeExercise.levelOrderBST(root3));
		
	}
	
	
	
}


  