package GuessingGameUnrestricted;

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
import javax.swing.JTextField;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import DataStructures.BinaryTree;
import DataStructures.BinaryTreeNode;
import DataStructures.DefaultBinaryTreeNode;

/**
 * This class contains the methods for the unrestricted guessing game 
 * @author Amrita Reddy
 *
 */
public class GuessingGameUnrestricted extends JPanel implements ActionListener {

	// Creates an instance of type SportsFileReader
	private SportsFileReader reader; 


	private BinaryTree<String> tree ; 
	private BinaryTreeNode<String> node ; 

	// JButtons
	private JButton yes; 
	private JButton no; 
	private JButton newGame; 
	private JButton ok; 

	// JLabels 
	private JLabel question; 

	// Textfields 
	private JTextField newThing; 
	private JTextField newQuestion; 
	private JTextField newAnswer; 
	private JPanel popQuestions; 

	// Boolean to determine if the panels containing the textfields is present or not 
	private boolean add = false; 



	/**
	 * The Constructors creates the layout and adds panels the the main panel 
	 * @throws ParserConfigurationException
	 */
	public GuessingGameUnrestricted () throws ParserConfigurationException {
		super(new GridLayout (4, 1)); 

		try {
			//Sets up XML Document
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			File xmlFile = new File( "sports.xml" );
			Document document = builder.parse( xmlFile );


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

		// Calls the method 
		extraQuestions(); 

		//Adds to the main panel
		add(Instructions()); 
		add(Question()); 
		add(Buttons()); 


	}

	/**
	 * A panel that holds the instructions 
	 * @return a panel 
	 */
	private JPanel Instructions() {
		JPanel Instructions = new JPanel(new GridLayout(3,1)); 

		// Creates the JLables that contain the instructions and adds them to the panel 
		JLabel instructions = new JLabel ("Pick one of the options from below and play the game to see if it is right:");
		Instructions.add(instructions); 

		JLabel options = new JLabel ("Soccer, Field Hockey, Basketball, Tennis, Gymnastics, Skiing, Snowboarding, Ice-Skating, "); 
		Instructions.add(options); 

		JLabel moreOptions = new JLabel ("Ice Hockey, Diving,"
				+ " Swimming, Archery, Fencing, Golf, Baseball, Cricket and Volleyball"); 
		Instructions.add(moreOptions);

		// Returns the panel 
		return Instructions; 
	}

	/**
	 * A panel that holds the buttons 
	 * @return
	 */
	private JPanel Buttons() {

		JPanel Buttons = new JPanel (new GridLayout(3, 1));

		// Creates the buttons and sets the color and adds them to the panel
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

		Buttons.add(yes); 
		Buttons.add(no);
		Buttons.add(newGame);

		// Returns the panel 
		return Buttons; 


	}

	/**
	 * Creates a JLabel and a gif and puts them into the same panel which is returned 
	 * @return JPanel  
	 */

	private JPanel Question() {

		// Creates a JPanel 
		JPanel mainQuestion = new JPanel (new BorderLayout()); 

		// Sets the node to the root of the tree created in the constructor 
		node = tree.getRoot(); 

		// Creates the JLabel and sets it 
		question = new JLabel(); 
		question.setText(node.getData().toString()); 

		// Adds the JLabel and the gif to the panel 
		mainQuestion.add(question, BorderLayout.WEST); 
		mainQuestion.add(gif(), BorderLayout.EAST); 

		return mainQuestion; 

	}

	/**
	 * Class that contains the text fields 
	 */

	public void extraQuestions() {
		// Creates a new panel 
		popQuestions = new JPanel (new GridLayout (4,3)); 


		// Creates JLabels and correspoding TextFields and adds them to the panel creates 
		JLabel thing = new JLabel ("What sport were you thinking of?"); 
		newThing = new JTextField(); 
		popQuestions.add(thing); 
		popQuestions.add(newThing);

		JLabel newSportQuestion = new JLabel ("Please give me a yes/no question that would"
				+ "determine your thing"); 
		newQuestion = new JTextField(); 
		popQuestions.add(newSportQuestion);
		popQuestions.add(newQuestion);

		JLabel answer = new JLabel ("Is the answer to your question yes or no?"); 
		newAnswer = new JTextField(); 
		popQuestions.add(answer);
		popQuestions.add(newAnswer);


		// Creates a button and adds it to the panel 
		ok = new JButton ("OK"); 
		popQuestions.add(ok);
		ok.addActionListener(this); 


	}

	// Adds a gif to a panel 
	private JPanel gif() {

		// Imports the gif 
		ImageIcon sportsGif = new ImageIcon(getClass().getResource("73P0zaB.gif"));
		JLabel sports = new JLabel(sportsGif);
		JPanel panelSports = new JPanel();
		// Adds it to the panel 
		panelSports.add(sports);
		return panelSports;
	}


	/**
	 * Determines what should happen when the various buttons are pressed 
	 */


	@Override
	public void actionPerformed(ActionEvent e) {
		// If the yes button is pressed 
		if (e.getSource().equals(yes)){

			if (node.getLeftChild() != null) {
				// node is set to the left child 
				node = node.getLeftChild(); 
				question.setText(node.getData().toString());
			}
			else if (node.getLeftChild() == null){
				// when the guess is reached 
				question.setText("Good Job! The answer is correct!");
			}

		}
		// if the no button is pressed 
		else if (e.getSource().equals(no)) {
			if (node.getRightChild() != null) {
				// sets the node to the right child 
				node = node.getRightChild(); 
				question.setText(node.getData().toString());
			}
			else if (node.getRightChild() == null) {
				// If the guess does not exist 
				if (add == false) {
					// The panels containing the JtextFields is added
					add(popQuestions); 
					add = true; 
					revalidate(); 
					repaint(); 



				}
			}
		}

		// If the newGame button is pressed 
		else if (e.getSource().equals(newGame)) {

			// The node is set to the root of the tree 
			node = tree.getRoot(); 
			question.setText(node.getData().toString());

			// If the panel containing the textfields exists, it is removed 
			remove(popQuestions); 
			repaint(); 
			revalidate(); 
			add = false; 
		}


		// If the ok button is pressed 
		else if (e.getSource().equals(ok)) {

			// The text from the text fields is stores as String variables 
			String newSport = newThing.getText(); 
			String newQ = newQuestion.getText();
			String ans = newAnswer.getText(); 

			// The data in the current node is stored 
			String currentData = node.getData();

			// the data of the current node is set to the new question 
			node.setData(newQ);

			// If the answer is yes 
			if (newAnswer.getText().equals("yes")) {
				// Right and left child are set as follows 
				DefaultBinaryTreeNode<String> leftChild = new DefaultBinaryTreeNode<String>(); 
				DefaultBinaryTreeNode<String> rightChild = new DefaultBinaryTreeNode<String>(); 
				rightChild.setData(currentData);
				leftChild.setData(newSport);
				node.setRightChild(rightChild);
				node.setLeftChild(leftChild);
			}
			// If the answer is no
			else if (newAnswer.getText().equals("no")) {
				// Right and left child are set as follows 
				DefaultBinaryTreeNode<String> leftChild = new DefaultBinaryTreeNode<String>(); 
				DefaultBinaryTreeNode<String> rightChild = new DefaultBinaryTreeNode<String>(); 
				rightChild.setData(newSport);
				leftChild.setData(currentData);


				node.setRightChild(rightChild);
				node.setLeftChild(leftChild);

			}
		}
	}


}


		

