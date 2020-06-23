package DataStructures;
/**
 * Creates the methods required to create a binary tree node with left and right children 
 * @author AmritaReddy 
 *
 * @param <T>
 */
public class DefaultBinaryTreeNode<T> implements BinaryTreeNode<T> {

	// Variable to store the data type found in the node 
	private T data; 
	// Variables of type node for left and right child 
	private DefaultBinaryTreeNode<T> leftChild; 
	private DefaultBinaryTreeNode<T> rightChild; 

	/**
	 * Returns the data found at the node 
	 * @return object data 
	 */
	@Override
	public T getData() {
		return data; 
	}

	/**
	 * Sets the data to be stored in this node 
	 */
	@Override
	public void setData(Object data) {
		this.data = (T) data;  

	}
	/**
	 * Returns the left child of the node 
	 */
	@Override
	public BinaryTreeNode<T> getLeftChild() {

		return leftChild; 
	}
	/**
	 * Returns the right child of the node 
	 */
	@Override
	public BinaryTreeNode<T> getRightChild() {
		return rightChild; 
	}
	/**
	 * Sets the left child of the node 
	 */
	@Override
	public void setLeftChild(BinaryTreeNode<T> left) {
		leftChild = (DefaultBinaryTreeNode<T>) left; 

	}

	/**
	 * Sets the right child of the node 
	 */
	@Override
	public void setRightChild(BinaryTreeNode<T> right) {
		rightChild = (DefaultBinaryTreeNode<T>) right; 

	}
	/**
	 * Determines if the node is a leaf by checking to see if it has a left and right child 
	 */
	@Override
	public boolean isLeaf() {
		return (leftChild == null && rightChild == null); 
	}

}
