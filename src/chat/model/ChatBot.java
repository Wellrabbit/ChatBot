package chat.model;

import java.util.ArrayList;

/**
 * Base version of the 2015 Chatbot class. Only stub methods are provided.
 * Students will complete methods as part of the project.
 * 
 * @author Emily Orton
 * @version 1.5 11/3/15 Added switch statement
 */
public class Chatbot
{
	private ArrayList<String> memesList;
	private ArrayList<String> politicalTopicList;
	private String userName;
	private String content;

	/**
	 * Creates an instance of the Chatbot with the supplied username.
	 * 
	 * @param userName
	 *            The username for the chatbot.
	 */
	public Chatbot(String userName)
	{

		this.memesList = new ArrayList<String>();
		this.politicalTopicList = new ArrayList<String>();
		this.userName = userName;
		this.content = "Baking Shows";
		buildMemesList();
		buildPoliticalTopicsList();

	}

	/**
	 * Builds Array list with specified adds.
	 */
	private void buildMemesList()
	{
		this.memesList.add("cute Animals");
		this.memesList.add("doge");
		this.memesList.add("pepe the rarest");
		this.memesList.add("John Cena");
		this.memesList.add("spoodermun");
		this.memesList.add("you're gonna have a bad time");
		this.memesList.add("condecending Wonka");
		this.memesList.add("Philosaraptor");
		this.memesList.add("do you even lift");
		this.memesList.add("Shakespeare Lyrics");

		// cute animals
		// doge
		// 10 memes
	}

	private void buildPoliticalTopicsList()
	{
		this.politicalTopicList.add("election");
		this.politicalTopicList.add("democrat");
		this.politicalTopicList.add("republican");
		this.politicalTopicList.add("liberal");
		this.politicalTopicList.add("conservation");
		this.politicalTopicList.add("TRUMP");
		this.politicalTopicList.add("CLINTON");
		this.politicalTopicList.add("BIDEN");
		this.politicalTopicList.add("CARSON");
		this.politicalTopicList.add("RUBIO");
		this.politicalTopicList.add("FIORINA");
		this.politicalTopicList.add("SANDERS");
		this.politicalTopicList.add("vote");
		this.politicalTopicList.add("11/8/2016");

	}

	/**
	 * Checks the length of the supplied string. Returns false if the supplied
	 * String is empty or null, otherwise returns true.
	 * 
	 * @param currentInput
	 * @return A true or false based on the length of the supplied String.
	 */
	public boolean lengthChecker(String currentInput)
	{
		boolean hasLength = false;
		if (currentInput != null)
		{
			if (currentInput.length() > 0)
			{
				return hasLength = true;
			}
		}

		return hasLength;

	}

	public boolean keyboardMashChecker(String currentInput)
	{
		boolean hasMash = false;
		if(currentInput.contains("sdf"))
		{
			hasMash = true;
		}
		else if(currentInput.contains("dfg"))
		{
			hasMash = true;
		}
		else if(currentInput.contains("cvb"))
		{
			hasMash = true;
		}
		else if(currentInput.contains(",./"))
		{
			hasMash = true;
		}
		
		return hasMash;
	}

	/**
	 * Checks if the supplied String matches the content area for this Chatbot
	 * instance.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked.
	 * @return Whether it matches the content area.
	 */
	public boolean contentChecker(String currentInput)
	{
		boolean hasContent = false;

		if (currentInput.toLowerCase().contains(content.toLowerCase()))
		{
			hasContent = true;
		}
		return hasContent;
	}

	/**
	 * Checks if supplied String matches ANY of the topics in the
	 * politicalTopicsList. Returns true if it does find a match and false if it
	 * does not match.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked.
	 * @return Whether the String is contained in the ArrayList.
	 */
	public boolean politicalTopicChecker(String currentInput)
	{
		boolean hasPolitic = false;

		for (String politic : politicalTopicList)
		{
			if (currentInput.toLowerCase().contains(politic.toLowerCase()))
			{
				hasPolitic = true;
			}
		}

		return hasPolitic;
	}

	public String processQuestion(String currentInput)
	{
		String backTalk;
		backTalk = "Topic Time";

		int randomTopic = (int) (Math.random() * 5);

		switch (randomTopic)
		{
		case 0:
			if (contentChecker(currentInput))
			{
				backTalk = "Thats my favorite thing whats next?";
			}
			break;
		case 1:
			if (memeChecker(currentInput))
			{
				backTalk = "That is a popular Meme this year! What about your favorite food?";
			}
			break;
		case 2:
			if (politicalTopicChecker(currentInput))
			{
				backTalk = "Really Thats what you want to talk about wow okay any questions";
			}
			break;
		case 3:
			if (currentInput.length() < 5)
			{
				backTalk = "Could you please elaborate";
			}
			break;
		case 4:
			if (currentInput.length() > 26)
			{
				backTalk = "Can you dumb it down my CPU is overloading";
			}

			break;
		default:
			backTalk = "YOU GET THE EASTER EGG";
			break;
		}
		return backTalk;
	}

	/**
	 * Checks to see that the supplied String value is in the current memesList
	 * variable.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked.
	 * @return Whether the supplied String is a recognized meme.
	 */
	public boolean memeChecker(String currentInput)
	{
		boolean hasMeme = false;

		for (String meme : memesList)
		{
			if (currentInput.toLowerCase().contains(meme.toLowerCase()))
			{
				hasMeme = true;
			}
		}

		return hasMeme;
	}

	/**
	 * Returns the username of this Chatbot instance.
	 * 
	 * @return The username of the Chatbot.
	 */
	public String getUserName()
	{
		return userName;
	}

	/**
	 * Returns the content area for this Chatbot instance.
	 * 
	 * @return The content area for this Chatbot instance.
	 */
	public String getContent()
	{
		return content;
	}

	/**
	 * Getter method for the memesList object.
	 * 
	 * @return The reference to the meme list.
	 */
	public ArrayList<String> getMemesList()
	{
		return memesList;
	}

	/**
	 * Getter method for the politicalTopicList object.
	 * 
	 * @return The reference to the political topic list.
	 */
	public ArrayList<String> getPoliticalTopicList()
	{
		return politicalTopicList;
	}

	/**
	 * Updates the content area for this Chatbot instance.
	 * 
	 * @param content
	 *            The updated value for the content area.
	 */
	public void setContent(String content)
	{

	}
}