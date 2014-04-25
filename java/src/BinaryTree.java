public class BinaryTree<T extends Comparable<T>> {
	private BinaryTreeNode<T> root;

	public BinaryTreeNode<T> getRoot() {
		return root;
	}

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
