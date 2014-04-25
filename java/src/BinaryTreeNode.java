public class BinaryTreeNode<T> {
	T data;
	boolean visited;
	BinaryTreeNode left;
	BinaryTreeNode right;

	public BinaryTreeNode(T data) {
		this.data = data;
		this.left = null;
		this.right = null;
		this.visited = false;
	}

	public BinaryTreeNode(T data, BinaryTreeNode left) {
		this.data = data;
		this.left = left;
		this.right = null;
		this.visited = false;
	}

	public BinaryTreeNode(T data, BinaryTreeNode left, BinaryTreeNode right) {
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

	public void setData(T data, BinaryTreeNode left) {
		this.data = data;
		this.left = left;
		this.right = null;
	}

	public void setData(T data, BinaryTreeNode left, BinaryTreeNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public T getData() {
		return data;
	}

	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}

	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}

	public BinaryTreeNode getLeft() {
		return left;
	}

	public BinaryTreeNode getRight() {
		return right;
	}

}