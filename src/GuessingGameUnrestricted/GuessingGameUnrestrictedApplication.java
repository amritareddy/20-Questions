package GuessingGameUnrestricted;
import javax.swing.JFrame;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Creates the Frame which holds the unrestricted Guessing Game 
 * @author Amrita Reddy
 *
 */
public class GuessingGameUnrestrictedApplication  {


	/**
	 * Creates the frame 
	 * @param args
	 * @throws ParserConfigurationException
	 */
	public static void main (String[] args) throws ParserConfigurationException{
		// Creates a JFrame 
		JFrame GuessingGameFrame; 
		GuessingGameFrame = new JFrame ("20 Questions Unrestricted"); 

		// Sets the size of the JFrame 
		GuessingGameFrame.setSize(1200,900); 

		// Closes the frame when you exit 
		GuessingGameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

		// Adds the panel GuessingGameUnrestricted to the to the JFrame 
		GuessingGameFrame.add(new GuessingGameUnrestricted()); 

		// Sets the frame to visible 
		GuessingGameFrame.setVisible(true);

	}

	
}
