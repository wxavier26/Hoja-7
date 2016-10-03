/*Algoritmos y Esctructuras de Datos
 *BinaryHeap
 *Xavier Cifuentes -13316 
 *Pablo de leon - 13227
 */


/**
 * CSE 373, Winter 2011, Jessica Miller
 * The BinaryHeap is an -generic- implementation of the PriorityQueue interface.  
 * This is a binary min-heap implementation of the priority queue ADT.
 * http://courses.cs.washington.edu/courses/cse373/11wi/homework/5/BinaryHeap.java
 */
import java.util.*;

public class BinaryHeap<E extends Comparable<E>> implements PriorityQueue<E> {
 
    protected Vector<E> array;
    protected int size;
    
    /**
     * Constructs a new BinaryHeap.
     */

	public BinaryHeap () {
        array = new Vector<E>();  
        size = 0;
    }
   
    
	public Vector<E> getAll(){
		return array;
	}
	
	public void setAll(Vector<E> newArray){
		this.array = newArray;
	}
	
    public E get(int index) {
		return array.get(index);
	}

    
	public void add(E value){
		size++;
		array.add(value);
	}
	
	public void add(int i, E value){
		size++;
		array.add(i, value);
	}
    
    public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	/**
     * Adds a value to the min-heap.
     */
    public void addOrdered(E value) {       
        E object;
        array.add(0, value);
        for (int i = 1; i<=size; i++){
	        object = array.get(i);
	        if ( object.compareTo(value)== 1){
	        	swap(array.indexOf(value), i );
	        }
	    }
        
        size++;
    }
    
    
    /**
     * Returns true if the heap has no elements; false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    
    /**
     * Returns (but does not remove) the minimum element in the heap.
     */
    public E peek() {
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }
        
        return array.get(0);
    }

    
    /**
     * Removes and returns the minimum element in the heap.
     */
    public void remove() {
    	
    	array.remove(0);
    	
    	// get rid of the last leaf/decrement
    	size--;    	

    }
    
    
    /**
     * Returns a String representation of BinaryHeap with values stored with 
     * heap structure and order properties.
     */
    public String toString() {
        return array.toString();
    }    
    
    protected boolean hasParent(int i) {
        return i < size-1;
    }
    
    
    protected int leftIndex(int i) {
    	return i -1;
    }
    
    
    protected int rightIndex(int i) {
        return (i-2);
    }
    
    
    protected boolean hasLeftChild(int i) {
        return leftIndex(i) <= size && leftIndex(i)>=0;
    }
    
    
    protected boolean hasRightChild(int i) {
        return rightIndex(i) <= size && rightIndex(i)>=0;
    }
    
    
    protected E parent(int i) {
        return array.get(parentIndex(i));
    }
    
    
    protected int parentIndex(int i) {
        if (i==size-1) return size-1;
        else return i/2 +2 + i/2;
    }  
    
    protected void swap(int index1, int index2) {
        E tmp = array.get(index1);
        array.set(index1, array.get(index2));
        array.set(index2,tmp);        
    }
    
    protected E getLast(){
		return array.get(size-1);
    }
    
    protected void removeAll(){
    	array.removeAllElements();
    	size =0;
    }
    
}