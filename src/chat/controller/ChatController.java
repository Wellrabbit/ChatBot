package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatView;
import chat.view.ChatFrame;

/**
 * Controller for ChatBot project
 * 
 * @author Emily Orton
 * @version 1.3 10/30/15 Created constructor and intialized vairiables.
 *
 */
public class ChatController
{

	private Chatbot chatBot;
	private ChatView myView;

	private ChatFrame baseFrame;

	public ChatController()
	{
		myView = new ChatView();
		String user = myView.getAnswers("What is your name");
		chatBot = new Chatbot(user);
		baseFrame = new ChatFrame(this);
	}

	public void start()
	{
		myView.displayAnswer("Hello " + chatBot.getUserName());
		//chat();
	}
/**
 * Used in popup controller version to run chat between user and chatbot. 
 * Takes user input loops it to processQuestion switch statment and displays responce
 */
	private void chat()
	{
		String textFromUser = myView.getAnswers("Talk to the chatbot");

		while (chatBot.lengthChecker(textFromUser))
		{

			textFromUser = chatBot.processQuestion(textFromUser);
			textFromUser = myView.getAnswers("wow " + textFromUser);

		}
	}
	/**
	 * Used in the GUI version.
	 * Sends the users text to the chatbot then loops it back.
	 * Also checks to see if user would like to quit.
	 */
	public String fromUserToChatbot(String textFromUser)
	{
		String botResponce = "";
		if(chatBot.quitChecker(textFromUser))
		{
			shutDown();
		}
		botResponce = chatBot.processQuestion(textFromUser);
		
		return botResponce;
	}
	/**
	 * Allows user to quit chatbot by typing quit
	 */
	private void shutDown()
	{
		myView.displayAnswer("Goodbye," + chatBot.getUserName() + " That was fun!!!" );
		System.exit(0);
	}
	
	

	public Chatbot getChatbot()
	{
		return chatBot;
	}

	public void setChatbot(Chatbot chatBot)
	{
		this.chatBot = chatBot;
	}

	public ChatView getChatView()
	{
		return myView;
	}

	public void setMyView(ChatView myView)
	{
		this.myView = myView;
	}

	public ChatFrame getBaseFrame()
	{
		return baseFrame;
	}

	public void setBaseFrame(ChatFrame baseFrame)
	{
		this.baseFrame = baseFrame;
	}

}
