package GuessingGameRestricted;
import javax.swing.JFrame;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Creates the frame for the restricted Guessing Game 
 * @author Amrita Reddy
 *
 */
public class GuessingGameApplication  {

	public static void main (String[] args) throws ParserConfigurationException{
		// Creates a JFrame 
		JFrame GuessingGameFrame; 
		GuessingGameFrame = new JFrame ("20 Questions"); 
		
		// Sets the size of the JFrame 
		GuessingGameFrame.setSize(600,500); 
		
		// Closes the frame when you exit 
		GuessingGameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		// Adds the panel GuessingGame to the to the JFrame 
		GuessingGameFrame.add(new GuessingGame()); 
		
		// Sets the frame to visible 
		GuessingGameFrame.setVisible(true);
	}

	
}