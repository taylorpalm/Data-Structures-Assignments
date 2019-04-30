package lab7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;




public class TreeExercise {
	/*
	 * Construct BST from preorder traversal
	 */
	public static Node<Integer> consBSTfromPreOrder(int[] arr, int start, int end)
	{
				
		if(start > end) return null;
		
		Node<Integer> root = new Node<Integer>(arr[start], null, null);
		
		
		int index = start+1;
		while(index <= end)
		{
			if (arr[index] < arr[start])
			{
				index ++;
			}
			else
			{
				break;
			}
		}
				
		root.left = consBSTfromPreOrder(arr, start + 1, index -1);
		
		root.right = consBSTfromPreOrder(arr, index, end);
		
		return root;		
	}
	
	
	/*
	 *  Tree level traversal 
	 */
	public static void levelOrder(Node<Integer> root)
	{
		Queue<Node<Integer>> que = new LinkedList<Node<Integer>>();
		
		que.offer(root);
		
		while(!que.isEmpty())
		{
			
			Node<Integer> temp = que.poll();
			
			System.out.print(temp + " ");
			
			if (temp.left != null)
				que.offer(temp.left);
			
			if(temp.right != null)
				que.offer(temp.right);
		
		}	
		
	}
	
	
	/**
	 * 
	 * @param root - root of the given BST
	 * @param ret - an ArrayList of the data following inOrder tree traversal
	 * @return the ArrayList ret
	 */
	
	public static ArrayList<Integer> inOrder(Node<Integer> root, ArrayList<Integer> ret)
	{
		
		//TODO: please add your code here

		Node<Integer> temp=root;
		
		if(temp==null) {
			return ret;
			}
		
		inOrder(temp.left, ret);
		
		ret.add(temp.data);
		
		inOrder(temp.right, ret);
	

		return ret;
		
	}


	/**
	 * 
	 * @param root - the root of given BST
	 * @return the maximum data in the given BST or 0 if empty BST
	 */
	public static int maxBST(Node<Integer> root)
	{
		//TODO: please add your code here
		
		Node <Integer> temp=root;
		
		while(temp.right!=null) {
			temp=temp.right;
		}
		
		return temp.data; // please remove this line after your coding
		
	}
	
	/**
	 * 
	 * @param root  - the root of given binary search tree
	 * @return - the minimum data in the given BST or 0 if empty BST
	 */
	
	public static int minBST(Node<Integer> root)
	{
		
		//TODO: please add your code here
		
	Node <Integer> temp=root;
		
		while(temp.left!=null) {
			temp=temp.left;
		}
		
		return temp.data;
	}
	
	
	/**
	 * 
	 * @param root - the given root of binary tree
	 * @return true if a binary search tree; otherwise false
	 */
	
	public static boolean isBST(Node<Integer> root)
	{
		//TODO: please add your code here
		
		Node<Integer> temp=root;
		
		if(temp.left!=null&&temp.right!=null) {
		
			if(!isBST(temp.left)||!isBST(temp.right)) {
				return false;
			}
		
			if(temp.left.data>temp.data||temp.right.data<temp.data) {
				return false;
			}
		}
		
		return true; 
		
	}
	
	
	
	/* ====== Extra Credit (10%)  ==============================*/
	
	/**
	 * 
	 * @param root - the root of the given BST
	 * @return data following tree level traversal
	 */
	/*
	 *  Example:      7
	 *              /    \
	 *             5     10
	 *            / \     \ 
	 *           3   6    12
	 *           
	 * return:  7
	 *          5  10
	 *          3   6  12
	*/
	
	
	public static ArrayList<ArrayList<Integer>> levelOrderBST(Node<Integer> root)
	 
	{	
		ArrayList<ArrayList<Integer>> allLevels = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> level = new ArrayList<Integer>();
		
		Queue<Node<Integer>> que = new LinkedList<Node<Integer>>();
		
		Node<Integer> temp;
		
		que.offer(root);
		
		while(!que.isEmpty()){ 
			
			int numNodes = que.size(); 

	        while(numNodes!=0) {
			
	        	temp = que.poll();
		
				level.add(temp.data);
			
					if (temp.left != null)
						que.offer(temp.left);
			
					if(temp.right != null)
						que.offer(temp.right);
					
					numNodes--;
				
						}

			allLevels.add(new ArrayList<>(level));
			level.clear();
	
				} 
		
		return allLevels;  //remove this line after your coding
	}
	 
	
	
}