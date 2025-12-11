package h2;

public class SimpleList {
	Node head;
	
	public SimpleList() {
		head = new Node(Integer.MIN_VALUE);
	}
	
	public Node getFirst() {
		return head.next;
	}
	
	public Node getLast() {
		Node current = head.next;
		if(current == null) {
			return null;
		}
		
		while(current.next != null) {
			current = current.next;
		}
		return current;
	}
	
	public void append(int newValue) {
		Node newNode = new Node(newValue);
		
		if (head.next == null) {
			head.next = newNode;
			return;
		}
		
		Node last = getLast();
		last.next = newNode;
	}
	
	public Node findFirst(int value) {
		Node current = head.next;
		
		while(current != null) {
			if(current.value == value) {
				return current;
			}
			current = current.next;
		}
		return null;
	}
	
	public boolean insertAfter(int preValue, int newValue) {
		Node found = findFirst(preValue);
		if(found == null) {
			return false;
		}
		
		Node newNode = new Node(newValue);
		newNode.next = found.next;
		found.next = newNode;
		return true;
	}
	
	public boolean delete(int value) {
		Node prev = head;
		Node current = head.next;
		
		while (current != null) {
			if (current.value == value) {
				prev.next = current.next;
				return true;
			}
			prev = current;
			current = current.next;
		}
		return false;
	}

}
