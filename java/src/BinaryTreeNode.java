/**
 * @author Tulasi K Paradarami
 * Implementation of a node class used in binary search tree
 * 
 * Following variables are stored in a node
 * 	Data of the node
 * 	Reference to left tree
 * 	Reference to right tree
 *  	Mark a node as visited when all the children nodes are visited
 *  	or if it is a leaf node
 * @param <T>
 */

public class BinaryTreeNode<T> {
	T data;
	boolean visited;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	/*
	 * Node can be initialized in following ways
	 * data
	 * data & left node
	 * data, left node and right node
	 */
	public BinaryTreeNode(T data) {
		this.data = data;
		this.left = null;
		this.right = null;
		this.visited = false;
	}

	
	public BinaryTreeNode(T data, BinaryTreeNode<T> left) {
		this.data = data;
		this.left = left;
		this.right = null;
		this.visited = false;
	}

	public BinaryTreeNode(T data, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
		this.visited = false;
	}

	public void setVisited(boolean visit) {
		this.visited = visit;
	}

	public boolean getVisited() {
		return visited;
	}

	public void setData(T data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public void setData(T data, BinaryTreeNode<T> left) {
		this.data = data;
		this.left = left;
		this.right = null;
	}

	public void setData(T data, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public T getData() {
		return data;
	}

	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}

	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}

	public BinaryTreeNode<T> getLeft() {
		return left;
	}


	public BinaryTreeNode<T> getRight() {
		return right;
	}

}