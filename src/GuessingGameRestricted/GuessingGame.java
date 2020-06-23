package GuessingGameRestricted;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import DataStructures.BinaryTree;
import DataStructures.BinaryTreeNode;
import GuessingGameUnrestricted.SportsFileReader;

/**
 * This class contains the methods that run the guessing game restricted version
 * @author Amrita Reddy
 *
 */
public class GuessingGame extends JPanel implements ActionListener {

	// Creates an instance of the reader 
	private SportsFileReader reader; 


	private BinaryTree<String> tree ; 
	private BinaryTreeNode<String> node ; 

	// JButtons 
	private JButton yes; 
	private JButton no; 
	private JButton newGame; 

	// Jlabel to store the question 
	private JLabel question; 

	/**
	 * The Constructors creates the layout and adds panels the the main panel 
	 * @throws ParserConfigurationException
	 */
	public GuessingGame () throws ParserConfigurationException {
		super(new BorderLayout()); 

		try {
			//Sets up XML Document
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			File xmlFile = new File( "sports.xml" );
			Document document = builder.parse( xmlFile );

			// Creates a tree from the xml file 
			reader = new SportsFileReader(); 
			tree = reader.getTree(document);

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


		// Adds panels to the main panel 
		add(Instructions(), BorderLayout.NORTH); 
		add(Buttons(), BorderLayout.SOUTH); 
		add(Question(), BorderLayout.CENTER); 

	}

	/**
	 * A panel that holds the instructions 
	 * @return a panel 
	 */

	private JPanel Instructions() {

		JPanel Instructions = new JPanel(new BorderLayout()); 

		// Creates labels that hold the instructions and adds them to the panel Instructions 
		JLabel instructions = new JLabel ("Pick one of the options from below and play the game to see if it is right:");
		Instructions.add(instructions, BorderLayout.NORTH); 

		JLabel options = new JLabel ("Soccer, Field Hockey, Basketball, Tennis, Gymnastics, Skiing, Snowboarding, Ice-Skating, "); 
		Instructions.add(options, BorderLayout.CENTER); 

		JLabel moreOptions = new JLabel ("Ice Hockey, Diving,"
				+ " Swimming, Archery, Fencing, Golf, Baseball, Cricket and Volleyball"); 
		Instructions.add(moreOptions, BorderLayout.SOUTH);

		return Instructions; 
	}
	

	/**
	 * A panel that holds the buttons 
	 * @return
	 */
	private JPanel Buttons() {

		JPanel Buttons = new JPanel (new GridLayout(1,3));

		// Creates the buttons and sets their color 
		yes = new JButton ("Yes"); 
		yes.setBackground(Color.GREEN); 
		yes.setOpaque(true); 
		yes.setBorderPainted(false); 
		yes.addActionListener(this); 

		no = new JButton ("No"); 
		no.setBackground(Color.RED); 
		no.setOpaque(true); 
		no.setBorderPainted(false);
		no.addActionListener(this);

		newGame = new JButton ("New Game"); 
		newGame.setBackground(Color.YELLOW); 
		newGame.setOpaque(true); 
		newGame.setBorderPainted(false);
		newGame.addActionListener(this);

		// Adds the buttons to the panel 
		Buttons.add(yes); 
		Buttons.add(no);
		Buttons.add(newGame);

		return Buttons; 


	}
	/**
	 * Creates a JLabel 
	 * @return JLabel 
	 */
	private JLabel Question() {

		// Creates a JLabel which returns data from the tree 
		node = tree.getRoot(); 
		question = new JLabel(); 
		question.setText(node.getData().toString()); 
		return question; 

	}

	/**
	 * Determines what happens when the three buttons are pressed 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		// When the yes button is pressed 
		if (e.getSource().equals(yes)){
			// If the left child is not null 
			if (node.getLeftChild() != null) {
				// Sets the node as the left child 
				node = node.getLeftChild(); 
				question.setText(node.getData().toString());
			}

		}
		// when the no button is pressed 
		else if (e.getSource().equals(no)) {
			if (node.getRightChild() != null) {
				// If the right child is not null, the node is now the the right child 
				node = node.getRightChild(); 
				question.setText(node.getData().toString());
			}
		}
		// when the new game button is pressed, the node is set to the root again
		else if (e.getSource().equals(newGame)) {
			node = tree.getRoot(); 
			question.setText(node.getData().toString());
		}
	}


}

