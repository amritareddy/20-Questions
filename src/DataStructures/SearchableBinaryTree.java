package DataStructures;

/**
 * Creates the methods required to create a basic binary search tree
 * @author Amrita Reddy 
 *
 * @param <T>
 */
public class SearchableBinaryTree<T extends Comparable<T>> extends
DefaultBinaryTree<T> implements BinarySearchTree<T> {


	/**
	 * Inserts the data into the tree by calling the recursive method insert 
	 * @param data data to be inserted 
	 */
	public void insert(T data){
		if (root == null){
			DefaultBinaryTreeNode<T> n = new DefaultBinaryTreeNode<T>();
			n.setData(data);
			root = n; 
		}
		inserts (data, root); 


	}
	/**
	 * Inserts the data 
	 * @param data the data to be inserted
	 * @param node the node at which to start comparing 
	 */
	private void inserts (T data, BinaryTreeNode<T> node) {
		// If the data to be inserted is less than the node when compared 	
		if (data.compareTo(node.getData()) < 0){
			// If the left child is null it sets the data to the left child 	
			if (node.getLeftChild() == null){	
				DefaultBinaryTreeNode<T> n = new DefaultBinaryTreeNode<T>(); 
				n.setData(data); 
				node.setLeftChild(n); 
			}
			// Else it calls itself on the leftChild 
			inserts(data, node.getLeftChild()); 

		}
		// If the data to be inserted is greater than the node when compared 	

		else if (data.compareTo(node.getData()) > 0){
			// If the right child is null it sets the data to the right child 	

			if (node.getRightChild() == null){
				DefaultBinaryTreeNode<T> n = new DefaultBinaryTreeNode<T>(); 
				n.setData(data); 
				node.setRightChild(n); 
			}
			// Else it calls itself on the right child 
			inserts(data, node.getRightChild()); 
		}


	}
	/**
	 * Calls the recursive method search on the root of a tree 
	 * @param data the data to be found within the tree
	 */
	@Override
	public BinaryTreeNode<T> search(T data) {

		return search (data, root); 
	}
	/**
	 * Searches a tree for some data. Returns null if the data is not found else returns 
	 * the node at while the data is found 
	 * @return node at which data is found or null 
	 * @param data the data to be found 
	 * @param node the node at which the method starts comparing 
	 */
	public BinaryTreeNode<T> search(T data, BinaryTreeNode<T> node) {
		// If the node is empty it returns null 
		if (node == null){
			return null; 
		}
		else{
			// if data is equal to the data found at the node it returns the node 
			if (data.compareTo(node.getData()) == 0){
				return node; 
			}
			// If data is less than what is found at the node it calls this method on the left child 
			else if (data.compareTo(node.getData()) < 0){
				return search(data, node.getLeftChild());
			} 
			else {
				// If data is greater than what is found at the node it calls this method on the right child 
				return search(data, node.getRightChild()); 
			}

		}
	}




	/**
	 * Finds the minimum element in a tree 
	 */
	@Override
	public T minElement() {
		// returns null if the root is null 
		if (root == null) {

			return null; 

		}

		else {

			BinaryTreeNode<T> current = root; 
			// while the left child of the node is not null it continues to update current
			while (current.getLeftChild() != null) {

				current = current.getLeftChild(); 

			}
			// returns the data of the left child that is does not contain a left child and hence is the minimum element
			return (T) current.getData(); 



		}


	}
	/**
	 * Finds the maximum element in a tree 
	 */
	@Override
	public T maxElement() {
		// returns null if root is null 
		if (root == null) {

			return null; 

		}

		else {
			// while the right child of the node is not null it continues to update current

			BinaryTreeNode<T> current = root; 

			while (current.getRightChild() != null) {

				current = current.getRightChild(); 

			}
			// returns the data of the  right child that is does not contain a right child and hence is the minimum element

			return (T) current.getData(); 



		}
	}

}
