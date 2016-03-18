package chat.view;


import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

import chat.controller.ChatController;

public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private JButton submitButton;
	private JButton chatButton;
	private JButton tweetButton;
	private JButton analyzeTwitter;
	private JButton checkTwitterButton;
	private JButton saveButton;
	private JButton openButton;
	private JTextField userResponceField;
	private JTextArea ChatbotTextArea;
	private JScrollPane textScroll;
	private SpringLayout baseLayout;
	private JLabel promptLable;

	public ChatPanel(ChatController baseController)
	{
		baseLayout = new SpringLayout();
		this.baseController = baseController;
		submitButton = new JButton("Submit to chatbot");
		chatButton = new JButton("Click to Chat");
		tweetButton = new JButton("Send Tweet");
		checkTwitterButton = new JButton("Lets look for a topic on Twitter");
		saveButton = new JButton("Save this Chat");
		openButton = new JButton("Open a Saved Chat ^.^");
		userResponceField = new JTextField(30);
		analyzeTwitter = new JButton("Look at Twitter");
		promptLable = new JLabel("Chat with my Chatbot");

		ChatbotTextArea = new JTextArea(10, 30);
		setupChatPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}

	// Changes background to a random color
	private void changeColor()
	{
		int red, blue, green;
		red = (int) (Math.random() * 256);
		blue = (int) (Math.random() * 256);
		green = (int) (Math.random() * 256);

		this.setBackground(new Color(red, blue, green));
	}

	private void setupChatPane()
	{
		ChatbotTextArea.setLineWrap(true);
		ChatbotTextArea.setWrapStyleWord(true);
		ChatbotTextArea.setEnabled(false);
		ChatbotTextArea.setEditable(false);
		textScroll = new JScrollPane(ChatbotTextArea);

		textScroll
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		textScroll
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

	}

	// Sets the layout and adds elements to the panel
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(promptLable);
		this.add(submitButton);
		this.add(chatButton);
		this.add(tweetButton);
		this.add(checkTwitterButton);
		this.add(saveButton);
		this.add(openButton);
		this.add(userResponceField);
		this.add(textScroll);
		this.add(analyzeTwitter);
		// this.add(ChatbotTextArea);
		userResponceField.setToolTipText("Type to talk to chatbot");

		// ChatbotTextArea.setEnabled(false);
	}

	// Dump code for layout
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, tweetButton, 217,
				SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, tweetButton, -93,
				SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatButton, 0,
				SpringLayout.NORTH, checkTwitterButton);
		baseLayout.putConstraint(SpringLayout.WEST, checkTwitterButton, 159,
				SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, checkTwitterButton, -6,
				SpringLayout.NORTH, tweetButton);
		baseLayout.putConstraint(SpringLayout.NORTH, saveButton, 0,
				SpringLayout.NORTH, chatButton);
		baseLayout.putConstraint(SpringLayout.WEST, saveButton, 0,
				SpringLayout.WEST, openButton);
		baseLayout.putConstraint(SpringLayout.NORTH, openButton, 0,
				SpringLayout.NORTH, tweetButton);
		baseLayout.putConstraint(SpringLayout.WEST, openButton, 10,
				SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, ChatbotTextArea, 49,
				SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, ChatbotTextArea, 45,
				SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, ChatbotTextArea, -28,
				SpringLayout.NORTH, userResponceField);
		baseLayout.putConstraint(SpringLayout.EAST, ChatbotTextArea, -80,
				SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, promptLable, -29,
				SpringLayout.NORTH, checkTwitterButton);
		baseLayout.putConstraint(SpringLayout.EAST, promptLable, -224,
				SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatButton, -10,
				SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, submitButton, 0,
				SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, submitButton, 0,
				SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, textScroll, 50,
				SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, textScroll, 100,
				SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, textScroll, 200,
				SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, textScroll, -20,
				SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, userResponceField, 273,
				SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, userResponceField, 115,
				SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, userResponceField, -71,
				SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, userResponceField, -62,
				SpringLayout.NORTH, promptLable);
	}

	// Makes the button click actually do something
	private void setupListeners()
	{
		submitButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				changeColor();
				String userText = userResponceField.getText(); // Grabs user
																// text
				String responce = baseController.fromUserToChatbot(userText); // Sends
																				// text
																				// to
																				// controller
				ChatbotTextArea.append("\nUser: " + userText); // displays user
																// text
				ChatbotTextArea.append("\nChatbot: " + responce); // Displays
																	// answer
				userResponceField.setText(""); // Clears user field
			}
		});
		tweetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				baseController.sendTweet("I just tweeted from my Java Chatbot program! #APCSRocks @CTECNow Thanks @cscheerleader & @codyhenrichsen! - emmy<3");
			}	
		});
		analyzeTwitter.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent click)
		{
			String user = userResponceField.getText();
			String results = baseController.analyze(user);
			ChatbotTextArea.setText(results);
		}	
		});
	}

	public JTextArea getResponceFeild()
	{
		return ChatbotTextArea;
	}

	public void setChatbotTextArea(JTextArea chatbotTextArea)
	{
		ChatbotTextArea = chatbotTextArea;
	}

	public ChatController getBaseController()
	{
		return baseController;
	}

	public void setBaseController(ChatController baseController)
	{
		this.baseController = baseController;
	}

	public JButton getSubmitButton()
	{
		return submitButton;
	}

	public void setSubmitButton(JButton submitButton)
	{
		this.submitButton = submitButton;
	}

	public JTextField getTextField()
	{
		return userResponceField;
	}

	public void setUserResponceField(JTextField userResponceField)
	{
		this.userResponceField = userResponceField;
	}

	public SpringLayout getBaseLayout()
	{
		return baseLayout;
	}

	public void setBaseLayout(SpringLayout baseLayout)
	{
		this.baseLayout = baseLayout;
	}

	public JLabel getPromptLable()
	{
		return promptLable;
	}

	public void setPromptLable(JLabel promptLable)
	{
		this.promptLable = promptLable;
	}

	public JTextArea getChatbotTextArea()
	{
		return ChatbotTextArea;
	}

}
