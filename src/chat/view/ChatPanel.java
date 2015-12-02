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
	private JTextField userResponceField;
	private JTextArea ChatbotTextArea;
	private SpringLayout baseLayout;
	private JLabel promptLable;

	public ChatPanel(ChatController baseController)
	{
		baseLayout = new SpringLayout();
		this.baseController = baseController;
		submitButton = new JButton("Submit to chatbot");
		userResponceField = new JTextField(30);
		ChatbotTextArea = new JTextArea(10, 30);
		promptLable = new JLabel("Chat with my Chatbot");

		setupPanel();
		setupLayout();
		setupListeners();
	}
//Changes background to a random color
	private void changeColor()
	{
		int red, blue, green;
		red = (int) (Math.random() * 256);
		blue = (int) (Math.random() * 256);
		green = (int) (Math.random() * 256);

		this.setBackground(new Color(red, blue, green));
	}
//Sets the layout and adds elements to the panel
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(promptLable);
		this.add(submitButton);
		this.add(userResponceField);
		this.add(ChatbotTextArea);
		userResponceField.setToolTipText("Type to talk to chatbot");
		ChatbotTextArea.setEnabled(false);
	}
//Dump code for layout 
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.SOUTH, submitButton, 0,
				SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, submitButton, -10,
				SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, userResponceField, 29,
				SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, userResponceField, -46,
				SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, ChatbotTextArea, 0,
				SpringLayout.WEST, promptLable);
		baseLayout.putConstraint(SpringLayout.SOUTH, ChatbotTextArea, -21,
				SpringLayout.NORTH, promptLable);
		baseLayout.putConstraint(SpringLayout.WEST, promptLable, 45,
				SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, promptLable, -5,
				SpringLayout.NORTH, userResponceField);

	}
//Makes the button click actually do something
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
