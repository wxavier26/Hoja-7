/*Algoritmos y Esctructuras de Datos
 *BinaryHeap
 *Xavier Cifuentes -13316 
 *Pablo de leon - 13227
 */


/**
 * CSE 373, Winter 2011, Jessica Miller
 * An interface that defines the operations for a PrioityQueue ADT for any type.
 */

public interface PriorityQueue<E> {
	
	    /** 
	     * Adds a value to the priority queue.
	     */      
	    public void add(E value);

	    /** 
	     * Tests if the priority queue is empty.
	     */       
	    public boolean isEmpty();
	    
	    /**
	     * Returns, but does not delete the element at the top of the priority
	     * queue.
	     * @return the element at the top of the priority queue
	     * @throws IllegalStateException if priority queue is empty
	     */     
	    public E peek();

	    /**
	     * Deletes and  the element at the top of the priority queue.
	     * @throws IllegalStateException if priority queue is empty
	     */       
	    public void remove();
}

