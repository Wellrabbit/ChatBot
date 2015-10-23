package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatView;
/**
 * Controller for ChatBot project
 * @author Emily Orton
 * @version 1.2 10/23/15 Created constructor and intialized vairiables. 
 *
 */
public class ChatController {
	
	private Chatbot chatBot;
	private ChatView myView;
	
	public ChatController()
	{
		myView = new ChatView();
		String user = myView.getAnswers("What is your name");
		chatBot = new Chatbot(user);
	}
	
	public void start()
	{
		myView.displayAnswer("Hello " + chatBot.getUserName());
		chat();
	}
	
	private void chat()
	{
		String textFromUser = myView.getAnswers("Talk to the chatbot");
		while(chatBot.lengthChecker(textFromUser))
		{
			 textFromUser = myView.getAnswers("wow" + textFromUser);
		}
	}

}
