package chat.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

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
		} catch (TwitterException error)
		{
			baseController.handleErrors(error.getErrorMessage());
		}

	}

	private String removePunctuation(String currentString)
	{
		String punctuation = ".,'?!:;\"(){}^[]<>_";

		String scrubbedString = "";

		for (int i = 0; i < currentString.length(); i++)
		{
			if (punctuation.indexOf(currentString.charAt(i)) == -1)
			{
				scrubbedString += currentString.charAt(i);
			}

		}
		return scrubbedString;
	}

	private void removeEmptyText()
	{
		for (int spot = 0; spot < wordsList.size(); spot++)
		{
			if (wordsList.get(spot).equals(""))
			{
				wordsList.remove(spot);
				spot--;
			}
		}
	}

	@SuppressWarnings("unchecked")
	private List removeCommonEnglishWords(List<String> wordList)
	{
		String[] boringWords = importWordsToArray();
		for (int count = 0; count < wordsList.size(); count++)
		{
			for (int removeSpot = 0; removeSpot < boringWords.length; removeSpot++)
			{
				if (wordsList.get(count).equalsIgnoreCase(
						boringWords[removeSpot]))
				{
					wordList.remove(count);
					count--;
					removeSpot = boringWords.length;
				}
			}
		}
		return wordsList;
	}

	private String[] importWordsToArray()
	{
		String[] boringWords;
		int wordCount = 0;
		try
		{
			Scanner wordFile = new Scanner(new File("commonWords.txt"));
			while (wordFile.hasNext())
			{
				wordCount++;
				wordFile.next();
			}
			wordFile = new Scanner(new File("commonWords.txt"));
			boringWords = new String[wordCount];
			int boringWordCount = 0;
			while (wordFile.hasNext())
			{
				boringWords[boringWordCount] = wordFile.next();
				boringWordCount++;
			}
			wordFile.close();
		} catch (FileNotFoundException e)
		{
			baseController.handleErrors(e.getMessage());
			return new String[0];

		}
		return boringWords;

	}

	public void loadTweets(String twitterHandel) throws TwitterException
	{
		Paging statusPage = new Paging(1, 200);
		int page = 1;
		while (page <= 10)
		{
			statusPage.setPage(page);
			statusList.addAll(chatbotTwitter.getUserTimeline(twitterHandel,
					statusPage));
			page++;
		}
		for (Status currentStatus : statusList)
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

	public String topResults()
	{
		String tweetResults = "";

		int topWordLocations = 0;
		int topCount = 0;

		for (int index = 0; index < wordsList.size(); index++)
		{
			int wordUseCount = 1;

			for (int spot = index + 1; spot < wordsList.size(); spot++)
			{
				if (wordsList.get(index).equals(wordsList.get(spot)))
				{
					wordUseCount++;
				}
				if (wordUseCount > topCount)
				{
					topCount = wordUseCount;
					topWordLocations = index;
				}
			}
		}
		tweetResults = "The top word in the tweets was "
				+ wordsList.get(topWordLocations) + " and it was used "
				+ topCount + " Times.";
		wordsList.clear();
		statusList.clear();
		return tweetResults;
	}

}
