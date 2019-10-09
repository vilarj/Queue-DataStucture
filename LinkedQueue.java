package classes;

public class LinkedQueue<T> implements QueueInterface<T> {
	private Node frontNode;
	private Node backNode;

	public LinkedQueue () {
		frontNode = null;
		backNode = null;
	}

	@Override
	public void enqueue (T newEntry){
		Node newNode = new Node (newEntry, null);

		if (isEmpty()) 
			frontNode = newNode;     
		else
			backNode.setNext(newNode);
		backNode = newNode;   
	}
	
	@Override
	public T dequeue() {
		T front = getFront(); 
		assert frontNode != null;
		frontNode.setData(null);
		frontNode = frontNode.getNext();

		if (frontNode == null)
			backNode = null;
		return front;	
	}

	@Override
	public boolean isEmpty() {
		return frontNode == null;
	}

	@Override
	public void clear() {
		if(!isEmpty()) {
			frontNode = null;
			backNode = null;
		}
	}

	@Override
	public T getFront() {
		if (isEmpty())
			throw new EmptyQueueException();
		else
			return frontNode.getData();
	} 

	private class Node {
		private T data;
		private Node next;

		public Node(T data, Node next) {this.data = data;this.next = next;}
		public T getData() {return data;}
		public void setData(T data) {this.data = data;}
		public Node getNext() {return next;}
		public void setNext(Node next) {this.next = next;}
	}
}
	