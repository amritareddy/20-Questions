package DataStructures;
//import java.util.LinkedList;
/**
 * 
 * Creates methods to create a binary tree 
 * @author Amrita Reddy 
 *
 * @param <T>
 */
public class DefaultBinaryTree<T> implements BinaryTree<T>{
	protected DefaultBinaryTreeNode<T> root; 

	/**
	 * The main method creates a tree of type string and calls preorder, postorder
	 * and inorder on the tree 
	 * @param args
	 */
	public static void main (String[] args){
		DefaultBinaryTree<String> dwarves = new DefaultBinaryTree<String>(); 

		DefaultBinaryTreeNode<String> happy = new DefaultBinaryTreeNode<String>(); 
		happy.setData("Happy"); 
		DefaultBinaryTreeNode<String> doc = new DefaultBinaryTreeNode<String>(); 
		doc.setData("Doc"); 
		DefaultBinaryTreeNode<String> bashful = new DefaultBinaryTreeNode<String>(); 
		bashful.setData("Bashful"); 
		DefaultBinaryTreeNode<String> grumpy = new DefaultBinaryTreeNode<String>(); 
		grumpy.setData("Grumpy"); 
		DefaultBinaryTreeNode<String> dopey = new DefaultBinaryTreeNode<String>(); 
		dopey.setData("Dopey"); 
		DefaultBinaryTreeNode<String> sleepy = new DefaultBinaryTreeNode<String>(); 
		sleepy.setData("Sleepy"); 
		DefaultBinaryTreeNode<String> sneezy = new DefaultBinaryTreeNode<String>(); 
		sneezy.setData("Sneezy"); 

		dwarves.setRoot(happy); 
		happy.setLeftChild(doc);
		doc.setLeftChild(bashful); 
		doc.setRightChild(grumpy);
		grumpy.setRightChild(dopey); 
		happy.setRightChild(sleepy);
		sleepy.setRightChild(sneezy); 


		dwarves.preorderTraversal(); 
		dwarves.inorderTraversal(); 
		dwarves.postorderTraversal(); 


	}
	/**
	 * Returns the root of the tree 
	 * @return root 
	 */
	@Override
	public BinaryTreeNode<T> getRoot() {
		return root; 
	}
	/**
	 * Sets the root of the tree 
	 */
	@Override
	public void setRoot(BinaryTreeNode<T> root) {
		this.root = (DefaultBinaryTreeNode<T>) root; 

	}
	/**
	 * Checks to see if the tree is empty and returns null if the root is empty 
	 * @return is tree empty 
	 */
	@Override
	public boolean isEmpty() {
		if (root == null ){
			return true;
		}
		return false; 
	}
	/**
	 * Calls on the recursive method inorderTraversal 
	 * @return a linkedlist with the ordered tree
	 */
	@Override
	public LinkedList<T> inorderTraversal() {
		LinkedList<T> inOrder = new LinkedList<T>(); 
		inordTraversal(root, inOrder);
		System.out.println(inOrder); 
		return inOrder; 
	}
	/**
	 * Orders the tree inOrder 
	 * @param node node at which it begins to order 
	 * @param traversal linkedlist in which the ordered tree data is placed 
	 */
	private void inordTraversal(BinaryTreeNode<T> node, LinkedList <T> traversal){
		if (node != null){

			// Recur on left 
			inordTraversal(node.getLeftChild(), traversal); 


			// Adds node to list 
			traversal.add(traversal.size(), node.getData()); 



			// Recur on Right 
			inordTraversal(node.getRightChild(), traversal); 

		}


	}
	/**
	 * calls the recursive method preord 
	 * @return a linkedlist of the tree in preorder
	 */
	@Override
	public LinkedList<T> preorderTraversal() {
		LinkedList<T> preOrder = new LinkedList<T>(); 
		preordTraversal(root, preOrder);
		System.out.println(preOrder); 
		return preOrder; 

	}
	/**
	 * Orders the tree in preOrder
	 * @param node node at which it begins to order 
	 * @param traversal linkedlist in which the ordered tree data is placed 
	 */
	private void preordTraversal(BinaryTreeNode<T> node, LinkedList <T> traversal){
		if (node != null){

			// add node to list
			traversal.add(traversal.size(), node.getData()); 

			// recurse on left 
			preordTraversal(node.getLeftChild(), traversal);

			// recurse on right 
			preordTraversal(node.getRightChild(), traversal); 

		}
	}
	/**
	 * Calls the recursive method postord 
	 * @return linked list of the tree in postorder 
	 */
	@Override
	public LinkedList<T> postorderTraversal() {
		LinkedList<T> postOrder = new LinkedList<T>(); 
		postorderTraversal(root, postOrder);
		System.out.println(postOrder); 
		return postOrder; 

	}
	/**
	 * Orders the tree in post order 
	 * @param node node at which it begins to order 
	 * @param traversal linkedlist in which the ordered tree data is placed 
	 */
	public void postorderTraversal(BinaryTreeNode<T> node,LinkedList <T> traversal){
		if (node != null){

			//Traverse Left
			postorderTraversal(node.getLeftChild(),traversal); 


			// Traverse Right 
			postorderTraversal(node.getRightChild(),traversal); 

			// add node to list  
			traversal.add(traversal.size(), node.getData()); 
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
