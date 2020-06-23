package DataStructures;
/**
 * 
 * This class implements the interface class and lets you add, delete, determine the size of and perform other functions on a linked list 
 * @author AmritaReddy
 *
 * @param <T>
 */
public class LinkedList<T> implements List<T> {
	public LinkedListNode<T> head; 
	/**
	 * Helper method to access the node at index. 
	 * If the index is invalid (negative or >= size of list), return null pointer.
	 **/
	private LinkedListNode<T> getNode( int index ) {

		LinkedListNode<T> tempNode = head; 

		if (index < 0 || index >= size()) {
			tempNode = null; 
		}

		else {

			int count = 0; 

			while (count < index ) {
				tempNode = tempNode.getNext(); 
				count++; 

			}

		}
		return tempNode; 
	}

	/**
	 * This method lets you add a node at a specific index. 
	 */
	@Override
	public void add(int index, T data) {


		LinkedListNode<T> node = new LinkedListNode<T>(); 
		node.setData(data);

		if (index == 0) {
			node.setNext(head); 
			head = node; 
		}

		else {

			int count = 0; 
			LinkedListNode<T> tempNode = head; 

			while (count < index-1) {
				tempNode = tempNode.getNext(); 
				count++; 
			}
			node.setNext(tempNode.getNext());
			tempNode.setNext(node);



		}



	}


	/**
	 * This method returns the data at a particular node in a linkedlist 
	 */
	@Override
	public T get(int index) {
		if (index < 0 || index > size())	 {
			return null; 
		}
		return getNode(index).getData(); 

	}

	/**
	 * This method lets you delete a node at a particular index in a linkedlist 
	 */
	@Override
	public void delete(int index) {



		getNode(index); 

		if (index ==0){
			head = getNode(index+1); 
		}

		else {
			LinkedListNode<T> prev = getNode(index - 1); 
			LinkedListNode<T> next = getNode(index + 1); 

			prev.setNext(next);

		}

	}
	/**
	 * Returns the size 
	 */
	@Override
	public int size() {
		LinkedListNode<T> tempNode = head; 
		int count = 0; 

		while (tempNode != null){
			tempNode = tempNode.getNext(); 
			count++; 

		}

		return count; 
	}
	/**
	 * This method returns true if the linkedlist is empty 
	 */
	@Override
	public boolean isEmpty() {

		if (head == null){
			return true; 
		}
		return false; 
	}
	/**
	 * This method returns the data found in the nodes of the linkedlists as string 
	 */
	public String toString() {

		LinkedListNode<T> tempNode = head; 
		String string = ""; 

		for (int i = 0; i < size(); i++ ) {

			if (tempNode.getNext() != head) 
				string = string + tempNode.getData();
			tempNode = tempNode.getNext(); 


		}
		return string; 
	}
	
	public LinkedListNode<T> getFirstNode(){
		if (!isEmpty()) {
			return head;
		}
		return null;
	}

}
