/**
 * @author Tulasi K Paradarami
 * 
 * Give a linear time non-recursive function that reverses a singly linked list. The
 * function should use no more than constant storage beyond that needed for 
 * the list itself.
 * 
 */

public class ReverseLinkedList<T> {

	private LinkedListNode<T> node;
	
	public ReverseLinkedList(LinkedListNode<T> root) {
		this.node = root;
	}
	
	public LinkedListNode<T> reverseList() {
		LinkedListNode<T> currentNode = node;
		LinkedListNode<T> prevNode = null;
		LinkedListNode<T> nextNode = null;		

		do {
			nextNode = currentNode.getNext();			
			currentNode.setNext(prevNode);
			prevNode = currentNode;
			currentNode = nextNode;			
			
		} while (currentNode.getNext() != null);
		
		currentNode.setNext(prevNode);
		
		return currentNode;
	}
	
}
