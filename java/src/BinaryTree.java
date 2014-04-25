/**
 * @author Tulasi K Paradarami
 * Implementation of binary search tree. The tree can be implemented by adding
 * nodes of any data-type
 * 
 * Methods supported:
 * 	dfs(node): Accepts a node parameter and performs depth-first search
 * 			from that node.
 * 	add(node): Add a node to the tree
 * 	delete(node): Deletes a node from the tree
 * 	search(node): Search for a node in the tree; return true if found, false otherwise
 *  
 * @param <T>
 */

public class BinaryTree<T extends Comparable<T>> {
	/*
	 * Node variable for the root
	 */
	private BinaryTreeNode<T> root;

	/*
	 * Return the root node
	 */
	public BinaryTreeNode<T> getRoot() {
		return root;
	}
	
	/*
	 * Perform depth-first search on the binary tree
	 * Prints the nodes as they are visited
	 * A node is considered visited, when all its children are visited
	 * or if it is a leaf node
	 * 
	 */
	@SuppressWarnings({ "unchecked" })
	public void dfs(BinaryTreeNode<T> currRoot) {
		BinaryTreeNode<T> currentNode = currRoot;

		if (currentNode.getLeft() == null) {
			if (currentNode.getRight() == null) {
				currentNode.setVisited(true);
				System.out.println("Visited node: " + currentNode.getData());
				return;
			}
		}

		if (currentNode.getLeft() != null) dfs(currentNode.getLeft());
		if (currentNode.getRight() != null) dfs(currentNode.getRight());

		currentNode.setVisited(true);
		System.out.println("Visited node: " + currentNode.getData());

	}


	/*
	 * Add a node to the binary search tree
	 * If the newly added node is less than parent node, it is added to left tree
	 * else it is added to the right tree
	 */
	@SuppressWarnings("unchecked")
	public void add(T data) {

		if (root == null) {
			System.out.println("Adding root:" + data);
			root = new BinaryTreeNode<T>(data);
		}
		else {
			System.out.println("Adding new node:" + data);
			BinaryTreeNode<T> currentNode = root;
			BinaryTreeNode<T> nodeToAdd = new BinaryTreeNode<T>(data);

			while (true) {
				if (data == currentNode.getData()) {
					break;
				}
				System.out.println("Current node is [" + currentNode.getData() + "]");
				if (data.compareTo(currentNode.getData()) < 0) {
					if (currentNode.getLeft() == null) {
						System.out.println("Reached last node:" + currentNode.getData());
						currentNode.setLeft(nodeToAdd);
						System.out.println("Adding to the left of " + currentNode.getData() + ":" + nodeToAdd.getData());
						break;
					}
					currentNode = currentNode.getLeft();
				}
				else {
					if (currentNode.getRight() == null) {
						System.out.println("Reached last node:" + currentNode.getData());
						currentNode.setRight(nodeToAdd);
						System.out.println("Adding to the right of " + currentNode.getData() + ":" + nodeToAdd.getData());
						break;
					}
					currentNode = currentNode.getRight();
				}
			}
		}
	}

	/*
	 * Delete a node from the binary search tree
	 * When a node is deleted, all the children node will be deleted too
	 * Root node cannot be deleted
	 */
	@SuppressWarnings("unchecked")
	public void delete(T data) {
		BinaryTreeNode<T> currentNode = root;
		BinaryTreeNode<T> parent = root;
		boolean isLeft = false;
		boolean isRight = false;

		if (root.getData() == data) {
			System.out.println("Cannot delete root; Use deleteRoot() method");
			return;
		}

		while(true) {
			if (data == currentNode.getData()) {
				if (isLeft) {
					parent.setLeft(null);
				}
				else if (isRight) {
					parent.setRight(null);
				}
				break;
			}
			else if (data.compareTo(currentNode.getData()) < 0) {
				if (currentNode.getLeft() == null) {
					break;
				}

				parent = currentNode;
				currentNode = currentNode.getLeft();
				isLeft = true;
			}
			else {
				if (currentNode.getRight() == null) {
					break;
				}

				parent = currentNode;
				currentNode = currentNode.getRight();
				isRight = true;
			}

		}

		return;
	}

	/*
	 * Search for node in the binary search tree
	 * If the node is found, return true
	 * false otherwise
	 */
	@SuppressWarnings("unchecked")
	public boolean search(T data) {
		boolean isFound = false;
		BinaryTreeNode<T> currentNode = root;

		while (true) {
			if (data == currentNode.getData()) {
				isFound = true;
				break;
			}
			else if (data.compareTo(currentNode.getData()) < 0) {
				if (currentNode.getLeft() == null) {
					System.out.println("'" + data + "' not found in the tree");
					break;
				}
				currentNode = currentNode.getLeft();
			}
			else {
				if (currentNode.getRight() == null) {
					System.out.println("'" + data + "' not found in the tree");
					break;
				}
				currentNode = currentNode.getRight();
			}
		}

		return isFound;
	}
}
