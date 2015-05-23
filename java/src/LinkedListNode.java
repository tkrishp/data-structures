public class LinkedListNode<T> {
	private T data;
	private LinkedListNode<T> next;

	public LinkedListNode() {
		data = null;
		next = null;
	}

	public LinkedListNode(T data) {
		this.data = data;
		next = null;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public LinkedListNode<T> getNext() {
		return next;
	}

	public void setNext(LinkedListNode<T> next) {
		this.next = next;
	}
	
	public String toString() {
		return data.toString();
	}
}
