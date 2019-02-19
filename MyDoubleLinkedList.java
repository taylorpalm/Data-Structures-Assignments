package lab4;


/** 
 *  Simple implementation of DoubleLinkedList data structure
 *  @author 
 */

import java.util.NoSuchElementException;

public class MyDoubleLinkedList<E> {
    private Node<E> head;   // the head of the list
    private Node<E> tail;   // tail of the list
    private int size;   // the total number of the node in the list
    
    /**
     *The default constructor.
     */
    public MyDoubleLinkedList() {
    	head = null;
    	tail = null;
        size = 0;
    }// end constructor
    
    /**
     * the size of the list
     * @return the size of the list
     */
    public int size() {
        return size;
    }// end size
    
    /**
     * @return the head of the list
     */
    public E getHead() {
    	if(head == null)
    		throw  new NoSuchElementException();
        return head.data;
    }    
  
    
    /**
     * @return the tail of the list
     */
    public E getTail() {
    	if(tail == null)
    		throw new NoSuchElementException();
        return tail.data;
    }
    
    /**
     * @return the previous of the given node
     */
    public E getPrev(Node<E> cur) {
    	
    	if(cur == null || cur.prev == null)
    		throw new NoSuchElementException();
    	
        return cur.prev.data;
    }
    
    /**
     * @return the next of the given node
     */
    public E getNext(Node<E> cur) {
    	
    	if(cur == null || cur.next == null)
    		throw new NoSuchElementException();
    	
        return cur.next.data;
    }
    
    /**
   	 * get the node at a given index in the list
   	 * @param index  the index of the node to find
   	 * @return       the node at the given index
   	 * @throws       NoSuchElementException if there is no node at the given index in the list
   	 */
    public Node<E> get(int index) {
   		// Is index valid?
   		if ((index < 0) || (index >= size)) 
   			throw new NoSuchElementException();
   		
   		// Start at first node
   		Node<E> cursor = head;
   		int i = 0;
   		// Walk through list
   		while (i < index) {			
   			cursor = cursor.next;
   			i++;
   		}
   		return cursor;
   	}
    
  /**
   * Add a new node with data as x at the beginning of the list
   * @param x the element to be added
   * @return true if successfully added
   */
    
    public boolean addFirst(E x) {
    	
    	if(head == null)
    	{
    		head = new Node<E>(x, null, null);
    		tail = head;
    		size ++;
    		return true;
    	}
    	    	
        head.prev  = new Node<E>(x,head.prev,head);
        head = head.prev;
        size++;
        return true;
    }// end addFirst
    
        
     /** 
     * @param element - the value to be find
     * @return True - if found a node in the list containing value as element
     */
    public boolean contains(E element) {
    	  
    	  Node<E> tmp = head;
    	  
    	  while(tmp != null)
    	  {
    		  if (tmp.data.equals(element))
    			  return true;
    		  tmp = tmp.next;
    	  }    	  
    	  return false;    	  
      }
 
 
	/**
	 * get the data stored in the node at given index
	 * @param index -  the data in the node at given index
	 * @return the data in the node at given index
	 * @throws NoSuchElementException if the index is less than 0 or larger than size
	 */
	public E dataAt(int index) {
		if ((index < 0) || (index >= size)) 
   			throw new NoSuchElementException();
		
		return get(index).data;		
	}
	
	/** remove the node at given index
	 * @param index the index of the node to be removed
	 * @return the node to be removed
	 * @throws NoSuchElementException if there is no node at the given index in the list
	 */
	public Node<E> remove(int index)
	{
		if ((index < 0) || (index >= size) || head == null) 
			throw new NoSuchElementException();
		
		
		if(index == 0)
		{
			if (head == tail)
			{				
				tail = null;
				head = null;
			}
			else
			{
				head = head.next;
				head.prev = null;				
			}
			size --;
			return head;
		}
		
		Node<E> cur = get(index);
		
		if(tail == cur)
		{
			tail = cur.prev;
			cur.prev.next = null;
			size --;
			return cur;
		}
		
		cur.prev.next = cur.next;
		cur.next.prev = cur.prev;
		size --;
		return cur;	
	}
    
	/*
	 * ================================   The following functions need to be filled ===================================================
	 */
	/**
     * Add a new node with data as x at the end of the list
     * @param x the element to be added
     * @return true if it is successfully added
     */      
      public boolean addLast(E x) {
      	
    	// TODO: please fill your code here. 
    	 
    	  if(head==null) {
    		  return this.addFirst(x);
    	  }
    	  

    	  else{
    	  Node<E> added= new Node<E>(x, tail, null);
    	  
    	  tail.next=added;
    	  tail=added;
    	  size++;
    	  return true;}
    	  
    	  
      } 
	
	
	
	
	/**
	 * Adds a new node at a specific index in the list
	 * @param index - the given index
	 * @param elem - the new value to be added in
	 * @throws   NoSuchElementException if the given index is invalid, i.e. less than 0 or larger than the size 
	 */
	public void add(int index, E elem) {
		
		// TODO: please fill your code here.  
		
		if(index<0||index>size)
		{throw new NoSuchElementException();}
		
		else if(head==null||index==0) {
			this.addFirst(elem);
		}
		
		else if(index==size) {
			this.addLast(elem);
		}
		
		else {
		Node<E> temp= this.get(index);
		
		Node<E> added =new Node<E>(elem, temp.prev, temp);
		
		temp.prev.next=added;
		temp.prev=added;
		
		size++;}
	}
		
	/**
	 * set value of the node at a given index in the list
	 * @param  index  the index of the node with value to set
	 * @param  elem  the new value 
	 * @return true if value of the node is successfully changed
	 * @throws       NoSuchElementException if there is no node at the given index in the list
	 */
	public boolean set(int index, E elem)
	{
		// TODO: please fill your code here.  
		
		if(this.get(index)==null) {
			throw new NoSuchElementException();
		}
		
		else if(index==0) {
		
			Node<E> added= new Node<E>(elem, null, head.next);
			head=added;
			return true;
		}
		
		else if(index==size){
			Node<E> added= new Node<E>(elem, tail.prev, null);
			tail=added;
			
			return true;
		}
		
		else {
			Node<E> temp=this.get(index);
			Node<E> added= new Node<E>(elem, temp.prev, temp.next);
			
			temp.prev.next=added;
			temp.prev=added;
			
			return true;
			
		}	
				
	}
	
 /* ============================================================================================*/
	private static class Node<E> {
        E data;
        Node<E> next;
        Node<E> prev;
        
        Node() {}
        
        Node(E data, Node<E> previous, Node<E> next) {
            this.data = data;
            this.prev = previous;
            this.next = next;
        }// end constructor
                
    }// end class
    
  
    
} // end MyDoubleLinkedList
