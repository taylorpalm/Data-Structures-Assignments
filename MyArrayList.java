	package lab2;
	import java.util.Arrays;
	import java.util.AbstractList;

	/**
	 * This class implements some of the methods of the Java
	 *  ArrayList class.
	 * 
	 * Authors: Taylor Palm and Tyler Harring
	 *  
	 */
	public class MyArrayList<E>  extends AbstractList<E>
	{
	    // Data Fields
	    /** The default initial capacity */
	    private static final int INITIAL_CAPACITY = 10;
	    /** The underlying data array */				
	    private E[] theData;
	    /** The current size */
	    private int size = 0;
	    /** The current capacity */
	    private int capacity = 0;

	    /**
	     * Construct an empty ArrayList with the default
	     * initial capacity
	     */
	    public MyArrayList() {
	        capacity = INITIAL_CAPACITY;
	        theData = (E[]) new Object[capacity];
	    }

	    
	    /**
	     * Add an entry to the end of the list
	     * @param anEntry - The anEntry to be inserted
	     * @return true/false - if the entry is inserted successfully at the end
	     */
	    public boolean add(E anEntry) {
	        if (size == capacity) {
	            reallocate();
	        }
	        theData[size] = anEntry;
	        size++;
	        return true;
	    }


	    /**
	     * Get a value in the array based on its index.
	     * @param index - The index of the item desired
	     * @return The contents of the array at that index
	     * @throws ArrayIndexOutOfBoundsException - if the index
	     *         is negative or if it is greater than or equal to the
	     *         current size
	     */
	    public E get(int index) {
	        if (index < 0 || index >= size) {
	            throw new ArrayIndexOutOfBoundsException(index);
	        }
	        return theData[index];
	    }

	    /**
	     * Set the value in the array based on its index.
	     * @param index - The index of the item desired
	     * @param newValue - The new value to store at this position
	     * @return The old value at this position
	     * @throws ArrayIndexOutOfBoundsException - if the index
	     *         is negative or if it is greater than or equal to the
	     *         current size
	     * @throws NullPointerException - if newValue is null       
	     */
	    public E set(int index, E newValue) {
	        if (index < 0 || index >= size) {
	            throw new ArrayIndexOutOfBoundsException(index);
	        }
	        
	        if(newValue == null)
	        	throw new NullPointerException();
	        
	        E oldValue = theData[index];
	        theData[index] = newValue;
	        return oldValue;
	    }
	    
	    /**
	     * Get the current size of the array
	     * @return The current size of the array
	     */
	    public int size() {
	        return size;
	    }
	    
	    /**
	     * Returns the index of the first occurence of the specified element
	     * in this list, or -1 if this list does not contain the element
	     * @param item The object to search for
	     * @returns The index of the first occurence of the specified item
	     *          or -1 if this list does not contain the element
	     */
	    public int indexOf(Object item) {
	        for (int i = 0; i < size; i++) {
	            if (theData[i] == null && item == null) {
	                return i;
	            }
	            if (theData[i].equals(item)) {
	                return i;
	            }
	        }
	        return -1;
	    }   
	    
	    
	    /*
	     *  ================================   The following functions need to be filled ===================================================
	     *    
	     */
	        
	    /**
	     * Construct an empty ArrayList with a specified initial capacity
	     * @param capacity - The initial capacity
	     * @throws IllegalArgumentException - if the capacity is less 0
	     */
	    public MyArrayList(int capacity) {
	    	
	    	//TODO: Please fill your code
	    	if(capacity<0)
	    	{ throw new IllegalArgumentException();}	
	    	
	    	else
	    	{theData = (E[]) new Object[capacity];}
	    	
	    }
	    

	   /**
	     * Add an entry to the data inserting it at the specified index.
	     * @param index - The index of the time that the new
	     *        value it to be inserted           
	     * @param newValue - The value to be inserted
	     * @throws ArrayIndexOUtOfBoundsException if index is
	     *         less than zero or greater than size
	     * @throws NullPointerException if newValue is null
	     *         
	     */
	    public void add(int index, E newValue) {    		
	    	
	        //TODO: Please fill your code
	    	
	    	 if (index < 0 || index > size) {
		            throw new ArrayIndexOutOfBoundsException(index);
		        }
	    	 if(newValue.equals(null))
	    	  	{throw new NullPointerException();}
	    	 
	    	 if(size==capacity)
	    	 	{this.reallocate();}

	    	for(int i=size; i>=index; i--)
	    		{theData[i+1]=theData[i];}
	    		theData[index]=newValue;
	    		size++;
	    		
	    		
	    	
	    	
	    }    /**
	     * Remove an entry based on its index
	     * @param index - The index of the entry to be removed
	     * @return The Item removed
	     * @throws ArrayIndexOutOfBoundsException - if the index
	     *         is negative or if it is greater than or equal to the
	     *         current size
	     */
	    public E remove(int index) {
	    	
	    	
	    	//TODO: Please fill your code
	    	if(index<0 ||index>=size)
	    	{throw new ArrayIndexOutOfBoundsException(index);}
	    	
	    	  E oldValue = theData[index];
	    	
	    	for(int i=index; i<size; i++)
	    		{theData[i]=theData[i+1];}
	    		size--;
	    	
	        return oldValue;   // please remove this line after filling your code 
	    }

	    /**
	     * Allocate a new array to hold the directory
	     * Double the capacity of the array and copy the original one at the beginning 
	     * 
	     */
	    private void reallocate() {
	        
	    	// TODO: please fill your code here. 
	    	
	    	theData= Arrays.copyOf(theData, capacity*2);
	    	// Hint: using Arrays.copyof() function. Please read your textbook if need aditional help.
	    }
	          
	    
	    /**
	     * Count the total number of elements equals to elem
	     * @param theValue - the compared element
	     * @return the total number of replicas or -1 if not found in the list    
	     */
	    public int countApperance(E theValue)
	    {
	    	// TODO: please fill your code here. 
	    	int total=0;
	    	for (int i=0; i<size; i++)
	    		{if(theValue.equals(theData[i]))
	    			{total++;}}
	    	
	    	if(total==0)
	    		{total=(-1);}
	    	
	    	return total;
	    	    	
	    }
	    
	    /**
	     * Remove all the duplicated elements equals to theValue
	     * @param theValue - the duplicated element to be removed     * 
	     */
	    public void removeDuplicate(E theValue)
	    {    	
	    	// TODO: please fill your code here.     
	    	for (int i=0; i<size; i++)
    			{if(theData[i].equals(theValue))
    				{this.remove(i);}}
	    }
	       
	    
	 }


