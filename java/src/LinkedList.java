public class LinkedList<T extends Comparable<T>> {

	private LinkedListNode<T> first;
	private LinkedListNode<T> last;
	private int size = 0;

	public int getSize() {
		return size;
	}
	
	public void append(T data) {
		LinkedListNode<T> node = new LinkedListNode<T>(data);

		if (size == 0) {
			this.first = node;
			this.last = node;
		}
		else {
			this.last.setNext(node);
			this.last = node;
		}

		this.size++;
	}
	
	public void append(LinkedListNode<T> node) {

		if (size == 0) {
			this.first = node;
			this.last = node;
		}
		else {
			this.last.setNext(node);
			this.last = node;
		}

		this.size++;
	}

	public void add(T data, int index) {
		
		LinkedListNode<T> addNode = new LinkedListNode<T>(data);
		
		if ((size > 0 && index > (size - 1)) || index < 0) {
			return;
		}
		
		if (size == 0) {
			System.out.println("adding root node");
			this.first = addNode;
			this.last = addNode;
		}
		else {
			LinkedListNode<T> node = this.first;
			
			for (int i= 0; i < (index - 1); i++) {
				node = node.getNext();
			}
	
			addNode.setNext(node.getNext());
			node.setNext(addNode);
		}
		
		this.size++;

		return;
	}
	
	public void add(LinkedListNode<T> newNode, int index) {
		
		LinkedListNode<T> node = this.first;
		
		System.out.println("size: " + size + ", index: " + index);
		if ((size > 0 && index > size) || index < 0) {
			return;
		}
		System.out.println("Im here");
		if (size == 0) {
			System.out.println("adding root node");
			this.first = newNode;
			this.last = newNode;
		}
		else {
			
			for (int i= 0; i < (index - 1); i++) {
				node = node.getNext();
			}
	
			newNode.setNext(node.getNext());
			node.setNext(newNode);
		}
		
		this.size++;

		return;
	}

	public LinkedListNode<T> removeAtIndex(int index) {
		LinkedListNode<T> priorToRemoveNode = this.first;
		LinkedListNode<T> nodeToRemove = new LinkedListNode<T>();

		if ((size > 0 && index > (size - 1)) || index < 0) {
			return new LinkedListNode<T>();
		}

		for (int i = 1; i < index; i++) {
			priorToRemoveNode = priorToRemoveNode.getNext();
		}

		if (index == (size - 1)) {
			nodeToRemove = this.last;
			priorToRemoveNode.setNext(null);
			this.last = priorToRemoveNode;
		}
		else if (index == 0) {
			nodeToRemove = this.first;
			this.first = priorToRemoveNode.getNext();
		}
		else {
			nodeToRemove = priorToRemoveNode.getNext();
			priorToRemoveNode.setNext((priorToRemoveNode.getNext()).getNext());
		}

		this.size--;

		return nodeToRemove;
	}
	
	public LinkedListNode<T> getNode(int index) {
		LinkedListNode<T> node = this.first;
		
		if ((size > 0 && index > (size - 1)) || index < 0) {
			return null;
		}

		for (int i = 0; i < index; i++) {
			node = node.getNext();
		}

		return node;
	}

	public T getData(int index) {
		LinkedListNode<T> node = this.first;

		if ((size > 0 && index > (size - 1)) || index < 0) {
			T obj = null;
			return obj;
		}

		for (int i = 0; i < index; i++) {
			node = node.getNext();
		}

		return node.getData();
	}

	public LinkedListNode<T> getNextNode(LinkedListNode<T> node) {
		
		LinkedListNode<T> currNode = this.first;
		LinkedListNode<T> retNode = new LinkedListNode<T>();
		
		for (int i = 0; i < size; i++) {
			node = node.getNext();
			
			if (currNode.getData().compareTo(node.getData()) == 0) {
				retNode = currNode.getNext();
			}
		}
		return retNode;
		
	}
	
	public void printLinkedList() {
		LinkedListNode<T> node = this.first;

		System.out.println("Size:" + size);

		for (int i = 0; i < size; i++) {
			System.out.println("Node [" + i + "] is: " + node.toString());
			node = node.getNext();
		}

	}

	public void removeAllNodes() {
		size = 0;
		first = null;
		last = null;
	}
}
