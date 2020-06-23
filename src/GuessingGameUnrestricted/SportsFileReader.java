package GuessingGameUnrestricted;
import javax.xml.parsers.*;
import org.xml.sax.SAXException;

import DataStructures.BinaryTreeNode;
import DataStructures.DefaultBinaryTree;
import DataStructures.DefaultBinaryTreeNode;

import org.w3c.dom.*;
import java.io.*;

/**
 * This class translates the sports XML file into a format that can be used by Java 
 * @author Amrita Reddy
 *
 */
public class SportsFileReader {

	// Creates a binary tree
	private static DefaultBinaryTree<String> tree;


	/**
	 * Converts the xml into a document and calls the parse method
	 * @param args
	 */
	public static void main (String args[]){

		try {
			//Sets up XML Document
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			File xmlFile = new File( "sports.xml" );
			Document document = builder.parse( xmlFile );

			// Calls parseSportsFile 
			parseSportFile(document); 

		}
		catch (ParserConfigurationException pce) {
			//what to do if this exception happens
			System.err.println("ParserConfigurationException: " + pce.getMessage());
		} catch (SAXException saxe) {
			//what to do if this exception happens
			System.err.println("SAXException: " + saxe.getMessage());
		} catch (IOException ioe) {
			//what to do if this exception happens
			System.err.println("IOException: " + ioe.getMessage());
		}



	}

	/**
	 * Gets the data from the xml doc and calls parse node 
	 * @param document the xml 
	 */
	private static DefaultBinaryTree<String> parseSportFile( Document document ){
		// Creates a tree
		tree = new DefaultBinaryTree<String>();
		// Gets the root element of the xml
		Element docRoot =  document.getDocumentElement();
		// Sets the root of the tree as the root element of the xml
		tree.setRoot(parseNode(docRoot));
		// Returns the tree
		return tree; 

	}

	/**
	 * Parse node calls on all the nodes in the document as well as all the nodes that a particular node has 
	 * @param n root node of the document 
	 */

	private static DefaultBinaryTreeNode<String> parseNode(Element n) {

		// If the node is a question it executes the following 
		if( n.getTagName().equals("question") ) {
			// Creates a new node 
			DefaultBinaryTreeNode<String> sport = new DefaultBinaryTreeNode<String>();
			// Sets the data of the node to the id of the element, which is the question itself
			sport.setData(n.getAttribute("id"));

			// If the element has children nodes 
			if (n.hasChildNodes()) {
				// stores them in a linked list 
				NodeList childrenOfNode= n.getChildNodes();
				// It runs through the list determining whether the child nodes are of type yes or not 
				for (int i = 0; i < childrenOfNode.getLength(); i++) {
					if(childrenOfNode.item(i) instanceof Element) {
						Element childrenElement = (Element) childrenOfNode.item(i);
						if(childrenElement.getAttribute("a").equals ("yes")) {
							// If they are of type yes it calls the parsing method answerNode on the leftChild
							sport.setLeftChild(answerNode(childrenElement));

						} else {
							// If they are not of type yes it calls the parsing method answerNode on the rightChild
							sport.setRightChild(answerNode(childrenElement));
						}


					}
				}
			}
			return sport;
		}
		return null;

	}

	/**
	 * This method parses the answers 
	 * @param n element of xml
	 * @return
	 */
	private static BinaryTreeNode<String> answerNode(Element n) {
		// Creates a node that stores the leaf node 
		DefaultBinaryTreeNode<String> leaf = new DefaultBinaryTreeNode<String>();
		// If the element is yes or no 
		if( n.getTagName().equals("a_yes") || n.getTagName().equals("a_no")) {
			// If it has children 
			if (n.hasChildNodes()) {
				// stores the children in a list 
				NodeList childrenOfNode= n.getChildNodes();
				// Runs through the list
				for (int i = 0; i < childrenOfNode.getLength(); i++) {
					if(childrenOfNode.item(i) instanceof Element) {
						Element childrenElement = (Element) childrenOfNode.item(i);
						// If its a guess(leaf) it sets the data as the text of the guess
						if(childrenElement.getTagName().equals("guess")) {
							leaf.setData(childrenElement.getAttribute("text"));

						} else {
							// Else it calls parse node on the element 
							leaf = parseNode(childrenElement); 
						}


					}
				}
			}
		}
		return leaf;

	}

	/**
	 * This method returns a parsed tree 
	 * @param d document 
	 * @return a binary tree
	 */
	public DefaultBinaryTree<String> getTree(Document d){

		DefaultBinaryTree<String> sportTree = new DefaultBinaryTree<String>(); 
		sportTree = parseSportFile(d); 

		return sportTree;


	}

}


