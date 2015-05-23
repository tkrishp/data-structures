import java.util.HashMap;

public class NonCyclicOverlappingLists<T> {

	private LinkedListNode<T> node1;
	private LinkedListNode<T> node2;
	private HashMap<LinkedListNode<T>, Integer> hashNodes;
	
	public NonCyclicOverlappingLists(LinkedListNode<T> node1, LinkedListNode<T> node2) {
		this.node1 = node1;
		this.node2 = node2;
		this.hashNodes = new  HashMap<LinkedListNode<T>, Integer>();
	}
	
	public void initializeHash() {		
		LinkedListNode<T> currentNode = node1;

		while(currentNode.getNext() != null) {
			hashNodes.put(currentNode, 1);
			currentNode = currentNode.getNext();
		}		
	}
	
	public LinkedListNode<T> getEarliestOverlappingNode() {
		LinkedListNode<T> currentNode = node2;
		
		do {
			if (hashNodes.containsKey(currentNode)) {
				return currentNode;
			}
			
			currentNode = currentNode.getNext();
			
		} while (currentNode.getNext() != null);
		
		return null;
	}
	
}
