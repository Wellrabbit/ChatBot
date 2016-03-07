package chat.model;

import java.util.ArrayList;
import chat.controller.ChatController;

import twitter4j.*;

public class CTECTwitter
{
private ArrayList<Status> statusList;
private ArrayList<String> wordsList;
private Twitter chatbotTwitter;
private ChatController baseController;

public void CTECTTwitter(ChatController baseController)
{
	this.statusList = new ArrayList<Status>();
	this.wordsList = new ArrayList<String>();
	this.baseController = baseController;
	this.chatbotTwitter = TwitterFactory.getSingleton();
}

public void sendTweet(String input)
{
	try
	{
		chatbotTwitter.updateStatus("I just tweeted from my Java Chatbot program! #APCSRocks @CTECNow Thanks @cscheerleader & @codyhenrichsen!");
	}
	catch(TwitterException error)
	{
		baseController.handelErrors(error.getErrorMessage());
	}
	
}
}
