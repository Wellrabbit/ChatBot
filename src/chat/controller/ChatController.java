package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatView;

/**
 * Controller for ChatBot project
 * 
 * @author Emily Orton
 * @version 1.3 10/30/15 Created constructor and intialized vairiables.
 *
 */
public class ChatController {

	private Chatbot chatBot;
	private ChatView myView;

	public ChatController() {
		myView = new ChatView();
		String user = myView.getAnswers("What is your name");
		chatBot = new Chatbot(user);
	}

	public void start() {
		myView.displayAnswer("Hello " + chatBot.getUserName());
		chat();
	}

	private void chat() {
		String textFromUser = myView.getAnswers("Talk to the chatbot");
		
		while (chatBot.lengthChecker(textFromUser)) 
		{
		
			if(chatBot.contentChecker(textFromUser))
			{
				myView.displayAnswer("Wow I had no idea you loved " + chatBot.getContent() );
				myView.displayAnswer(chatBot.processQuestion(textFromUser));
			}
			else if (chatBot.memeChecker(textFromUser))
			{
				myView.displayAnswer("That some dank meme");
				myView.displayAnswer(chatBot.processQuestion(textFromUser));
			}
			else if (chatBot.politicalTopicChecker(textFromUser))
			{
				myView.displayAnswer("I cant beileve your into the election");
				myView.displayAnswer(chatBot.processQuestion(textFromUser));
			}
			
			textFromUser = myView.getAnswers("wow " + textFromUser);
			
		
		}
	}

	

}
