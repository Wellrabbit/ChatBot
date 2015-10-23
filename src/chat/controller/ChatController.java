package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatView;

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
	}

}
