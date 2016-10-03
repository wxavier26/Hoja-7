/*Algoritmos y Esctructuras de Datos
 *BinaryHeap
 *Xavier Cifuentes -13316 
 *Pablo de leon - 13227
 */

import java.util.*;

/**
 * Generic binary tree, storing data of a parametric data in each node
 *
 * @author Chris Bailey-Kellogg, Dartmouth CS 10, Fall 2012
 * 
 * http://www.cs.dartmouth.edu/~cbk/10/notes/7/code/BinaryTree.java
 */

public class BinaryTree<E extends Comparable<E>> implements Comparable<BinaryTree<E>> {
	private BinaryTree<E> parent, left, right;	// children; can be null
	E data;

	/**
	 * Constructs leaf node -- left and right are null
	 */
	public BinaryTree(E data) {
		this.data = data; this.parent = null; this.left = null; this.right = null;
	}

	/**
	 * Constructs inner node
	 */
	public BinaryTree(E data, BinaryTree<E> parent, BinaryTree<E> left, BinaryTree<E> right) {
		this.data = data; this.parent = parent; this.left = left; this.right = right;
	}
	
	/**
	 * Constructs inner node
	 */
	public BinaryTree(E data, BinaryTree<E> left, BinaryTree<E> right) {
		this.data = data; this.parent = null; this.left = left; this.right = right;
	}
	

	public BinaryTree<E> getParent() {
		return parent;
	}

	public void setParent(BinaryTree<E> parent) {
		this.parent = parent;
	}

	/**
	 * Is it an inner node?
	 */
	public boolean isInner() {
		return left != null || right != null;
	}

	/**
	 * Is it a leaf node?
	 */
	public boolean isLeaf() {
		return left == null && right == null;
	}

	/**
	 * Does it have a left child?
	 */
	public boolean hasLeft() {
		return left != null;
	}

	/**
	 * Does it have a right child?
	 */
	public boolean hasRight() {
		return right != null;
	}

	/**
	 * Number of nodes (inner and leaf) in tree
	 */
	public int size() {
		int num = 1;
		if (hasLeft()) num += left.size();
		if (hasRight()) num += right.size();
		return num;
	}

	/**
	 * Longest length to a leaf node from here
	 */
	public int height() {
		if (isLeaf()) return 0;
		int h = 0;
		if (hasLeft()) h = Math.max(h, left.height());
		if (hasRight()) h = Math.max(h, right.height());
		return h+1;						// inner: one higher than highest child
	}	

	/**
	 * Same structure and data?
	 */
	public boolean equalsTree(BinaryTree<E> t2) {
		if (hasLeft() != t2.hasLeft() || hasRight() != t2.hasRight()) return false;
		if (!data.equals(t2.data)) return false;
		if (hasLeft() && !left.equalsTree(t2.left)) return false;
		if (hasRight() && !right.equalsTree(t2.right)) return false;
		return true;
	}

	/**
	 * Leaves, in order from left to right
	 */
	public ArrayList<E> fringe() {
		ArrayList<E> f = new ArrayList<E>();
		addToFringe(f);
		return f;
	}

	/**
	 * Helper for fringe, adding fringe data to the list
	 */
	public void addToFringe(ArrayList<E> fringe) {
		if (isLeaf()) {
			fringe.add(data);
		}
		else {
			if (hasLeft()) left.addToFringe(fringe);
			if (hasRight()) right.addToFringe(fringe);
		}
	}

	/**
	 * Returns a string representation of the tree
	 */
	public String toString() {
		return ""+data;
	}

	public int compareTo(BinaryTree<E> o) {
		if ((data).compareTo(o.getValue()) == -1) return -1;
		else if ((data).compareTo(o.getValue()) == 1) return 1;
		else return 0;
	}
	
	public E getValue(){
		return data;
	}
	
	public void setValue(E data){
		this.data = data;
	}

	public BinaryTree<E> getLeft() {
		return left;
	}

	public void setLeft(BinaryTree<E> left) {
		this.left = left;
	}

	public BinaryTree<E> getRight() {
		return right;
	}

	public void setRight(BinaryTree<E> right) {
		this.right = right;
	}

	
}