package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
/**
 * 
 * @author EmilyOrton
 * @version 1.0 10/21/15
 * Class that handles the view, currently popup controller based.
 *
 */
public class ChatView {
	/**
	 * Displays small popup that collects user input
	 * Normally has a question displayed with it
	 * @param Display
	 * @return Text given by user.
	 */
	public ChatView()
	{
		private String windowMessage;
		private ImageIcon chatIcon;
		
		windowMessage = "This is my Chatbot ^.^";
		chatIcon = new ImageIcon(getClass().getResource("images/mypic.jpg"));
	}
	public String getAnswers(String Display)
	{
		String answer = "";
		
		answer = JOptionPane.showInputDialog(null, Display);
		
		return answer;
		
	}
/**
 * Displays text user put in
 * 
 * @param Display
 */
	public void displayAnswer(String Display)
	{
		JOptionPane.showMessageDialog(null, Display);
		
	}
}
