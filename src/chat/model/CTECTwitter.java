package chat.model;

import java.util.ArrayList;
import chat.controller.ChatController;
import java.util.List;


import twitter4j.*;

public class CTECTwitter
{
private ArrayList<Status> statusList;
private ArrayList<String> wordsList;
private Twitter chatbotTwitter;
private ChatController baseController;

public CTECTwitter(ChatController baseController)
{
	this.statusList = new ArrayList<Status>();
	this.wordsList = new ArrayList<String>();
	this.baseController = baseController;
	this.chatbotTwitter = TwitterFactory.getSingleton();
}

public void sendTweet(String tweet)
{
	try
	{
		chatbotTwitter.updateStatus(tweet);
	}
	catch(TwitterException error)
	{
		baseController.handleErrors(error.getErrorMessage());
	}
	
}
private String removePunctuation(String currentString)
{
	String punctuation = ".,'?!:;\"(){}^[]<>_";
	
	String scrubbedString = "";
	
	for (int i = 0 i < currentString.length(); i++)
	{
		if(punctuation.indexOf(currentString.charAt(i)) == -1)
		{
			scrubbedString += currentString.charAt(i);
		}
		return scrubbedString;
	}
}

private void removeEmptyText()
{
	for (int spot = 0; spot < wordsList.size(); spot++)
	{
		if(wordsList.get(spot).equals(" "))
		{
			wordsList.remove(spot);
			spot--;
		}
	}
}

@SupressWarning("unchecked")
private List removeCommonEnglishWords(List<String> wordList)
{
	String [] boringWords = importWordstoArray();
	for(int count = 0; count < wordsList.size(); count++)
	{
		for(int removeSpot = 0; removeSpot < boringWords.length; removeSpot++)
		{
			if (wordsList.get(count).equalsIgnoreCase(boringWords[removeSpot]))
					{
						wordList.remove(count);
						count--;
						removeSpot = boringWords.length;
					}
		}
	}
}

public void loadTweets(String twitterHandel) throws TwitterException
{
	Paging statusPage = new Paging(1, 200)
	int page = 1;
	while (page <= 10)
	{
		statusPage.setPage(page);
		statuses.addAll(chatbotTwitter.getUserTimeline(twitterHandel, statusPage));
		page++;
	}
	for (Status currentStatus : statuses)
	{
		String[] tweetText = currentStatus.getText().split(" ");
		for (String word : tweetText)
		{
			wordsList.add(removePunctuation(word).toLowerCase());
		}
	}
	removeCommonEnglishWords(wordsList);
	removeEmptyText();
}

}
